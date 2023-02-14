package repo;

import model.Lesson;
import my.exceptions.DublicatedHomeWorkIDException;
import my.exceptions.LessonDoesNotExistsException;
import my.exceptions.LessonsArrayIsEmptyException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LessonDao implements DaoAble {
    Connection connection;

    public LessonDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void addLesson(String name, String date, int homework) throws DublicatedHomeWorkIDException {
        int resultSet = 0;
        try (PreparedStatement statement = connection.prepareStatement("INSERT INTO test_mysql_db.Lesson (name, updatedAt, homework_id)" +
                "VALUES (?, ?, ?)")) {
            statement.setString(1, name);
            statement.setString(2, date);
            statement.setInt(3, homework);
            statement.executeUpdate();
            resultSet = statement.getUpdateCount();

            if(resultSet > 0)
                System.out.println("Lesson was added successfully: " + resultSet);
            System.out.println("Last added lesson id is: " + getLastAddedLessonId() + "\n");
        } catch (SQLException e) {
            if(resultSet == 0)
                throw new DublicatedHomeWorkIDException("Homework with id: " + homework + " is already exists. " +
                        "Specified homeworkID should be unique.");
        }
    }

    @Override
    public void deleteLesson(int id) throws LessonDoesNotExistsException {
        if (isLessonPresent(id)){
            int rowsDeleted = -1;
            try (PreparedStatement statement = connection.prepareStatement("DELETE FROM test_mysql_db.lesson WHERE id = ?")) {
                statement.setInt(1, id);
                rowsDeleted = statement.executeUpdate();

                if (rowsDeleted >= 1)
                    System.out.println("Rows deleted: " + rowsDeleted);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } else
            throw new LessonDoesNotExistsException("Lesson with id \"" + id + "\" does not exists");
    }

    @Override
    public List<Lesson> getAllLessons() throws LessonsArrayIsEmptyException {
        String sql = "SELECT * FROM test_mysql_db.lesson";
        List<Lesson> lessons = new ArrayList<>();
        Lesson lesson;

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.execute();
            ResultSet resultSet = statement.getResultSet();



            while (resultSet.next()) {
                    lesson = new Lesson();
                    lesson.setId(resultSet.getInt("id"));
                    lesson.setName(resultSet.getString("name"));
                    lesson.setHomework(resultSet.getString("homework_id"));

                    lessons.add(lesson);
            }

            if(lessons.size() == 0)
                throw new LessonsArrayIsEmptyException("Lessons array is empty.");

            System.out.println(lessons);
            return lessons;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Lesson getLessonById(int id) throws LessonDoesNotExistsException {

        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM test_mysql_db.lesson WHERE id = ?")) {
            statement.setInt(1, id);
            statement.execute();
            ResultSet resultSet = statement.getResultSet();
            resultSet.next();

            Lesson lesson = new Lesson();
            lesson.setId(resultSet.getInt("id"));
            lesson.setName(resultSet.getString("name"));
            lesson.setHomework(resultSet.getString("homework_id"));

            System.out.printf("Lesson with id %d is: " + lesson + "\n", id);
            return lesson;
        }
        catch (SQLException e) {
            throw new LessonDoesNotExistsException("Lesson with id \"" + id + "\" doesn't exists. " +
                    "SQLState is: " + e.getSQLState() +
                    ". SQLErrorCode is " + e.getErrorCode());

        }
    }

    public int getLastAddedLessonId() throws LessonDoesNotExistsException {
        try (PreparedStatement statement = connection.prepareStatement("SELECT id FROM test_mysql_db.lesson ORDER BY id DESC LIMIT 1")) {
            statement.execute();
            ResultSet resultSet = statement.getResultSet();
            resultSet.next();

            return resultSet.getInt("id");
        } catch (SQLException e) {
            throw new LessonDoesNotExistsException("Lessons table is empty.");
        }
    }

    public boolean isLessonPresent(int id) throws LessonDoesNotExistsException {
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM test_mysql_db.lesson WHERE id = ?")) {
            statement.setInt(1, id);
            statement.execute();
            ResultSet resultSet = statement.getResultSet();

            if(resultSet.next()){
                return true;
            }
        } catch (SQLException e) {
            throw new LessonDoesNotExistsException("Lesson with id \"" + id + "\" doesn't exists. " +
                    "SQLState is: " + e.getSQLState() +
                    ". SQLErrorCode is " + e.getErrorCode());
        }
        return false;
    }
}

package repo;

import model.Lesson;

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
    public void addLesson(String name, String date, int homework) {
        try (PreparedStatement statement = connection.prepareStatement("INSERT INTO test_mysql_db.Lesson (name, updatedAt, homework_id)" +
                "VALUES (?, ?, ?)")) {
            statement.setString(1, name);
            statement.setString(2, date);
            statement.setInt(3, homework);
            statement.executeUpdate();
            int resultSet = statement.getUpdateCount();

            if(resultSet > 0)
                System.out.println("Lesson was added successfully: " + resultSet);
            System.out.println("Last added lesson id is: " + getLastAddedLessonId() + "\n");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteLesson() {
        try (PreparedStatement statement = connection.prepareStatement("DELETE FROM test_mysql_db.lesson WHERE id = ?")) {
            statement.setInt(1, getLastAddedLessonId());
            int rowsDeleted = statement.executeUpdate();

            if(rowsDeleted >= 1)
                System.out.println("Rows deleted: " + rowsDeleted);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Lesson> getAllLessons() {
        String sql = "SELECT * FROM test_mysql_db.lesson";
        List<Lesson> lessons = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.execute();
            ResultSet resultSet = statement.getResultSet();

            Lesson lesson;

            while (resultSet.next()) {
                    lesson = new Lesson();
                    lesson.setId(resultSet.getInt("id"));
                    lesson.setName(resultSet.getString("name"));
                    lesson.setHomework(resultSet.getString("homework_id"));

                    lessons.add(lesson);
            }

            System.out.println(lessons);
            return lessons;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public Lesson getLessonById(int id) {

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
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private int getLastAddedLessonId(){
        try (PreparedStatement statement = connection.prepareStatement("SELECT id FROM test_mysql_db.lesson ORDER BY id DESC LIMIT 1")) {
            statement.execute();
            ResultSet resultSet = statement.getResultSet();
            resultSet.next();

            return resultSet.getInt("id");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

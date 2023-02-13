import dbconnection.DataBaseConnection;
import my.exceptions.DBCustomeException;
import my.exceptions.DublicatedHomeWorkIDException;
import my.exceptions.LessonDoesNotExistsException;
import my.exceptions.LessonsArrayIsEmptyException;
import repo.LessonDao;


public class Application {
    public static void main(String[] args) {
        try(DataBaseConnection mySqlConnection = DataBaseConnection.getInstance()){
            LessonDao lessonDao = new LessonDao(DataBaseConnection.getConnection());
            lessonDao.getAllLessons();
            lessonDao.getLessonById(2);
            lessonDao.deleteLesson(lessonDao.getLastAddedLessonId());
            lessonDao.addLesson("Math", "2022-01-01 12:45:36", 3);
            lessonDao.getAllLessons();
        } catch (DBCustomeException | LessonDoesNotExistsException | LessonsArrayIsEmptyException | DublicatedHomeWorkIDException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


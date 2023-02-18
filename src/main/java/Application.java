import dbconnection.DataBaseConnection;
import model.Lesson;
import my.exceptions.DBCustomeException;
import my.exceptions.DublicatedHomeWorkIDException;
import my.exceptions.LessonDoesNotExistsException;
import my.exceptions.LessonsArrayIsEmptyException;
import repo.LessonDao;


public class Application {
    public static void main(String[] args) {
        final String lessonName = "Math";
        try(DataBaseConnection mySqlConnection = DataBaseConnection.getInstance()){
            LessonDao lessonDao = new LessonDao(mySqlConnection.getConnection());
            lessonDao.getAllLessons();
            lessonDao.getLessonById(lessonDao.getLastAddedLessonId());
            lessonDao.deleteLesson(lessonDao.getLastAddedLessonId());
            lessonDao.addLesson(new Lesson(lessonName, "2022-01-01 12:45:36", lessonDao.getHomeworkByLessonName(lessonName)));
            lessonDao.getAllLessons();
        } catch (DBCustomeException | LessonDoesNotExistsException | LessonsArrayIsEmptyException | DublicatedHomeWorkIDException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


import dbconnection.DataBaseConnection;
import my.exceptions.DBCustomeException;
import my.exceptions.DublicatedHomeWorkIDException;
import my.exceptions.LessonDoesNotExistsException;
import my.exceptions.LessonsArrayIsEmptyException;
import repo.LessonDao;

public class Application {
    public static void main(String[] args) {
        try(DataBaseConnection mySqlConnection = new DataBaseConnection()){
            LessonDao lessonDao = new LessonDao(DataBaseConnection.getConnection());
            lessonDao.getAllLessons();
            lessonDao.getLessonById(2);
//            lessonDao.getLessonById(3);
            lessonDao.deleteLesson(lessonDao.getLastAddedLessonId());
            lessonDao.addLesson("Math", "2022-01-01 12:45:36", 3);
            lessonDao.getAllLessons();

//        mySqlConnection.close(DataBaseConnection.getConnection());
        } catch (DBCustomeException | LessonDoesNotExistsException | LessonsArrayIsEmptyException | DublicatedHomeWorkIDException e) {
            System.out.println(e.getMessage());
//            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }


        System.out.println();
    }
}


import dbconnection.DataBaseConnection;
import repo.DaoAble;
import repo.LessonDao;

import java.sql.*;

public class Application {
    public static void main(String[] args) {
        DataBaseConnection mySqlConnection = new DataBaseConnection();
        Connection connection = mySqlConnection.getConnection();
        DaoAble lessonDao = new LessonDao(connection);
        lessonDao.getAllLessons();
        lessonDao.getLessonById(2);
        lessonDao.deleteLesson();
        lessonDao.addLesson("Math", "2022-01-01 12:45:36", 3);
        lessonDao.getAllLessons();

        mySqlConnection.close(connection);

        System.out.println();
    }
}


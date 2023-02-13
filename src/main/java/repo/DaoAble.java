package repo;

import model.Lesson;
import my.exceptions.DublicatedHomeWorkIDException;
import my.exceptions.LessonDoesNotExistsException;
import my.exceptions.LessonsArrayIsEmptyException;

import java.util.List;

public interface DaoAble {

    void addLesson(String name, String date, int homework) throws DublicatedHomeWorkIDException;
    void deleteLesson(int id) throws LessonDoesNotExistsException;
    List<Lesson> getAllLessons() throws LessonsArrayIsEmptyException;
    Lesson getLessonById(int id) throws LessonDoesNotExistsException;
}

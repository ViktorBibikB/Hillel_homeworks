package repo;

import model.Lesson;
import my.exceptions.DublicatedHomeWorkIDException;
import my.exceptions.LessonDoesNotExistsException;
import my.exceptions.LessonsArrayIsEmptyException;

import java.util.List;

public interface DaoAble {

    void addLesson(Lesson lesson) throws DublicatedHomeWorkIDException;

    void deleteLesson(int id) throws LessonDoesNotExistsException;

    List<Lesson> getAllLessons() throws LessonsArrayIsEmptyException;

    Lesson getLessonById(Integer id) throws LessonDoesNotExistsException;
}

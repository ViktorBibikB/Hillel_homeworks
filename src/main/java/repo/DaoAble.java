package repo;

import model.Lesson;

import java.util.List;

public interface DaoAble {

    void addLesson(String name, String date, int homework);
    void deleteLesson();
    List<Lesson> getAllLessons();
    Lesson getLessonById(int id);
}

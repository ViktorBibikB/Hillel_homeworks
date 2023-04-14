package repository;

import model.Student;

import java.util.List;

public interface DataAccessObject {

    Student add(Student student);

    void remove(Student student);

    Student update(Student student);

    List<Student> getAll();

    Student getStudentById(int id);


}

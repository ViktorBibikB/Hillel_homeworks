import jakarta.persistence.*;
import model.Student;
import repository.DataAccessStudent;
import repository.DataAccessObject;

public class Application {

    public static void main(String[] args) {
        Student student = new Student();
        student.setName("User_1");
        student.setEmail("User_1@test.com");

        CustomEntityManagerFactory.addEntityClass(Student.class);


        EntityManager entityManager = CustomEntityManagerFactory.getEntityManager();

        DataAccessObject repo = new DataAccessStudent(entityManager);

        System.out.println(repo.add(student));

        student.setName("User_2");
        System.out.println(repo.update(student));

        repo.remove(student);

        System.out.println(repo.getAll());

        System.out.println(repo.getStudentById(2));
        entityManager.close();
    }
}

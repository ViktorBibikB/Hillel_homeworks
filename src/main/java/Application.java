import car.Car;
import employee.ContactInfo;
import employee.Employee;

public class Application {
    public static void main(String[] args) {
        Employee employee = new Employee("First Second Final", "Developer", 26,
                new ContactInfo("qwerty@gmail.com", "+380502549652"));
        System.out.println(employee);

        Car car = new Car();
        car.start();
    }
}

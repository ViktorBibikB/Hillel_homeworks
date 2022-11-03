import fauna.Animal;
import fauna.Cat;
import fauna.Dog;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<Animal>();
        animals.add(new Cat("Cat1"));
        animals.add(new Dog("Dog2"));
        animals.add(new Cat("Cat3"));
        animals.add(new Dog("Dog1"));
        animals.add(new Cat("Cat2"));

        for (Animal animal : animals) {
            animal.run((Math.random() * 150) + 1);
            animal.swim((Math.random() * 10) + 1);
        }

        System.out.println("Animal count: " + Animal.getInstanceCount());
        System.out.println("Cat count: " + Cat.getInstanceCount());
        System.out.println("Dog count: " + Dog.getInstanceCount());
    }
}

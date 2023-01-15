import arraytolist.Converter;
import fruits.Apple;
import fruits.Box;
import fruits.Fruit;
import fruits.Orange;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Integer[] integers = new Integer[]{2, 54, -74, 856, 0, 56, 47};

        Converter<Integer> converter = new Converter<>(integers);
        System.out.println("List: " + converter.toList());


        List<Orange> orangeList = new ArrayList<>();
        orangeList.add(new Orange());
        orangeList.add(new Orange());
        orangeList.add(new Orange());

        Box<Orange> orangeBox = new Box<>(new Orange());
        orangeBox.addFruit(new Orange());
        orangeBox.addFruit(new Orange());
        orangeBox.addFruit(orangeList);

        System.out.println("Total orange box weight is: " + orangeBox.getWeight());

        List<Apple> appleList = new ArrayList<>();
        appleList.add(new Apple());
        appleList.add(new Apple());
        appleList.add(new Apple());

        Box<Apple> appleBox = new Box<>(new Apple());
        appleBox.addFruit(new Apple());
        appleBox.addFruit(new Apple());
        appleBox.addFruit(appleList);

        System.out.println("Total apple box weight is: " + appleBox.getWeight());

        Box<Apple> appleBox2 = new Box<>(new Apple());
        appleBox2.addFruit(new Apple());
        appleBox2.addFruit(new Apple());
        appleBox2.addFruit(appleList);

        System.out.println("Total apple2 box weight is: " + appleBox2.getWeight());

        Box<Apple> appleBox3 = new Box<>(new Apple());
        appleBox3.addFruit(new Apple());
        appleBox3.addFruit(new Apple());

        System.out.println("Total apple3 box weight is: " + appleBox3.getWeight());


        System.out.println();
        System.out.println("orangeBox weight - " + orangeBox.getWeight() + " / appleBox weight - " + appleBox.getWeight()
                + " = " +  orangeBox.compare(appleBox.getFruits()));
        System.out.println("appleBox weight - " + appleBox.getWeight() + " / appleBox2 weight - " + appleBox2.getWeight()
                + " = " +  appleBox.compare(appleBox2.getFruits()));
        System.out.println("appleBox weight - " + appleBox.getWeight() + " / appleBo3 weight - " + appleBox3.getWeight()
                + " = " +  appleBox.compare(appleBox3.getFruits()));

        System.out.println("Before merge");
        System.out.println(appleBox.getFruits());
        System.out.println(appleBox3.getFruits());

        appleBox.merge(appleBox3.getFruits());

        System.out.println("After merge");
        System.out.println(appleBox.getFruits());
        System.out.println(appleBox3.getFruits());
    }
}

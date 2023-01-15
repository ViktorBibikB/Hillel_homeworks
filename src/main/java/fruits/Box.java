package fruits;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {
    T fruit;
    List<T> fruitList = new ArrayList<>();

    public Box(T fruit) {
        this.fruit = fruit;
    }

    public void addFruit(T fruit) {
        fruitList.add(fruit);
    }

    public void addFruit(List<T> fruits) {
        fruitList.addAll(fruits);
    }

    public float getWeight(){
        return getWeight(fruitList);
    }

    private float getWeight(List<? extends Fruit> fruits){
        return fruits.size() * fruit.getWeight();
    }

    public boolean compare(List<? extends Fruit> fruitBox){
        return getWeight() == getWeight(fruitBox);
    }

    public void merge(List<T> fruits){
        addFruit(fruits);
        fruits.clear();
    }

    public List<T> getFruits(){
        return fruitList;
    }
}

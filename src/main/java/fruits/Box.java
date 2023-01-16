package fruits;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {
    List<T> fruitList = new ArrayList<>();

    public void addFruit(T fruit) {
        fruitList.add(fruit);
    }

    public void addFruit(List<T> fruits) {
        fruitList.addAll(fruits);
    }

    public float getWeight() {
        float weight = 0;

        for (Fruit fruit : fruitList)
            weight += fruit.getWeight();

        return weight;
    }

    public boolean compare(Box<? extends Fruit> box) {
        return getWeight() == box.getWeight();
    }

    public void merge(Box<T> fruitBox){
        addFruit(fruitBox.fruitList);
        fruitBox.fruitList.clear();
    }
}

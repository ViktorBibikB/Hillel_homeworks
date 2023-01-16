package arraytolist;

import java.util.LinkedList;
import java.util.List;

public class Converter<T> {
    T[] arr;

    public Converter(T[] arr) {
        this.arr = arr;
    }

    public List<T> toList() {
        List<T> list = new LinkedList<>();

        for (int i = 0; i < arr.length; i++) list.add(arr[i]);

        return list;
    }
}

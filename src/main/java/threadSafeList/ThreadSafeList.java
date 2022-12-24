package threadSafeList;

import java.util.concurrent.CopyOnWriteArrayList;

public class ThreadSafeList<T> extends CopyOnWriteArrayList<T> {
    @Override
    public synchronized boolean add(T value) {
        return super.add(value);
    }

    @Override
    public synchronized T remove(int index) {
        return super.remove(index);
    }

    @Override
    public synchronized T get(int index) {
        return super.get(index);
    }
}

package coffee.order;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class CoffeeOrderBoard {
    private static int number = 0;
    private Queue<Order> orderQueue = new LinkedList<>();

    public void add(Order order){
        order.setOrderNumber(++number);
        orderQueue.add(order);
    }

    public void deliver(){
        orderQueue.poll();
    }

    public void deliver(int number){
        for (Order order : orderQueue) {
            if(order.getOrderNumber() == number){
                orderQueue.remove(order);
                break;                            // Should be Committed to find out ConcurrentModificationException....
            }
        }
    }

    public void draw(){
        System.out.println("Num | Name");
        for (Order order : orderQueue) {
            System.out.println(order.getOrderNumber()+ " | " + order.getClientName());
        }
    }
}

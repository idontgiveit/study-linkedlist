package examples;

import java.util.LinkedList;
import java.util.Queue;


public class LinkedListAsQueue {
    public static void main(String[] args) {
        LinkedList<Integer> queue = new LinkedList<>();

        for (int i = 0; i < 5; i ++) {
            System.out.println("in :" + i);
            add(queue, i);
        }

        for (int i = 0; i < 5; i ++) {
            System.out.println("out :" + get(queue));
        }
    }

    public static void add(Queue<Integer> queue, int value) {
        queue.add(value);
    }

    public static int get(Queue<Integer> queue) {
        return queue.poll();
    }
}

package examples;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;


public class LinkedListAsStack {
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

    public static void add(Deque<Integer> queue, int value) {
        queue.offerFirst(value);
    }

    public static int get(Deque<Integer> queue) {
        return queue.pollFirst();
    }
}

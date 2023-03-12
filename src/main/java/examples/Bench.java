package examples;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Supplier;


public class Bench {
    public static void main(String[] args) {

//        runBench(Bench::insertIntoMiddle, ArrayList::new, 100000, 1, "Insert intto middle arraylist");
//        runBench(Bench::insertIntoMiddle, LinkedList::new, 100000, 1, "Insert intto middle linkedlist");

//       runBench(Bench::insertIntoHead, ArrayList::new, 100000, 1, "Insert intto head arraylist");
//        runBench(Bench::insertIntoHead, LinkedList::new, 100000, 1, "Insert intto head linkedlist");

//        runBench(Bench::insertIntoTail, ArrayList::new, 100000, 1, "Insert intto tail arraylist");
//        runBench(Bench::insertIntoTail, LinkedList::new, 100000, 1, "Insert intto tail linkedlist");

//        int cnt = 100000;
//       runBench(Bench::removeFromMiddle, () -> fillList(new ArrayList<>(), cnt), cnt, 1, "remove from middle arraylist");
//        runBench(Bench::removeFromMiddle, () -> fillList(new LinkedList<>(), cnt), cnt, 1, "remove from middle linkedlist");

//        int cnt = 100000;
//        runBench(Bench::removeFromHead, () -> fillList(new ArrayList<>(), cnt), cnt, 1, "remove from head arraylist");
//        runBench(Bench::removeFromHead, () -> fillList(new LinkedList<>(), cnt), cnt, 1, "remove from head linkedlist");

 //       int cnt = 100000;
//        runBench(Bench::removeFromTail, () -> fillList(new ArrayList<>(), cnt), cnt, 1, "remove from head arraylist");
//        runBench(Bench::removeFromTail, () -> fillList(new LinkedList<>(), cnt), cnt, 1, "remove from head linkedlist");

//        int cnt = 100000;
//        runBench(Bench::readAll, () -> fillList(new ArrayList<>(), cnt), cnt, 1, "read all arraylist");
//        runBench(Bench::readAll, () -> fillList(new LinkedList<>(), cnt), cnt, 1, "read all linkedlist");

    }

    private static List<Integer> fillList(List<Integer> list, int cnt) {
        for (int i = 0; i < cnt; i ++) {
            list.add(i);
        }
        return list;
    }

    public static void runBench(BiConsumer<List<Integer>, Integer> test,
                                Supplier<List<Integer>> listSupplier, int cnt, int runs, String name) {
        long time = System.currentTimeMillis();
        long supplierTime = 0;
        for (int i = 0; i < runs; i ++) {
            long supplierStart = System.currentTimeMillis();
            List<Integer> list = listSupplier.get();
            long supplierRun = System.currentTimeMillis() - supplierStart;
            supplierTime += supplierRun;

            test.accept(list, cnt);
        }
        System.out.println(name + ": " + cnt + " times " + runs + " runs " + (System.currentTimeMillis() - time - supplierTime) + " ms");
        System.out.println("Test preparation: " + supplierTime);

        Runtime rt = Runtime.getRuntime();
        long total_mem = rt.totalMemory();
        long free_mem = rt.freeMemory();
        long used_mem = total_mem - free_mem;
        System.out.println("Amount of used memory: " + used_mem);
        System.out.println("--------------------------------------------------------------------");
    }

    public static void insertIntoMiddle(List<Integer> list, int cnt) {
        for (int i = 0; i < cnt; i ++) {
            int position = list.size() / 2;
            list.add(position, i);
        }
    }

    public static void removeFromMiddle(List<Integer> list, int cnt) {
        for (int i = 0; i < cnt; i ++) {
            int position = list.size() / 2;
            list.remove(position);
        }
    }

    public static void removeFromHead(List<Integer> list, int cnt) {
        for (int i = 0; i < cnt; i ++) {
            list.remove(0);
        }
    }

    public static void removeFromTail(List<Integer> list, int cnt) {
        for (int i = 0; i < cnt; i ++) {
            list.remove(list.size() - 1);
        }
    }

    public static void readAll(List<Integer> list, int cnt) {
        for (int i = 0; i < cnt; i ++) {
            int test = list.get(i);
        }
    }

    public static void insertIntoHead(List<Integer> list, int cnt) {
        for (int i = 0; i < cnt; i ++) {
            list.add(0, i);
        }
    }

    public static void insertIntoTail(List<Integer> list, int cnt) {
        for (int i = 0; i < cnt; i ++) {
            list.add(i);
        }
    }


}

package PriorityQueues_10;

import LinkedLists.Assignment_5.SinglyLinkedList;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
//        LinkedList l = new LinkedList();
//        l.addPriorityLinear(9);
//        l.addPriorityLinear(5);
//        l.addPriorityLinear(10);
//        l.addPriorityLinear(8);
//        l.addPriorityLinear(7);
//        System.out.println(l);
        Heaps h = new Heaps();
//        randomAdder(h,10);
////        h.add(1,3);
////        h.add(2,6);
////        h.add(4,9);
////        h.add(5,7);
//
//        h.root.print();
//        h.root.incrementData(h.size*2);
//        h.pushDown(h.root);
//        System.out.println();
//        h.root.print();
//        for (int i = 0; i < 1000000; i++)
//        {
//            h.add(i);
//        }
//        System.out.println(h.add(10));
//        h.root.incrementData(3);
//        System.out.println(h.pushDown(h.root));
//        System.out.println();
        Benchmark.benchmark(1000);
//        System.out.println(h.root.key);
//        int n = 5;
//        HeapArray h = new HeapArray(n);
//        Random r= new Random();
//        for (int i = 0; i < n; i++) {
//            h.bubble(r.nextInt(n));
//        }
//        for (int i = 0; i < n; i++) {
//            System.out.println(h.heapArray[i]);
//        }
//        int n = 64;
//        HeapArray h = new HeapArray(n);
//        randomAdder(h,64);
//        h.print();
    }
    public static void randomAdder(SinglyLinkedList sll, int n){
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            sll.appendData(random.nextInt(n*2));
        }
    }
    public static void randomAdder(Heaps h, int n){
        Random rd = new Random();
        for (int i = 0; i < n ; i++) {
            int t = rd.nextInt(n);
            h.add(t);
        }
    }
}

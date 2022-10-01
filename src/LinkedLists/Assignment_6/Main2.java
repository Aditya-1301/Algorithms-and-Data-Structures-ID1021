package LinkedLists.Assignment_6;

import LinkedLists.Assignment_5.SinglyLinkedList;
import LinkedLists.Benchmarks;
import LinkedLists.Node;
import LinkedLists.TaskFunctions;

import java.util.Random;

public class Main2 {
    public static void main(String[] args) {
//        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
//        doublyLinkedList.appendData(3);
//        doublyLinkedList.appendData(4);
//        doublyLinkedList.appendData(5);
//        doublyLinkedList.appendData(6);
//        doublyLinkedList.printList();
//        doublyLinkedList.removeData(5);
//        doublyLinkedList.removeData(3);
//        doublyLinkedList.deleteData(6);
////        doublyLinkedList.removeData(7);
//        doublyLinkedList.printList();
        Benchmarks.benchmark(100);
//        int iterations = 1000;
//        Random r = new Random();
//        int [] nValues =
//                { 1000, 250, 500, 1_000, 2_000, 4_000, 8_000, 16_000, 32_000, 64_000, 128_000, 256_000};
//        for (int i = 0; i <nValues.length ; i++) {
//            long t = 0, t4 = 0, t0, t1,t2,t3;
//            int value = r.nextInt(nValues[i]);
//            for (int j = 0; j < iterations; j++) {
//                DoublyLinkedList dl = new DoublyLinkedList();
//                t0 = System.nanoTime();
//                dl.appendData(value);
//                t1 = System.nanoTime();
//                t+= t1 - t0;
//
//                t2 = System.nanoTime();
//                dl.removeData(value);
//                t3 = System.nanoTime();
//                t4+= t3 - t2;
//            }
//            System.out.println(nValues[i]+"\t"+t/iterations + "\t" + t4/iterations);
//        }
    }
}

package LinkedLists;

import LinkedLists.Assignment_5.SinglyLinkedList;

import java.util.Random;

public class TaskFunctions {
    public static void addRandomElementsToTheLinkedList(SinglyLinkedList sll, int n){
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            sll.appendData(random.nextInt(n));
        }
    }
    public static Node randomNodeGenerator(int n){
        Random random = new Random();
        return new Node(random.nextInt(n));
    }
    public static void benchmarkAppendData(SinglyLinkedList singlyLinkedList, int n){
        Random r = new Random();
        long t = 0, t0, t1;
        int i1;
        for (int i = 0; i <n ; i++) {
            i1 = r.nextInt(n);
            t0 = System.nanoTime();
            singlyLinkedList.appendData(i1);
            t1 = System.nanoTime();
            t += t1-t0;
        }
        System.out.printf("%d\t%d\n",n,t/n);
    }
    public static void benchmarkAppendList
            (SinglyLinkedList singlyLinkedList, SinglyLinkedList singlyLinkedList2 , int n){
        Random r = new Random();
        long t = 0, t0, t1;
        for (int i = 0; i < n ; i++) {
            t0 = System.nanoTime();
            singlyLinkedList.appendList(singlyLinkedList2);
            t1 = System.nanoTime();
            t += t1-t0;
        }
        System.out.printf("%d\t%d\n",n,t/n);
    }
}

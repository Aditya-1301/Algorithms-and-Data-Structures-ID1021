package LinkedLists.Assignment_5;

import LinkedLists.Benchmarks;

public class Main3 {
    public static void main(String[] args) throws StackUnderflow {
        SinglyLinkedList sL = new SinglyLinkedList();
        sL.appendData(3);
        sL.appendData(4);
        sL.appendData(5);
        System.out.println(sL);
        sL.removeData(3);
        sL.removeData(4);
        System.out.println(sL);
        //Benchmarks.dynamicArrayBenchmark(1000);
//        int n = 10;
//        DynamicArray a = new DynamicArray(n);
//        Benchmarks.dynamicArrayAddElements(a,n);
//        int[] a1 = new int[n];
//        Benchmarks.arrayGenerator(a1,n);
//        System.out.println(a);
//        a.pushArray(a1);
//        System.out.println(a);
    }
}

package Quicksort_Assignment_8;

import Trees_Assignment_7.BinaryTree;

import java.util.Random;

public class TaskFunctions {
    static Random r = new Random();
    public static int [] randomArrayGenerator(int n){
        int [] randomNumbers = new int[n];
        for (int i = 0; i < n; i++) {
            randomNumbers[i] = r.nextInt(n*10);
        }
        return randomNumbers;
    }
    public static void printArray(int[] a){
        for (int i: a) {
            System.out.printf("%5d",i);
        }
        System.out.println();
    }

    public static void benchmark(int iterations){
        int [] nValues =
                { 1_000, 250, 500, 1_000, 2_000, 4_000, 8_000, 16_000, 32_000, 64_000, 128_000, 256_000, 512_000, 1_024_000};
        for (int i = 0; i < nValues.length; i++) {
            long t = 0, t0, t1;
            for (int j = 0; j < iterations; j++) {
                //int [] a = randomArrayGenerator(nValues[i]);
                LinkedList l = randomLinkedListGenerator(nValues[i]);
                t0 = System.nanoTime();
                //Quicksort.quickSortUnoptimized(a,0,a.length-1);
                //Quicksort.sortLL(l.head,l.tail);
                l.sort(l.head, l.tail);
                t1 = System.nanoTime();
                t += t1 - t0;
            }
            System.out.println(nValues[i] + "\t" + t/(iterations));
        }
    }
    public static LinkedList randomLinkedListGenerator(int n){
        LinkedList l = new LinkedList();
        for (int i = 0; i < n; i++) {
            int x = r.nextInt(n*10);
            l.appendData(x);
        }
        System.out.println();
        return l;
    }
}

package LinkedLists;

import LinkedLists.Assignment_5.DynamicArray;
import LinkedLists.Assignment_5.SinglyLinkedList;
import LinkedLists.Assignment_6.DoublyLinkedList;

import java.util.ArrayList;
import java.util.Random;

public class Benchmarks {
    public static void benchmark(int iterations){

        int [] nValues =
                { 1_000, 250, 500, 1_000, 2_000, 4_000, 8_000, 16_000, 32_000, 64_000, 128_000, 256_000, 512_000, 1_024_000};
                //{ 1000, 25, 50, 100, 200, 400, 800, 1_600, 3_200, 6_400, 12_800, 25_600};

        Random rd = new Random();


        for (int i = 0; i < nValues.length; i++) {
            int value = rd.nextInt(nValues[i] - 1);
            long t = 0, t0, t1;
            for (int j = 0; j < iterations; j++) {
//                SinglyLinkedList sll = new SinglyLinkedList();
//                addElements(sll,nValues[i]);
                DoublyLinkedList dll = new DoublyLinkedList();
                doubleAddElements(dll,nValues[i]);
                t0 = System.nanoTime();
                dll.addNodeToStart(new Node(value));
                //sll.prependHead(new Node(value));
//                sll.appendNode(new Node(value));
//                sll.removeData(1);
//                dll.appendNode(new Node(value));
//                dll.removeData(value);
//                dll.deleteData(value);
                t1 = System.nanoTime();
                t += t1 - t0;
                /*LinkedList nodeA = new LinkedList();
                LinkedList nodeB = new LinkedList();
                addElements(nodeB, nValues[i]);
                addElements(nodeA, 100);

                t0 = System.nanoTime();
                nodeA.appendList(nodeB);
                t1 = System.nanoTime();
                t += t1 - t0;*/
            }
            System.out.println(nValues[i] + "\t" + t/iterations);
        }

    }

    public static int [] randomSequenceGenerator(int n){
        int[] sequence = new int[n];
        Random rnd = new Random();
        for (int i = 0; i < n; i++) {
            sequence[i] = rnd.nextInt(n);
        }
        return sequence;
    }
    public static void doubleAddElements(DoublyLinkedList nodeA, int n){
        for (int i = 0; i < n; i++) {
            nodeA.appendNode(new Node(i*3+1));
        }
    }

    public static void addElements(SinglyLinkedList singlyLinkedList, int n){
        for (int i = 0; i < n; i++) {
            singlyLinkedList.appendData(i*3+1);
        }
    }

    public static void dynamicArrayBenchmark(int iteration){
        int [] nValues =
//                { 1000,250, 500, 1_000, 2_000, 4_000, 8_000, 16_000, 32_000, 64_000, 128_000, 256_000};
                { 1000,250, 500, 1_000, 2_000, 4_000, 8_000, 16_000, 32_000, 64_000, 128_000, 256_000, 512_000, 1_024_000, 2_048_000};
        Random rd = new Random();
        for (int i = 0; i < nValues.length; i++) {
            int value = rd.nextInt(nValues[i]);
            long t = 0, t0, t1;
            for (int j = 0; j < iteration; j++) {
                //DynamicArray a = new DynamicArray(nValues[i]/2);
                int [] a = new int[nValues[i]];
                //dynamicArrayAddElements(a,nValues[i]/2);
                arrayGenerator(a,nValues[i]);
                int a1 [] = new int[nValues[i]];
                arrayGenerator(a1,100);
                t0 = System.nanoTime();
                a = mergeArrays(a,a1);
                t1 = System.nanoTime();
                t += t1 - t0;
            }
            System.out.println(nValues[i] + "\t" + t/iteration);
        }
    }
    public static void arrayListBenchmark(int iteration){
        int [] nValues =
//                { 1000,250, 500, 1_000, 2_000, 4_000, 8_000, 16_000, 32_000, 64_000, 128_000, 256_000};
                { 1000,250, 500, 1_000, 2_000, 4_000, 8_000, 10_000, 8_000, 16_000, 32_000, 64_000, 128_000, 256_000, 512_000, 1_024_000, 2_048_000};
        Random rd = new Random();
        for (int i = 0; i < nValues.length; i++) {
            int value = rd.nextInt(nValues[i]);
            long t = 0, t0, t1;
            for (int j = 0; j < iteration; j++) {
                ArrayList<Integer> a = new ArrayList<>(nValues[i]/2);
//                DynamicArray a = new DynamicArray(nValues[i]/2);
                arrayListAddElements(a,nValues[i]/2);
                ArrayList<Integer> a1 = new ArrayList(nValues[i]);
                arrayGenerator(a1,nValues[i]);
                t0 = System.nanoTime();
                a.addAll(a1);
                t1 = System.nanoTime();
                t += t1 - t0;
            }
            System.out.println(nValues[i] + "\t" + t/iteration);
        }
    }
    public static void arrayListAddElements(ArrayList<Integer> nodeA, int n){
        for (int i = 0; i < n; i++) {
            nodeA.add((i*3+1));
        }
    }
    public static void dynamicArrayAddElements(DynamicArray nodeA, int n){
        for (int i = 0; i < n; i++) {
            nodeA.push((i*3+1));
        }
    }
    public static void arrayGenerator(int [] a, int n){
        for (int i = 0; i < n; i++) {
            a[i] = (i*3+1);
        }
    }

    public static void arrayGenerator(ArrayList<Integer> a, int n){
        for (int i = 0; i < n; i++) {
            a.add(i*3+1);
        }
    }

    public static int [] mergeArrays(int [] a, int [] a1){
        int [] a2 = new int [a.length + a1.length];
        for (int i = 0; i < a.length; i++) {
            a2[i] = a[i];
        }
        for (int i = 0; i <a1.length; i++) {
            a2[i + a.length] = a1[i];
        }
        return a2;
    }
}
//Dynamic Array Benchmark
//10000	22964
//8000	16436
//16000	11200
//32000	39788
//64000	72156
//128000	134065
//256000	291262
//512000	501527
//1024000	1039633
//2048000	2420832
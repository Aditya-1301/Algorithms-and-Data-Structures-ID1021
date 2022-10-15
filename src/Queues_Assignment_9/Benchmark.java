package Queues_Assignment_9;

import Quicksort_Assignment_8.LinkedList;

import java.util.Random;

public class Benchmark {
    static Random r = new Random();
    public static void benchmark(int iterations){
        int [] nValues =
        { 1_000, 250, 500, 1_000, 2_000, 4_000, 8_000, 16_000, 32_000, 64_000, 128_000, 256_000, 512_000, 1_024_000};
        for (int i = 0; i < nValues.length; i++) {
            long t = 0, t0, t1;
            int value = r.nextInt(nValues[i]);
            for (int j = 0; j < iterations; j++) {
                DynamicQueue<Integer> dq = new DynamicQueue<>();
                StaticQueue sq = new StaticQueue(nValues[i]);
                dynamicQueueGenerator(dq,nValues[i]);
                staticQueueFiller(sq,nValues[i]-1);
                t0 = System.nanoTime();
//                dq.enqueue(value);
//                dq.dequeue();
//                sq.enqueue(value);
                sq.dequeue();
                t1 = System.nanoTime();
                t += t1 - t0;
            }
            System.out.println(nValues[i] + "\t" + t/(iterations));
        }
    }
    public static void dynamicQueueGenerator(DynamicQueue<Integer> dq, int n){
        for (int i = 0; i <n ; i++) {
            dq.enqueue(r.nextInt(n));
        }
    }
    public static void staticQueueFiller(StaticQueue sq, int n){
        for (int i = 0; i <n ; i++) {
            sq.enqueue(r.nextInt(n));
        }
    }
}

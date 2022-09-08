package SearchingInASortedArray_Assignment3;

import java.util.Random;

import static SearchingInASortedArray_Assignment3.Task_Methods.*;


public class Benchmarks {
    //Unsorted lin search
    public static void benchmark1(){
        int [ ] nValues =
                {8_000, 16_000, 32_000, 64_000, 128_000, 256_000, 512_000};
        double t = 0, t1,t2;
        int n = 10000;
        Random r = new Random();

        for (int i = 0; i < nValues.length; i++) {

            int [] a0 = new int[nValues[i]];

            for (int j = 0; j <nValues[i] ; j++) {
                a0[j] = r.nextInt(nValues[i]);
            }

            int key = r.nextInt(nValues[i]);

            for (int j = 0; j < n ; j++) {
                t1 = System.nanoTime();
                search_unsorted(a0,key);
                t2 = System.nanoTime();
                t += t2 - t1;
            }
            System.out.println("Time taken for n = " + nValues[i] + "--->" + (t)/n);
        }
//        long t = 0, t1, t0;
//        Random r = new Random();
//        int [ ] nValues = {8_000, 16_000, 32_000, 64_000, 128_000, 256_000, 512_000};
//
//        /*N values that start from 8000 as below this the values are too small for the purpose of benchmarking and
//        the values only go up to 512_000 as otherwise it takes too long for the benchmarking procedure to complete.*/
//
//        search_unsorted(new int[]{2,1,4,5,65,2,-342,352,-3,423,2,1324,324,6},3);
//
//        /*Running the search_unsorted() method before the benchmarking process
//        so that the JIT has lesser effect on the final time calculation.*/
//
//        int n = 100;
//        for (int j = 0; j < nValues.length; j++) {
//            int [] a0 = new int[nValues[j]];
//
//            for (int i = 0; i <nValues[j] ; i++) {
//                a0[i] = r.nextInt(nValues[j]);
//            }
//
//            /*Generating an array with random values of size and
//            bound{for random number generation} nValues[j]*/
//
//            //boolean [] a = new boolean[nValues[j]];
//
//            for (int i = 0; i <n ; i++) {
//                t0 = System.nanoTime();
//                search_unsorted(a0,3);
//                t1 = System.nanoTime();
//                t += t1 -t0;
//            }
//            System.out.println("Time taken for n = " + nValues[j] + "--->" + t/n);
//            t = 0;
//        }
    }

    public static void benchmark2(){
        //Sorted lin search
        int [ ] nValues =
        {8_000, 16_000, 32_000, 64_000, 128_000, 256_000, 512_000};
        long t = 0, t1,t2;
        int n = 1000;
        Random r = new Random();
        for (int i = 0; i < nValues.length; i++) {
            int key = r.nextInt();
            for (int j = 0; j < n ; j++) {
                int [] a1 = sorted(nValues[i]);
                t1 = System.nanoTime();
                search_unsorted_optimized(a1,key);
                t2 = System.nanoTime();
                t += t2 - t1;
            }
            System.out.println("Time taken for n = " + nValues[i] + "--->" + t/n);
        }
    }

    public static void benchmark3(){
        //binary search
        int [ ] nValues =
                {8_000, 16_000, 32_000, 64_000, 128_000, 256_000, 512_000};
        int min = (int) Double.POSITIVE_INFINITY;
        long t = 0, t1,t2;
        Random r = new Random();
        int n = 1000;
        for (int i = 0; i < nValues.length; i++) {
            int key = r.nextInt();
            for (int j = 0; j < n ; j++) {
                int [] array = sorted(nValues[i]);
                t1 = System.nanoTime();
                binary_search(array,key);
                t2 = System.nanoTime();
                t += t2 - t1;
            }
            System.out.println("Time taken for n = " + nValues[i] + "--->" + t/(n));
        }
    }

    public static void benchmark4(){
        //Binary Duplicates
        int [ ] nValues =
                {8_000, 16_000, 32_000, 64_000, 128_000, 256_000, 512_000};
        long t = 0, t1,t2;
        int n = 10000;
        for (int i = 0; i < nValues.length; i++) {
            int [] array1 = sorted(nValues[i]);
            int [] array2 = sorted(nValues[i]);
            for (int j = 0; j <n ; j++) {
                t1 = System.nanoTime();
                binary_duplicates(array1,array2);
                t2 = System.nanoTime();
                t += t2 - t1;
            }
            System.out.println("Time taken for n = " + nValues[i] + "--->" + t/n);
        }
    }

    public static void benchmark5(){
        //Parallel Duplicates
        int [ ] nValues =
                {8_000, 16_000, 32_000, 64_000, 128_000, 256_000, 512_000};
        long t = 0, t1,t2;
        int n = 10000;
        for (int i = 0; i < nValues.length; i++) {
            int [] array1 = sorted(i);
            int [] array2 = sorted(i);
            for (int j = 0; j < n ; j++) {
                t1 = System.nanoTime();
                parallel_duplicates(array1,array2);
                t2 = System.nanoTime();
                t += t2 - t1;
            }
            System.out.println("Time taken for n = " + nValues[i] + "--->" + t/n);
        }
    }
}

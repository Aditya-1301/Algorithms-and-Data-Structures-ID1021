package Introduction_Assignment1;

import java.util.Random;
import java.util.Scanner;

public class Introduction {
    public static void first(int [] index){
        int[] given = {1,2,3,4,5,6,7,8,9,0};
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            long t0 = System.nanoTime();
            sum += given[index[i]];
            long t1 = System.nanoTime();
            System.out.println(" resolution " + (t1- t0) + " nanoseconds " + sum);
        }
    }

    public static void main(String[] args) {
//        for (int i = 0; i < 10; i++) {
//            long n0 = System.nanoTime();
//            long n1 = System.nanoTime();
//            System.out.println(" resolution " + (n1- n0) + " nanoseconds");
//        }
        //int [] index  = randomArrayGenerator(n);
        //for (int i = 0; i <n ; i++) {
        while (true){
            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();
            System.out.println(access(n));
        }
        //}
    }
    private static int [] randomArrayGenerator(int n) {
        int [] a = new int [n];
        Random random = new Random();
        for (int i = 0; i < n ; i++) {
            a[i] = random.nextInt(n);
        }
        return a;
    }

    private static double access(int n) {
        int k = 1_000_000;
        int l = n;
        Random rnd = new Random();
        int[] index = new int[l];
        // fill the index array with random number from 0 to n (not including n)
        int[] array = new int[n];
        // fill the array with dummy values (why not 1)
        for (int i: array) i = 1;
        int sum = 0;
        long t0 = System.nanoTime();
        for (int j = 0; j < k; j++) {
            for (int i = 0; i < l; i++) {
                // access the array with the index given by index[i]
                // sum up the result
                sum += array[index[i]];
            }
        }
        long t_access = (System.nanoTime() - t0);
        t0 = System.nanoTime();
        // do the same loop iteration but only do a dummy add operation
        long t_dummy = (System.nanoTime() - t0);
        return ((double)(t_access - t_dummy))/((double)k*(double)l);
    }

}

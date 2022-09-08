package Introduction_Assignment1;

import java.util.Random;
import java.util.Scanner;

public class Introduction2 {

    public static void main(String[] args) {
//        search(10);
//        long s1 ,s2, s3, s4 ,s5 ,s6 ;
//        for (int i = 0; i < 10 ; i++) {
//        s1 = search(1);
//        System.out.println("1 :" + s1 + "| Ratio: " + 1  + "| Ratio3: " + 1);
//        s2 = search(10);
//        System.out.println("10 :" + s2 + "| Ratio: " + ((double)s2)/s1 + "| Ratio2: " + 10 + "| Ratio3: " + ((double)s2)/s1);
//        s3 = search(20);
//        System.out.println("20 :" + s3 + "| Ratio: " + ((double)s3)/s1 + "| Ratio2: " + 20 + "| Ratio3: " + ((double)s3)/s2) ;
//        s4 = search( 100);
//        System.out.println("100 :" + s4 + "| Ratio: " + ((double)s4)/s1 + "| Ratio2: " + 100 + "| Ratio3: " + ((double)s4)/s3);
//        s5 = search(1000);
//        System.out.println("1000 :" + s5 + "| Ratio: " + ((double)s5)/s1 + "| Ratio2: " + 1000 + "| Ratio3: " + ((double)s5)/s4);
//        s6 = search(10000);
//        System.out.println("10000 :" + s6 + "| Ratio: " + ((double)s6)/s1 + "| Ratio2: " + 10000 + "| Ratio3: " + ((double)s6)/s5);
//        //System.out.println("100000 :" + search(100000));
//        System.out.println("----------" + i);
//        }
//        System.out.println(search(10));
        searchDuplicates(100);
        searchDuplicates(200);
        searchDuplicates(400);
        searchDuplicates(800);
        searchDuplicates(1600);

        System.out.println("\n\n\n");
        System.out.println(search(1));
        System.out.println(search(10));
        System.out.println(search(20));
        System.out.println(search(100));
        System.out.println(search(1000));
        System.out.println(search(10000));
    }

    public static void searchDuplicates(int n){
        int k = 10;
        int m = n;
        Random rnd = new Random();
        int sum = 0;
        long t_total = 0;
        int[] keys = new int[m];
        int[] array = new int[n];
        for (int j = 0; j < k; j++) {

            long t0 = System.nanoTime();
            for (int ki = 0; ki < m; ki++) {
                int key = keys[ki];
                for (int i = ki + 1; i < n; i++) {
                    if (array[i] == key) {
                        sum++;
                        break;
                    }
                }
            }
            t_total += (System.nanoTime() - t0);
            System.out.println("t_total: "+ j + " " + t_total);
        }
        System.out.println("---------------" + n);
    }
    public static long search(int n){
        int k = 10;
        int m = n*2;
        Random rnd = new Random();
        int sum = 0;
        long t_total = 0;
        int[] keys = new int[m];
        int[] array = new int[n];
        for (int j = 0; j < k; j++) {
            for (int i = 0; i < m; i++) {
                // fill the keys array with random number from 0 to 10*n
                keys[i] = rnd.nextInt(10 * n);
            }
            for (int i = 0; i < n ; i++) {
                // fill the array with random number from 0 to 10*n
                array[i] = rnd.nextInt(10 * n);
            }

            long t0 = System.nanoTime();
            for (int ki = 0; ki < m; ki++) {
                int key = keys[ki];
                for (int i = ki + 1; i < n; i++) {
                    if (array[ki] == array[i]) {
                        sum++;
                        break;
                    }
                }
            }
            t_total += (System.nanoTime() - t0);
        }
        //System.out.println("t_total:"+t_total);
        return t_total;
    }
    private static double access(int n) {
        int k = 1_000_000;
        int l = n;
        Random rnd = new Random();
        int[] indx = new int[l];
        int[] array = new int[n];
        // fill the indx array with random number from 0 to n (not including n)
        // fill the array with dummy values (why not 1)
        for (int i = 0; i < l; i++) {
            indx[i] = rnd.nextInt(l);
            array[i] = 1;
        }
        int sum = 0;
        long t0 = System.nanoTime();
        for (int j = 0; j < k; j++) {
            for (int i = 0; i < l; i++) {
                // access the array with the index given by indx[i]
                // sum up the result
                sum += array[indx[i]];
            }
        }
        long t_access = (System.nanoTime() - t0);
        t0 = System.nanoTime();
        // do the same loop iteration but only do a dummy add operation
        sum = 0;
        for (int j = 0; j < k; j++) {
            for (int i = 0; i < l; i++) {
                sum ++;
            }
        }
        long t_dummy = (System.nanoTime() - t0);
//        System.out.println("ACCESS:" + ((double) (t_access)) / ((double) k * (double) l));
//        System.out.println("DUMMY:" + ((double) (t_dummy)) / ((double) k * (double) l));
        return ((double) (t_access - t_dummy)) / ((double) k * (double) l);
    }

    public static void badAccess() {
        int n = 50;
        int[] given = new int[n];
        int sum = 0;
        long tSum = 0;
        for (int i = 0; i < n; i++) {
            given[i] = i;
        }
        for (int i = 0; i < n; i++) {
            long t0 = System.nanoTime();
            sum += given[i];
            long t1 = System.nanoTime();
            tSum += (t1 - t0);
            System.out.println(" resolution " + (t1 - t0) + " nanoseconds " + sum);
        }
        System.out.println("TSUM:" + tSum / n);
    }

}

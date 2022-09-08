package SearchingInASortedArray_Assignment3;

import java.util.Random;

public class Task_Methods {

    public static boolean search_unsorted(int[] array, int key) {
        for (int index = 0; index < array.length ; index++) {
            if (array[index] == key) {
                return true;
            }
        } return false;
    }

    public static boolean search_unsorted_optimized(int[] sorted_array, int key) {
        for (int index = 0; index < sorted_array.length ; index++) {
            if(sorted_array[index] > key){
                return false;
            }
            if (sorted_array[index] == key) {
                return true;
            }
        } return false;
    }
    public static int[] sorted(int n) {
        Random rnd = new Random();
        int[] array = new int[n];
        int nxt = 0;
        for (int i = 0; i < n ; i++) {
            nxt += rnd.nextInt(10) + 1;
            array[i] = nxt;
        }
        return array;
    }

    public static boolean binary_search(int[] array, int key) {
        int min = 0;
        int max = array.length-1;
        while (max - min > 1) {
        // jump to the middle
            int mid = min + (max - min)/2; // gives the middle point in the array's index
            if (array[mid] == key) {
                //System.out.println("key found");
                return true;
            }
            if (array[mid] < key && mid < max) {
            // The middle position holds something that is less than
            // what were looking for, what is the min possible page?
                min = mid + 1;
                continue;
            }
            if (array[mid] > key && mid > min) {
            // The mid position holds something that is larger than
            // what were looking for, what is the max possible page?
                max = mid;
                continue;
            }
            // Why do we land here? What should we do?
            }
        return false;
    }

    public static void parallel_duplicates(int[] list1, int[] list2){

        int i = 0;
        int j = 0;
        int n = list1.length;

        //list1 = sorted(n);
        //list2 = sorted(n);

        while(i+1 < n && j+1 < n) {
            if (list2[i + 1] < list1[j + 1] || list2[i + 1] == list1[j + 1]) {
                i++;
            } else if (list1[j + 1] < list2[i + 1]) {
                j++;
            }
        }
    }

    public static void binary_duplicates(int[] list1, int[] list2){

        for (int i = 0; i < list1.length; i++) {
            int key = list1[i];
            //for (int j = 0; j < list2.length; j++) {
            binary_search(list2, key);
            //}
        }
    }

//    public static boolean searchImproved(int i){
//        int j = 0;
//        int k = 0;
//        while(j < array1.length && k < array2.length){
//            t1 = System.nanoTime();
//            if(array1[j] < array2[k]){
//                j++;
//            } else if (array1[j] > array2[k]) {
//                k++;
//            }
//            else if(array1[j] == array2[k]){
//
//            }
//            t2 = System.nanoTime();
//            t += t2 - t1;
//        }
//    }
}

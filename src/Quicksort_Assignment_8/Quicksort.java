package Quicksort_Assignment_8;

import java.util.Random;

public class Quicksort {
    public static void quickSortUnoptimized(int [] array, int lowIndex, int highIndex){
        if(lowIndex >= highIndex){
            return;
        }
        int pivot = array[highIndex];

        int leftPointer = lowIndex;
        int rightPointer = highIndex;
        while (leftPointer < rightPointer){
            while(array[leftPointer] <= pivot && leftPointer < rightPointer){
                leftPointer++;
            }
            while(array[rightPointer] >= pivot && leftPointer < rightPointer){
                rightPointer--;
            }
            swap(array,leftPointer,rightPointer);
        }
        swap(array,leftPointer,highIndex);

        quickSort(array,lowIndex,leftPointer-1);
        quickSort(array,leftPointer+1,highIndex);
    }
    public static void quickSort(int [] array, int lowIndex, int highIndex){
        if(lowIndex >= highIndex){
            return;
        }
        int pivotIndex = new Random().nextInt(highIndex - lowIndex) + lowIndex;
        int pivot = array[pivotIndex];
        swap(array,pivotIndex,highIndex);
        int leftPointer = partition(array,lowIndex,highIndex,pivot);

        quickSort(array,lowIndex,leftPointer-1);
        quickSort(array,leftPointer+1,highIndex);
    }
    public static int partition(int [] array, int lowIndex, int highIndex, int pivot){
        int leftPointer = lowIndex;
        int rightPointer = highIndex;
        while (leftPointer < rightPointer){
            while(array[leftPointer] <= pivot && leftPointer < rightPointer){
                leftPointer++;
            }
            while(array[rightPointer] >= pivot && leftPointer < rightPointer){
                rightPointer--;
            }
            swap(array,leftPointer,rightPointer);
        }
        swap(array,leftPointer,highIndex);
        return leftPointer;
    }
    private static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

//    public static void sort(LinkedList.Node lo, LinkedList.Node hi){
//        if(lo != null || )
//    }

    public static LinkedList.Node partition(LinkedList.Node start, LinkedList.Node end){
        if(start == end || start == null || end == null){
            return start;
        }
        LinkedList.Node pivotPrev = start;
        LinkedList.Node current = start;
        int pivot = end.data;

        while(start != end){
            if(start.data < pivot){
                pivotPrev = current;
                int temp = current.data;
                current.data = start.data;
                start.data = temp;
                current = current.next;
            }
            start = start.next;
        }
        int temp = current.data;
        current.data = pivot;
        end.data = temp;

        return pivotPrev;
    }


    public static void sortLL(LinkedList.Node start, LinkedList.Node end){
        if(start == null || end == null || start == end){
            return;
        }
        LinkedList.Node pivotPrev = partition(start,end);
        sortLL(start,pivotPrev);

        if(pivotPrev != null && pivotPrev == start){
            sortLL(pivotPrev.next,end);
        }

        else if(pivotPrev != null && pivotPrev.next != null){
            sortLL(pivotPrev.next.next,end);
        }
    }

    public static LinkedList.Node iterateTo(LinkedList.Node lo, LinkedList.Node hi){
        LinkedList.Node current = lo;
        while(current.next!=hi){
            current =current.next;
        }
        return current;
    }
    public static void sort1(int [] arr, int low, int high){
        if(low < high){
            int pi = partition2(arr, low, high);
            sort1(arr, low, pi - 1);
            sort1(arr,pi + 1, high);
        }
    }
    public static int partition2(int [] arr, int low, int high){
        // pivot (Element to be placed at right position)
        int pivot = arr[high];

        int i = (low - 1); // Index of smaller element and indicates the
        // right position of pivot found so far

        for (int j = low; j <= high - 1; j++){
            // If current element is smaller than the pivot
            if (arr[j] < pivot){
                i++;    // increment index of smaller element
                swap (arr,i,j);
            }
        }
        swap (arr, i + 1 ,high);
        return (i + 1);
    }

}
/*
The main steps in the QuickSort Algorithm:-
1. Choose a Pivot.
2. Do the partitioning.
3. Do the recursive Quicksort Call.
*/

//Node current = lo;
//while(current.next != hi){
//    current = current.next;
//}


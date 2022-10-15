package Quicksort_Assignment_8;

public class Main {
    public static void main(String[] args) {
//        int n = 10;
//        int [] numbers = TaskFunctions.randomArrayGenerator(n);
//
//        System.out.println("Before:");
//        TaskFunctions.printArray(numbers);
//
//        Quicksort.quickSortUnoptimized(numbers,0,numbers.length-1);
//
//        System.out.println("\nAfter");
//        TaskFunctions.printArray(numbers);
//        int [] numbers2 = TaskFunctions.randomArrayGenerator(n);
//        TaskFunctions.printArray(numbers2);
//        Quicksort.sort1(numbers2,0,numbers2.length-1);
//        System.out.println("\nAfter");
//        TaskFunctions.printArray(numbers2);
        int n = 10;
        LinkedList l = TaskFunctions.randomLinkedListGenerator(n);
        System.out.println(l);
        System.out.println();
        l.quickSortLL(l.head, l.tail);
        System.out.println(l);
//        Quicksort.sortLL(l.head, l.tail);
//        LinkedList.Node current = l.head;
//        while(current !=null){
//            System.out.printf(current.data + "\t");
//            current = current.next;
//        }
//        TaskFunctions.benchmark(1000);
//        System.out.println(fib(5));
    }

//    public static int fib(int n){
//        if(n == 0 || n == 1){
//            return 1;
//        }
//        else{
//            return fib(n-1) + fib(n-2);
//        }
//    }
}

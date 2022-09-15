package SortingAlgorithms_Assignment_4;

public class Main {
    public static void main(String[] args) {
        System.out.printf("N\tSelection Sort\tInsertion Sort\tMerge Sort\tMerge Sort Arrays");
        TaskFunctions.benchmarkForAllAlgorithms();
        Runtime. getRuntime(). gc();
//        long t = 0, t1, t2;
//        Random r = new Random();
//        int n = 10;
//        int [] a= new int[n];
//        System.out.println("unsorted:");
//        for (int i = 0; i < n  ; i++) {
//            a[i] = r.nextInt(n);
//            System.out.print(a[i] + "\t");
//        }
//        for (int i = 0; i < n; i++) {
//            t1 = System.nanoTime();
//            SortingAlgorithms.mergeSortArrays(a);
//            t2 = System.nanoTime();
//            t+= t2 - t1;
//        }
//        System.out.println("\nsorted:");
//        for (int i = 0; i < n; i++) {
//            System.out.print(a[i] + "\t");
//        }
    }
    public static void test(){
        int [] a = {1,34,-7,243,-532,0, 345,23,56,87,8};
        System.out.println("Unsorted Array: ");
        for (int a1: a) {
            System.out.printf("%d   ",a1);
        }
        System.out.println();
        //SortingAlgorithms.mergeSort(a);
        //SortingAlgorithms.insertionSort(a);
        SortingAlgorithms.selectionSort(a);
        System.out.println("Sorted Array: ");
        for (int a1: a) {
            System.out.printf("%d   ",a1);
        }
    }
}

// LAST RUN OF THE BENCHMARKS ON ALL OF OUR SORTING ALGORITHMS GIVES US THIS DATA:-
//         N	Selection Sort	Insertion Sort	Merge Sort	Merge Sort Arrays
//        800	     60762	        66765	       24813	     49390
//        1600	    199831	       197009	       51375	    141399
//        2400	    386631	       383638	       47175	    308793
//        3200	    711771	       709645	       60301	    592823
//        4000	   1166235	      1163862	       81215	   1062714
//        4800	   1644116	      1638433	       91871	   1744785
//        5600	   2208618	      2204869	      116724	   2723147
//        6400	   2873484	      2864718	      143754	   5297197
//        12800	  11310411	     11100451	      277295	  17313500
//        25600	  78470655	     77966553	      937248	 111816386


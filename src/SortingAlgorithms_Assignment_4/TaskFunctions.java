package SortingAlgorithms_Assignment_4;

import java.util.Random;

public class TaskFunctions {
    public static void benchmarkForAllAlgorithms(){
        int [ ] nValues =
                //{8_000, 16_000, 32_000, 64_000, 128_000, 256_000, 512_000};
                //{800, 1_600, 2_400, 3_200, 4_000, 4_800, 5_600, 6_400, 12_800, 25_600};
                {4_000, 8_000, 16_000, 32_000, 64_000, 128_000};
        long tSel = 0,tSel1,tSel2, tIns = 0, tIns1, tIns2, tMer = 0, tMer1, tMer2, tMerge = 0, tMerge1, tMerge2;
        Random r = new Random();
        int n = 1000;
        for (int i = 0; i < nValues.length; i++) {
            int [] unsortedArray = randomArrayGenerator(nValues[i]);
            for (int j = 0; j < n ; j++) {
                tSel1 = System.nanoTime();
                SortingAlgorithms.selectionSort(unsortedArray);
                tSel2 = System.nanoTime();

                tIns1 = System.nanoTime();
                SortingAlgorithms.insertionSort(unsortedArray);
                tIns2 = System.nanoTime();

                tMer1 = System.nanoTime();
                SortingAlgorithms.mergeSort(unsortedArray);
                tMer2 = System.nanoTime();

                tMerge1 = System.nanoTime();
                SortingAlgorithms.mergeSortArrays(unsortedArray);
                tMerge2 = System.nanoTime();

                tSel += tSel2 - tSel1;
                tIns += tIns2 - tIns1;
                tMer += tMer2 - tMer1;
                tMerge += tMerge2 - tMerge1;
            }
            //System.out.println("Time taken for n = " + nValues[i] + "--->" + tSel/(n));
            System.out.printf("\n%d\t%d\t%d\t%d\t%d",nValues[i],tSel/n,tIns/n,tMer/n,tMerge/n);
            tIns = 0;
            tSel = 0;
            tMer = 0;
        }
    }
    public static int [] randomArrayGenerator(int arrayLength){
        int [] randomArray = new int[arrayLength];
        Random random = new Random();
        for (int ra: randomArray) {
            ra = random.nextInt(arrayLength);
        }
        return randomArray;
    }
}

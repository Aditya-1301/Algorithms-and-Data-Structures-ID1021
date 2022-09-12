package Sorting_Algorithms_Assignment_4;

public class SortingAlgorithms {
    public static void selectionSort(int [] inputArray){
        int min, t;
        for (int i = 0; i < inputArray.length - 1; i++) {
            min = i;
            for (int j = i; j < inputArray.length; j++) {
                if(inputArray[min]>inputArray[j]){
                    min = j;
                }
                if(min != i){
                    t = inputArray[min];
                    inputArray[min] = inputArray[i];
                    inputArray[i] = t;
                }
            }
        }
    }
    //    public static void selectionSortOptimized(int [] inputArray){
//        for (int i = 0; i < inputArray.length; i++) {
//        // for each element from i towards 1, swap the item found with the
//        // item before it if it is smaller
//            for (int j = i; j > 0 ; j--) {//j>0 && .....
//
//            }
//        }
//    }
    public static void insertionSort(int [] inputArray){
        for (int i = 1; i <inputArray.length ; i++) {
            for (int j = 0; j < i ; j++) {
                if(inputArray[i] < inputArray[j]){
                    int t = inputArray[i];
                    inputArray[i] = inputArray[j];
                    inputArray[j] = t;
                }
            }
        }
    }
    public static void mergeSort(int [] inputArray){
        int arrayLength = inputArray.length;
        if (arrayLength<2){
            return;
        }
        int midIndex = arrayLength/2;
        int [] leftHalf = new int[midIndex];
        int [] rightHalf = new int[arrayLength - midIndex];

        for (int i = 0; i <midIndex ; i++) {
            leftHalf[i] = inputArray[i];
        }
        for (int i = midIndex; i <arrayLength ; i++) {
            rightHalf[i-midIndex] = inputArray[i];
        }
        mergeSort(leftHalf);
        mergeSort(rightHalf);

        //MERGE
        merge(inputArray, leftHalf, rightHalf);
    }

    private static void merge(int[] inputArray, int[] leftHalf, int[] rightHalf) {
        int lengthOfLeftHalf = leftHalf.length;
        int lengthOfRightHalf = rightHalf.length;
        int i = 0, j = 0, k = 0;
        while(i < lengthOfLeftHalf && j < lengthOfRightHalf){
            if(leftHalf[i] <= rightHalf[j]){
                inputArray[k] = leftHalf[i];
                i++;
            }
            else{
                inputArray[k] = rightHalf[j];
                j++;
            }
            k++;
        }
        while(i < lengthOfLeftHalf){
            inputArray[k++] = leftHalf[i++];
        }
        while (j < lengthOfRightHalf){
            inputArray[k++] = rightHalf[j++];
        }
    }
    public static void mergeSortArrays(int[] org) {
        if (org.length == 0)
            return;
        int[] aux = new int[org.length];
        mergeSortArrays(org, aux, 0, org.length -1);
    }
    private static void mergeArrays(int[] org, int[] aux, int lo, int mid, int hi) {
        // copy all items from lo to hi from org to aux
        for (int i = 0; i < org.length ; i++) {
            org[i] = aux[i];
        }
        // let's do the merging
        int i = lo; // the index in the first part
        int j = mid+1; // the index in the second part
        // for all indices from lo to hi
        for ( int k = lo; k <= hi; k++) {
            // if i is greater than mid, move the j item to the org array, update j
            if(i > mid){
                org[k] = org[j];
                j++;
            }
            // else if j is greater than hi, move the i item to the org array, update i
            else if (j > hi) {
                org[k] = org[i];
                i++;
            }
            // else if the i item is smaller than the j item,
            // move it to the org array, update i
            else if (org[i] < org[j]) {
                org[k] = org[i];
                i++;
            }
            // else you can move the j item to the org array, update j
            else{
                org[k] = org[j];
                j++;
            }
        }
    }
    private static void mergeSortArrays(int[] org, int[] aux, int lo, int hi) {
        if (lo != hi) {
            int mid = lo + (hi-lo)/2;
// sort the items from lo to mid
            mergeSortArrays(org,aux,lo,mid);
// sort the items from mid+1 to hi
            mergeSortArrays(org,aux,mid+1,hi);
// merge the two sections using the additional array merge(org, aux, lo, mid, hi);
            mergeArrays(org,aux,lo,mid,hi);
        }
    }
}

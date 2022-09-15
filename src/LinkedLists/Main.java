package LinkedLists;

import LinkedLists.Assignment_5.SinglyLinkedList;

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        SinglyLinkedList singlyLinkedList2 = new SinglyLinkedList();
        //System.out.println(TaskFunctions.addRandomElementsToTheLinkedList(singlyLinkedList,5));
        singlyLinkedList.appendData(5);
        int [] nValues =
                { 1_000, 2_000,4_000,8_000,16_000,32_000,64_000,128_000,256_000 };
        for (int i = 0; i <nValues.length ; i++) {
            TaskFunctions.addRandomElementsToTheLinkedList(singlyLinkedList2,1000);
            TaskFunctions.addRandomElementsToTheLinkedList(singlyLinkedList,nValues[i]);
        }
        for (int i = 0; i <nValues.length ; i++) {
            //TaskFunctions.benchmarkAppendData(singlyLinkedList,nValues[i]);
            TaskFunctions.benchmarkAppendList(singlyLinkedList, singlyLinkedList2, nValues[i]);
        }
//        System.out.println(singlyLinkedList);
//        System.out.println("Length of this list:\t"+ singlyLinkedList.listLength());
    }
}

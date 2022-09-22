package LinkedLists;

import LinkedLists.Assignment_5.DynamicStackWithLinkedLists;
import LinkedLists.Assignment_5.SinglyLinkedList;
import LinkedLists.Assignment_5.StackUnderflow;

public class Main {
    public static void main(String[] args) throws StackUnderflow {
//        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
//        DynamicStackWithLinkedLists dsll = new DynamicStackWithLinkedLists(singlyLinkedList);
//        dsll.push(5);
//        dsll.push(4);
//        dsll.push(3);
//        dsll.push(2);
//        dsll.push(1);
//        dsll.push(0);
//        System.out.println(dsll);
//        dsll.pop();
//        System.out.println(dsll);
//        dsll.pop();
//        dsll.printStack();

        int iterations = 1000;
        int [] nValues =
                { 1000, 250, 500, 1_000, 2_000, 4_000, 8_000, 16_000, 32_000, 64_000, 128_000, 256_000};
        for (int i = 0; i <nValues.length ; i++) {
            long t = 0, t0, t1;
            for (int j = 0; j < iterations; j++) {
                SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
                SinglyLinkedList singlyLinkedList2 = new SinglyLinkedList();
//                TaskFunctions.addRandomElementsToTheLinkedList(singlyLinkedList,100);
//                TaskFunctions.addRandomElementsToTheLinkedList(singlyLinkedList2,nValues[i]);
                TaskFunctions.addIElementsToTheLinkedList(singlyLinkedList,100);
                TaskFunctions.addIElementsToTheLinkedList(singlyLinkedList2,nValues[i]);
                t0 = System.nanoTime();
                singlyLinkedList.appendList(singlyLinkedList2);
                t1 = System.nanoTime();
                t+= t1 - t0;
            }
            System.out.println(nValues[i]+"\t"+t/iterations);
        }
        /*
        singlyLinkedList.appendData(10);
        singlyLinkedList.appendData(11);
        singlyLinkedList.appendData(12);
        singlyLinkedList.appendData(13);
        singlyLinkedList.appendData(14);
//        singlyLinkedList.appendData(15);
//        singlyLinkedList.appendData(16);
//        singlyLinkedList.appendData(17);
//        singlyLinkedList.appendData(18);
//        singlyLinkedList.appendData(19);
//        singlyLinkedList.appendData(20);
//        singlyLinkedList.appendData(21);
        singlyLinkedList2.appendData(10);
        singlyLinkedList2.appendData(11);
        singlyLinkedList2.appendData(12);
        singlyLinkedList2.appendData(13);
        singlyLinkedList2.appendData(14);
        singlyLinkedList2.appendData(15);
        singlyLinkedList2.appendData(16);
        singlyLinkedList2.appendData(17);
        singlyLinkedList2.appendData(18);
        singlyLinkedList2.appendData(19);
        singlyLinkedList2.appendData(20);
        singlyLinkedList2.appendData(21);*/
    }
}
/*
250	993714
500	1497308
1000	999016
2000	1103269
4000	1092092
8000	1128461
16000	1115057
32000	1149831
64000	2335364
*/
//benchmark(ll1,ll2,iterations)

//        250	2139094
//        500	2129731
//        1000	2024166
//        2000	1995540
//        4000	2237859
//        8000	2166701
//        16000	1994792
//        32000	1666823
//        64000	1349849
//        128000 1232525
//        256000 2011902

/*
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
////        System.out.println(singlyLinkedList);
//        DynamicStackWithLinkedLists dsll = new DynamicStackWithLinkedLists(singlyLinkedList);
//        dsll.push(5);
//        dsll.push(4);
//        dsll.push(3);
//        dsll.push(2);
//        dsll.push(1);
//        dsll.push(0);
//        System.out.println(dsll);
//        dsll.pop();
//        System.out.println(dsll);
//        DynamicStackWithLinkedLists.printStack();
        SinglyLinkedList singlyLinkedList2 = new SinglyLinkedList();
//        //System.out.println(TaskFunctions.addRandomElementsToTheLinkedList(singlyLinkedList,5));
//        singlyLinkedList.appendData(5);
        int [] nValues =
                { 250, 500, 1_000, 2_000, 4_000, 8_000, 16_000, 32_000, 64_000, 128_000, 256_000};
        TaskFunctions.addRandomElementsToTheLinkedList(singlyLinkedList,1000);
        for (int i = 0; i <nValues.length ; i++) {
            //TaskFunctions.benchmarkAppendData(singlyLinkedList,nValues[i]);
            TaskFunctions.addRandomElementsToTheLinkedList(singlyLinkedList2,nValues[i]);
            TaskFunctions.benchmarkAppendList(singlyLinkedList, singlyLinkedList2, nValues[i]);
        }
//        System.out.println(singlyLinkedList);
//        System.out.println("Length of this list:\t"+ singlyLinkedList.listLength());
*/
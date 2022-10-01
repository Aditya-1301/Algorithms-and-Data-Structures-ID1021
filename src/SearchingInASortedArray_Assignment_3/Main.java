package SearchingInASortedArray_Assignment_3;

import static SearchingInASortedArray_Assignment_3.Benchmarks.*;

public class Main {
    public static void main(String[] args) {
        //benchmark1();
        //benchmark2();
        benchmark3();
        //benchmark4();
        //benchmark5();
    }
}

//        int [] sortedArray = sorted(10);
//        for (int sa: sortedArray) {
//            System.out.printf("%d   ",sa);
//        }
//        System.out.println();
//        int key = 6;//new Random().nextInt(sortedArray.length);
//        System.out.println("key :" + key);
//        System.out.println("Key status: "+ binary_search(sortedArray,key));
//    }
//}


//A method to display how labels in Java work
//public static void labelsAreAwesome(){
//    Random r = new Random();
//    outer_loop:
//    for (int i = 0; i < 10; i++) {
//        inner_loop:
//        for (int j = 0; j < 3; j++) {
//            if(r.nextInt(10) == 5){
//                System.out.println("i+j " + i+j + " " + i + " " + j);
//                break outer_loop;
//            }
//            else continue inner_loop;
//        }
//    }
//}
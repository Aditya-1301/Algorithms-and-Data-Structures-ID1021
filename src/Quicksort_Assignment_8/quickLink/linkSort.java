package Quicksort_Assignment_8.quickLink;

import Quicksort_Assignment_8.LinkedList;
import Quicksort_Assignment_8.TaskFunctions;

public class linkSort {
    public static void sort(LinkedList.Node start, LinkedList.Node end){
        if (start == null || start == end || end == null)
            return;
        LinkedList.Node pivot = end;

        LinkedList.Node left = start;
        LinkedList.Node right = start;

        while(left != right){
            while(left.data <= pivot.data && left != null){
                left = left.next;
            }
            while(right.data >= pivot.data && right != null){
                right = right.next;
            }
            swap(left,right);
        }
        swap(start,end);

        LinkedList.Node current = start;
        while(current!=null && current.next!=left){
            current = current.next;
        }
        sort(start,current);
        sort(left.next,end);
    }
    public static void swap(LinkedList.Node left, LinkedList.Node right){
        Integer temp = left.data;
        left.data = right.data;
        right.data = temp;
    }

    public static void main(String[] args) {
        LinkedList l = TaskFunctions.randomLinkedListGenerator(10);
        System.out.println(l);
        linkSort.sort(l.head,l.tail);
        System.out.println(l);
    }
}

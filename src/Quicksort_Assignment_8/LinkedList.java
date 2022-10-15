package Quicksort_Assignment_8;

import LinkedLists.Node;
import PriorityQueues.Heaps;

public class LinkedList {
    public static class Node{
        public int data;
        public Node next;
        //public Node prev;
        Node(int data){
            this.data = data;
        }
    }
    public Node head;
    public Node tail;

    @Override
    public String toString() {
        System.out.println("Elements in this List :\t");
        StringBuilder stringBuilder = new StringBuilder();
        Node current = head;
        if(head == null){
            return "No Elements";
        }
        else{
            while(current != null){
                stringBuilder.append(current.data + "\t");
                current = current.next;
            }
        }
        return stringBuilder.toString();
    }

    public void appendData(int data){
        if(head == null){
            head = new Node(data);
            tail = head;
            return;
        } else{
            if(tail.next != null){
                tail.next.next = new Node(data);
                return;
            }
            Node current = head;
            while(current.next != null){
                current = current.next;
            }
            current.next = new Node(data);
            tail = current.next;
        }
//        if(head == null){
//            head = new Node(data);
//            head.prev = null;
//            head.next = null;
//            tail = head;
//        }
//        else{
//            if(tail != null){
//                tail.next = new Node(data);
//                tail.next.prev = tail;
//                return;
//            }
//            Node current = head;
//            while(current.next != null){
//                current = current.next;
//            }
//            current.next = new Node(data);
//            current.next.prev = current;
//            tail = current.next;
//        }
    }

//    public void appendNode(Node node) {
//        if(head == null){
//            head = node;
//            head.prev = null;
//            head.next = null;
//            tail = head;
//        }
//        else{
//            if(tail != null){
//                tail.next = node;
//                tail.next.prev = tail;
//                return;
//            }
//            Node current = head;
//            while(current.next != null){
//                current = current.next;
//            }
//            current.next = node;
//            current.next.prev = current;
//        }
//    }

    public void quickSortLL(Node start, Node end){
        if (start != null && start != end && start != end.next){
            Node node_before_pivot = partitionLL(start, end);
            Node pivot = node_before_pivot.next;
            quickSortLL(start, node_before_pivot);
            quickSortLL(pivot.next, end);
        }
    }

    public Node partitionLL(Node start, Node end){
        Node current  = start;
        Node previous = start;
        Node iterator = start;
        int pivot = end.data;
        while (iterator != end){
            if(iterator.data < pivot){
                swapNode(current,iterator);
                previous = current;
                current = current.next;
            }
            iterator = iterator.next;
        }
        swapNode(current,end);
        return previous;
//        Node i = start;
//        for (Node j = start; j != end; j = j.next) {
//            if(j.data < pivot){
//                swapNode(i,j);
//                previous = i;
//                i = i.next;
//            }
//        }
    }

    private void swapNode(Node x, Node y) {
        int t = x.data;
        x.data = y.data;
        y.data = t;
    }

    public void sort(Node start, Node end)
    {
        if (start == null || start == end || end == null || start == end.next)
            return;

        // Split list and partition recurse
        Node pivot_prev = partitionLast(start, end);
        sort(start, pivot_prev);

        // If pivot is picked and moved to the start,
        // that means start and pivot is same
        // so pick from next of pivot
        if (pivot_prev != null && pivot_prev == start)
            sort(pivot_prev.next, end);

            // If pivot is in between of the list,
            // start from next of pivot,
            // since we have pivot_prev, so we move two nodes
        else if (pivot_prev != null && pivot_prev.next != null)
            sort(pivot_prev.next.next, end);
    }

    Node partitionLast(Node start, Node end)
    {
        if (start == end || start == null || end == null)
            return start;

        Node pivot_prev = start;
        Node curr = start;
        int pivot = end.data;

        // iterate till one before the end,
        // no need to iterate till the end
        // because end is pivot
        while (start != end) {
            if (start.data < pivot) {
                // keep tracks of last modified item
                pivot_prev = curr;
                int temp = curr.data;
                curr.data = start.data;
                start.data = temp;
                curr = curr.next;
            }
            start = start.next;
        }

        // Swap the position of curr i.e.
        // next suitable index and pivot
        int temp = curr.data;
        curr.data = pivot;
        end.data = temp;

        // Return one previous to current
        // because current is now pointing to pivot
        return pivot_prev;
    }

    public int length(){
        Node current = head;
        int size = 0;
        while(current!=null){
            size++;
            current = current.next;
        }
        return size;
    }
//    public void appendLink(LinkedList l){
//        if(l.head == null){
//            return;
//        }
//        this.tail.next = l.head;
//    }
//    public Node removeData(int data) {
//        Node returnNode = null;
//        if(head.data == data){
//            returnNode = head;
//            head = head.next;
//            return returnNode;
//        }
//        else{
//            Node current = head;
//            while(current.next != null){
//                if(current.next.data == data){
//                    returnNode = current.next;
//                    current.next = current.next.next;
//                    return returnNode;
//                }
//                current = current.next;
//            }
//        }
//        throw new NoSuchElementException
//                ("Data that you are trying to remove is not part of this list");
//    }

}

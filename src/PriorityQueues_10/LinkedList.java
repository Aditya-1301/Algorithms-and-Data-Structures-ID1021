package PriorityQueues_10;

import java.util.NoSuchElementException;

public class LinkedList {
    public class Node{
        public int data;
        public Node next;
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

    public void addDataConstant(int data){
        if(head == null){
            head = new Node(data);
            tail = head;
            return;
        } else{
            if(tail != null){
                tail.next = new Node(data);
                return;
            }
//            Node current = head;
//            while(current.next != null){
//                current = current.next;
//            }
//            current.next = new Node(data);
//            tail = current.next;
        }
    }
    public void addPriorityLinear(int key){
        if(head == null){
            head = new Node(key);
        }
        else if (head.data > key) {
            Node temp = new Node(key);
            temp.next = head;
            head = temp;
        }
        else{
            Node current = head;
            while(current.next!=null && current.next.data<key){
                current = current.next;
            }
            Node nxt = current.next;
            current.next = new Node(key);
            current.next.next = nxt;
        }
    }
    public Node removePriorityConstant(){
        if(head == null){
            return null;
        }
        else{
            Node temp = head;
            head = head.next;
            return temp;
        }
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
    public Node removeLinear(int data) {
        Node returnNode = null;
        if(head.data == data){
            returnNode = head;
            head = head.next;
        }
        else{
            Node current = head;
            while(current.next != null){
                if(current.next.data == data){
                    returnNode = current.next;
                    current.next = current.next.next;
                }
                current = current.next;
            }
        }
        return returnNode;
    }
}

package LinkedLists.Assignment_5;

import LinkedLists.Lists;
import LinkedLists.Node;

import java.util.NoSuchElementException;

public class SinglyLinkedList implements Lists {
    Node head;
    Node tail;

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

    public void printList(){
        System.out.println(this);
    }

    public void appendData(int data){
        Node current = head;
        if(head == null){
            head = new Node(data);
            return;
        }else{
            while(current.next != null){
                current = current.next;
            }
            current.next = new Node(data);
        }
    }

    @Override
    public void appendList(SinglyLinkedList singlyLinkedList) {
//        if(head == null){
//            head = singlyLinkedList.head;
//            return;
//        }
//        this.head.next = singlyLinkedList.head;
//        return;
    }

    @Override
    public Node removeData(int data) {
        Node current = head, returnNode = null;
        if(head.data == data){
            returnNode = head;
            head = head.next;
            return returnNode;
        }
        else{
            while(current.next != null){
                if(current.next.data == data){
                    returnNode = current.next;
                    current.next = current.next.next;
                    return returnNode;
                }
                current = current.next;
            }
        }
        throw new NoSuchElementException
                ("Data that you are trying to remove is not part of this list");
    }

    @Override
    public void appendNode(Node node) {
        Node current = head;
        if(head == null){
            head = node;
            return;
        }
        else{
            while(current.next!=null){
                current = current.next;
            }
            current.next = node;
        }
    }

    @Override
    public void removeNode(Node node) {
        Node current = head;
        if(head == node){
            head = head.next;
            return;
        }
        else{
            while(current.next != null){
                if(current.next == node){
                    current.next = current.next.next;
                    return;
                }
                current = current.next;
            }
        }
        throw new NoSuchElementException
                ("Data that you are trying to remove is not part of this list");
    }

    public int listLength(){
        Node current = head;
        int length = 0;
        if(head == null){
            return 0;
        }
        else{
            while(current != null){
                current = current.next;
                length++;
            }
            return length;
        }
    }
    public Node getHead(){
        return head;
    }
    public Node getTail(){
        Node current = head;
        if(head == null) return null;
        else if (head.next == null) {
            return head;
        } else{
            while(current.next!=null){
                current = current.next;
            }
            return current;
        }
    }
    public boolean isEmpty(){
        return (this.listLength() == 0);
    }
}

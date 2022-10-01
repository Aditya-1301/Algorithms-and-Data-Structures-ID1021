package LinkedLists.Assignment_6;

import LinkedLists.Assignment_5.SinglyLinkedList;
import LinkedLists.Lists;
import LinkedLists.Node;

public class DoublyLinkedList implements Lists {
    static Node head;
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

    @Override
    public void printList() {
        System.out.println(this);
    }

    @Override
    public void appendData(int data) {
        if(head == null){
            head = new Node(data);
            head.prev = null;
            head.next = null;
            tail = head;
        }
        else{
            if(tail != null){
                tail.next = new Node(data);
                tail.next.prev = tail;
                return;
            }
            Node current = head;
            while(current.next != null){
                current = current.next;
            }
            current.next = new Node(data);
            current.next.prev = current;
            tail = current.next;
        }

    }

    @Override
    public Node removeData(int data) {
        if(head == null){
            return null;
        }
        if(head.data == data){
            Node retValue = head;
            head = head.next;
            return retValue;
        }
        else{
            if(tail != null && tail.data == data){
                Node temp = tail;
                tail.prev.next = null;
                tail.prev = null;
                return temp;
            }
            Node current = head, retValue;
            while(current != null){
                if(current.data == data && current.next != null){
                    retValue = current;
                    current.next.prev = current.prev;
                    current.prev.next = current.next;
                    return retValue;
                }
                current = current.next;
            }
            return null;
        }
    }

    @Override
    public void appendNode(Node node) {
        if(head == null){
            head = node;
            head.prev = null;
            head.next = null;
            tail = head;
        }
        else{
            if(tail != null){
                tail.next = node;
                tail.next.prev = tail;
                return;
            }
            Node current = head;
            while(current.next != null){
                current = current.next;
            }
            current.next = node;
            current.next.prev = current;
        }
    }

    public void deleteData(int data) {
        Node current = head;
        while (current != null && current.data != data) {
            current = current.next;
        }
        deleteNode(current);
        // Note: We silently do nothing if 'data' not found
    }
    private void deleteNode(Node node) {
        tail = getTail();
        if (node != null) {
            // Here we can rely on 'node' actually being in our list
            if (node.prev != null)
                node.prev.next = node.next;
            else
                head = node.next;
            if (node.next != null)
                node.next.prev = node.prev;
            else
                tail = node.prev;
        }
    }

    @Override
    public void removeNode(Node node) {
//        if(node == null){
//            return;
//        }
//        if(head == node){
//            head = head.next;
//            head.prev = null;
//            return;
//        }
//        else{
//            Node current = head;
//            tail = getTail();
//            while(current != null){
//                if (current == node){
//                    current.next = node.next;
//                    current.next.next.prev = current.next;
//                    return;
//                }
//                current = current.next;
//            }
//            tail = node.next;
//            throw new NoSuchElementException
//                    ("Data that you are trying to remove is not part of this list");
//        }
        // Base case
        if (head == null || node == null) {
            return;
        }

        // If node to be deleted is head node
        if (head == node) {
            head = node.next;
        }

        // Change next only if node to be deleted
        // is NOT the last node
        if (node.next != null) {
            node.next.prev = node.prev;
        }

        // Change prev only if node to be deleted
        // is NOT the first node
        if (node.prev != null) {
            node.prev.next = node.next;
        }

        // Finally, free the memory occupied by del
        return;
    }

    @Override
    public int listLength() {
        return 0;
    }

    @Override
    public Node getHead() {
        return this.head;
    }

    @Override
    public Node getTail() {
        if(head == null){
            return null;
        }
        else{
            Node current  = head;
            while(current.next != null){
                current = current.next;
            }
            return current;
        }
    }

    @Override
    public boolean isEmpty() {
        if(this.listLength() == 0){
            return true;
        }
        return false;
    }

    public static void addNodeToStart(Node n){
        if (head != null) {
            n.next = head;
        }
        head = n;
    }
}



//Notes:
/*
*We don't need to check if the list even contains the element that we are trying to remove as we assume that much
*This means this operation takes constant time to complete. Thus, we can see the benefit of using a doubly linked list
*over a singly linked list. Similarly, when we want to append data to the end of a list we just keep track of the last
*element(i.e. the tail) then we can append data in constant time as we always just set the next element of the tail to
*the new data node.
*
*/
package Queues_Assignment_9;

public class DynamicQueue<T> {
    Node head;
    Node tail;

    public class Node<T> {
        public T item;
        public Node next;
        public Node(T item) {
            this.item = item;
            this.next = null;
        }
    }

    public DynamicQueue() {
        this.head = this.tail = null;
    }

    @Override
    public String toString(){
        System.out.println("Elements in this Queue :\t");
        StringBuilder stringBuilder = new StringBuilder();
        Node current = head;
        if(head == null){
            return "No Elements";
        }
        else{
            while(current != null){
                stringBuilder.append(current.item + "\t");
                current = current.next;
            }
        }
        return stringBuilder.toString();
    }
    public void enqueue(T item) {
        if(head == null){
            head = new Node(item);
            tail = head;
            //System.out.println("enqueued item: "+item);
            return;
        } else{
            if(tail != null){
                tail.next = new Node(item);
                tail = tail.next;
                //System.out.println("enqueued item: "+item);
                return;
            }
//            Node current = head;
//            while(current.next != null){
//                current = current.next;
//            }
//            current.next = new Node(item);
//            //System.out.println("enqueued item: "+item);
//            tail = current.next;
        }
    }

    public T dequeue(){
        if(head == null){
            return null;
        }
        else{
            Node temp = head;
            head = head.next;
            if(tail == head){
                tail = null;
            }
            //System.out.println("dequeued item: " + temp.item);
            return (T) temp.item;
        }
    }
}
/*
* [1] <-2
* [1,2] <-3
* [1,2,3]->
* [2,3]<-4
* [2,3,4]<-5
* [2,3,4,5]
* [2,3,4,5]->->->
* [5]
* */
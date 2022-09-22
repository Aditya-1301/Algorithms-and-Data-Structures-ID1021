package LinkedLists;

public class Node {
    public int data;
    public Node prev;
    public Node next;
    public Node(int data){
        this.data = data;
    }
    int getData(){
        return this.data;
    }
    Node getNext(){
        return this.next;
    }
}

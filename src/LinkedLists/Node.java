package LinkedLists;

public class Node {
    public int data;
    Node prev;
    public Node next;
    public Node(int data){
        this.data = data;
    }
    int getData(){
        return this.data;
    }
}

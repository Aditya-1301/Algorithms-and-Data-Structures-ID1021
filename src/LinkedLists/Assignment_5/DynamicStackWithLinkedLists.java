package LinkedLists.Assignment_5;

import LinkedLists.*;

public class DynamicStackWithLinkedLists {
    public static SinglyLinkedList stack;
    public static Node top;

    public DynamicStackWithLinkedLists(SinglyLinkedList singlyLinkedList) {
        stack = singlyLinkedList;
        this.top = stack.head;
    }

    public String toString() {
        System.out.println("Elements in this List :\t");
        StringBuilder stringBuilder = new StringBuilder();
        if(top == null){
            return "No Elements";
        }
        else{
            Node current = top;
            while(current != null){
                stringBuilder.append(current.data + "\t");
                current = current.next;
            }
        }
        return stringBuilder.toString();
    }

    public void push(int data){
        if(top == null){
            top = new Node(data);
        }
        else{
            Node temp = new Node(data);
            temp.next = top;
            top = temp;
        }
    }

    public Node pop() throws StackUnderflow{
        if(top == null){
            throw new StackUnderflow();
        }
        else{
            Node temp = top;
            top = top.next;
            return temp;
        }
    }

    public void printStack(){
        System.out.println(this);
    }
}

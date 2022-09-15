package LinkedLists.Assignment_5;

import LinkedLists.*;

public class DynamicStackWithLinkedLists {
    SinglyLinkedList stack;
    Node top;

    public DynamicStackWithLinkedLists() {
        this.top = stack.head;
    }

    void push(int data){
        if(top == null){
            top = new Node(data);
        }
        else{
            Node temp = top;
            top = new Node(data);
            top.next = temp;
        }
    }

    Node pop() throws StackUnderflow{
        if(top == null){
            throw new StackUnderflow();
        }
        else{
            Node temp = top;
            top = top.next;
            return temp;
        }
    }
}

package LinkedLists;

import LinkedLists.Assignment_5.SinglyLinkedList;

public interface Lists {
    public void printList();
    public void appendData(int data);
    public void appendList(SinglyLinkedList singlyLinkedList);
    public Node removeData(int data);
    public void appendNode(Node node);
    public void removeNode(Node node);
    public Node getHead();
    public Node getTail();
    public boolean isEmpty();
}

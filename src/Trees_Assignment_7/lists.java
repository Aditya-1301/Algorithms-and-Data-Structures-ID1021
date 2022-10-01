package Trees_Assignment_7;

import Trees_Assignment_7.list.SinglyLinkedList;

public interface lists<D> extends java.lang.Iterable<D> {

    void appendData(D key, D value);
    void appendNode(SinglyLinkedList.Node node);
    SinglyLinkedList.Node getNode(D key);
    void removeNode(SinglyLinkedList.Node node);
    void removeData(D key);
    void printList();
    boolean isEmpty(SinglyLinkedList<D> s);
    long ListSize();
    java.util.Iterator<D> iterator();
}

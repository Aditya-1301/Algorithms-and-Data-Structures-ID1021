package LinkedLists;

import LinkedLists.Assignment_5.SinglyLinkedList;

public class Reverse {
    public static void main(String[] args) {
        SinglyLinkedList sl = new SinglyLinkedList();
        sl.appendData(1);
        sl.appendData(2);
        sl.appendData(3);
        System.out.println(sl);
        SinglyLinkedList rev = reverse(sl);
        System.out.println(rev);
    }
    public static SinglyLinkedList reverse(SinglyLinkedList l){
      SinglyLinkedList reverse = new SinglyLinkedList();
      Node current = l.getHead();
      if(current == null){
          return l;
      }
      else{
          Node prev;
          while(current != null){
              prev = current;
              current = current.next;
              reverse.prependHead(prev);
          }
          return reverse;
      }
    }
}

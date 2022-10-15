package Queues_Assignment_9;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import Queues_Assignment_9.QBinaryTree.*;

public class QTreeIterator implements Iterator<Integer> {
    QTreeNode next;
    Queue<QTreeNode> queue = new LinkedList<>();
//    DynamicQueue<QTreeNode> queue= new DynamicQueue();
    public QTreeIterator(QBinaryTree integers) {
        queue.add(integers.root);
//        queue.enqueue(integers.root);
//        addChildNodes(integers.root);
    }

    private void addChildNodes(QTreeNode current){
        if (current != null) {
            if (current.left != null){
                //System.out.println("left:"+current.left.value);
//                queue.enqueue(current.left);
                queue.add(current.left);
            }
            if (current.right != null){
                //System.out.println("right:"+current.right.value);
//                queue.enqueue(current.right);
                queue.add(current.right);
            }
        }
    }

    @Override
    public boolean hasNext() {
//        return this.queue.head != null;
        return !this.queue.isEmpty();
    }

    @Override
    public Integer next() {
        //QTreeNode next = queue.remove();
        this.next = queue.remove();
//        this.next = queue.dequeue();
        //System.out.println("next:"+this.next.value);
        addChildNodes(this.next);
        return this.next.value;
    }
}

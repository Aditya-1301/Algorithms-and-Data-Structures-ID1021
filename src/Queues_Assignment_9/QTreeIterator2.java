package Queues_Assignment_9;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class QTreeIterator2 implements Iterator {
    QBinaryTree.QTreeNode next;
    DynamicQueue<QBinaryTree.QTreeNode> queue= new DynamicQueue();
    //dQ queue = new dQ();
    public QTreeIterator2(QBinaryTree integers) {
        queue.enqueue(integers.root);
    }

    private void addChildNodes(QBinaryTree.QTreeNode current){
        if (current != null) {
            if (current.left != null){
                //System.out.println("left:"+current.left.value);
                queue.enqueue(current.left);
            }
            if (current.right != null){
                //System.out.println("right:"+current.right.value);
                queue.enqueue(current.right);
            }
        }
    }

    @Override
    public boolean hasNext() {
        return this.queue.head != null;
    }

    @Override
    public Integer next() {
        this.next = queue.dequeue();
        addChildNodes(this.next);
        return this.next.value;
    }
}

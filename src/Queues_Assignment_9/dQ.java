package Queues_Assignment_9;

public class dQ {
    QBinaryTree.QTreeNode head;
    QBinaryTree.QTreeNode tail;
    public dQ(){
        this.head = this.tail = null;
    }
    public void enqueue(QBinaryTree.QTreeNode node){
        if(head == null){
            head = new QBinaryTree.QTreeNode(node.key, node.value);
            tail = head;
            return;
        } else{
            if(tail != null){
                tail.right = new QBinaryTree.QTreeNode(node.key, node.value);
                return;
            }
            QBinaryTree.QTreeNode current = head;
            while(current.right != null){
                current = current.right;
            }
            current.right = new QBinaryTree.QTreeNode(node.key,node.value);
            tail = current.right;
        }
    }

public QBinaryTree.QTreeNode dequeue(){
        if(head == null){
            return null;
        }
        else{
            QBinaryTree.QTreeNode temp = head;
            head = head.right;
            if(tail == head){
                tail = null;
            }
            //System.out.println("dequeued item: " + temp.item);
            return temp;
        }
    }
}

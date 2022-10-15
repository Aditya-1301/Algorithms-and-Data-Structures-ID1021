package Queues_Assignment_9;

import java.util.Iterator;

public class QBinaryTree implements Iterable<Integer>{
    public static class QTreeNode {
        public Integer key;
        public Integer value;
        public QTreeNode left, right;

        public QTreeNode(Integer key, Integer value) {
            this.key = key;
            this.value = value;
            this.left = this.right = null;
        }

        public void add(Integer key, Integer value){
            if(this.key == key){
                this.setValue(value);
                return;
            }
            if(this.key > key){
                if(this.left != null){
                    this.left.add(key,value);
                }
                else{
                    this.left = new QTreeNode(key,value);
                }
            }
            else{
                if(this.right != null){
                    this.right.add(key,value);
                }
                else{
                    this.right = new QTreeNode(key,value);
                }
            }
        }
        public void print() {
            if(left != null)
                left.print();
            System.out.println(" key: " + key + "\tvalue: " + value);
            if(right != null)
                right.print();
        }

        public void setValue(Integer value) {
            this.value = value;
        }
    }
    static QTreeNode root;

    public QBinaryTree() {
        root = null;
    }

    public static void add(Integer key, Integer value){
        if(root == null){
            root = new QTreeNode(key,value);
        }
        else{
            root.add(key,value);
        }
    }
    public Integer lookup(Integer key) {
        QTreeNode here = root;
        while(here != null){
            if(key < here.key) {
                here = here.left;
            }
            else if(key > here.key) {
                here = here.right;
            }
            else {
                return here.value;
            }
        }
        return null;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new QTreeIterator2(this);
    }

    void deleteKey(int key) {
        root = delete_Recursive(root, key);
    }

    //recursive delete function
    QTreeNode delete_Recursive(QTreeNode root, int key)  {
        //tree is empty
        if (root == null)  return null;

        //traverse the tree
        if (key < root.key)     //traverse left subtree
            root.left = delete_Recursive(root.left, key);
        else if (key > root.key)  //traverse right subtree
            root.right = delete_Recursive(root.right, key);
        else  {
            // node contains only one child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // node has two children;
            //get inorder successor (min value in the right subtree)
            root.key = minValue(root.right);

            // Delete the inorder successor
            root.right = delete_Recursive(root.right, root.key);
        }
        return root;
    }
    int minValue(QTreeNode root)  {
        //initially minval = root
        int minval = root.key;
        //find minval
        while (root.left != null)  {
            minval = root.left.key;
            root = root.left;
        }
        return minval;
    }
}

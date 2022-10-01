package Trees_Assignment_7;

import java.util.Iterator;

public class BinaryTree implements Iterable<Integer>{

    public static class TreeNode {
        public Integer key;
        public Integer value;
        public TreeNode left, right;

        public TreeNode(Integer key, Integer value) {
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
                    this.left = new TreeNode(key,value);
                }
            }
            else{
                if(this.right != null){
                    this.right.add(key,value);
                }
                else{
                    this.right = new TreeNode(key,value);
                }
            }
        }

//        public Integer lookup(Integer key){
//            if(this.key == key){
//                return this.value;
//            }
//            else{
//                if(this.key > key  && left != null){
//                    return left.lookup(key);
//                }
//                else if(this.key < key  && right != null){
//                    return right.lookup(key);
//                }
//            }
//            return null;
//        }

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

    static TreeNode root;

    public BinaryTree() {
        root = null;
    }

    public static void add(Integer key, Integer value){
        if(root == null){
            root = new TreeNode(key,value);
        }
        else{
            root.add(key,value);
        }
    }

//    public static Integer lookup(int key){
//        if(root == null){
//            return null;
//        }
//        else{
//            return root.lookup(key);
//        }
//    }
public Integer lookup(Integer key) {
    TreeNode here = root;
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
        return new TreeIterator(this);
    }

    void deleteKey(int key) {
        root = delete_Recursive(root, key);
    }

    //recursive delete function
    TreeNode delete_Recursive(TreeNode root, int key)  {
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
    int minValue(TreeNode root)  {
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

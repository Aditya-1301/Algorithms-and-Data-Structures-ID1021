package Trees_Assignment_7;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class TreeIterator implements Iterator<Integer>{

    private BinaryTree.TreeNode next;
    private Stack stack ;

    public TreeIterator(BinaryTree tree){
        stack = new Stack();
        FillStackWithTreeNodes(tree.root);
        next = stack.pop();
    }

    private void FillStackWithTreeNodes(BinaryTree.TreeNode current) {
        if(current.right != null){
            FillStackWithTreeNodes(current.right);
        }
        stack.push(current);
        if(current.left != null){
            FillStackWithTreeNodes(current.left);
        }
    }

    @Override
    public boolean hasNext() {
        return (next != null);
    }

    @Override
    public Integer next() {
        if(!hasNext()){
            throw new NoSuchElementException();
        }
        Integer n = next.key;
        next = stack.pop();
        return n;
    }


    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}

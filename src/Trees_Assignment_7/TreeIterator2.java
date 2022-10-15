package Trees_Assignment_7;

import java.util.Stack;
import java.util.*;
import Trees_Assignment_7.BinaryTree.*;

public class TreeIterator2 implements Iterator<Integer> {
    private TreeNode next;
    private Stack<TreeNode> stack = new Stack<>();

    public TreeIterator2(BinaryTree tree) {
        traverseBottomLeft(tree.root);
    }

    private void traverseBottomLeft(TreeNode current){
        if (current != null) {
            stack.push(current);
            traverseBottomLeft(current.left);
        }
    }

    @Override
    public boolean hasNext() {
        return !this.stack.isEmpty();
    }
    @Override
    public Integer next() {
        next = stack.pop();

        if (next.right != null){
            traverseBottomLeft(next.right);
        }

        return next.value;
    }
    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
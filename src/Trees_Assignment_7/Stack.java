package Trees_Assignment_7;
public class Stack {
    BinaryTree.TreeNode root;
    int size;
    public Stack()
    {
        root = null;
    }

    public void push(BinaryTree.TreeNode n)
    {
        size++;
        n.right = root;
        this.root = n;
    }

    public BinaryTree.TreeNode pop()
    {
        if(root == null)
        {
            return null;
        }
        BinaryTree.TreeNode nodeToReturn = root;
        size--;
        root = root.right;
        return nodeToReturn;
    }
}
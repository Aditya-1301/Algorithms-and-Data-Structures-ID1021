package Trees_Assignment_7;
public class Stack<T> {
    BinaryTree.TreeNode root;
    public Stack()
    {
        root = null;
    }

    public void push(BinaryTree.TreeNode n)
    {
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
        root = root.right;
        return nodeToReturn;
    }
}
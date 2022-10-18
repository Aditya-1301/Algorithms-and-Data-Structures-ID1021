package PriorityQueues_10;

public class Heaps {
    static int size;
    static int depth;

    Heaps(){
        size = 0;
    }
    public static class TreeNode {
        public Integer data;
        public Integer size;
        public Heaps.TreeNode left, right;
        public TreeNode(Integer key) {
            this.data = key;
            this.size = 0;
            this.left = this.right = null;
        }

        public void incrementData(Integer incrementValue) {
            this.data += incrementValue;
        }

        //        public Integer push(Integer increment){
//            root.key = root.key + increment;
//            TreeNode current = root;
//            Integer depth = 0;
//            while(current.left.key < current.key || current.right.key < current.key) {
//                if (root.key > root.left.key) {
//                    System.out.println("Swapping current and current.left (" + root.value + " " +root.left.value + ")");
//                    swapNode(current,current.left);
//                    System.out.println("Swapped current and current.left (" + root.value + " " +root.left.value + ")");
//
//                } else if(root.key > root.right.key) {
//                    swapNode(current,current.right);                 }
//                else{
//                    break;
//                }
//                depth++;
//            }
//            return depth;
//        }


    public void add(Integer data) {
        if (this.data < data) {
            this.size++;
            if (this.left == null) {
                this.left = new Heaps.TreeNode(data);
                Heaps.size++;
            } else if (this.right == null) {
                this.right = new Heaps.TreeNode(data);
                Heaps.size++;
            } else if (this.left.size <= this.right.size){
                this.left.add(data);
                size++;
            } else{
                this.right.add(data);
                size++;
            }
        }
        else{
            TreeNode node = new TreeNode(data);
            swapNode(node,root);
            TreeNode current = root;
            heapifyWithNode(node,current);
        }
    }
//    public Integer addImproved(Integer key) {
//        if (this.key > key){
//            TreeNode node = new TreeNode(key);
//            swapNode(node,root);
//            TreeNode current = root;
//            heapifyWithNode(node,current,depth);
//        } else {
//            if (this.key < key) {
//                if (this.left == null) {
//                    this.left = new Heaps.TreeNode(key);
//                    size++;
//                } else if (this.right == null) {
//                    this.right = new Heaps.TreeNode(key);
//                    size++;
//                } else if (this.left.key < key) {//&& left.depth < right.depth
//                    this.left.add(key);
//                    depth++;
//                } else if (this.right.key < key) {//&& right.depth < left.depth
//                    this.right.add(key);
//                    depth++;
//                }
//            }
//        }
//        return depth;
//    }
    public boolean isLeaf(){
        return (this.left == null && this.right == null);
    }
    public static void heapifyWithNode(TreeNode node, TreeNode current){
        if (current.left == null) {
            current.left = node;
            current.size += 1;
            Heaps.size++;
        } else if (current.right == null) {
            current.right = node;
            current.size += 1;
            Heaps.size++;
        }
        else if(current.left.size <= node.size){
            swapNode(node,current.left);
            heapifyWithNode(node, current.left);
        } else{
            swapNode(node,current.right);
            heapifyWithNode(node, current.right);
        }
    }
//    public void balancedAdd(Integer key){
//    if(left != null && right != null){
//        if (left.depth < right.depth){
//            left.balancedAdd(key);
//        }else if ( right.depth < left.depth) {
//            right.balancedAdd(key);
//        }
//    }
//    else{
//        if(left == null){
//            left = new TreeNode(key);
//            size++;
//        }
//        else{
//            right = new TreeNode(key);
//            size++;
//        }
//    }
//    }
//    public Integer lookup(Integer key){
//        if(this.key == key){
//            return this.value;
//        }
//        else{
//            if(this.key > key  && left != null){
//                return left.lookup(key);
//            }
//            else if(this.key < key  && right != null){
//                return right.lookup(key);
//            }
//        }
//        return null;
//    }

//    public int NumberOfLeaves() {
//        if(left == null && right == null){
//            return 1;
//        }
//        else{
//            return left.NumberOfLeaves() + right.NumberOfLeaves();
//        }
//    }
    public void print() {
        if(left != null)
            left.print();
        System.out.println(" data: " + data + "\tsize: " + size);
        if(right != null)
            right.print();
    }

    public Integer push(Integer increment){
//        root.key = root.key + increment;
//        TreeNode current = root;
//        Integer depth = 0;
//        while(current.left.key < current.key || current.right.key < current.key) {
//            if (root.key > root.left.key) {
//                swapNode(current,current.left);
//            } else if(root.key > root.right.key) {
//                swapNode(current,current.right);                 }
//            else{
//                break;
//            }
//            depth++;
//        }
//        return depth;
        root.data = root.data + increment;
        TreeNode current = root;
        Integer depth = 0;
        if(current.left != null && current.right != null) {
            while (current.left.data < current.data || current.right.data < current.data) {
                if (root.data > root.left.data) {
                    //System.out.println("Swapping current and current.left (" + root.value + " " + root.left.value + ")");
                    swapNode(current, current.left);
                    //System.out.println("Swapped current and current.left (" + root.value + " " + root.left.value + ")");
                } else if (root.data > root.right.data) {
                    swapNode(current, current.right);
                } else {
                    break;
                }
                depth++;
            }
        }
        return depth;
    }

    public TreeNode remove() {
        if(Heaps.size == 1){
            TreeNode temp = root;
            root = null;
            Heaps.size--;
            return temp;
        }
        else{
            if(this.left.data > this.right.data){
                TreeNode temp = root;
                root = this.right;
                root.left = temp.left;
                Heaps.size--;
                return temp;
            }
            if(this.right.data > this.left.data){
                TreeNode temp = root;
                root = this.left;
                root.right = temp.right;
                Heaps.size--;
                return temp;
            }
            TreeNode temp = root;
            if(this.left == null){
                root = this.right;
            }
            else{
                root = this.left;
            }
            Heaps.size--;
            return temp;
        }
    }

}
    static TreeNode root;

    public static Integer add(Integer key){
        if(root == null){
            root = new TreeNode(key);
            size++;
            return 0;
        }
        else{
            return addDataToNode(root,key,0);
        }
    }

    public static Integer addDataToNode(TreeNode current, Integer data, int depth) {
        current.size++;
        depth++;
        if(data < current.data){
            Integer temp = data;
            data = current.data;
            current.data = temp;
        }
        if (current.left == null) {
            current.left = new TreeNode(data);
            current.left.size++;
            return depth;
        } else if (current.right == null) {
            current.right = new TreeNode(data);
            current.right.size++;
            return depth;
        } else{
            if (current.left.size <= current.right.size){
                depth = addDataToNode(current.left,data,depth);
            }
            else {
                depth = addDataToNode(current.right,data,depth);
            }
        }
        return depth;
    }

    public void removeRoot(TreeNode node){
        size--;
        node.size--;
        if(node.left == null){
            swapNode(node,node.right);
            if(node.right.isLeaf()){
                node.right = null;
                return;
            }
            removeRoot(node.right);
        }
        else if(node.right == null){
            swapNode(node,node.left);
            if(node.left.isLeaf()){
                node.left = null;
                return;
            }
            removeRoot(node.left);
        }
        else if (node.left.data <= node.right.data)
        {
            //Promote left branch
            swapNode(node, node.left);
            if (node.left.isLeaf())
            {
                node.left = null;
                return;
            }
            removeRoot(node.left);
        }
        else if (node.right.data < node.left.data)
        {
            //Promote right branch
            swapNode(node, node.right);
            if (node.right.isLeaf())
            {
                node.right = null;
                return;
            }
            removeRoot(node.right);
        }
    }

    public static void swapNode(TreeNode n1, TreeNode n2){
        Integer temp = n1.data;
        n1.data = n2.data;
        n2.data = temp;
    }

    public Integer pushDown(TreeNode node){
        if(node.isLeaf()) return 0;
        if(node.right == null){
            if(node.left.data <= node.data){
                swapNode(node,node.left);
                return 1+pushDown(node.left);
            }
        }
        else if (node.left == null) {
            if(node.right.data < node.data){
                swapNode(node,node.right);
                return 1+pushDown(node.right);
            }
        }
        else{
            if(node.left.data <= node.right.data){
                if(node.left.data < node.data){
                    swapNode(node.left,node);
                    return 1+pushDown(node.left);
                }
            }
            else{
                if(node.right.data < node.data){
                    swapNode(node,node.right);
                    return 1+pushDown(node.right);
                }
            }
        }
        return 0;
    }
//    public static void balanceAdd(Integer key){
//        if(root == null){
//            root = new TreeNode(key);
//        }
//        else{
//            root.balancedAdd(key);
//        }
//    }
}

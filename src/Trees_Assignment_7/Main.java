package Trees_Assignment_7;

public class Main {
    public static void main(String[] args) {
//        BinaryTree bt = new BinaryTree();
//        int n  = 10;
//        Random r = new Random(n);
//        for (int i = 1; i <= n; i++) {
//            bt.add(r.nextInt(10*n), r.nextInt(10*n));
//        }
//        bt.root.print();
//        System.out.println(BinaryTree.lookup(1));
//        Benchmark.benchmark(1000);

        BinaryTree tree = new BinaryTree();
        tree.add(5,105);
        tree.add(2,102);
        tree.add(7,107);
        tree.add(1,101);
        tree.add(8,108);
        tree.add(6,106);
        tree.add(3,103);
        //tree.delete_Recursive(tree.root, 1);
        for (int i : tree) {
            System.out.println("next value " + i);
            //tree.add(6*i, 5-i);
        }
//        System.out.println();
//        for (int i: tree) {
//            System.out.println("next value "+ i);
//        }
//        TreeIterator2 iterator = new TreeIterator2(tree);
//        int i = iterator.next();
//        System.out.println("key: " + i);
//        i = iterator.next();
//        System.out.println("key: " + i);
//        i = iterator.next();
//        System.out.println("key: " + i);
//        tree.add(60, 9);
//        i = iterator.next();
//        System.out.println("key: " + i);
    }
}

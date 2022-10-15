package Queues_Assignment_9;

public class Main {
    public static void main(String[] args) {
//        DynamicQueue dynamicQueue = new DynamicQueue();
//        dynamicQueue.enqueue(5);
//        dynamicQueue.enqueue(4);
//        dynamicQueue.enqueue(3);
//        dynamicQueue.enqueue(2);
//        System.out.println(dynamicQueue);
//        dynamicQueue.dequeue();
//        System.out.println(dynamicQueue);

//        StaticCircularQueue staticQueue = new StaticCircularQueue(5);
//        staticQueue.enqueue(2);
//        staticQueue.enqueue(4);
//        staticQueue.enqueue(2);
//        staticQueue.enqueue(4);
//        //staticQueue.enqueue(null);
//        //staticQueue.dequeue();
//        staticQueue.enqueue(3);
//        staticQueue.dequeue();
//        staticQueue.enqueue(5);
//        staticQueue.enqueue(4);
//        int i = 0;
//        while (i<StaticCircularQueue.getCapacity()){
//            System.out.printf("%5d",staticQueue.queue[i++]);
//        }

//        QBinaryTree tree = new QBinaryTree();
//        tree.add(5,105);
//        tree.add(2,102);
//        tree.add(7,107);
//        tree.add(1,101);
//        tree.add(8,108);
//        tree.add(6,106);
//        tree.add(3,103);
//        for (int i: tree) {
//            System.out.println("next value " + i);
//        }
        DynamicCircularQueue dcq = new DynamicCircularQueue(5);
        dcq.enqueue(5);
        dcq.enqueue(4);
        dcq.enqueue(3);
        dcq.enqueue(2);
        dcq.enqueue(1);
        for (int i: dcq.queue) {
            System.out.printf("%5d", i);
        }
        dcq.enqueue(0);
        dcq.enqueue(1);
        System.out.println();
        for (int i: dcq.queue) {
            System.out.printf("%5d", i);
        }
    }
}

package Queues_Assignment_9;

public class StaticCircularQueue {
    Integer [] queue;
    static public int front, capacity, currentQueuePointer,dequeueCounter;
    StaticCircularQueue(int n){
        queue = new Integer[n];
        front = currentQueuePointer = 0;
        capacity = n;
    }

    public static int getCapacity() {
        return capacity;
    }

    public void enqueue(Integer item){
        if(capacity == currentQueuePointer && dequeueCounter > 0){
//            currentQueuePointer = 0;
//            queue[currentQueuePointer++] = item;
//            return;
            int t = currentQueuePointer%capacity;
            if (queue[t] == null){
                queue[t] = item;
                currentQueuePointer++;
            }
        } else if (currentQueuePointer>capacity) {
            return;
        }
        else {
            queue[currentQueuePointer++] = item;
        }
    }
    public void dequeue(){
        if(front == currentQueuePointer){
            System.out.println("The Queue is empty");
            return;
        }
        else{
            int firstExistingElement = 0;
            for (int i = 0; i < capacity ; i++) {
                if (queue[i] != null){
                    break;
                }
                ++firstExistingElement;
            }
            queue[firstExistingElement] = null;
            dequeueCounter++;
//            int whatever =
//            (currentQueuePointer==capacity) ? currentQueuePointer - 1 : currentQueuePointer;
//            for (int i = 0; i < whatever ; i++) {
//                queue[i] = queue[i+1];
//            }
//            if(currentQueuePointer < capacity){
//                queue[currentQueuePointer] = null;
//            }
//            currentQueuePointer--;
        }
        return;
    }
}

package Queues_Assignment_9;

import java.util.Arrays;

public class DynamicCircularQueue {
    Integer [] queue;
    static public int front, capacity, currentQueuePointer,dequeueCounter,amount;
    DynamicCircularQueue(int n){
        queue = new Integer[n];
        front = currentQueuePointer = 0;
        capacity = n;
    }

    public static int getCapacity() {
        return capacity;
    }

    public void enqueue(Integer item){
        if(capacity == currentQueuePointer){
            if(dequeueCounter > 0) {
                int t = currentQueuePointer % capacity;
                if (queue[t] == null) {
                    queue[t] = item;
                    currentQueuePointer++;
                }
                amount++;
            }
            else{
                queueExpander();
                queue[currentQueuePointer++] = item;
                amount++;
            }
        }
        else if (currentQueuePointer>capacity) {
            queueExpander();
            queue[currentQueuePointer++] = item;
            amount++;
        }
        else {
            queue[currentQueuePointer++] = item;
            amount++;
        }
    }
    public void dequeue(){
        if(front == currentQueuePointer){
            System.out.println("The Queue is empty");
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
        }
        if(amount <= capacity/4 && capacity > 4) shrinkQueue();
    }
    public void queueExpander(){
        Integer[] temp = new Integer[capacity*2];
        int index = 0;

        for(int i = front; i < capacity; i++)
            temp[index++] = queue[i];

        for(int i = 0; i < currentQueuePointer; i++)
            temp[index++] = queue[i];

        front = 0;
        currentQueuePointer = capacity;
        capacity = capacity*2;
        queue = temp;
    }
    public void shrinkQueue(){
        Integer[] temp = new Integer[capacity/2];
        int index = 0;

        if(front < currentQueuePointer) {
            for(int i = front; i < currentQueuePointer; i++) {
                temp[index++] = queue[i];
            }
        }

        if(currentQueuePointer < front) {
            for(int i = front; i < capacity; i++)
                temp[index++] = queue[i];

            for(int i = 0; i < currentQueuePointer; i++)
                temp[index++] = queue[i];
        }

        front = 0;
        currentQueuePointer = index;
        capacity = capacity/2;
        queue = temp;
    }
}

package PriorityQueues_10;

public class HeapArray {
    public Integer [] heap;
    public int capacity, size;
    public final int FRONT = 1;
    HeapArray(int n){
        this.size = 0;
        this.capacity = n;
        this.heap = new Integer[this.capacity + 1];
        this.heap[0] = Integer.MIN_VALUE;
    }

    public int parent(int position){
        return position/2;
    }

    public int leftChild(int position){
        return (2*position);
    }

    public int rightChild(int position){
        return (2*position) + 1;
    }

    public void add(Integer key){
        if(size >= capacity){
            return;
        }
        heap[++size] = key;
        int current = size;
        while (heap[current] < heap[parent(current)]){
            swap(current, parent(current));
            current = parent(current);
        }
    }
    public void swap(int current, int parent){
        Integer t = heap[current];
        heap[current] = heap[parent];
        heap[parent] = t;
    }

    public Integer remove(){
        int popped = heap[FRONT];
        heap[FRONT] = heap[size--];
        minHeapify(FRONT);
        return popped;
    }

    private void minHeapify(int position){
        if(!isLeaf(position)){
            int swapPosition = position;
            if(rightChild(position)<size){
                swapPosition =
                        (heap[leftChild(position)] < heap[rightChild(position)])?
                        leftChild(position):rightChild(position);
            }
            else{
                swapPosition = heap[leftChild(position)];
            }
            if (heap[position] > heap[leftChild(position)] ||
                heap[position] > heap[rightChild(position)]){
                swap(position,swapPosition);
                minHeapify(swapPosition);
            }
        }
    }

    private boolean isLeaf(int position){
        if(position > size/2){
            return true;
        }
        return false;
    }

    public void print()
    {
        for (int i = 1; i < size / 2; i++) {
            // Printing the parent and both children
            System.out.print(
            " PARENT : " + heap[i] +
            " LEFT CHILD : " + heap[2 * i] +
            " RIGHT CHILD :" + heap[2 * i + 1]);
            // By here new line is required
            System.out.println();
        }
    }
}

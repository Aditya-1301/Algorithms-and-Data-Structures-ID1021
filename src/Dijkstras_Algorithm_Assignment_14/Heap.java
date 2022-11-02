package Dijkstras_Algorithm_Assignment_14;

public class Heap {
    public class Node{
        City city;
        int distance;
        City prev;
        int pos;
        public Node(City city,int distance,City prev){
            this.city = city;
            this.distance = distance;
            this.prev = prev;
        }
    }
    Node[] array;
    int k;
    public Heap(int size){
        array = new Node[size];
        k = -1;
    }
    public Node add(City city,int distance,City prev){
        Node node = new Node(city, distance, prev);
        array[++k] = node;
        node.pos = k;
        bubble(k);
        return node;
    }
    public void pull(Node node, int distance, City prev){
        node.distance =distance;
        node.prev = prev;
        bubble(node.pos);
    }
    public void bubble(int position){
        while(position > 0){
            if(position%2==0){
                if(array[(position -2)/2].distance > array[position].distance){
                    Node k = array[position];
                    array[position].pos = (position -2)/2;
                    array[(position -2)/2].pos = position;
                    array[position] = array[(position -2)/2];
                    array[(position -2)/2] = k;
                    position = (position -2)/2;
                }
                else{
                    break;
                }
            }
            else if(array[(position -1)/2].distance > array[position].distance){
                Node k = array[position];
                array[position].pos = (position -1)/2;
                array[(position -1)/2].pos = position;
                array[position] = array[(position -1)/2];
                array[(position -1)/2] = k;
                position = (position -1)/2;
            }
            else
                break;
        }
    }
    public Node remove(){
        Node v;
        if(k<0){
            v=null;
        }
        else {
            v = array[0];
            array[0] = array[k--];
            sink();
        }
        return v;
    }
    public void push(int incrementValue){
        array[0].distance += incrementValue;
        sink();
    }
    private void sink(){
        int pos = 0;
        int left =1;
        int right = 2;
        while(left <= k){
            if(array[left].distance < array[right].distance && array[left].distance < array[pos].distance){
                Node k = array[left];
                array[pos].pos = left;
                array[left].pos = pos;
                array[left] = array[pos];
                array[pos] = k;
                pos = left;
            }
            else if(array[left].distance >= array[right].distance && array[right].distance < array[pos].distance){
                Node k = array[right];
                array[pos].pos = right;
                array[right].pos = pos;
                array[right] = array[pos];
                array[pos] = k;
                pos = right;
            }
            else{
                break;
            }
            right = (pos*2)+2;
            left = (pos*2)+1;
        }
    }
}
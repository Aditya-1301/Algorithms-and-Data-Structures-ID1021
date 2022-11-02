package Dijkstras_Algorithm_Assignment_14;

public class Hash {
    public class Node{
        City city;
        City prev;
        Integer distance;
        Heap.Node queueNode;
        public Node(City city){
            this.city = city;
            this.distance = null;
            this.queueNode = null;
        }
        public Node(Node node){
            this.city = node.city;
            this.distance = node.distance;
            this.queueNode = node.queueNode;
        }
    }
    Node[] array;
    int k;
    public Hash(int size){
        array = new Node[size];
        k = 0;
    }
    public Hash(Hash hash){
        array = new Node[hash.array.length];
        for(int i = 0; i< array.length;i++){
            if(hash.array[i]!=null)
                array[i] = new Node(hash.array[i]);
        }
    }
    public void addNew(City city){
        if(k<array.length){
            city.setHash(k);
            array[k++] = new Node(city);
        }
    }
    public void setDis(int pos, int dis){
        array[pos].distance = dis;
    }
    public void setPrev(int pos, City prev){
        array[pos].prev = prev;
    }
}
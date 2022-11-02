package Dijkstras_Algorithm_Assignment_14;

public class City {
    String name;
    Connection[] neighbors;
    int k;
    int hash;
    public City(String name){
        this.name = name;
        neighbors = new Connection[1];
        k=0;
    }
    public  void setHash(int hash){
        this.hash = hash;
    }
    public void add(City city, int distance){
        if(neighbors.length<=k) {
            Connection[] temp = new Connection[neighbors.length*2];
            System.arraycopy(neighbors, 0, temp, 0, k);
            neighbors = temp;
        }
        neighbors[k++] = new Connection(city, distance);
    }

}
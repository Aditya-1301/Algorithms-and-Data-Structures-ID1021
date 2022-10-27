package Graphs_Assignment_13;

public class City {
    //Hash table change 541 to 557
    String name;
    Connection[] neighbors;
    int cities;

    public City(String name){
        this.name = name;
        neighbors = new Connection[51];
        int cities = 0;
    }

    public void addConnection(City city, int distance){
        neighbors[cities] = new Connection(city, distance);
        cities++;
    }
}

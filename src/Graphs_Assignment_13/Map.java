package Graphs_Assignment_13;

import java.io.BufferedReader;
import java.io.FileReader;

public class Map {
    private City[] cities;
    private final int mod = 557; //541
    public Map(String file) {
        cities = new City[mod];
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                int distance = Integer.parseInt(row[2]);
                City[] citiesToConnect = {lookup(row[0]), lookup(row[1])};

                citiesToConnect[0].addConnection(citiesToConnect[1], distance);
                citiesToConnect[1].addConnection(citiesToConnect[0], distance);
            }
        } catch (Exception e) {
            System.out.println(" file " + file + " not found or corrupt");
        }
    }
    private Integer hash(String name){
        int hash = 7;
        for (int i = 0; i < name.length(); i++)
            hash = (hash * 31 % mod) + name.charAt(i);

        return hash % mod;
    }

    public City lookup(String name){
        int index = hash(name);
        while (cities[index] != null){
            if (name.equals(cities[index].name))
                return cities[index];
            index = (index + 1) % mod;
        }
        cities[index] = new City(name);
        return cities[index];
    }
}
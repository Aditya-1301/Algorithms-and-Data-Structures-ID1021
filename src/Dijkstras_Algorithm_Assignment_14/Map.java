package Dijkstras_Algorithm_Assignment_14;
import java.io.BufferedReader;
import java.io.FileReader;

public class Map {
    private City[] cities;
    private final int mod = 541;
    public Hash hashmap = new Hash(55);
    public Map(String file){
        cities = new City[mod];
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                int c1 = hash(row[0]);
                for(int i = c1; i<mod;i++){
                    if(cities[i]==null){
                        cities[i] = new City(row[0]);
                        hashmap.addNew(cities[i]);
                        addConnection(cities[i], row[1],Integer.parseInt(row[2]));
                        break;
                    }
                    else if(cities[i].name.equals(row[0])){
                        addConnection(cities[i], row[1],Integer.parseInt(row[2]));
                        break;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(" file " + file + " not found or corrupt");
        }
    }
    public Integer hash(String name) {
        int hash = 7;
        for (int i = 0; i < name.length(); i++) {
            hash = (hash*31 % mod) + name.charAt(i);
        }
        return hash % mod;
    }
    private void addConnection(City c1, String namec2, int distance){
        int hashc2 = hash(namec2);
        City c2 = null;
        for(int i = hashc2; i<mod;i++){
            if(cities[i]==null){
                cities[i] = new City(namec2);
                hashmap.addNew(cities[i]);
                c2 = cities[i];
                break;
            }
            else if(cities[i].name.equals(namec2)){
                c2 = cities[i];
                break;
            }
        }
        c1.add(c2, distance);
        c2.add(c1,distance);
    }
    public City lookup(String name){
        int hash = hash(name);
        City city = null;
        for(int i = hash; i<mod;i++) {
            if(cities[i] == null){
                break;
            }
            else if (cities[i].name.equals(name)) {
                city = cities[i];
                break;
            }
        }
        return city;
    }
}
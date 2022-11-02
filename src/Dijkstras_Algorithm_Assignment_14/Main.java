package Dijkstras_Algorithm_Assignment_14;

public class Main {
    static String G = "Göteborg";
    static String M = "Malmö";
    static String St = "Stockholm";
    static String Su = "Sundsvall";
    static String U = "Umeå";
    static String K = "Kiruna";

    public static void main(String[] args) {
        System.out.println("ö");
        for (int i = 0; i < 5; i++)
            test(M,K); //G,U
    }

    public static void testHeapArray() {
        Heap heap = new Heap(50);
        Map map = new Map("D:\\TCOMK Pdfs\\Year 2\\Period 1\\Algorithms and Data Structures\\ADSA_Assignments\\src\\Graphs_Assignment_13\\trains.csv");
        City g = map.lookup(G);
        City m = map.lookup(M);
        City st = map.lookup(St);
        City su = map.lookup(Su);
        City u = map.lookup(U);
        heap.add(g, 0, null);
        heap.add(m, 1, null);
        heap.add(st, 2, null);
        heap.add(su, 3, null);
        heap.add(u, 4, null);
        System.out.println();
        heap.push(5);
        System.out.println();
    }

    public static void test2() {
        String[][] cities = new String[9][2];
        cities[0][0] = M;
        cities[0][1] = G;
        cities[1][0] = G;
        cities[1][1] = St;
        cities[3][0] = St;
        cities[3][1] = Su;
        cities[4][0] = St;
        cities[4][1] = U;
        cities[5][0] = G;
        cities[5][1] = Su;
        cities[6][0] = Su;
        cities[6][1] = U;
        cities[7][0] = U;
        cities[7][1] = G;
        cities[8][0] = G;
        cities[8][1] = U;
        cities[2][0] = G;
        cities[2][1] = St;
        for (String[] city : cities) {
            System.out.print("from " + city[0] + " to " + city[1] + " ");
            test(city[0], city[1]);
        }
        System.out.println();
    }

    private static Hash shortest(City from, City to, Hash hashmap) {
        Heap q = new Heap(55);
        q.add(from, 0, null);
        City current = from;
        while (true) {
            Heap.Node currentNode = q.remove();
            if (currentNode == null || currentNode.city.equals(to)) {
                current = currentNode.city;
                hashmap.setDis(current.hash, currentNode.distance);
                hashmap.setPrev(current.hash, currentNode.prev);
                break;
            }
            current = currentNode.city;
            hashmap.setDis(current.hash, currentNode.distance);
            hashmap.setPrev(current.hash, currentNode.prev);
            int currentDistance = currentNode.distance;
            //add or update the neighbors of current to the queue
            for (int i = 0; i < current.neighbors.length; i++) {
                Connection neighbor = current.neighbors[i];
                if (neighbor == null)
                    continue;
                //if the shortest path to that city has already been found skip this neighbor
                if (hashmap.array[neighbor.city.hash].distance != null) {
                    continue;
                }
                Heap.Node neighborQNode = hashmap.array[neighbor.city.hash].queueNode;
                //is the neighbor in the queue?
                if (neighborQNode != null) {
                    //is the path in the queue longer than the path over the current node?
                    if (neighborQNode.distance > currentDistance + neighbor.distance) {
                        //update the element in the queue
                        q.pull(neighborQNode, currentDistance + neighbor.distance, current);
                    }
                }
                //else the element isn't in the queue -> add it to the queue
                else {
                    hashmap.array[neighbor.city.hash].queueNode = q.add(neighbor.city, currentDistance + neighbor.distance, current);
                }
            }

        }
        return hashmap;
    }

    public static void print(Hash map) {
        int i = 0;
        City temp = map.array[i++].city;
        while (map.array[i] != null) {
            System.out.println(temp.name + " " + map.array[temp.hash].distance);
            temp = map.array[i++].city;
        }
    }

    public static void printpath(Hash map, City to) {
        City temp = to;
        while (temp != null) {
            System.out.println(temp.name + " " + map.array[temp.hash].distance);
            temp = map.array[temp.hash].prev;
        }

    }

    public static void test(String from, String to) {
        Map map = new Map("D:\\TCOMK Pdfs\\Year 2\\Period 1\\Algorithms and Data Structures\\ADSA_Assignments\\src\\Graphs_Assignment_13\\trains.csv");
        long t0 = System.nanoTime();
        Hash dist = shortest(map.lookup(from), map.lookup(to), new Hash(map.hashmap));
        long time = (System.nanoTime() - t0) / 1_000;
        printpath(dist, map.lookup(to));
        System.out.println("shortest: " + dist.array[map.lookup(to).hash].distance + " min (" + time + " mus)");
    }
}

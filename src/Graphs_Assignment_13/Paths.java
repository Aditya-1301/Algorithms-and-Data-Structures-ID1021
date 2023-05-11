package Graphs_Assignment_13;

//'å','ä','ö'

public class Paths {
    City[] path;
    int sp;

    public Paths() {
        path = new City[52];
        sp = 0;
    }

    public static void main(String [] args) {
        benchmark(  "Malmö","Stockholm", 557);
        benchmark(  "Malmö","Sundsvall", 557);
        benchmark(  "Malmö","Umeå", 10000);
        benchmark(  "Malmö","Kiruna", 10000);
//        benchmark(  "Malmö","Göteborg", 557);
//        benchmark(  "Göteborg","Stockholm", 557);
//        benchmark(  "Malmö","Stockholm", 557);
//        benchmark(  "Stockholm","Sundsvall", 557);
//        benchmark(  "Stockholm","Umeå", 557);
//        benchmark(  "Göteborg","Sundsvall", 557);
//        benchmark(  "Sundsvall","Umeå", 557);
//        benchmark(  "Umeå","Göteborg", 1100);
//        benchmark(  "Göteborg","Umeå", 1100);
    }

    public static void benchmark(String from, String to, Integer max){
        Map map = new Map("D:\\TCOMK Pdfs\\Year 2\\Period 1\\Algorithms and Data Structures\\ADSA_Assignments\\src\\Graphs_Assignment_13\\trains.csv");
        Paths path = new Paths();

        float t0 = System.nanoTime();
        Integer dist = path.shortest(map.lookup(from), map.lookup(to), max);
        float time = (System.nanoTime() - t0)/1_000;//_000;

//        System.out.println("shortest: " + dist + " min (" + time + " ms)");
        System.out.println("From:" + from + "\t" + "To:" + to + "\t" + "shortest: " + dist + " min (" + time + " us)");
    }

    private Integer shortest(City from, City to, Integer max) {
        if (max != null && max < 0)
            return null;

        if (from == to)
            return 0;

        for (int i = 0; i < sp; i++) {
            if (path[i] == from)
                return null;
        }
        path[sp++] = from;

        Integer shortest = null;
        for (int i = 0; i < from.neighbors.length; i++){
            if (from.neighbors[i] != null){
                Connection conn = from.neighbors[i];
                Integer candidate;
                if (max == null)
                    candidate = shortest(conn.city, to, max);
                else
                    candidate = shortest(conn.city, to, max - conn.distance);

                if(candidate != null) {
                    if (shortest == null) {
                        shortest = conn.distance + candidate;
                    }
                    else {
                        shortest = Math.min(conn.distance + candidate, shortest);
                    }
                    max = shortest;
                }
            }
        }

        path[sp--] = null;
        return shortest;
    }
}

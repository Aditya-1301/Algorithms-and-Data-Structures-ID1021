package Graphs_Assignment_13;

//'å','ä','ö'
//Malmö to Göteborg
//Göteborg to Stockholm
//Malmö to Stockholm
//Stockholm to Sundsvall
//Stockholm Umeå
//Göteborg to Sundsvall
//Sundsvall to Umeå
//Umeå to Göteborg
//Göteborg to Umeå
public class Naive {

    public static void main(String [] args) {
        //bench(  "Stockholm","Malmö", 557);
        benchmark(  "Malmö","Göteborg", 557);
        benchmark(  "Göteborg","Stockholm", 557);
        benchmark(  "Malmö","Stockholm", 557);
        benchmark(  "Stockholm","Sundsvall", 557);
        benchmark(  "Stockholm","Umeå", 557);
        benchmark(  "Göteborg","Sundsvall", 557);
        benchmark(  "Sundsvall","Umeå", 557);
        benchmark(  "Umeå","Göteborg", 1100);
        benchmark(  "Göteborg","Umeå", 1100);
    }

    public static void benchmark(String from, String to, Integer max){
        Map map = new Map("D:\\TCOMK Pdfs\\Year 2\\Period 1\\Algorithms and Data Structures\\ADSA_Assignments\\src\\Graphs_Assignment_13\\trains.csv");

        long t0 = System.nanoTime();
        Integer dist = shortest(map.lookup(from), map.lookup(to), max);
        long time = (System.nanoTime() - t0)/1_000_000;

        System.out.println("From:" + from + "\t" + "To:" + to + "\t" + "shortest: " + dist + " min (" + time + " ms)");
    }
    private static Integer shortest(City from, City to, Integer max) {
        if (max < 0)
            return null;
        if (from == to)
            return 0;
        Integer shortest = null;
        for (int i = 0; i < from.neighbors.length; i++) {
            if (from.neighbors[i] != null) {
                Connection conn = from.neighbors[i];
                Integer candidate = shortest(conn.city, to, max - conn.distance);
                if(candidate != null) {
                    if (shortest == null)
                        shortest = conn.distance + candidate;
                    else
                        shortest = Math.min(conn.distance + candidate, shortest);
                }
            }
        }
    return shortest;
    }
}

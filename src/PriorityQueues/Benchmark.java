package PriorityQueues;

import java.util.Random;

public class Benchmark {
    static Random r = new Random();
    public static void benchmark(int iterations){
        int [] nValues =
                { 1_000, 64, 250, 500, 1_000, 2_000, 4_000, 8_000, 16_000, 32_000, 64_000, 128_000, 256_000, 512_000, 1_024_000};
//                {64};
        for (int i = 0; i < nValues.length; i++) {
            //float t = 0, t0, t1;
            long t = 0, t0, t1;
            //Integer tAdd = 0, tPush = 0;
            int value = r.nextInt(nValues[i]);
            for (int j = 0; j < iterations; j++) {
                //HeapArray h = new HeapArray(nValues[i]);
//                Heaps h1 = new Heaps();
                LinkedList l = new LinkedList();
//                Main.randomAdder(h,nValues[i]);
                //tAdd += h.add(value);
//                h.root.incrementData(value);
                //tPush += h.pushDown(h.root);
                l = randomLinkedListGenerator(nValues[i]);
                t0 = System.nanoTime();
//                for (int k = 0; k < nValues[i]; k++) {
//                    //h.add(k);
//                    //h1.add(k);
//                }
                l.addDataConstant(value);
                l.addPriorityLinear(value-1);
                //h.remove();
                //h1.removeRoot(h1.root);
                t1 = System.nanoTime();
                t += t1 - t0;
            }
            System.out.println(nValues[i] + "\t" + (t)/((iterations)));
            //System.out.println(nValues[i] + "\t" + tAdd/(iterations) + "\t" + tPush/iterations);
        }
    }
    public static LinkedList randomLinkedListGenerator(int n){
        LinkedList l = new LinkedList();
        for (int i = 0; i < 1; i++) {
            int x = r.nextInt(n*10);
            l.addPriorityLinear(x);
        }
//        System.out.println();
        return l;
    }
}

package Trees_Assignment_7;

import java.util.Random;

public class Benchmark {
    public static void benchmark(int iterations){
        int [] nValues =
                { 1_000, 250, 500, 1_000, 2_000, 4_000, 8_000, 16_000, 32_000, 64_000, 128_000, 256_000, 512_000, 1_024_000};
        //{ 1000, 25, 50, 100, 200, 400, 800, 1_600, 3_200, 6_400, 12_800, 25_600};
        Random rd = new Random();
        for (int i = 0; i < nValues.length; i++) {
            int value = rd.nextInt(nValues[i]*2);
            long t = 0, t0, t1;
            for (int j = 0; j < iterations; j++) {
                BinaryTree bt = randomTreeGenerator(nValues[i]);
                t0 = System.nanoTime();
                //bt.add(value,value);
                bt.lookup(value);
                t1 = System.nanoTime();
                t += t1 - t0;
            }
            System.out.println(nValues[i] + "\t" + t/(iterations));
        }
    }
    public static BinaryTree randomTreeGenerator(int n){
        BinaryTree bt = new BinaryTree();
        Random r = new Random();
        bt.add(n,n);
        for (int i = 2; i <= n ; i++) {
            bt.add(r.nextInt(n*2),i*8-7);
        }
        return bt;
    }
}

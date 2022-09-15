package HP35_Assignment_2;

public class Main {
    public static void main(String[] args) {
        Item [] i = new Item[]
//                {
//                new Item(ItemType.VALUE, 3),
//                new Item(ItemType.VALUE,4),
//                new Item(ItemType.ADD,0)
//        };
        {
                    new Item(ItemType.VALUE,10),
                    new Item(ItemType.VALUE,0),
                    new Item(ItemType.VALUE, 2),
                    new Item(ItemType.W_STAR,0),
                    new Item(ItemType.VALUE,3),
                    new Item(ItemType.VALUE, 1),
                    new Item(ItemType.W_STAR,0),
                    new Item(ItemType.VALUE,0),
                    new Item(ItemType.VALUE, 2),
                    new Item(ItemType.W_STAR,0),
                    new Item(ItemType.VALUE,1),
                    new Item(ItemType.VALUE, 1),
                    new Item(ItemType.W_STAR,0),
                    new Item(ItemType.VALUE,1),
                    new Item(ItemType.VALUE, 2),
                    new Item(ItemType.W_STAR,0),
                    new Item(ItemType.VALUE,3),
                    new Item(ItemType.VALUE, 1),
                    new Item(ItemType.W_STAR,0),
                    new Item(ItemType.VALUE,1),
                    new Item(ItemType.VALUE, 2),
                    new Item(ItemType.W_STAR,0),
                    new Item(ItemType.VALUE,2),
                    new Item(ItemType.VALUE, 1),
                    new Item(ItemType.W_STAR,0),
                    new Item(ItemType.VALUE,9),
                    new Item(ItemType.VALUE, 2),
                    new Item(ItemType.W_STAR,0),
                    new Item(ItemType.ADD,0),
                    new Item(ItemType.ADD,0),
                    new Item(ItemType.ADD,0),
                    new Item(ItemType.ADD,0),
                    new Item(ItemType.ADD,0),
                    new Item(ItemType.ADD,0),
                    new Item(ItemType.ADD,0),
                    new Item(ItemType.ADD,0),
                    new Item(ItemType.MOD,0),
                    new Item(ItemType.SUB,0)
        };

        int n = 200;
//        Static_Stack s = new Static_Stack(n);
//        Random r = new Random();
//        int s1 = 0;
//        long t0 = System.nanoTime();
//        for (int j = 0; j < n; j++) {
//            s.push(r.nextInt(n));
//            s1 += s.pop();
//        }
//        long t1 = System.nanoTime();
//        System.out.println(s1);
//        System.out.println("time: " + (t1 -t0)/n);
//        int [] val = new int[]{};
//        Dynamic_Stack s = new Dynamic_Stack(n);
//        Random r = new Random();
//        int s1 = 0;
//        long t0 = System.nanoTime();
//        for (int j = 0; j < n; j++) {
//            s.push(r.nextInt(n));
//            s1 += s.pop();
//        }
//        long t1 = System.nanoTime();
//        System.out.println(s1);
//        System.out.println("time: " + (t1 -t0)/n);

        long t_total = 0;
//        //for (int j = 0; j < i.length ; j++) {
//            Dynamic_Calculator c = new Dynamic_Calculator(i);
//            long t0 = System.nanoTime();
//            System.out.println(c.run());
//            long t1 = System.nanoTime();
//            System.out.println(t1 - t0);
//            t_total += t1 - t0;
//            System.out.println("-----------SS "  );
//        //}
        for (int j = 0; j < i.length; j++) {
            Dynamic_Calculator dc = new Dynamic_Calculator(i);
            long t2 = System.nanoTime();
            System.out.println(dc.run());
            long t3 = System.nanoTime();
            System.out.println(t3 - t2);
            t_total += t3 - t2;
            System.out.println("-----------DS "  + j);
        }
        System.out.println("Average:" +  t_total/ i.length);
    }
    /*
    {
                new Item(ItemType.VALUE,10),
                new Item(ItemType.VALUE,0),
                new Item(ItemType.VALUE, 2),
                new Item(ItemType.W_STAR,0),
                new Item(ItemType.VALUE,3),
                new Item(ItemType.VALUE, 1),
                new Item(ItemType.W_STAR,0),
                new Item(ItemType.VALUE,0),
                new Item(ItemType.VALUE, 2),
                new Item(ItemType.W_STAR,0),
                new Item(ItemType.VALUE,1),
                new Item(ItemType.VALUE, 1),
                new Item(ItemType.W_STAR,0),
                new Item(ItemType.VALUE,1),
                new Item(ItemType.VALUE, 2),
                new Item(ItemType.W_STAR,0),
                new Item(ItemType.VALUE,3),
                new Item(ItemType.VALUE, 1),
                new Item(ItemType.W_STAR,0),
                new Item(ItemType.VALUE,1),
                new Item(ItemType.VALUE, 2),
                new Item(ItemType.W_STAR,0),
                new Item(ItemType.VALUE,2),
                new Item(ItemType.VALUE, 1),
                new Item(ItemType.W_STAR,0),
                new Item(ItemType.VALUE,9),
                new Item(ItemType.VALUE, 2),
                new Item(ItemType.W_STAR,0),
                new Item(ItemType.ADD,0),
                new Item(ItemType.ADD,0),
                new Item(ItemType.ADD,0),
                new Item(ItemType.ADD,0),
                new Item(ItemType.ADD,0),
                new Item(ItemType.ADD,0),
                new Item(ItemType.ADD,0),
                new Item(ItemType.ADD,0),
                new Item(ItemType.MOD,0),
                new Item(ItemType.SUB,0)
                };//0 3 0 1 1 3 1 2 9
    */
}

package Hashtables_Assignenment_11;

public class Main {
    public static void main(String[] args) {
        Zip z = new Zip(
                "D:\\TCOMK Pdfs\\Year 2\\Algorithms and Data Structures\\Assignments\\Hash\\postnummer.csv");
        ZipString zs = new ZipString(
                "D:\\TCOMK Pdfs\\Year 2\\Algorithms and Data Structures\\Assignments\\Hash\\postnummer.csv");
        ZipKey zk = new ZipKey(
        "D:\\TCOMK Pdfs\\Year 2\\Algorithms and Data Structures\\Assignments\\Hash\\postnummer.csv");
        int iterations = 10000;
        int [] j = {8000, 9675 ,10000, 12345, 14616, 17626, 20000};
//        for (int i = 0; i <= j.length ; i++) {
//            zs.collisions(j[i]);
//        };

        long t = 0,t_0 = 0,t1,t2,t3,t4;
        for (int i = 0; i < iterations  ; i++) {
            t1= System.nanoTime();
            //zk.lookupConstant(11428);
            //z.lookupLinear(11428);
            z.lookupOpenAddressing(11428);
            t2 = System.nanoTime();
            t += t2-t1;
            t3= System.nanoTime();
            //zs.lookupLinear("111 15");
            z.lookupWithChaining(11428);
            //z.lookupOpenAddressing(11428);
            t4 = System.nanoTime();
            t_0 += t4-t3;
        }
        System.out.println(t_0/iterations + "\n" + t/iterations + "\n" + t/t_0 + "\n" + t/(38*iterations) + "\n" + t_0/(38*iterations));

    }
}

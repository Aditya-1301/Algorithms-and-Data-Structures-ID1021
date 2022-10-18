package Hashtables_Assignenment_11;

public class Main {
    public static void main(String[] args) {
        Zip z = new Zip(
                "D:\\TCOMK Pdfs\\Year 2\\Algorithms and Data Structures\\Assignments\\Hash\\postnummer.csv");
        ZipString zs = new ZipString(
                "D:\\TCOMK Pdfs\\Year 2\\Algorithms and Data Structures\\Assignments\\Hash\\postnummer.csv");
        ZipKey zk = new ZipKey(
        "D:\\TCOMK Pdfs\\Year 2\\Algorithms and Data Structures\\Assignments\\Hash\\postnummer.csv");
        int [] iterations = new int[]{
          1000, 2000, 4000, 8000, 16000
        };
        long t = 0,t1,t2;
        for (int i = 0; i < iterations.length && i < iterations[i]  ; i++) {
            t1= System.nanoTime();
            zk.lookupConstant(11428);
            //zs.lookupLinear("111 15");
            t2 = System.nanoTime();
            t += t2-t1;
            System.out.println(t/iterations[i]);
        }
        //System.out.println(z.lookupOpenAddressing(11115));
    }
}

package Hashtables_Assignenment_11;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ZipString {
    static Node[] data;
    static Integer [] keys;

    static int [] dataIndex;
    static int max, modulo;
    public class Node {
        String zipCode;
        String area;
        Integer population;
        public Node(String z, String a, Integer p) { //String z
            zipCode = z;
            area = a;
            population = p;
        }

        @Override
        public String toString() {
            return "zipcode = " + zipCode + " | area = " + area + " | population = " + population;
        }
    }
    public ZipString(String file) {
        modulo = 14616;
        data = new Node[modulo];
        keys = new Integer[modulo];
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                Integer code = Integer.valueOf(row[0].replaceAll("\\s", ""));
                data[i] = new Node(row[0], row[1], Integer.valueOf(row[2]));
                keys[i++] = code;
            }
            max = i - 1;
        }
        catch (IOException e){
        throw new RuntimeException(e);
        }
    }

    public Node lookupLinear(String s){
        for (int i = 0; i <= max; i++) {
            if(keys[i].equals(s)){
                return data[i];
            }
        }
        return null;
    }

    public void collisions(int mod) {
        dataIndex = new int[mod];
        int[] cols = new int[10];
        for (int i = 0; i < max; i++) {
            Integer index = keys[i] % mod;
            cols[dataIndex[index]]++;
            dataIndex[index]++;
        }
        System.out.print(mod);
        for (int i = 0; i < 10; i++) {
            System.out.print("\t" + cols[i]);
        }
        System.out.println("\n---------------------------------------------------------------------");
    }

    private static String removeSpaces(String s){
        StringBuilder s1 = new StringBuilder();
        for (int i = 0; i <s.length() ; i++) {
            if(s.charAt(i) != ' '){
                s1.append(s.charAt(i));
            }
        }
        return s1.toString();
    }
    public int index(int zip){
        return zip%modulo;
    }

}

package Hashtables_Assignenment_11;

import java.io.BufferedReader;
import java.io.FileReader;

public class Zip {
    static Node[] data;
    static Integer [] keys;
    static int [] dataIndex;
    static int max, modulo;
    public class Node {
        Integer zipCode;
        Node next;
        String area;
        Integer population;
        public Node(Integer z, String a, Integer p) { //String z
            zipCode = z;
            area = a;
            population = p;
        }

        @Override
        public String toString() {
            return "zipcode = " + zipCode + " | area = " + area + " | population = " + population;
        }
    }
    public Zip(String file) {
        modulo = 14616;
        data = new Node[modulo];
        keys = new Integer[modulo];
    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
        while ((line = br.readLine()) != null) {
            String[] row = line.split(",");
            int index = index(Integer.parseInt(removeSpaces(row[0])));
            if (data[index] == null)
            {
                Integer code = Integer.valueOf(row[0].replaceAll("\\s",""));
                data[index] = new Node(code, row[1], Integer.valueOf(row[2]));
            }
            else
            {
                while (data[index] != null)
                {
                    index++;
                    index %= modulo;
                }
                Integer code = Integer.valueOf(row[0].replaceAll("\\s",""));
                data[index] = new Node(code, row[1], Integer.valueOf(row[2]));
            }
            max = index - 1;
        }
        } catch (Exception e) {
            System.out.println(" file " + file + " not found");
        }
    }

        public Node lookupLinear(String s){
//        s = removeSpaces(s);
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
//    for (int i = 0; i < dataIndex.length; i++) {
//        System.out.print("\t" + dataIndex[i]);
//    }
//    System.out.println("\n---------------------------------------------------------------------")
    for (int i = 0; i < 10; i++) {
        System.out.print("\t" + cols[i]);
    }
    System.out.println("\n---------------------------------------------------------------------");
    }

    public Node lookupLinear(Integer integer){
        for (int i = 0; i < data.length; i++) {
            if(integer.equals(keys[i])){
                return data[i];
            }
        }
        return null;
        //We observe that we see around less than a microsecond of time to search for
        //a zipcode in the data, using this method, and we consistently get close to the same
        //time which indicates that this function has a constant time complexity.
        //Unlike doing a linear search or a binary search through an array.
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

    public String lookupWithChaining(int zip){
        var index = this.index(zip);
        if (data[index] == null)
        return "No such address";
        var node = data[index];
        while (node != null && node.zipCode != zip) node = node.next;
        if (node != null && node.zipCode == zip) return node.toString();
        return "No such address";
    }

    public String lookupOpenAddressing(int zip)
    {
        var index = this.index(zip);
        if (data[index] == null) {
            return "No such address";
        }
        var i = 0;
        while (data[index] != null && zip != data[index].zipCode && i < modulo)
        {
            index++;
            index %= modulo;
            i++;
        }
        if (data[index] != null && zip == data[index].zipCode) return data[index].toString();

        return "No such address";
    }
}
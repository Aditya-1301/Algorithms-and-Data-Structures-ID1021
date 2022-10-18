package Hashtables_Assignenment_11;

import java.io.BufferedReader;
import java.io.FileReader;

public class ZipKey {
    static Node[] data;
    int max;
    public class Node {
        Integer zipCode;
        //String zipCode;
        String area;
        Integer population;
        public Node(Integer z, String a, Integer p) { //String z
            zipCode = z;
            area = a;
            population = p;
        }
    }
    public ZipKey(String file) {
        data = new Node[100000];
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            //int i = 0;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                Integer code = Integer.valueOf(row[0].replaceAll("\\s",""));
                data[code] = new Node(code, row[1], Integer.valueOf(row[2]));
                //data[code] = new Node(row[0], row[1], Integer.valueOf(row[2]));
            }
            max = 99999;
        } catch (Exception e) {
            System.out.println(" file " + file + " not found");
        }
    }

    public Node lookupConstant(Integer s){
       //String s1 = removeSpaces(s);
       return data[s];
       //We observe that we see around less than a microsecond of time to search for
       //a zipcode in the data, using this method, and we consistently get close to the same
       //time which indicates that this function has a constant time complexity.
       //Unlike doing a linear search or a binary search through an array.
    }



    private String removeSpaces(String s){
        StringBuilder s1 = new StringBuilder();
        for (int i = 0; i <s.length() ; i++) {
            if(s.charAt(i) != ' '){
                s1.append(s.charAt(i));
            }
        }
        return s1.toString();
    }
}

package T9_Algorithm_Assignment_12.Implementation2;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Tries t = new Tries();
        String s = "123", s1 = "ceiling", s2 = "";
        t.searchWord(s);
//        for (int i = 0; i < 4; i++) {
//            s2 += getCode(s1.charAt(i));
//        }
//        System.out.println(s2);
    }
    public static int getCode(char character){
        char temp = Character.toLowerCase(character);
        System.out.println(temp - 97);
        int t = temp - 96;
        System.out.println(t);
        if(t >= 0 && t < 3){
            return 1;
        }
        else if (t > 2 && t < 6 ){
            return 2;
        } else if (t > 5 && t < 9 ) {
            return 3;
        }
        else if (t > 8 && t < 12 ) {
            return 4;
        }
        else if (t > 11 && t < 15 ) {
            return 5;
        }
        else if (t > 14 && t < 18 ) {
            return 6;
        }
        else if (t > 17 && t < 21 ) {
            return 7;
        }
        else if (t > 20 && t < 24 ) {
            return 8;
        }
        else if (t > 23 && t < 27 ) {
            return 9;
        }
        else{
            return 0;
        }
    }
}

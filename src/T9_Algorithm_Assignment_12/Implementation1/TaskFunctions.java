package T9_Algorithm_Assignment_12.Implementation1;

import T9_Algorithm_Assignment_12.Implementation1.Node;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TaskFunctions {
    public static Node generateDictionary(){
        Node root = new Node();
        try (BufferedReader br = new BufferedReader(new FileReader("src/kelly.txt"))){
            String line = "";
            while((line = br.readLine()) != null){
                Node current = root;
                System.out.println(line);
                for(char c : line.toCharArray()){
                    int i = charTranslator(c);
                    if(current.next[i] == null)
                        current.next[i] = new Node();
                    current = current.next[i];
                }
                current.word = true;
                System.out.println();
            }
        }
        catch (IOException fe) {
            System.out.println("File not found");
        }
        return root;
    }

    static char intTranslator(int i){
        char c = '0';
        c = (char)(i+97);
        if(i >= 16) c++;
        if(i >= 19) c++;
        if(i == 24) c = 'ä';
        if(i == 25) c = 'å';
        if(i == 26) c = 'ö';
        return c;
    }
    public static int charTranslator(char c){
        int character = (int)c;
        if(character == 113) character++;
        if(character == 119) character++;
        System.out.println((char)character);
        character -= 97;
        if(character == 131) character = 24;
        if(character == 132) character = 25;
        if(character == 149) character = 26;
        return character;
    }
}

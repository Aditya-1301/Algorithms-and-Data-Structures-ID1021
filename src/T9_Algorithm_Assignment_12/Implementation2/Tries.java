package T9_Algorithm_Assignment_12.Implementation2;

import java.io.*;
import java.util.ArrayList;
import java.util.NoSuchElementException;
public class Tries {
    public static class Node{
        private Node [] array;
        public boolean endOfWord;
        public char character;

        public Node(char c){
            array = new Node[30];
            endOfWord = false;
            character = c;
        }
        public Node(){
            array = new Node[30];
            endOfWord = false;
        }
        public Node get(char c){
            int index = calcIndex(c);
            if (index < 0 || index > 29) return null;
            return array[index];
        }

        public Node get(int index)
        {
            if (index < 0 || index > 29) return null;
            return array[index];
        }

        public boolean add(char c)
        {
            int index = calcIndex(c);
            if (index < 0 || index > 29) return false;
            if (array[index] != null) return true;
            array[index] = new Node(c);
            return true;
        }

        private int calcIndex(char c)
        {
            int index;
            if (c == 'å') index = 26;
            else if (c == 'ä') index = 27;
            else if (c == 'ö') index = 28;
            else if (c == ' ') index = 29;
            else index = c - 'a';
            return index;
        }

    }
    private Node root;
    public Tries() throws IOException {
        root = new Node();
        read("D:\\TCOMK Pdfs\\Year 2\\Algorithms and Data Structures" +
        "\\ADSA_Assignments\\src\\T9_Algorithm_Assignment_12\\kelly1.txt");
    }

    private void read(String fileAddress) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileAddress));
        String line;
        ArrayList<String> lines= new ArrayList<>();
        while ((line = br.readLine())!=null){
            lines.add(line);
        }
        for (String line1: lines) {
            addWord(line1.replaceAll("\\s","").toLowerCase());
        }
    }

    public void addWord(String word){
        Node current = root;
        char c;
        for (int i = 0; i < word.length() ; i++) {
            c = word.charAt(i);
            if(current.add(c)) current = current.get(c);
        }
        current.endOfWord = true;
    }

    public void searchWord(String sequence){
        char [][] outcomes = new char[sequence.length()][3];
        for (int i = 0; i < sequence.length(); i++)
        {
            char[] cc = numberToChar(sequence.charAt(i));
            System.arraycopy(cc, 0, outcomes[i], 0, cc.length);
        }
        prefixSearch(outcomes, 0, root, "");
    }
    private void prefixSearch(char[][] outcomes, int index, Node node, String word)
    {
        int length = outcomes.length;
        if (index < length)
        {
            for (int i = 0; i < 3; i++)
            {
                char c = outcomes[index][i];
                var node2 = node.get(c);
                if (node2 != null)
                {
                    String temp = word + node2.character;
                    prefixSearch(outcomes, index + 1, node2, temp);
                }
            }
        }
        else
        {
            if(node.endOfWord) System.out.println(word);
            for (int i = 0; i < 30; i++)
            {
                var node2 = node.get(i);
                if (node2 != null)
                {
                    String temp = word + node2.character;
                    prefixSearch(outcomes, index + 1, node2, temp);
                }
            }
        }
    }
    private char[] numberToChar(char c)
    {
        int number = c - '0';
        if(number==1) return new char[] { 'a', 'b', 'c' };
        if(number==2) return new char[] { 'd', 'e', 'f' };
        if(number==3) return new char[] { 'g', 'h', 'i' };
        if(number==4) return new char[] { 'j', 'k', 'l' };
        if(number==5) return new char[] { 'm', 'n', 'o' };
        if(number==6) return new char[] { 'p', 'q', 'r' };
        if(number==7) return new char[] { 's', 't', 'u' };
        if(number==8) return new char[] { 'v', 'w' ,'x'};
        if(number==9) return new char[] { 'y','z', 'å' };
        if(number==0) return new char[] { 'ä','ö', ' ' };
        throw new NoSuchElementException();
    }
}

package T9_Algorithm_Assignment_12.Implementation2;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Tries t = new Tries();
        //Tries.Node a = new Tries.Node();
        t.addWord("asdfg");
        t.addWord("qwerty");
        t.addWord("uiop");
        t.searchWord("asdfg");
    }
}

package T9_Algorithm_Assignment_12.Implementation1;

public class Main {
    public static void main(String[] args) {
//        Node root = TaskFunctions.generateDictionary();
//        Node current = root;
        System.out.println(getCode('z'));
        System.out.println(getCharacter(26));
//                TaskFunctions.intTranslator(18) + "" +
//                        TaskFunctions.intTranslator(19) +
//                        TaskFunctions.intTranslator(20));
    }

    public static int getCode(char character){
        char temp = Character.toLowerCase(character);
        return temp - 96;
    }
    public static char getCharacter(int code){
        char i = (char) (code + 96);
        return i;
    }
}

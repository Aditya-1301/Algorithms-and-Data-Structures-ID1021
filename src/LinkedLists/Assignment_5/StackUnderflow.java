package LinkedLists.Assignment_5;

public class StackUnderflow extends Exception{
    public StackUnderflow(){
        super("You cannot pop from an empty list");
    }
    StackUnderflow(String message){
        super(message);
    }
}

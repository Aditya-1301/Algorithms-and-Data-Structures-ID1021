package HP35_Assignment2;

public class Static_Stack {

    int [] list;
    int pointer;

    Static_Stack(int length){
//        expr = new Item[MAX_CAPACITY_FOR_STACK];
        this.list = new int[length];
        this.pointer = 0;
    }

    public int pop(){
        if(pointer -1 < 0){
            System.out.println("Stack UnderFlow");
            return -1;//Integer.parseInt(String.valueOf(list));
        }
        else{
            return list[pointer--];
        }
    }

    public boolean push(int i){
        if(pointer < list.length){
            this.list[pointer++] = i;
            return true;
        }
        else{
            System.out.println("Stack OverFlow");
            return false;
        }
    }
}
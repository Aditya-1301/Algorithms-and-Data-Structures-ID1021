package HP35_Assignment_2;

public class Dynamic_Stack {
    int [] list;
    //final int MAX_CAPACITY_FOR_STACK = 4;
    int pointer;
    int pushCount = 0;

    Dynamic_Stack(int length){
//        expr = new Item[MAX_CAPACITY_FOR_STACK];
        this.list = new int[length];
        this.pointer = 0;
    }

    public int pop() {
        if(pointer -1 < 0){
            System.out.println("Stack UnderFlow");
            return 0;
        }
        else{
            int retValue = list[pointer--];
            if(pushCount > list.length && list.length > 4){
                arrayShrink(list);
            }
            return retValue;
        }
    }

    public boolean push(int i) {
        if(pointer + 1< list.length){
            this.list[++pointer] = i;
            pushCount ++;
            return true;
        } else if (pointer == list.length) {
            this.list = arrayExpander(list);
        } else{
            System.out.println("Stack UnderFlow");
        }
        return false;
    }
    public int[] arrayExpander(int [] list){
        int [] newList = new int[list.length * 2];
        for (int i = 0; i < list.length; i++) {
            newList[i] = list[i];
        }
        return newList;
    }
    public void arrayShrink(int [] list){
        if(pointer<=(list.length)/4){
            int [] halfList = new int[list.length/2];
            for (int i = 0; i < pointer + 1; i++) {
                halfList[i] = list[i];
            }
            this.list = halfList;
        }
    }
}
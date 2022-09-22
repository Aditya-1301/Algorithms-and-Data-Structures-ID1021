package LinkedLists.Assignment_5;

public class DynamicArray {
    int [] a;
    int tailPointer;

    public DynamicArray(int n){
        tailPointer = 0;
        setA(n);
    }

    public void setA(int n) {
        if(n > 0) a = new int[n];
    }

    public String toString(){
        StringBuilder s = new StringBuilder();
        if(tailPointer == 0) {
            s.append("No elements");
        }
        else{
            int i = 0;
            while(i < tailPointer ){
                s.append(a[i] + "\t");
                i++;
            }
        }
        return s.toString();
    }

    public void push(int e){
        int length = a.length;
        if(tailPointer < length) a[tailPointer++] = e;
        else{
           a = arrayExpander();
           a[tailPointer-1] = e;
        }
    }

    public void pushArray(int [] a2){
        a = arrayExpander2(a2);
    }

    int pop(){
        int temp = a[tailPointer-1];
        tailPointer--;
        return temp;
    }

    int [] arrayExpander(){
        int [] a1 = new int[a.length*2];
        for (int i = 0; i < a.length; i++) {
            a1[i] = a[i];
        }
        tailPointer++;
        return a1;
    }

    int [] arrayExpander2(int [] a2){
        int [] a1 = new int[a.length + a2.length];
        for (int i = 0; i < a.length; i++) {
            a1[i] = a[i];
        }
        for (int i = 0; i <a2.length ; i++) {
            a1[i + a.length] = a2[i];
        }
        tailPointer +=a2.length ;
        return a1;
    }
}

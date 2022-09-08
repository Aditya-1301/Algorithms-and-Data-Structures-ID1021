package HP35_Assignment2;

public class Calculator {
        Item[] expr;
        int ip;
        Static_Stack stack;

    public Calculator(Item[] expr) {
        this.expr = expr;
        this.ip = 0;
        this.stack = new Static_Stack(expr.length);
    }
    public int run() {
        while ( ip < expr.length ) {
            //if(ip == -1) ++ip;
            step();
        }
        return stack.pop();
    }

    public void step() {
        Item nxt = expr[ip++];
        switch (nxt.getType()) {
                case ADD: {
                    int y = stack.pop();
                    int x = stack.pop();
                    stack.push(x + y);
                    break;
                }
                case SUB:{
                    int y = stack.pop();
                    int x = stack.pop();
                    stack.push(x-y);
                    break;
                }
                case MUL:{
                    int y = stack.pop();
                    int x = stack.pop();
                    stack.push(x*y);
                    break;
                }
                case DIV:{
                    int y = stack.pop();
                    int x = stack.pop();
                    stack.push(x/y);
                    break;
                }
                case W_STAR:{
                    int y = stack.pop();
                    int x = stack.pop();
                    stack.push(x*y%10 + x*y/10);
                    break;
                }
                case MOD:{
                    int x = stack.pop();
                    stack.push(x%10);
                    break;
                }
                case VALUE: {
                stack.push(nxt.getValue());
                break;
                }
          }
    }
}

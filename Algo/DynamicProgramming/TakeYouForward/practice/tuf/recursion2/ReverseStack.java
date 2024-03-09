package recursion2;

import java.util.Stack;

public class ReverseStack {


    public static void main(String[] args) {
        new ReverseStack();
        
    }

    private Stack<Integer> stack = new Stack<>();

    ReverseStack(){
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        System.out.println(stack);
        reverseStack(stack);
        System.out.println(stack);
    }

    public void reverseStack(Stack<Integer> stack){
        if(stack.isEmpty()) return;

        int a = stack.pop();
        reverseStack(stack);
        putBottom(stack, a);
        
    }

    public void putBottom(Stack<Integer> stack,int b){
        if(stack.isEmpty()) {
            stack.push(b);
            return;
        }
        int a = stack.pop(); 
        putBottom(stack, b);
        stack.push(a);
    }
}

package recursion2;

import java.util.*;

public class SortNumbers {

    int[] list =  {6,7,2,1,9,4,3,0,9,8};
    Stack<Integer> stack = new Stack<>();
    public static void main(String[] args) {
        new SortNumbers();
    }
    SortNumbers(){
         for(int i:list) stack.push(i);
         sortNumber(stack);
         System.out.println(stack);
    }
    public void sortNumber(Stack<Integer> stack){
        if(stack.isEmpty()) return;
        int a = stack.pop();
        sortNumber(stack);
        pushBack(stack, a);
    }

     public void pushBack(Stack<Integer> stack,int src){
         if(stack.isEmpty() || src<=stack.peek()){
            stack.push(src);
            return;
        }
        int a= stack.pop();
        pushBack(stack, src);
        stack.push(a);
     }

}

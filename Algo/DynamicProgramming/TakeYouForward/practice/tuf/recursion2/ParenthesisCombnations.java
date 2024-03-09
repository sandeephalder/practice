package recursion2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ParenthesisCombnations {
    public static void main(String[] args) {
        new ParenthesisCombnations();
    }

    ParenthesisCombnations(){
        List<String> result = new ArrayList<>();
        int len=2;
        printAllParanthesis(result, "", len*2);
        System.out.println(result);
    }

    private void printAllParanthesis(List<String> list,String str,int index){
        if(index<=0){
            if(isValid(str))
            list.add(new String(str));
            return;
        }

        printAllParanthesis(list, str+")", index-1);
        printAllParanthesis(list, str+"(", index-1);

    }

    public boolean isValid(String pattern){
        Stack<Character> stack = new Stack<>();

        for(int i=0;i<pattern.length();i++)
        {
            if(pattern.charAt(i)=='(') stack.push(pattern.charAt(i));
            if(pattern.charAt(i)==')') {
                if(stack.size()==0) return false;
                Character c = stack.pop();
                if(c!='(') return false;
            }

            
        }
        return stack.size()==0;
    }
}

package StackQueues;

public class CheckBalancedParanthesis {
    String input="{[]}{}{([])}[[()]]()";
    public static void main(String[] args) {
        new CheckBalancedParanthesis();
    }

    CheckBalancedParanthesis(){
        System.out.println(checkBalancedParanthesis(input));
    }

    public boolean checkBalancedParanthesis(String ip){
        int N= ip.length();
        Stack<Character> stack = new Stack<>(N+1);
        for(int i=0;i<N;i++){
            char c = ip.charAt(i);
            if(c=='('||c=='{'||c=='[') {
                stack.push(c);
            }
            else if(stack.isEmpty()) return false;
            else if(c==')'){
                char comp = stack.pop();
                if(comp !='(') return false; 
            }
            else if(c=='}'){
                char comp = stack.pop();
                if(comp !='{') return false; 
            }
            else if(c==']'){
                char comp = stack.pop();
                if(comp !='[') return false; 
            }
            else return false;
        }
        if(!stack.isEmpty()) return false;
        return true;
    }
}

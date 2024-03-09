import java.util.Stack;

public class ValidString {
    ValidString(){
     String str = "{}";
     System.out.println(isValid(str));
    }
    public static void main(String[] args) {
        new ValidString();
    }

    public boolean isValid(String s) {
    
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='(' || c=='{' || c=='[') stack.push(c);
            else if(c==')' || c=='}' || c==']'){
                if(stack.isEmpty()) return false;
                char d = stack.pop();
                if(c==')' && d != '(') return false;
                if(c=='}' && d != '{') return false;
                if(c==']' && d != '[') return false;
            }
        }
        return stack.size()==0;
    }
}

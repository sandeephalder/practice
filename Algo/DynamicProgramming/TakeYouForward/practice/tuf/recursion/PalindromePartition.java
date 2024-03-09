package tuf.recursion;
import java.util.ArrayList;
import java.util.List;

public class PalindromePartition {

    String str = "aaabbb";

    PalindromePartition(){
        List<List<String>> result = new ArrayList<>();
        partitionString(str,new ArrayList<>(), result);
        System.out.println(result);
    }

    public static void main(String[] args) {
        new PalindromePartition();
    }

    private boolean partitionString(String s,List<String> palindrome,List<List<String>> result){
        if(s.length()==0) {
            result.add(palindrome);
            return true;
        }
        for(int i=0;i<s.length();i++){
            String st = s.substring(0, i+1);
            
            if(isPalindrome(st)){
                List<String> palindrome_new = new ArrayList<>(palindrome);
                palindrome_new.add(st);
                partitionString(s.substring(i+1), palindrome_new, result);
            }
            
        }
        return false;
    }

    private boolean isPalindrome(String str){
        int N = str.length();
        if(str.length()<1) return false;
        if(str.length()==1) return true;
        for(int i=0;i<N/2;i++){
            if(str.charAt(i)!=str.charAt(N-i-1)) return false;
        }
        return true;
    }

}

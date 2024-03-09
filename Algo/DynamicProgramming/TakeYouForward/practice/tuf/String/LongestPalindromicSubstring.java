package String;

import java.util.ArrayList;
import java.util.List;

public class LongestPalindromicSubstring {
    String s = "aba";
    public static void main(String[] args) {
        new LongestPalindromicSubstring();
    }

    LongestPalindromicSubstring(){
        int max=0;
        for(String a:findAllSubStrings(s)){
            if(isPalindrome(a)){
              
                max = Math.max(max,a.length());
            }
        }
        System.out.println(max);
    }

    private boolean isPalindrome(String s){
        int N= s.length();
        if(N==0 || N==1) return true;
        for(int i=0;i<N;i++) if(s.charAt(i)!=s.charAt(N-1-i)) return false;
        return true;
    }

    private List<String> findAllSubStrings(String s){
        List<String> res = new ArrayList<>();
        for(int i=0;i<=s.length();i++){
            for(int j=i;j<=s.length();j++){
                if(i==j) continue;
                res.add(s.substring(i, j));
            }
        }
        return res;
    }
}

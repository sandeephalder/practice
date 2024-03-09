package recursion2;

import java.util.*;

public class LargerNumberOfSubsequences {
    String s1="ab",s2="dd";
    public static void main(String[] args) {
        new LargerNumberOfSubsequences();
    }

    LargerNumberOfSubsequences(){
        Set<String> set1= new HashSet<>();
        Set<String> set2= new HashSet<>();
        findDistinctSubsequences(s1, set1, s1.length(), "");
        findDistinctSubsequences(s2, set2, s2.length(), "");
        if(set1.size()>set2.size())
        System.out.println(" S1 " +set1);
        else
        System.out.println(" S2 " +set2);
    }

    private void findDistinctSubsequences(String s,Set<String> result,int index,String carry){
        if(index==0){
            result.add(new String(carry));
            return;
        }
         carry+=s.charAt(index-1);
        findDistinctSubsequences(s,result, index-1, carry);
         carry= carry.substring(0,carry.length()-1);
        findDistinctSubsequences(s,result, index-1, carry);
    }
}

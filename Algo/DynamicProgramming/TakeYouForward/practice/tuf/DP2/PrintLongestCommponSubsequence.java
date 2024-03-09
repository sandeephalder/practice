package DP2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrintLongestCommponSubsequence {
    String s1= "adebc",s2="dcadb";
    int N1=s1.length(),N2=s2.length(),MIN=-(int)(10e6);

    public static void main(String[] args) {
        new PrintLongestCommponSubsequence();
    }

    PrintLongestCommponSubsequence(){
        System.out.println("Recursive: "+findLCSRecursive(N1, N2, s1, s2));
        System.out.println("Iterative: "+findLCSIterative(s1, s2));
        System.out.println("Iterative Efficient: "+findLCSIterativeEfficient(s1, s2));
    }

    public String findLCSRecursive(int n, int m, String s1, String s2){
        String[][] dp = new String[N1][N2];
        for(int i =0;i<N1;i++) Arrays.fill(dp[i],null);
        return findLCSRecursive(s1, s2, N1-1, N2-1, "",dp);
    }

    public String findLCSIterative( String s1, String s2){
        String[][] dp = new String[N1][N2];
        String s="";
        for(int i =0;i<N1;i++) Arrays.fill(dp[i],"");
        for(int i =0;i<N1;i++) {
            if(s1.charAt(0)==s2.charAt(i)) s= s1.substring(0,1);
            dp[0][i]=s;
        }

        for(int index1=1;index1<N1;index1++){
            for(int index2=0;index2<N2;index2++){

                if(s1.charAt(index1)==s2.charAt(index2) && index2>0){
                    dp[index1][index2]=dp[index1-1][index2-1]+""+s1.charAt(index1);
                }
                else{
                    String l1="",l2="";
                    l1 = dp[index1-1][index2];
                    if(index2>0)
                    l2 = dp[index1][index2-1];
                    if(l1.length()>l2.length())
                    dp[index1][index2] = l1;
                    else dp[index1][index2]=l2;
                }
            }
        }

        return dp[N1-1][N2-1];
    }

    public String findLCSRecursive( String s1, String s2,int index1,int index2,String level,String[][] dp){
        if(index1<0 || index2<0) return "";
        if(dp[index1][index2]!=null) return dp[index1][index2];
        if(s1.charAt(index1)==s2.charAt(index2)){
            return findLCSRecursive(s1, s2, index1-1, index2-1, level, dp)+""+s1.charAt(index1);
        }
        else{
            String l1="",l2="";
            l1 = findLCSRecursive(s1, s2, index1-1, index2, level, dp);
            l2 = findLCSRecursive(s1, s2, index1, index2-1, level, dp);
            if(l1.length()>l2.length())
            dp[index1][index2] = l1;
            else dp[index1][index2]=l2;
        }
        return dp[index1][index2];
    }

public String findLCSIterativeEfficient( String s1, String s2){
        String[] previous = new String[N2];
        String[] current = new String[N2];
        String s="";
        Arrays.fill(current,"");
        Arrays.fill(previous,"");
        for(int i =0;i<N1;i++) {
            if(s1.charAt(0)==s2.charAt(i)) s= s1.substring(0,1);
            previous[i]=s;
        }

        for(int index1=1;index1<N1;index1++){
            for(int index2=0;index2<N2;index2++){

                if(s1.charAt(index1)==s2.charAt(index2) && index2>0){
                    current[index2]=previous[index2-1]+""+s1.charAt(index1);
                }
                else{
                    String l1="",l2="";
                    l1 = previous[index2];
                    if(index2>0)
                    l2 = current[index2-1];
                    if(l1.length()>l2.length())
                    current[index2] = l1;
                    else current[index2]=l2;
                }
            }
            previous=current.clone();
        }

        return current[N2-1];
    }
    
}

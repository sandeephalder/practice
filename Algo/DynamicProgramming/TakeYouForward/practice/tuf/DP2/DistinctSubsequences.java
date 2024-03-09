package DP2;

import java.util.Arrays;

public class DistinctSubsequences {
    String string="rabbbit",pattern="rabbit";
    int N1=string.length(),N2=pattern.length();
    public static void main(String[] args) {
        new DistinctSubsequences();
    }

    DistinctSubsequences(){
        int[][] dp = new int[N1][N2];
        for(int i=0;i<N1;i++) Arrays.fill(dp[i],-1);
        System.out.println("Recursive : "+numDistinctRecursive(string, pattern, N1-1, N2-1, dp));
        System.out.println(" Iterative: "+numDistinctIterative(string, pattern));
        System.out.println(" Iterative Efficient: "+numDistinctIterativeEfficient(string, pattern));
    }

    public int numDistinctRecursive(String s, String t,int index1,int index2,int[][] dp) {
          if(index2<0)
            return 1;
        if(index1<0)
            return 0;
    
        if(dp[index1][index2]!=-1) return dp[index1][index2];

        if(s.charAt(index1)==t.charAt(index2)){
            dp[index1][index2] = numDistinctRecursive(s, t, index1-1, index2-1, dp)
            +numDistinctRecursive(s, t, index1-1, index2, dp);
        }
        else
            dp[index1][index2] = numDistinctRecursive(s, t, index1-1, index2, dp);;
        
        return dp[index1][index2];
    }

      public int numDistinctIterative(String s, String t) {
        int[][] dp = new int[N1+1][N2+1];
        for(int i=0;i<N1;i++) dp[i][0]=1;
    
        for(int index1=1;index1<=N1;index1++){
            for(int index2=1;index2<=N2;index2++){
                  if(s.charAt(index1-1)==t.charAt(index2-1)){
            dp[index1][index2] = dp [index1-1] [index2-1]
            +dp [index1-1] [index2];
        }
        else
            dp[index1][index2] = dp [index1-1] [index2];
            }
        }
        return dp[N1][N2];
    }

    public int numDistinctIterativeEfficient(String s, String t) {
        int[] current = new int[N2+1];
        int[] previous = new int[N2+1];
        previous[0]=1;
        current[0]=1;
    
        for(int index1=1;index1<=N1;index1++){
            for(int index2=1;index2<=N2;index2++){
                  if(s.charAt(index1-1)==t.charAt(index2-1)){
            current[index2] = previous [index2-1]
            +previous [index2];
        }
        else
            current[index2] = previous [index2];
            }
            previous=current.clone();
        }
        return current[N2];
    }
}

package DP2;

import java.util.Arrays;

public class MinimumInsertionsDeletions {
    //String s1="sea",s2="eat";
    String s1="abcd",s2="efgab";
    int N1=s1.length(),N2=s2.length();
    public static void main(String[] args) {
        new MinimumInsertionsDeletions();
    }

    MinimumInsertionsDeletions(){
        int[][] dp = new int[N1][N2];
        for(int i=0;i<N1;i++) Arrays.fill(dp[i], -1);
        System.out.println(" Recursion: "+((N1+N2)-2*minDistanceRecursion(s1, s2, N1-1, N2-1, dp)));
        System.out.println(" Iteration: "+(minDistanceIteration(s1, s2)));
        System.out.println(" Iteration Efficient: "+(minDistanceIterationEfficient(s1, s2)));

    }

    public int minDistanceRecursion(String word1, String word2,int index1,int index2,int[][] dp) {
        if(index1 < 0 || index2 <0) return 0;
        if(dp[index1][index2]!=-1) return dp[index1][index2];
        if(word1.charAt(index1)==word2.charAt(index2)){
            dp[index1][index2]=minDistanceRecursion(word1, word2, index1-1, index2-1, dp)+1;
        }
        else{
            dp[index1][index2]=Math.max(minDistanceRecursion(word1, word2, index1-1, index2, dp), 
            minDistanceRecursion(word1, word2, index1, index2-1, dp));
        }
        return dp[index1][index2];
    }

    public int minDistanceIteration(String word1, String word2) {
        int[][] dp = new int[N1+1][N2+1];
        for(int index1=1;index1<=N1;index1++){
            for(int index2=1;index2<=N2;index2++){
                    if(word1.charAt(index1-1)==word2.charAt(index2-1)){
                        dp[index1][index2]=dp[index1-1][index2-1]+1;
                    }
                    else{
                        dp[index1][index2]=Math.max(dp[index1-1][index2],dp[index1][index2-1]);
                    } 
            }
        }
        return (N1+N2)-2*dp[N1][N2];
    }

    public int minDistanceIterationEfficient(String word1, String word2) {
        int[] current = new int[N2+1];
        int[] previous = new int[N2+1];
        for(int index1=1;index1<=N1;index1++){
            for(int index2=1;index2<=N2;index2++){
                    if(word1.charAt(index1-1)==word2.charAt(index2-1)){
                        current[index2]=previous[index2-1]+1;
                    }
                    else{
                        current[index2]=Math.max(previous[index2],current[index2-1]);
                    } 
            }
            previous=current.clone();
        }
        return (N1+N2)-2*current[N2];
    }
}

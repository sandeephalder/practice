package DP2;

import java.util.Arrays;

public class MinimumEditDistance {
    String s1="intention",s2="execution";
    int N1=s1.length(),N2=s2.length(),MAX=(int)(10e6);
    public static void main(String[] args) {
        new MinimumEditDistance();
    }

    MinimumEditDistance(){
        int[][] dp = new int[N1+1][N2+1];
        for(int i=0;i<=N1;i++) Arrays.fill(dp[i],-1);
        System.out.println("Recursive: "+minDistanceRecursive(s1, s2, N1, N2, dp));
        System.out.println(" Iterative: "+minDistanceIterative(s1, s2));
        System.out.println(" Iterative Efficient: "+minDistanceIterativeEfficient(s1, s2));
    }

    public int minDistanceRecursive(String s1, String s2,int i1,int i2,int[][] dp) {
        if(i1==0) return i2;
        if(i2==0) return i1;
        if(dp[i1][i2]!=-1) return dp[i1][i2];
        if(s1.charAt(i1-1)==s2.charAt(i2-1)){
            dp[i1][i2]=minDistanceRecursive(s1, s2, i1-1, i2-1, dp);
        }
        else{
            int a=0,e=0,d=0;
            a = minDistanceRecursive(s1, s2, i1-1, i2, dp);
            e = minDistanceRecursive(s1, s2, i1, i2-1, dp);
            d = minDistanceRecursive(s1, s2, i1-1, i2-1, dp);
            dp[i1][i2]=Math.min(a, Math.min(e, d))+1;
        }
        return dp[i1][i2];
    }

    public int minDistanceIterative(String s1, String s2) {
        int[][] dp = new int[N1+1][N2+1];
        for(int i1=0;i1<=N1;i1++) dp[i1][0]=i1;
        for(int i2=0;i2<=N2;i2++) dp[0][i2]=i2;

        for(int i1=1;i1<=N1;i1++) {
            for(int i2=1;i2<=N2;i2++){
                if(s1.charAt(i1-1)==s2.charAt(i2-1)){
                    dp[i1][i2]=dp[i1-1][i2-1];
                }
                else{
                    int a=0,e=0,d=0;
                    a = dp[i1-1][i2];
                    e = dp[i1][i2-1];
                    d = dp[i1-1][i2-1];
                    dp[i1][i2]=Math.min(a, Math.min(e, d))+1;
                }
            }
        }
        return dp[N1][N2];
    }

    public int minDistanceIterativeEfficient(String s1, String s2) {
        int[] current = new int[N2+1];
        int[] previous = new int[N2+1];
        
        for(int i2=0;i2<=N2;i2++){
            previous[i2]=i2;
             
           } 

        for(int i1=1;i1<=N1;i1++) {
             current[0]=i1;
            for(int i2=1;i2<=N2;i2++){
                if(s1.charAt(i1-1)==s2.charAt(i2-1)){
                    current[i2]=previous[i2-1];
                }
                else{
                    int a=0,e=0,d=0;
                    a = previous[i2];
                    e = current[i2-1];
                    d = previous[i2-1];
                    current[i2]=Math.min(a, Math.min(e, d))+1;
                }
            }
            previous=current.clone();
        }
        return current[N2];
    }
}

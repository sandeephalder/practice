package DP2;

import java.util.Arrays;

public class LongestPalindromicSubsequence {
    String s= "bbbab",r=reverse(s);
    int N= s.length(),MIN= -(int)(10e6);
    public static void main(String[] args) {
        new LongestPalindromicSubsequence();
    }

    LongestPalindromicSubsequence(){
        
        System.out.println(" Recursive: "+longestPalindromeSubsequenceRecursion(s, r, N-1, N-1));
        System.out.println(" Iterative : "+longestPalindromeSubsequenceIterative(s, reverse(s)));
        System.out.println(" Iterative Efficient: "+longestPalindromeSubsequenceIterativeEfficient(s, reverse(s)));

       // System.out.println(reverse("abcd"));
    }

    public int longestPalindromeSubsequenceRecursion(String s1,String s2,int index1,int index2) {
        int[][] dp = new int[N][N];
        for(int i=0;i<N;i++) Arrays.fill(dp[i],-1);
        
        return longestPalindromeSubsequenceRecursion(s1, s2, index1, index2, dp);
    }

    public int longestPalindromeSubsequenceRecursion(String s1,String s2,int index1,int index2,int[][] dp) {
        if(index1<0 || index2 < 0){
            return 0;
        }
        if(dp[index1][index2]!=-1) return dp[index1][index2];
        if(s1.charAt(index1)==s2.charAt(index2)){
            dp[index1][index2]= longestPalindromeSubsequenceRecursion(s1, s2, index1-1, index2-1, dp)+1;
        }
        else{
        int left =MIN,top=MIN;
      
        left = longestPalindromeSubsequenceRecursion(s1, s2, index1-1, index2, dp);
       
        top = longestPalindromeSubsequenceRecursion(s1, s2, index1, index2-1, dp);
        dp[index1][index2]=Math.max(left, top);
        }
       
        return dp[index1][index2];
    }

    public int longestPalindromeSubsequenceIterative(String s1,String s2) {
        int[][] dp = new int[N+1][N+1];
        
        for(int index1=1;index1<=N;index1++){
            for(int index2=1;index2<=N;index2++){
                if(s1.charAt(index1-1)==s2.charAt(index2-1)){
                    dp[index1][index2]= dp[index1-1][index2-1]+1;
                }
                else
                dp[index1][index2]=Math.max(dp[index1-1][index2], dp[index1][index2-1]);
            }
        }
        return dp[N][N];
    }

    public int longestPalindromeSubsequenceIterativeEfficient(String s1,String s2) {
        int[] current = new int[N+1];
        int[] previous = new int[N+1];
        for(int index1=1;index1<=N;index1++){
            for(int index2=1;index2<=N;index2++){
                if(s1.charAt(index1-1)==s2.charAt(index2-1)){
                    current[index2]= previous[index2-1]+1;
                }
                else
                current[index2]=Math.max(previous[index2], current[index2-1]);
            }
            previous=current.clone();
        }
        return current[N];
    }
    

   
    private String reverse(String s){
        if(s==null) return null;
        int n= s.length();
        String result ="";
        for(int i=n-1;i>=0;i--) result+=s.charAt(i);
        return result;
    }
}

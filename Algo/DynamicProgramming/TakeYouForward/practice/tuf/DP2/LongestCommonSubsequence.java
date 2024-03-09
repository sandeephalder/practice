package DP2;

import java.util.Arrays;

public class LongestCommonSubsequence {
    String s1= "adebc",s2="dcadb";
    int N1=s1.length(),N2=s2.length(),MIN=-(int)(10e6);
    public static void main(String[] args) {
        new LongestCommonSubsequence();
    }

    LongestCommonSubsequence(){
        int[][] dp =new int[N1][N2];
        for(int i=0;i<N1;i++) Arrays.fill(dp[i], -1);
        System.out.println(" Recursive: "+longestCommonSubsequenceRecursive(s2, s1,N1-1,N2-1,dp,0));
        System.out.println(" Iterative : "+longestCommonSubsequenceIterative(s1, s2));
        System.out.println(" Iterative Efficient: "+longestCommonSubsequenceIterativeEfficient(s1, s2));
    }

    public int longestCommonSubsequenceRecursive(String text1, String text2,int index1,int index2,int[][] dp,int sum) {
        if(index1<0 || index2<0)
            return 0;
        
        if(dp[index1][index2]!=-1) return dp[index1][index2];
        
        int l2=MIN,l3=MIN;
        
        if(text1.charAt(index1)==text2.charAt(index2))    
            return longestCommonSubsequenceRecursive(text1, text2, index1-1, index2-1,dp,sum) +1;
        else{
       
        l2= longestCommonSubsequenceRecursive(text1, text2, index1-1, index2,dp,sum);
       
        l3= longestCommonSubsequenceRecursive(text1, text2, index1, index2-1,dp,sum);
        }
       
        dp[index1][index2] = Math.max(l2,l3);
        return dp[index1][index2];
    }

    public int longestCommonSubsequenceIterative(String text1, String text2) {
        int[][] dp =new int[N1][N2];
        int s=0;
        for(int i=0;i<N2;i++) {
            if(text1.charAt(0)==text2.charAt(i)) s=1;
            dp[0][i]=s;
        }
        for(int index1=1;index1<N1;index1++){
            for(int index2=0;index2<N1;index2++){
                int l2=MIN,l3=MIN;
        
                if(text1.charAt(index1)==text2.charAt(index2) && index2>0)  
                    dp[index1][index2] =dp[index1-1][ index2-1] +1;
                       
                else{ 
                l2= dp[index1-1][ index2];
                if(index2>0)
                l3= dp[index1][ index2-1];
                dp[index1][index2] = Math.max(l2,l3);
                }
            }
        }
        return dp[N1-1][N2-1];
    }

    public int longestCommonSubsequenceIterativeEfficient(String text1, String text2) {
        int[] previous =new int[N2];
        int[] current =new int[N2];
        int s=0;
        for(int i=0;i<N2;i++) {
            if(text1.charAt(0)==text2.charAt(i)) s=1;
            current[i]=s;
        }
        for(int index1=1;index1<N1;index1++){
            for(int index2=0;index2<N1;index2++){
                int l2=MIN,l3=MIN;
        
                if(text1.charAt(index1)==text2.charAt(index2) && index2>0)  
                    current[index2] =previous[ index2-1] +1;
                       
                else{ 
                l2= previous[ index2];
                if(index2>0)
                l3= current[ index2-1];
                current[index2] = Math.max(l2,l3);
                }
                previous=current.clone();
            }
        }
        return current[N2-1];
    }
}

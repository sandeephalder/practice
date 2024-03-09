package DP2;

import java.util.Arrays;

public class LongestCommonSubstring {
    String s1= "abcjklp",s2="acjkp";
    int N1=s1.length(),N2=s2.length(),MIN=-(int)(10e6);
    public static void main(String[] args) {
        new LongestCommonSubstring();
    }

    LongestCommonSubstring(){
        int[][] dp =new int[N1][N2];
        for(int i=0;i<N1;i++) Arrays.fill(dp[i], -1);
        System.out.println(" Recursive: "+longestCommonSubstringRecursive(s1, s2,N1-1,N2-1,dp,0));
        System.out.println(" Iterative : "+longestCommonSubstringIterative(s1, s2));
        System.out.println(" Iterative Efficient: "+longestCommonSubstringIterativeEfficient(s1, s2));
    }

    public int longestCommonSubstringRecursive(String text1, String text2,int index1,int index2,int[][] dp,int max) {
        if(index1<0 || index2<0)
            return 0;
        
        if(dp[index1][index2]!=-1) return dp[index1][index2];
        
        
        if(text1.charAt(index1)==text2.charAt(index2))  {
             dp[index1][index2] = longestCommonSubstringRecursive(text1, text2, index1-1, index2-1,dp,max) +1;
             //System.out.println(text1.substring(index1,index1+1)+" ==> "+dp[index1][index2]);  
             return dp[index1][index2];
            }  
             
        else{
       
        longestCommonSubstringRecursive(text1, text2, index1-1, index2,dp,max);
       
        longestCommonSubstringRecursive(text1, text2, index1, index2-1,dp,max);
        }
       
        dp[index1][index2] = 0;
        return dp[index1][index2];
    }

    public int longestCommonSubstringIterative(String text1, String text2) {
        int[][] dp =new int[N1][N2];
        int s=0,max=MIN;
        for(int i=0;i<N2;i++) {
            if(text1.charAt(0)==text2.charAt(i)) s=1;
            dp[0][i]=s;
        }
        for(int index1=1;index1<N1;index1++){
            for(int index2=0;index2<N2;index2++){
                if(text1.charAt(index1)==text2.charAt(index2) && index2>0)  {
                     dp[index1][index2] =dp[index1-1][ index2-1] +1;
                     max = Math.max(max, dp[index1][index2]);
                }    
                else 
                dp[index1][index2] = 0;
                
            }
        }
        return max;
    }

    public int longestCommonSubstringIterativeEfficient(String text1, String text2) {
        int[] previous =new int[N2];
        int[] current =new int[N2];
        int s=0,max=MIN;
        for(int i=0;i<N2;i++) {
            if(text1.charAt(0)==text2.charAt(i)) s=1;
            current[i]=s;
        }
        for(int index1=1;index1<N1;index1++){
            for(int index2=0;index2<N2;index2++){
               
                if(text1.charAt(index1)==text2.charAt(index2) && index2>0)  {
                    current[index2] =previous[ index2-1] +1;
                    max=Math.max(current[index2] ,max);
                }
                    
                       
                else{ 
                current[index2] = 0;
                }
                
            }
            previous=current.clone();
        }
        return max;
    }
}

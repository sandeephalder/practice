import java.util.Arrays;

public class LongestCommonPalindromeSubsequence {
    LongestCommonPalindromeSubsequence(){
        String s1= "bbbcb";
        String s2= new StringBuilder(s1).reverse().toString();
        int i= s1.length()-1,j=i;
        System.out.println("Recursive :"+findLongestCommonPalindromeRecursive(s1, s2, i, j));
        int[][] dp = new int[i+1][i+1];
        for(int[] d:dp) Arrays.fill(d, -1);
        System.out.println("Recursive DP :"+findLongestCommonPalindromeRecursiveDP(s1, s2, i, j,dp));
        
        dp = new int[i+2][i+2];
        for(int[] d:dp) Arrays.fill(d, 0);
        System.out.println("Iterative DP :"+findLongestCommonPalindromeIterativeDP(s1, s2, i+1, j+1,dp));
    }

    public static void main(String[] args) {
        new LongestCommonPalindromeSubsequence();
        }

    private int findLongestCommonPalindromeRecursive(String s1,String s2,int i,int j){
        int result =0,left =0,right =0;
        if(i<0 || j<0) return 0;

        if(s1.charAt(i)==s2.charAt(j)){
            result = findLongestCommonPalindromeRecursive(s1, s2, i-1, j-1)+1 ;
        }
        else{
            left= findLongestCommonPalindromeRecursive(s1, s2, i-1, j);
            right = findLongestCommonPalindromeRecursive(s1, s2, i, j-1);
            result = Math.max(left, right);
        }
        return result;
    }

    private int findLongestCommonPalindromeRecursiveDP(String s1,String s2,int i,int j,int[][] dp){
        int result =0,left =0,right =0;
        if(i<0 || j<0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s1.charAt(i)==s2.charAt(j)){
            result = findLongestCommonPalindromeRecursiveDP(s1, s2, i-1, j-1,dp)+1 ;
        }
        else{
            left= findLongestCommonPalindromeRecursiveDP(s1, s2, i-1, j,dp);
            right = findLongestCommonPalindromeRecursiveDP(s1, s2, i, j-1,dp);
            result = Math.max(left, right);
        }
        dp[i][j] = result;
        return result;
    }

    private int findLongestCommonPalindromeIterativeDP(String s1,String s2,int I,int J,int[][] dp){
        int result =0,left =0,right =0;
        for(int i=1;i<=I;i++){
            for(int j=1;j<=J;j++){
                
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    result = dp[i-1][j-1] +1 ;
                }
                else{
                    left= dp[i-1][j];
                    right = dp[i][j-1];
                    result = Math.max(left, right);
                }
                dp[i][j] = result;
            }
        }
        
        return dp[I][J];
    }

    private void printArray(int[][] arr){
        for(int[] ar: arr){
            System.out.println();
            for(int a:ar){
                System.out.print(" ==> "+a);
            }
        }
    }
}

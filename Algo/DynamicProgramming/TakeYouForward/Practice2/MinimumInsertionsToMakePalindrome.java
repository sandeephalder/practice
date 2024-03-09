import java.util.Arrays;

public class MinimumInsertionsToMakePalindrome {
    MinimumInsertionsToMakePalindrome(){
        String s1= "aaaba";
        String s2 = new StringBuilder(s1).reverse().toString();
        int i=s1.length(),j=i;
        System.out.println(" Palindrome Recursion: "+(i-findMinimumInsertionsToMakePalindrome(s1, s2, i-1, j-1)));
        int[][] dp = new int[i+1][i+1];
        for(int[] d:dp) Arrays.fill(d, -1);
        System.out.println(" Palindrome Recursion DP: "+(i-findMinimumInsertionsToMakePalindromeDP(s1, s2, i-1, j-1,dp)));
        System.out.println(" Palindrome Iteration DP: "+(i-findMinimumInsertionsToMakePalindromeIterativeDP(s1, s2, i, j)));
        
    }
    public static void main(String[] args) {
        new MinimumInsertionsToMakePalindrome();
    }

    private int findMinimumInsertionsToMakePalindrome(String s1,String s2,int i,int j){
        int result =0;
         if(i<0 || j<0) return 0;
         
         if(s1.charAt(i)==s2.charAt(j)){
            result = 1+ findMinimumInsertionsToMakePalindrome(s1, s2, i-1, j-1);
         }
         else{
            result = Math.max(findMinimumInsertionsToMakePalindrome(s1, s2, i-1, j), findMinimumInsertionsToMakePalindrome(s1, s2, i, j-1));
         }
        return result;
    }
    private int findMinimumInsertionsToMakePalindromeDP(String s1,String s2,int i,int j,int[][] dp){
        int result =0;
         if(i<0 || j<0) return 0;
         if(dp[i][j]!=-1) return dp[i][j];
         if(s1.charAt(i)==s2.charAt(j)){
            result = 1+ findMinimumInsertionsToMakePalindromeDP(s1, s2, i-1, j-1,dp);
         }
         else{
            result = Math.max(findMinimumInsertionsToMakePalindromeDP(s1, s2, i-1, j,dp), findMinimumInsertionsToMakePalindromeDP(s1, s2, i, j-1,dp));
         }
         dp[i][j]=result;
        return result;
    }

    private int findMinimumInsertionsToMakePalindromeIterativeDP(String s1,String s2,int I,int J){
        int result =0;
        int[][] dp = new int[I+1][J+1];
        for(int i=1;i<I;i++) Arrays.fill(dp[i], -1);

        for(int i=1;i<=I;i++)
        {
            for(int j=1;j<=J;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    result = 1+ dp[i-1][j-1];
                 }
                 else{
                    result = Math.max(dp[i-1][j], dp[i][j-1]);
                 }
                 dp[i][j]=result;
            }
        }
        
        
        return  dp[I][J];
    }


    
}

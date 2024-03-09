import java.util.Arrays;

public class LongestCommonSubString {
    LongestCommonSubString(){
        String s1= "abcjkpl",s2="acjkp";
        int i= s1.length()-1,j=s2.length()-1;
        int[][] dp = new int[i+1][j+1];
        for(int[] d: dp) Arrays.fill(d, -1);
        findLongestCommonSubStringRecursive(s1, s2, i, j,dp);
        System.out.println("\nRecursive");
        printArray(dp);

        for(int[] d: dp) Arrays.fill(d, 0);
        findLongestCommonSubStringIterative(s1, s2, i, j,dp);
        System.out.println("\nIterative");
        printArray(dp);
    }

    public static void main(String[] args) {
        new LongestCommonSubString();
    }

    private int findLongestCommonSubStringRecursive(String s1,String s2,int i,int j,int[][] dp){
        if(i<0 || j<0) return 0;
        int result = 0;
        if(dp[i][j]!=-1) return dp[i][j];
        
        if(s1.charAt(i)==s2.charAt(j)) {
            
            result = 1+ findLongestCommonSubStringRecursive(s1, s2, i-1, j-1,dp);
            System.out.println(result);
        }
        else{
           findLongestCommonSubStringRecursive(s1, s2, i-1, j, dp);
           findLongestCommonSubStringRecursive(s1, s2, i, j-1, dp);
        }
        dp[i][j]=result;
        return result;
    }

    private int findLongestCommonSubStringIterative(String s1,String s2,int I,int J,int[][] dp){
        
        int result = 0;
       for(int i=0;i<=I;i++){
        for(int j=0;j<=J;j++){
            if(s1.charAt(i)==s2.charAt(j)) {
                result = 1+ ((i>0&&j>0)?dp[i-1][j-1]:0);
                dp[i][j]=result;
            }
           
        }
       }
        return result;
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

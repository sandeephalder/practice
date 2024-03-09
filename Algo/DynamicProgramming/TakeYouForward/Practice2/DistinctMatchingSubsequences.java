import java.util.Arrays;

public class DistinctMatchingSubsequences {
    static int prime = (int)(Math.pow(10,9)+7);
    public static void main(String[] args) {
        new DistinctMatchingSubsequences();
    }


    DistinctMatchingSubsequences(){
        String s="babgbag",m="bag";
        int i= s.length(),j= m.length();
        
        System.out.println(findDistinctMatchingSubsequences(s, m, i-1, j-1));
        int[][] dp = new int[i][j];
        for(int rows[]: dp)
        Arrays.fill(rows,-1);
        System.out.println(findDistinctMatchingSubsequencesDP(s, m, i-1, j-1,dp));
        for(int rows[]: dp)
        Arrays.fill(rows,0);
        System.out.println(findDistinctMatchingSubsequencesIterativeDP(s, m, i-1, j-1));

    }

    private int findDistinctMatchingSubsequences(String s,String m,int i,int j){
        int result=0;
        if(j < 0) return 1;
        if(i< 0) return 0;
        
        if(s.charAt(i)==m.charAt(j)){
            result = findDistinctMatchingSubsequences(s, m, i-1, j-1) +
            findDistinctMatchingSubsequences(s, m, i-1, j);
        }
        else{
            result = findDistinctMatchingSubsequences(s, m, i-1, j);
        }

        return result;
    }

    private int findDistinctMatchingSubsequencesDP(String s,String m,int i,int j,int[][] dp){
        int result=0;
        if(j < 0) return 1;
        if(i< 0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        
        if(s.charAt(i)==m.charAt(j)){
            result = findDistinctMatchingSubsequencesDP(s, m, i-1, j-1,dp) +
            findDistinctMatchingSubsequencesDP(s, m, i-1, j,dp);
        }
        else{
            result = findDistinctMatchingSubsequencesDP(s, m, i-1, j,dp);
        }
        dp[i][j] = result;
        return result;
    }

    private int findDistinctMatchingSubsequencesIterativeDP(String s,String m,int I,int J){
        int result=0;
        
        int[][] dp = new int[I+1][J+1];
        for(int rows[]: dp)
        Arrays.fill(rows,0);

        for(int j=0;j<=J;j++) dp[0][j]=1;
        //printArray(dp);
        for(int i=1;i<=I;i++){
            for(int j=1;j<=J;j++){
                if(s.charAt(i-1)==m.charAt(j-1)){
                    result = dp[i-1][j-1] +  dp[i-1][j];
                }
                else{
                    result = dp[i-1][j];
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
        System.out.println();
    }

}

import java.util.Arrays;

public class LongetstCommonSubsequence {
    LongetstCommonSubsequence(){
        char[] s1 = "adebc".toCharArray();
        char[] s2="dcadb".toCharArray();
        System.out.println(" findLongetstCommonSubsequenceRecursion===> "+findLongetstCommonSubsequenceRecursion(s1, s2, s1.length-1, s2.length-1));
        int[][] dp = new int[s1.length+1][s2.length+1];
        for(int i=0;i<s1.length;i++) Arrays.fill(dp[i],-1);
        System.out.println(" findLongetstCommonSubsequenceRecursionDP===> "+findLongetstCommonSubsequenceRecursionDP(s1, s2, s1.length-1, s2.length-1,dp));
        for(int i=0;i<s1.length;i++) Arrays.fill(dp[i],0);
        System.out.println(" findLongetstCommonSubsequenceIterationDP===> "+findLongetstCommonSubsequenceIterationDP(s1, s2, s1.length, s2.length,dp));
        System.out.println(" findLongetstCommonSubsequenceIteration===> "+findLongetstCommonSubsequenceIteration(s1, s2, s1.length, s2.length));
        for(int i=0;i<s1.length;i++) Arrays.fill(dp[i],0);
        System.out.println(" printLongetstCommonSubsequenceIterationDP===> "+printLongetstCommonSubsequenceIterationDP(s1, s2, s1.length, s2.length,dp));
    }
    public static void main(String[] args) {
        new LongetstCommonSubsequence();
    }

    private int findLongetstCommonSubsequenceRecursion(char[] s1,char[] s2,int x,int y){
        int result =0,left=0,right=0;

        if(x<0 || y<0) {
            return 0;
        }

        if(s1[x]==s2[y]) {
            result = findLongetstCommonSubsequenceRecursion(s1, s2, x-1, y-1) + 1;
        }
        else{
            left = findLongetstCommonSubsequenceRecursion(s1, s2, x-1, y);
            right = findLongetstCommonSubsequenceRecursion(s1, s2, x, y-1);
            result = Math.max(left, right);
        }
        return result;
    }

    private int findLongetstCommonSubsequenceRecursionDP(char[] s1,char[] s2,int x,int y,int[][] dp){
        int result =0,left=0,right=0;

        if(x<0 || y<0) {
            return 0;
        }
        if(dp[x][y]!=-1) return dp[x][y];
        if(s1[x]==s2[y]) {
            result = findLongetstCommonSubsequenceRecursionDP(s1, s2, x-1, y-1,dp) + 1;
        }
        else{
            left = findLongetstCommonSubsequenceRecursionDP(s1, s2, x-1, y,dp);
            right = findLongetstCommonSubsequenceRecursionDP(s1, s2, x, y-1,dp);
            result = Math.max(left, right);
        }
        dp[x][y] = result;
        return result;
    }

    private int findLongetstCommonSubsequenceIterationDP(char[] s1,char[] s2,int X,int Y,int[][] dp){
        int result =0;

        for(int x=1;x<=X;x++){
            for(int y=1;y<=Y;y++){
                if(s1[x-1]==s2[y-1]) {
                    result = dp[x-1][y-1] + 1;
                }
                else{
                    result = Math.max(dp[x-1][y], dp[x][y-1]);
                }
                dp[x][y] = result;
            }
        }
        return dp[X][Y];
    }

    private int findLongetstCommonSubsequenceIteration(char[] s1,char[] s2,int X,int Y){
        int result =0;
        int prev[] = new int[X+1];
        int curr [] = new int[X+1];
        Arrays.fill(prev, 0);
        for(int x=1;x<=X;x++){
            for(int y=1;y<=Y;y++){
                if(s1[x-1]==s2[y-1]) {
                    result = prev[y-1] + 1;
                }
                else{
                    result = Math.max(prev[y], curr[y-1]);
                }
                curr[y] = result;
            }
            prev = curr;
        }
        return curr[Y];
    }

    private int printLongetstCommonSubsequenceIterationDP(char[] s1,char[] s2,int X,int Y,int[][] dp){
        int result =0;

        for(int x=1;x<=X;x++){
            for(int y=1;y<=Y;y++){
                if(s1[x-1]==s2[y-1]) {
                    result = dp[x-1][y-1] + 1;
                }
                else{
                    result = Math.max(dp[x-1][y], dp[x][y-1]);
                }
                dp[x][y] = result;
            }
        }
        printArray(dp);
        int x=X-1,y=Y-1;
        System.out.println();
        while( x>0 && y>0){
            
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

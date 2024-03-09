public class MinimumpathSum {
    MinimumpathSum(){
        int[][] arr = {{5,9,6},{11,5,2}};
        System.out.println(" findMinimumpathSumRecursive ===> "+findMinimumpathSumRecursive(arr,1,2));
        int[][] dp = new int[2][3];
        for(int i=0;i<2;i++) for(int j=0;j<3;j++) dp[i][j]=-1;
        System.out.println(" findMinimumpathSumRecursiveDP ===> "+findMinimumpathSumRecursiveDP(arr,1,2,dp));
        for(int i=0;i<2;i++) for(int j=0;j<3;j++) dp[i][j]=0;
        System.out.println(" findMinimumpathSumIterativeDP ===> "+findMinimumpathSumIterativeDP(arr,2,3,dp));
    }

    public static void main(String[] args) {
        new MinimumpathSum();
    }

    private int findMinimumpathSumRecursive(int[][] arr,int x,int y){
        if(x==0 && y ==0) return arr[x][y];
        if( x< 0 || y < 0) return Integer.MAX_VALUE/2;
        int left=0,up=0;

         left = findMinimumpathSumRecursive(arr, x, y-1) + arr[x][y];
         up = findMinimumpathSumRecursive(arr, x-1, y)+ arr[x][y];

        return Math.min(left,up);
    }


    private int findMinimumpathSumRecursiveDP(int[][] arr,int x,int y,int[][] dp){
        if(x==0 && y ==0) return arr[x][y];
        if( x< 0 || y < 0) return Integer.MAX_VALUE/2;
        int left=0,up=0;
        if(dp[x][y]!=-1) return dp[x][y];
         left = findMinimumpathSumRecursiveDP(arr, x, y-1,dp) + arr[x][y];
         up = findMinimumpathSumRecursiveDP(arr, x-1, y,dp)+ arr[x][y];
        dp[x][y]=Math.min(left,up);
        return dp[x][y];
    }


    private int findMinimumpathSumIterativeDP(int[][] arr,int x,int y,int[][] dp){
        for(int i=0;i<x;i++){
            for(int j=0;j<y;j++){
                
            }
        }
        return dp[x][y];
    }
}

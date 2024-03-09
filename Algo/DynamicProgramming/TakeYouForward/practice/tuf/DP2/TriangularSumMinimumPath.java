package DP2;

import java.util.Arrays;

public class TriangularSumMinimumPath {

    int[][] triangle = {{2},{3,4},{6,5,7},{4,1,8,3}};
    int M= triangle.length,N=triangle[M-1].length,MAX= (int)10e6;
    public static void main(String[] args) {
        new TriangularSumMinimumPath();
    }

    TriangularSumMinimumPath(){
        int[][] dp = new int[M][N];
        for(int i=0;i<M;i++) Arrays.fill(dp[i], -1);
        System.out.println(" Recursive: "+minimumTotalRecursive(triangle, dp, 0, 0));
        System.out.println(" Iterative: "+minimumTotalIterative(triangle));
         System.out.println(" Iterative: "+minimumTotalIterativeOptimized(triangle));
    }

    public int minimumTotalRecursive(int[][] triangle,int[][] dp,int x,int y) {
        if(x>M-1){
            return 0;
        }
      
        if(y<0 || y>=N) return MAX;
        if(dp[x][y]!=-1) return dp[x][y];
        int d=0,r=0;

        d= minimumTotalRecursive(triangle, dp, x+1, y);
        r= minimumTotalRecursive(triangle, dp, x+1, y+1);
    
        dp[x][y]=Math.min(d,r)+triangle[x][y];

        return dp[x][y];
    }

    public int minimumTotalIterative(int[][] triangle) {

         int[][] dp = new int[M][N];
        for(int i=0;i<M;i++) Arrays.fill(dp[i], 0);
        for(int i=0;i<M;i++) dp[M-1][i]=triangle[M-1][i];
        for(int x=M-2;x>=0;x--){
            for(int y=x;y>=0;y--){
                 int d=MAX,r=MAX;
                
                    d= dp[x+1][y]+triangle[x][y];
                    r= dp[x+1][y+1]+triangle[x][y];
                 
                 
                dp[x][y]=Math.min(d,r);
            }
        }
        return dp[0][0];
    }

     public int minimumTotalIterativeOptimized(int[][] triangle) {

         int[] current = new int[M];
         int[] next = new int[M];
        Arrays.fill(current, 0);
        Arrays.fill(next, 0);
        for(int i=0;i<M;i++) next[i]=triangle[M-1][i];
        for(int x=M-2;x>=0;x--){
            for(int y=x;y>=0;y--){
                 int d=MAX,r=MAX;
                
                    d= next[y]+triangle[x][y];
                    r= next[y+1]+triangle[x][y];
                 
                 
                current[y]=Math.min(d,r);
            }
            next=current.clone();
        }
        return current[0];
    }
}

package DP2;

import java.util.Arrays;

public class MinimumPathSum {

    int[][] maze = {
        {10,8,2},
        {10,5,100},
        {1,1,2}
    };
    int M= maze.length,N=maze[0].length,MAX=Integer.MAX_VALUE;

    public static void main(String[] args) {
        new MinimumPathSum();
    }

    MinimumPathSum(){
        int[][] dp = new int[M][N];
        for(int i=0;i<M;i++) Arrays.fill(dp[i],-1);
        System.out.println(" Recursive: "+minPathSumRecursive(maze, dp, M-1, N-1));
        System.out.println(" Iterative "+minPathSumIterative(maze));
        System.out.println(" Iterative Small "+minPathSumIterativeSmall(maze));
    }

    public int minPathSumRecursive(int[][] grid,int[][] dp,int x,int y) {
        if(x==0 && y==0 ) return grid[x][y];
        if(x<0 || y <0 || x>=M || y >=N) return MAX;
        if(dp[x][y]!=-1) return dp[x][y];
        int u=0,l=0;
        
        u = minPathSumRecursive(grid, dp, x-1, y);
        
        l = minPathSumRecursive(grid, dp, x, y-1);
        dp[x][y]=Math.min(u, l)+grid[x][y];
        return dp[x][y];
    }

     public int minPathSumIterative(int[][] grid) {
         int[][] dp = new int[M][N];
        for(int i=0;i<M;i++) Arrays.fill(dp[i],0);
        
        for(int x=0;x<M;x++){
            for(int y=0;y<N;y++){
                if(x==0 && y==0 ){
                    dp[x][y]=grid[x][y];
                    continue;
                }
                int u=MAX,l=MAX;
                if(x>0)
                u = dp[x-1][y];
                if(y>0)
                l = dp[x][y-1];

                dp[x][y]=Math.min(u, l)+grid[x][y];
            }
        }

        return dp[M-1][N-1];
    }

   public int minPathSumIterativeSmall(int[][] grid) {
         int[] previous = new int[N];
         int[] current = new int[N];
        Arrays.fill(current,0);
        Arrays.fill(previous,0);

        for(int x=0;x<M;x++){
            for(int y=0;y<N;y++){
                if(x==0 && y==0 ){
                    current[y]=grid[x][y];
                    continue;
                }
                int u=MAX,l=MAX;
                if(x>0)
                u = previous[y];
                if(y>0)
                l = current[y-1];
                for(int i=0;i<N;i++) previous[i]= current[i];
                current[y]=Math.min(u, l)+grid[x][y];
            }
        }

        return current[N-1];
    }

}

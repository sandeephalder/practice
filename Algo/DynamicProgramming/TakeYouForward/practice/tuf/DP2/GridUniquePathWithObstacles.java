package DP2;

import java.util.Arrays;

public class GridUniquePathWithObstacles {

    int[][] maze = {
        {0, 0, 0,0},
        {0, -1, 0,0},
        {0, 0, 0,0}
    };

    /* int[][] maze = {
        {0, -1},
        {0, 0}
    }; */

    int N = maze.length;
    int M = maze[0].length;
    

    public static void main(String[] args) {
        new GridUniquePathWithObstacles();
    }

    GridUniquePathWithObstacles(){
        int[][] dp = new int[N][M];
        for(int i=0;i<N;i++) Arrays.fill(dp[i],-1);
        System.out.println(" Recursive: "+uniquePathsWithObstacles(maze, dp, N-1, M-1));
        System.out.println(" Iterative: "+uniquePathsWithObstaclesIterative(maze));
        System.out.println(" Iterative Efficient: "+uniquePathsWithObstaclesIterativeEasy(maze));
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid,int[][] dp,int x,int y) {
        if(x==0 && y==0) return 1;
        if(x<0 || y<0 || x>=N || y >=M) return 0;
        if(obstacleGrid[x][y]==-1) return 0;
        if(dp[x][y]!=-1) return dp[x][y];
        int u=0,l=0;
        u= uniquePathsWithObstacles(obstacleGrid, dp, x-1, y);
        l= uniquePathsWithObstacles(obstacleGrid, dp, x, y-1);
        dp[x][y]=u+l;
        return dp[x][y];
    }


    public int uniquePathsWithObstaclesIterative(int[][] obstacleGrid) {
        int[][] dp = new int[N][M];
        for(int i=0;i<N;i++) Arrays.fill(dp[i],0);
        dp[0][0]=1;
        for(int x=0;x<N;x++){
            for(int y=0;y<M;y++){
                if(x<0 || y<0 || x>=N || y >=M) continue;
                if(x==0 && y==0) continue;
                if(obstacleGrid[x][y]==-1) continue;
                int u=0,l=0;
                if(x>0)
                u= dp[x-1][y];
                if(y>0)
                l= dp[x][y-1];
                
                dp[x][y]=u+l;
            }
        }      
        return dp[N-1][M-1];
    }

    public int uniquePathsWithObstaclesIterativeEasy(int[][] obstacleGrid) {
        int[] previous = new int[M];
        int[] current = new int[M];
        Arrays.fill(current,0);
        Arrays.fill(previous,0);
        current[0]=1;
        for(int x=0;x<N;x++){
            for(int y=0;y<M;y++){
                if(x<0 || y<0 || x>=N || y >=M) continue;
                if(x==0 && y==0) continue;
                if(obstacleGrid[x][y]==-1) continue;
                int u=0,l=0;
                if(x>0)
                u= previous[y];
                if(y>0)
                l= current[y-1];
                //System.out.println(" u= "+u+" l= "+l);
                for(int i=0;i<M;i++) previous[i]=current[i];
                current[y]=u+l;
            }
        }      
        return current[M-1];
    }
}

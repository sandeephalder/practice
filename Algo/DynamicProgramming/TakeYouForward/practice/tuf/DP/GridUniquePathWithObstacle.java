package tuf.DP;

import java.util.Arrays;

public class GridUniquePathWithObstacle {
    GridUniquePathWithObstacle(){
        int[][] maze = { {0,0,0,0},
        {0,-1,0,0},
        {-1,0,0,0}};
        int X= maze.length,Y=maze[0].length;
        int[][] dp = new int[X+1][Y+1];
        for(int i=0;i<=X;i++) Arrays.fill(dp[i],-1);
        System.out.println(findGridUniquePathIterative(X-1, Y-1,maze));
        for(int i=0;i<=X;i++) Arrays.fill(dp[i],-1);
        System.out.println(findGridUniquePath(maze,X-1, Y-1, dp));
    
    }

    public static void main(String[] args) {
        new GridUniquePathWithObstacle();
    }

    private int findGridUniquePathIterative(int I, int J, int[][] maze) {
        int[][]  dp = new int[I+1][J+1];

        dp[0][0] = 1;

        for(int i=0;i<=I;i++){
            int up =0;
            int left =0;
            for(int j=0;j<=J;j++){
                if(i>0 && j>0 && maze[i][j]==-1) {
                    dp[i][j]=0;
                    continue;
                }
                if(i==0 && j==0) {
                    dp[i][j]=1;
                    continue;
                }
                if(i>0)
                up = dp[i-1][j];
                if(j>0)
                left = dp[i][j-1];
                dp[i][j] = up+left;
            }
        }
        return dp[I][J];        
      }
      

    private int findGridUniquePath(int[][] maze,int x,int y,int[][] dp){
        if( x>0 && y>0 && maze[x][y]==-1) return 0;
        if(x==0 && y==0 )  return 1;
        if(x<0 || y<0) return 0;
        if(dp[x][y]!=-1) return dp[x][y];
        int xx=0,yy=0;
        xx=findGridUniquePath(maze,x-1, y, dp);
        yy=findGridUniquePath(maze,x, y-1, dp);
        dp[x][y]=xx+yy;
        return dp[x][y];
    }

    private int findGridUniquePathIterativeEfficient(int I, int J, int[][] maze) {
        int[]  current = new int[J+1];
        int[]  previous = new int[J+1];
        Arrays.fill(current,0);
        Arrays.fill(previous, 0);
        for(int i=0;i<=I;i++){
            int up =0;
            int left =0;
            for(int j=0;j<=J;j++){
                if(i>0 && j>0 && maze[i][j]==-1) {
                    current[j]=0;
                    continue;
                }
                if(i==0 && j==0) {
                    current[j]=1;
                    continue;
                }
                if(i>0)
                up = previous[j];
                if(j>0)
                left = current[j-1];
                current[j] = up+left;
                
            }
            previous=current;
        }
        return current[J];        
      }

  
}

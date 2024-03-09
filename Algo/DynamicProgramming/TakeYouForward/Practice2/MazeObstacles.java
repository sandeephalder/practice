public class MazeObstacles {
    MazeObstacles(){
        int[][] arr = {{0,0,0},{0,-1,0},{0,0,0}};
        System.out.println(" countMazeObstaclesRecursive==> "+countMazeObstaclesRecursive(arr,2,2));
        int[][] dp = new int[3][3];
        for(int i=0;i<3;i++) for(int j=0;j<3;j++) dp[i][j]=-1;
        System.out.println(" countMazeObstaclesRecursiveDP ==> "+countMazeObstaclesRecursiveDP(arr,2,2,dp));
        for(int i=0;i<3;i++) for(int j=0;j<3;j++) dp[i][j]=0;
        System.out.println(" countMazeObstaclesIterativeDP ==> "+countMazeObstaclesIterativeDP(arr,3,3,dp));
    }

    public static void main(String[] args) {
        new MazeObstacles();
    }

     private int countMazeObstaclesRecursive(int[][] arr,int x,int y){
            if(x==0 && y==0) return 1;
            if(x<0 || y<0 || arr[x][y] ==-1) return 0;
            
            int left=0,up=0;
            left = countMazeObstaclesRecursive(arr, x, y-1);
            up = countMazeObstaclesRecursive(arr, x-1, y);

            return left+up;
     }

     private int countMazeObstaclesRecursiveDP(int[][] arr,int x,int y,int[][] dp){
        if(x==0 && y==0) return 1;
        if(x<0 || y<0 || arr[x][y] ==-1) return 0;
        if(dp[x][y] != -1) return dp[x][y];
        int left=0,up=0;
        left = countMazeObstaclesRecursiveDP(arr, x, y-1,dp);
        up = countMazeObstaclesRecursiveDP(arr, x-1, y,dp);
        dp[x][y] = left+up;
        return dp[x][y];
    }

    private int countMazeObstaclesIterativeDP(int[][] arr,int x,int y,int[][] dp){
        for(int i=0;i<x;i++) {
            
            for(int j=0;j<y;j++){
                if(i==0 && j==0) dp[i][j]=1;
                else if(arr[i][j] ==-1) dp[i][j]=0;
                else{
                    int left=0,up=0;
                    if(j>1) left = dp[i][j-1];
                    if(i>1) up = dp[i-1][j];
                    dp[i][j] = left+up;
                }
            }
        }
        return dp[x-1][y-1];
    }
}

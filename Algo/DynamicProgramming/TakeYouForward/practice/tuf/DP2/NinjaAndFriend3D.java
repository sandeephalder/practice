package DP2;

import java.util.Arrays;

public class NinjaAndFriend3D {

    /*int matrix[][] = {{2, 3, 1, 2},
                      {3, 4, 2, 2},
                      {5, 6, 3, 5}};*/

    int matrix[][] = {{1,1},
                     {1,2}};


    int M= matrix.length,N=matrix[0].length,MIN=-(int)(10e6);
    int[] dx = {-1,0,1};
    public static void main(String[] args) {
        new NinjaAndFriend3D();
    }

    NinjaAndFriend3D(){
        int[][][] dp = new int[M][N][N];
        for(int i=0;i<M;i++)
        for(int j=0;j<N;j++)
         Arrays.fill(dp[i][j], -1);
        System.out.println(" Recursion : "+findNinjaAndFriend3DRecursive(matrix,dp,0,0,N-1));
        System.out.println(" Iteration : "+findNinjaAndFriend3DIterative(matrix));
    }

    private int findNinjaAndFriend3DRecursive(int matrix[][] ,int[][][] dp,int x,int y1,int y2){
        if(x>=M){
                return 0;  
        }
        if(y1<0 || y2 <0 || y1 >=N || y2 >= N) return MIN;
        if(dp[x][y1][y2]!=-1) return dp[x][y1][y2];
        int max = MIN;
        for(int yd1:dx){
            for(int yd2:dx){
                int i = findNinjaAndFriend3DRecursive(matrix, dp, x+1, y1+yd1, y2+yd2);
                if(y1==y2) i=i+matrix[x][y1];
                else i= matrix[x][y1]+matrix[x][y2]+i;
                max = Math.max(max, i);
                dp[x][y1][y2]=max;
            }
        }
        return dp[x][y1][y2];
    }

       private int findNinjaAndFriend3DIterative(int matrix[][]){
        int[][][] dp = new int[M][N][N];
        for(int i=0;i<M;i++)
        for(int j=0;j<N;j++)
         Arrays.fill(dp[i][j], 0);

         for (int j1 = 0; j1 < N; j1++) {
            for (int j2 = 0; j2 < N; j2++) {
              if (j1 == j2)
                dp[M - 1][j1][j2] = matrix[M - 1][j1];
              else
                dp[M - 1][j1][j2] = matrix[M - 1][j1] + matrix[M - 1][j2];
            }
          }

         for(int x=0;x<M;x++){
            for(int y1=0;y1<N;y1++){
                for(int y2=0;y2<N;y2++){
                int max = MIN;
                for(int yd1:dx){
                    for(int yd2:dx){
                        if(x>=M-1|| y1+yd1<0 || y2+yd2 <0 || y1+yd1 >=N || y2+yd2 >= N) continue;
                        int i =  dp[x+1][y1+yd1][y2+yd2];
                        if(y1==y2) i+=matrix[x][y1];
                        else i += matrix[x][y1]+matrix[x][y2];
                        max = Math.max(max, i);
                        dp[x][y1][y2]=max;
            }
        }
                }
            }
         }
        return dp[0][0][N-1];
    }
}

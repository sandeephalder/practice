package DP2;

import java.util.Arrays;

public class GridUniquePath {
    int M = 3;
    int N = 2;

    public static void main(String[] args) {
        new GridUniquePath();
    }

    GridUniquePath(){
        int[][] dp = new int[M][N];
        for(int i=0;i<M;i++)
            Arrays.fill(dp[i],-1);
        System.out.println(" Recursive: "+uniquePathsRecursive(dp, M-1, N-1));
        System.out.println(" Iterative: "+uniquePathsIterative(M,N));
        System.out.println(" Iterative Lighter: "+uniquePathsIterativeLighter(M,N));
    }

    public int uniquePathsRecursive(int[][] dp,int m, int n) {
        
        if(m==0 && n==0) return 1;
        if(m<0 || m>=M || n<0 || n>=N) return 0;
        if(dp[m][n]!=-1) return dp[m][n];
        int d = uniquePathsRecursive(dp,  m-1, n);
        int r = uniquePathsRecursive(dp,  m, n-1);
        dp[m][n]=d+r;
        return dp[m][n];
    }

    public int uniquePathsIterative(int M, int N) {
        int[][] dp = new int[M][N];
        for(int i=0;i<M;i++)
            Arrays.fill(dp[i],0);
        dp[0][0]=1;
        for(int m=0;m<M;m++){
            for(int n=0;n<N;n++){
                int d=0,r=0;
                if(m<0 || m>=M || n<0 || n>=N) continue;
                if(m==0 && n==0) continue;
                if(m>0)
                d = dp[m-1][n];
                if(n>0)
                r = dp[m][n-1];
                dp[m][n]=d+r;
            }
        }
        return dp[M-1][N-1];
    }

    public int uniquePathsIterativeLighter(int M, int N) {
        int[] prev = new int[N];
        int[] current = new int[N];
        Arrays.fill(current,0);
        Arrays.fill(prev,0);
        current[0]=1;
        for(int m=0;m<M;m++){
            for(int n=0;n<N;n++){
                int d=0,r=0;
                if(m<0 || m>=M || n<0 || n>=N) continue;
                if(m==0 && n==0) continue;
                //if(m>0)
                d = prev[n];
                if(n>0)
                r = current[n-1];
                for(int i=0;i<N;i++) prev[i]=current[i];
                current[n]=d+r;
            }
        }
        return current[N-1];
    }
}

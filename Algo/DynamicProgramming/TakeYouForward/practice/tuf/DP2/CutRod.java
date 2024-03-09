package DP2;

import java.util.Arrays;

public class CutRod {
    int[] rod ={2, 5 ,7 ,8 ,10};
    //int[] rod ={3 ,5 ,8 ,9, 10, 17, 17, 20};
    int N=rod.length,MAX=5,MIN=-(int)(10e6);
    public static void main(String[] args) {
        new CutRod();
    }

    CutRod(){
        int[][] dp = new int[N][MAX+1];
        for(int i=0;i<N;i++) Arrays.fill(dp[i], -1);
        System.out.println(" Recursive: "+findCutRodValueMaxRecursive(rod, dp, N-1, MAX));
        System.out.println(" Iterative: "+findCutRodValueMaxIterative(rod));
        System.out.println(" Iterative Efficient: "+findCutRodValueMaxIterativeEfficient(rod));
    }

    private int findCutRodValueMaxRecursive(int[] rod,int[][] dp,int index,int rodlength){
       
        if(index==0){
           return rod[index]*rodlength;
        }
        
        if(dp[index][rodlength]!=-1) return dp[index][rodlength];
        int take=MIN,nontake=MIN;

        nontake = findCutRodValueMaxRecursive(rod, dp, index-1, rodlength);
        if(rodlength-index-1>=0)
        take = findCutRodValueMaxRecursive(rod, dp, index, rodlength-index-1)+rod[index];
        dp[index][rodlength]=Math.max(take,nontake);
        return dp[index][rodlength];
    }

    private int findCutRodValueMaxIterative(int[] rod){
        int[][] dp = new int[N][MAX+1];
        for(int i=0;i<=MAX;i++) dp[0][i]= rod[0]*i;
        for(int index=1;index<N;index++){
            for(int rodlength=0;rodlength<=MAX;rodlength++){
                int take=MIN,nontake=MIN;
                nontake = dp[index-1][rodlength];
                if(rodlength-index-1>=0)
                take = dp[index][rodlength-index-1]+rod[index];
                dp[index][rodlength]=Math.max(take,nontake);
            }
        }
        return dp[N-1][MAX];  
    }

    private int findCutRodValueMaxIterativeEfficient(int[] rod){
        int[] current = new int[MAX+1];
        int[] previous = new int[MAX+1];
        for(int i=0;i<=MAX;i++) previous[i]= rod[0]*i;
        for(int index=1;index<N;index++){
            for(int rodlength=0;rodlength<=MAX;rodlength++){
                int take=MIN,nontake=MIN;
                nontake = previous[rodlength];
                if(rodlength-index-1>=0)
                take = current[rodlength-index-1]+rod[index];
                current[rodlength]=Math.max(take,nontake);
            }
            previous=current.clone();
        }
        return current[MAX];  
    }
}

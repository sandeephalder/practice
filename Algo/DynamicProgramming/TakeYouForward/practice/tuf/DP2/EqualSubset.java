package DP2;

import java.util.Arrays;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class EqualSubset {

    int[] arr ={2,3,5};
    int M= arr.length,TARGET=0;
    public static void main(String[] args) {
        new EqualSubset();
    }

    EqualSubset(){
        TARGET=Arrays.stream(arr).boxed().collect(Collectors.reducing((a,b)->a+b)).get();
        int[][] dp = new int[M][TARGET+1];
        for(int i=0;i<M;i++) Arrays.fill(dp[i], -1);
        System.out.println(" recursive: "+canDevideRecursive(arr, dp, M-1, TARGET/2));
    
        System.out.println(" Iterative: "+canDevideIterative(arr));
        System.out.println(" Iterative Efficient: "+canDevideIterativeOptimized(arr));
    }

    private boolean canDevideRecursive(int[] ip, int[][] dp, int index, int sum) {
        
        if(index==M-1 && TARGET%2==1) return false;
        if(sum==0) return true;
        if(index==0) return sum==0;
        if(dp[index][sum]!=-1) return dp[index][sum]==1;
        boolean t=false,n=false;
        n = canDevideRecursive(arr, dp, index-1, sum);
        if(sum-ip[index]>=0) t= canDevideRecursive(ip, dp, index-1, sum-ip[index]);
        dp[index][sum]= n||t?1:0;
        return dp[index][sum]==1;
    }

    private boolean canDevideIterative(int[] ip) {
        if(TARGET%2==1) return false;
        int[][] dp = new int[M][TARGET+1];
        for(int i=0;i<M;i++) dp[i][0]=1;

        if(ip[0]<TARGET/2) dp[0][ip[0]]=1;

        for(int index=1;index<M;index++){
            for(int sum=1;sum<=TARGET/2;sum++){
                boolean t=false,n=false;
                n = dp[index-1][sum]==1;
                if(sum-ip[index]>=0) t= dp[index-1][sum-ip[index]]==1;
                dp[index][sum]= n||t?1:0;
            }
        }

        return dp[M-1][TARGET/2]==1;
    }

    private boolean canDevideIterativeOptimized(int[] ip) {
        if(TARGET%2==1) return false;
        boolean[] past = new boolean[TARGET/2+1];
        boolean[] current=null;
        past[0]=true;

        if(ip[0]<=TARGET/2) past[ip[0]]=true;

        for(int index=1;index<M;index++){
            current = new boolean[TARGET/2+1];
            current[0]=true;
            for(int sum=1;sum<=TARGET/2;sum++){
               
                boolean t=false,n=false;
                n = past[sum];
                if(sum-ip[index]>=0) t= past[sum-ip[index]];
                
                current[sum]= n||t;
            }

            past=current.clone();
        }
        return current[TARGET/2];
    }
}

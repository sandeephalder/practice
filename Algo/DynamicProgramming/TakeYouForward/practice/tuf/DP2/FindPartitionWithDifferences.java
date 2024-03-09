package DP2;

import java.util.Arrays;

public class FindPartitionWithDifferences {
    int[] ip = {0,0,1};
    int N=ip.length,DIFF=1,SUM = Arrays.stream(ip).boxed().reduce((a,b)->a+b).get(), TARGET= (SUM-DIFF)/2;
    public static void main(String[] args) {
        new FindPartitionWithDifferences();
    }

    FindPartitionWithDifferences(){
        int[][] dp = new int[N][TARGET+1];
        for(int i=0;i<N;i++) Arrays.fill(dp[i], -1);
        System.out.println(" Recursion: "+countPartitions(ip, dp, N-1, TARGET));
        System.out.println(" Iteration: "+countPartitionsIterative(ip));
        System.out.println(" Iteration Efficient: "+countPartitionsIterativeEfficient(ip));
    }

    public int countPartitions(int[] arr,int[][] dp,int index,int sum) {
        if(index==0)
            {      
            if(sum==0 && arr[0]==0)
                return 2;
            if(sum==0 || sum == arr[0])
                return 1;
            return 0;
        }
        if(dp[index][sum]!=-1) return dp[index][sum];
        int take=0,nontake=0;
        if(sum-arr[index]>=0)
        take = countPartitions(arr, dp, index-1, sum-arr[index]);
        nontake = countPartitions(arr, dp, index-1, sum);
        dp[index][sum]= take+nontake;
        return dp[index][sum];
	}

     public int countPartitionsIterative(int[] arr) {
        int[][] dp = new int[N][TARGET+1];
        for(int i=0;i<N;i++) Arrays.fill(dp[i], 0);
        for(int i=0;i<N;i++) dp[i][0]=1;
        if(arr[0]<=TARGET) dp[0][arr[0]]=1;
        if(arr[0]==0) dp[0][arr[0]]=2;
        for(int index=1;index<N;index++){
            for(int sum=0;sum<=TARGET;sum++){
                int take=0,nontake=0;
                if(sum-arr[index]>=0)
                take = dp[index-1][sum-arr[index]];
                nontake = dp[index-1][sum];
                dp[index][sum]= take+nontake;
            }
        }
        return dp[N-1][TARGET];
	}

    public int countPartitionsIterativeEfficient(int[] arr) {
        int[] current = new int[TARGET+1];
        int[] previous = new int[TARGET+1];
        Arrays.fill(previous, 0);
        previous[0]=1;
        if(arr[0]<=TARGET) previous[arr[0]]=1;
        if(arr[0]==0) previous[arr[0]]=2;
        for(int index=1;index<N;index++){
            for(int sum=0;sum<=TARGET;sum++){
                int take=0,nontake=0;
                if(sum-arr[index]>=0)
                take = previous[sum-arr[index]];
                nontake = previous[sum];
                current[sum]= take+nontake;
            }
            previous=current.clone();
        }
        return current[TARGET];
	}
}

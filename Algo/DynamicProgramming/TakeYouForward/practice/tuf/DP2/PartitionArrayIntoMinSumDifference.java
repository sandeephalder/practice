package DP2;

import java.util.Arrays;

public class PartitionArrayIntoMinSumDifference {
    int[] arr ={1,2,3,4};
    int M= arr.length,SUM=Arrays.stream(arr).map(Math::abs).reduce((a,b)->a+b).getAsInt(),TARGET=SUM,MAX=(int)(10e5);
    public static void main(String[] args) {
        new PartitionArrayIntoMinSumDifference();
    }

    PartitionArrayIntoMinSumDifference(){
        System.out.println("Recursive: "+minimumDifferenceRecursive(arr));
        System.out.println("Iterative: "+minimumDifferenceIterative(arr));
        System.out.println("Iterative Efficient: "+minimumDifferenceIterativeEfficient(arr));
    }

    public int minimumDifferenceRecursive(int[] nums) {
        int[][] dp = new int[M][SUM+1];
        for(int i=0;i<M;i++) Arrays.fill(dp[i],-1);
        int result= minimumDifferenceRecursive(nums, dp,M-1,TARGET,MAX);
        return result;
    }

    public int minimumDifferenceRecursive(int[] nums,int[][] dp,int index,int sum,int min) {
        
        if(index<0) return min;
        

         int current = TARGET-Math.abs(sum);
         current = sum - Math.abs(current);
         if(TARGET==Math.abs(sum))
         current=MAX;
         //System.out.println(sum+" ==sum current== "+current);
        if(Math.abs(current)<min) min = Math.abs(current);
       
        if(dp[index][sum]!=-1) return dp[index][sum];
        int take=MAX,nontake=MAX;
        if(sum-nums[index]>=0)
        take = minimumDifferenceRecursive(nums, dp, index-1, sum-nums[index], min);
        nontake = minimumDifferenceRecursive(nums, dp, index-1, sum, min);
        dp[index][sum]= Math.min(take,nontake);
        return dp[index][sum];
    }

    public int minimumDifferenceIterative(int[] nums) {
        boolean[][] dp = new boolean[M][SUM+1];
        for(int i=0;i<M;i++) dp[i][0]=true;
        if(nums[0]<SUM) dp[0][nums[0]]=true;
        for(int index=1;index<M;index++){
            for(int sum=0;sum<=SUM;sum++){
                boolean take=false,nontake=false;
                if(sum-nums[index]>=0)
                take = dp[index-1][sum-nums[index]];
                nontake = dp[index-1][sum];
                dp[index][sum]= take||nontake;
            }
        }
        int min=MAX;
        for(int sum=1;sum<SUM;sum++){
          if(dp[M-1][sum]){
            int t= TARGET-sum;
            t = Math.abs(sum-t);
            //System.out.println(sum+" ==sum current== "+t);
            if(min>t) min=t;
          }
        }
        return min;
    }

    public int minimumDifferenceIterativeEfficient(int[] nums) {
        boolean[] current = new boolean[SUM+1];
        boolean[] previous = new boolean[SUM+1];
        previous[0]=true;
        if(nums[0]<SUM) previous[nums[0]]=true;
        for(int index=1;index<M;index++){
            for(int sum=0;sum<=SUM;sum++){
                boolean take=false,nontake=false;
                if(sum-nums[index]>=0)
                take = previous[sum-nums[index]];
                nontake = previous[sum];
                current[sum]= take||nontake;
            }
            previous= current.clone();
        }
        int min=MAX;
        for(int sum=1;sum<SUM;sum++){
          if(current[sum]){
            int t= TARGET-sum;
            t = Math.abs(sum-t);
            //System.out.println(sum+" ==sum current== "+t);
            if(min>t) min=t;
          }
        }
        return min;
    }
}

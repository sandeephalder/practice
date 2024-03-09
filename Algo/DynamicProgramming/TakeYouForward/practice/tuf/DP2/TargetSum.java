package DP2;

import java.util.Arrays;

public class TargetSum {
    int[] numbers = {1,2,3,2,1};
    int TARGET =3,N=numbers.length;
    public static void main(String[] args) {
        new TargetSum();
    }

    TargetSum(){
        int[][] dp = new int[N][TARGET+1];
        for(int i=0;i<N;i++) Arrays.fill(dp[i], -1);
        System.out.println(" Recursive: "+findTargetSumWaysRecursive(numbers, dp, TARGET, N-1));
        System.out.println(" Iterative: "+findTargetSumWaysIterative(numbers));
        System.out.println(" Iterative Efficient: "+findTargetSumWaysIterativeEfficient(numbers));
        
    }

    public int findTargetSumWaysRecursive(int[] nums,int[][] dp,int sum,int index) {
    
        if(index==0){
            if(sum==0 && nums[0]==0) return 2;
            if(sum==0 || sum ==nums[0]) return 1;
            return 0;
        }
        if(dp[index][sum]!=-1) return dp[index][sum];
        int plus=0,minus=0;
        plus  = findTargetSumWaysRecursive(nums, dp, sum , index-1);
        if(sum - nums[index]>=0)
        minus  = findTargetSumWaysRecursive(nums, dp, sum - nums[index] , index-1); 
        //System.out.println("Plus: "+plus+" minus= "+minus); 
        dp[index][sum] = plus+minus;
        return dp[index][sum];
    }

    public int findTargetSumWaysIterative(int[] nums) {
        int[][] dp = new int[N][TARGET+1];
        dp[0][0]=1;
        if(nums[0]!=0&&nums[0]<TARGET) dp[0][nums[0]]=1;
        if(nums[0]==0) dp[0][0]=2;
        for(int index=1;index<N;index++){
            for(int sum=0;sum<=TARGET;sum++){
                int plus=0,minus=0;
                plus  = dp[index-1][sum];
                if(sum - nums[index]>=0)
                minus  = dp[index-1][sum - nums[index]]; 
                //System.out.println("Plus: "+plus+" minus= "+minus); 
                dp[index][sum] = plus+minus;
            }
        }
        return dp[N-1][TARGET];
    }

    public int findTargetSumWaysIterativeEfficient(int[] nums) {
        int[] current = new int[TARGET+1];
        int[] previous = new int[TARGET+1];
        previous[0]=1;
        if(nums[0]!=0&&nums[0]<TARGET) previous[nums[0]]=1;
        if(nums[0]==0) previous[0]=2;
        for(int index=1;index<N;index++){
            for(int sum=0;sum<=TARGET;sum++){
                int plus=0,minus=0;
                plus  = previous[sum];
                if(sum - nums[index]>=0)
                minus  = previous[sum - nums[index]]; 
                //System.out.println("Plus: "+plus+" minus= "+minus); 
                current[sum] = plus+minus;
            }
            previous=current.clone();
        }
        return current[TARGET];
    }
}

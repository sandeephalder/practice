import java.util.Arrays;

public class MinCoinInfiniteSupply {
    MinCoinInfiniteSupply(){
        int[] coins = {1,2,3};
        int target =7;
        System.out.println(" findMinCoinInfiniteSupplyrecursive==> "+findMinCoinInfiniteSupplyrecursive(coins, target, 0));
        int[][] dp = new int[target+1][target+1];
        for(int i=0;i<target+1;i++) Arrays.fill(dp[i], -1);
        System.out.println(" findMinCoinInfiniteSupplyrecursiveDP==> "+findMinCoinInfiniteSupplyrecursiveDP(coins, target, 0,dp));
        
        System.out.println(" findMinCoinInfiniteSupplyIterativeDP==> "+findMinCoinInfiniteSupplyIterativeDP(coins, target));
    }

    public static void main(String[] args) {
        new MinCoinInfiniteSupply();
    }

    private int findMinCoinInfiniteSupplyrecursive(int[] coins,int target,int sum){
        if(target <0) return Integer.MAX_VALUE/2;
        if(target ==0) return sum;
        int min = Integer.MAX_VALUE/2;
        for(int i=0;i<coins.length;i++){
            int take = Integer.MAX_VALUE/2;
            if(target-coins[i] >=0) take = findMinCoinInfiniteSupplyrecursive(coins, target-coins[i], sum+1);
            
            min = Math.min(min, take);
        }
        return min;
    }

    private int findMinCoinInfiniteSupplyrecursiveDP(int[] coins,int target,int sum,int[][] dp){
        if(target <0) return Integer.MAX_VALUE/2;
        if(target ==0) return sum;
        if(dp[sum][target]!=-1) return dp[sum][target];
        int min = Integer.MAX_VALUE/2;
        for(int i=0;i<coins.length;i++){
            int take = Integer.MAX_VALUE/2;
            if(target-coins[i] >=0) take = findMinCoinInfiniteSupplyrecursiveDP(coins, target-coins[i], sum+1,dp);
            
            min = Math.min(min, take);
        }
        dp[sum][sum]=min;
        return min;
    }

    private int findMinCoinInfiniteSupplyIterativeDP(int[] arr,int T){
        int n= arr.length;
    
        int dp[][]=new int[n][T+1];
        
        for(int i=0; i<=T; i++){
            if(i%arr[0] == 0)  
                dp[0][i] = i/arr[0];
            else dp[0][i] = (int)Math.pow(10,9);
        }
        
        for(int ind = 1; ind<n; ind++){
            for(int target = 0; target<=T; target++){
                
                int notTake = 0 + dp[ind-1][target];
                int take = (int)Math.pow(10,9);
                if(arr[ind]<=target)
                    take = 1 + dp[ind][target - arr[ind]];
                    
                 dp[ind][target] = Math.min(notTake, take);
            }
        }
        
        int ans = dp[n-1][T];
        if(ans >=(int)Math.pow(10,9)) return -1;
        return ans;
    }
}

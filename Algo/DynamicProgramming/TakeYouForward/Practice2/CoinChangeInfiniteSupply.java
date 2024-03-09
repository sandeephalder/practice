import java.util.*;

public class CoinChangeInfiniteSupply {
    CoinChangeInfiniteSupply(){
        int[] coin = {1,2,3};
        int target = 4;
        System.out.println(" findCoinChangeInfiniteSupplyRecursion==> "+findCoinChangeInfiniteSupplyRecursion(coin,target,coin.length-1));

        int[][] dp = new int[coin.length][target+1];
        for(int i=0;i<coin.length;i++) Arrays.fill(dp[i],-1);
        System.out.println(" findCoinChangeInfiniteSupplyRecursionDP==> "+findCoinChangeInfiniteSupplyRecursionDP(coin,target,coin.length-1,dp));

        for(int i=0;i<coin.length;i++) Arrays.fill(dp[i],0);
        System.out.println(" findCoinChangeInfiniteSupplyIterationDP==> "+findCoinChangeInfiniteSupplyIterationDP(coin,target,coin.length-1,dp));

        System.out.println(" findCoinChangeInfiniteSupplyIteration==> "+findCoinChangeInfiniteSupplyIteration(coin,target,coin.length-1));
    }

    public static void main(String[] args) {
        new CoinChangeInfiniteSupply();
    }

    private int findCoinChangeInfiniteSupplyRecursion(int coin[],int target,int n){
        if(n==0) {
            if(target%coin[n]==0 || target ==0) return 1;
            
            return 0;
        }

        int notTaken = findCoinChangeInfiniteSupplyRecursion(coin,target,n-1);
        
        int taken = 0;
        if(coin[n]<=target)
            taken = findCoinChangeInfiniteSupplyRecursion(coin,target-coin[n],n);
            
        return notTaken + taken;
    }

    private int findCoinChangeInfiniteSupplyRecursionDP(int coin[],int target,int n,int[][] dp){
        if(n==0) {
            if(target%coin[n]==0 || target ==0) return 1;
            
            return 0;
        }
        if(dp[n][target]!=-1) return dp[n][target];

        int notTaken = findCoinChangeInfiniteSupplyRecursion(coin,target,n-1);
        
        int taken = 0;
        if(coin[n]<=target)
            taken = findCoinChangeInfiniteSupplyRecursion(coin,target-coin[n],n);
        dp[n][target] = notTaken + taken;
        return notTaken + taken;
    }

    private int findCoinChangeInfiniteSupplyIterationDP(int coin[],int target,int n,int[][] dp){
       
        for(int i=0;i<=target;i++) dp[0][i]= target%coin[0]==0?1:0;
        

        for(int i=1;i<=n;i++){
            for(int t=0;t<=target;t++){
                int notTaken = dp[i-1][t];
                int taken = 0;
                if(coin[i]<=t)
                    taken = dp[i][t-coin[i]];
                dp[i][t] = notTaken + taken;
            }
        }
        
        return dp[n][target];
    }

    private int findCoinChangeInfiniteSupplyIteration(int coin[],int target,int n){
        int prev[] = new int[target+1];
        int curr[] = new int[target+1];
        Arrays.fill(prev,0);
        Arrays.fill(curr,0);
        for(int i=0;i<=target;i++) prev[i]= target%coin[0]==0?1:0;

        for(int i=1;i<=n;i++){
            for(int t=0;t<=target;t++){
                int notTaken = prev[t];
                int taken = 0;
                if(coin[i]<=t)
                    taken = curr[t-coin[i]];
                curr[t] = notTaken + taken;
            }
            prev=curr;
        }
        
        return prev[target];
    }
}

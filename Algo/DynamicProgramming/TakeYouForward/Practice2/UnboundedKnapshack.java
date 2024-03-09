import java.util.Arrays;

public class UnboundedKnapshack {
    UnboundedKnapshack(){
        int[] weight = {2,4,6};
        int[] value = {5,11,13};
        int target =10;
        System.out.println(" findUnboundedKnapshackRecursive==> "+findUnboundedKnapshackRecursive(weight, value, target, weight.length-1));
        int[][] dp = new int[weight.length][target+1];
        for(int i=0;i<weight.length;i++) Arrays.fill(dp[i], -1);
        System.out.println(" findUnboundedKnapshackRecursiveDP==> "+findUnboundedKnapshackRecursiveDP(weight, value, target, weight.length-1,dp));
        for(int i=0;i<weight.length;i++) Arrays.fill(dp[i], 0);
        System.out.println(" findUnboundedKnapshackIterationDP==> "+findUnboundedKnapshackIterationDP(weight, value, target, weight.length-1,dp));

        System.out.println(" findUnboundedKnapshackIteration==> "+findUnboundedKnapshackIteration(weight, value, target, weight.length-1));
    }

    public static void main(String[] args) {
        new UnboundedKnapshack();
    }

    private int findUnboundedKnapshackRecursive(int[] wt,int[] val,int target,int n){
        if(n==0){
            return val[n]*(target/wt[0]);
            
        }
        if(target==0) return 0;

        int take=Integer.MIN_VALUE,nontake=Integer.MIN_VALUE;

        nontake = findUnboundedKnapshackRecursive(wt, val, target, n-1);
        if(target>=wt[n])
        take = findUnboundedKnapshackRecursive(wt, val, target-wt[n], n)+ val[n];

        return Math.max(take,nontake);
    }

    private int findUnboundedKnapshackRecursiveDP(int[] wt,int[] val,int target,int n,int[][] dp){
        if(n==0){
            return val[n]*(target/wt[0]);
            
        }
        if(target==0) return 0;
        if(dp[n][target]!=-1) return dp[n][target];
        int take=Integer.MIN_VALUE,nontake=Integer.MIN_VALUE;

        nontake = findUnboundedKnapshackRecursiveDP(wt, val, target, n-1,dp);
        if(target>=wt[n])
        take = findUnboundedKnapshackRecursiveDP(wt, val, target-wt[n], n,dp)+ val[n];
        dp[n][target] = Math.max(take,nontake);
        return Math.max(take,nontake);
    }

    private int findUnboundedKnapshackIterationDP(int[] wt,int[] val,int target,int n,int[][] dp){
        for(int i=0;i<=target;i++) dp[0][i]=val[0]*(i/wt[0]);
        for(int i=1;i<=n;i++){
            for(int t=0;t<=target;t++){
                int take=Integer.MIN_VALUE/2,nontake=Integer.MIN_VALUE/2;

                nontake = dp[i-1][t];
                if(t>=wt[i])
                take = dp[i][t-wt[i]]+ val[i];
                dp[i][t] = Math.max(take,nontake);
            }
        }
        return dp[n][target];
    }

    private int findUnboundedKnapshackIteration(int[] wt,int[] val,int target,int n){
        int[] prev = new int[target+1];
        int[] curr = new int[target+1];
        for(int i=0;i<=target;i++) prev[i]=val[0]*(i/wt[0]);
        for(int i=1;i<=n;i++){
            for(int t=0;t<=target;t++){
                int take=Integer.MIN_VALUE/2,nontake=Integer.MIN_VALUE/2;

                nontake = prev[t];
                if(t>=wt[i])
                take = curr[t-wt[i]]+ val[i];
                curr[t] = Math.max(take,nontake);
            }
            prev = curr;
        }
        return curr[target];
    }
}

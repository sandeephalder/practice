import java.util.Arrays;

public class RodCutting {
    RodCutting(){
        int price[] = {2,5,7,8,10};
        int target =5;
        int n= price.length;
        System.out.println(" findRodCuttingRecursion==> "+findRodCuttingRecursion(price,target));
        int dp[][] = new int[price.length][target+1];
        for(int i=0;i<price.length;i++) Arrays.fill(dp[i],-1);
        System.out.println(" findRodCuttingRecursionDP==> "+findRodCuttingRecursionDP(price,n-1,target,dp));
        for(int i=0;i<price.length;i++) Arrays.fill(dp[i],0);
        System.out.println(" findRodCuttingIterativeDP==> "+findRodCuttingIterativeDP(price,n-1,target,dp));

        System.out.println(" findRodCuttingIterative==> "+findRodCuttingIterative(price,n-1,target));
    }

    public static void main(String[] args) {
        new RodCutting();
    }

    private int findRodCuttingRecursion(int[] price,int target){
       
        if(target==0) return 0;

         int max= Integer.MIN_VALUE/2,result=0;
         for(int i=0;i<price.length;i++){
            if(target>=i+1) result = findRodCuttingRecursion(price, target-i-1)+ price[i];
            max = Math.max(max, result);
         }
        return max;
    }

    private int findRodCuttingRecursionDP(int[] price,int n,int target,int[][] dp){
       
        if(n==0) return target*price[n];
        if(dp[n][target]!=-1) return dp[n][target];

         int take= Integer.MIN_VALUE/2,nontake= Integer.MIN_VALUE/2,rodLength = n+1;
         nontake = findRodCuttingRecursionDP(price, n-1, target, dp);
         if(target>=rodLength) take = price[n]+findRodCuttingRecursionDP(price, n, target-rodLength, dp);
         dp[n][target] = Math.max(take, nontake);
        return dp[n][target];
    }

    private int findRodCuttingIterativeDP(int[] price,int N,int T,int[][] dp){
       
        for(int i=0;i<=T;i++) dp[0][i]= i*price[0];

        for(int n=1;n<price.length;n++){
            for(int target=0;target<=T;target++){
                int take= Integer.MIN_VALUE/2,nontake= Integer.MIN_VALUE/2,rodLength = n+1;
                nontake = dp[n-1][target];
                if(target>=rodLength) take = price[n]+ dp[n][target-rodLength];
                dp[n][target] = Math.max(take, nontake);
            }
        }
        return dp[N][T];
    }

    private int findRodCuttingIterative(int[] price,int N,int T){
        int[] prev = new int[T+1];
        int[] curr = new int[T+1];

        for(int i=0;i<=T;i++) prev[i]= i*price[0];

        for(int n=1;n<price.length;n++){
            for(int target=0;target<=T;target++){
                int take= Integer.MIN_VALUE/2,nontake= Integer.MIN_VALUE/2,rodLength = n+1;
                nontake = prev[target];
                if(target>=rodLength) take = price[n]+ curr[target-rodLength];
                curr[target] = Math.max(take, nontake);
            }
            prev = curr;
        }
        return curr[T];
    }
}

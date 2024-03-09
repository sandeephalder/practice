import java.util.Arrays;

public class CountSubsetsWithSum {
    CountSubsetsWithSum(){
        int[] arr = {1,2,3,35};
        int k=3;
        int[][] dp = new int[arr.length][k+1];
        
        System.out.println(" countSubsetsWithSum==> "+countSubsetsWithSum(arr,k,arr.length-1));
        for(int i =0;i<arr.length;i++) Arrays.fill(dp[i], -1); 
        System.out.println(" countSubsetsWithSumDP==> "+countSubsetsWithSumDP(arr,k,arr.length-1,dp));

        for(int i =0;i<arr.length;i++) Arrays.fill(dp[i], 0); 
        System.out.println(" countSubsetsWithSumIterationDP==> "+countSubsetsWithSumIterationDP(arr,k,arr.length-1,dp));
    }

    public static void main(String[] args) {
        new CountSubsetsWithSum();
    }

    private int countSubsetsWithSum(int[] arr,int target,int n){
        if(n==0) if(arr[n]==target) return 1; else return 0;
        if(target==0) return 1;

        int take =0,nontake =0;

        nontake = countSubsetsWithSum(arr, target, n-1);
        if(target>=arr[n]) take = countSubsetsWithSum(arr, target-arr[n], n-1);
        

        return take+nontake;
    }

    private int countSubsetsWithSumDP(int[] arr,int target,int n,int[][] dp){
        if(n==0) if(arr[n]==target) return 1; else return 0;
        if(target==0) return 1;
        if(dp[n][target]!=-1) return dp[n][target+1];
        int take =0,nontake =0;

        nontake = countSubsetsWithSum(arr, target, n-1);
        if(target>=arr[n]) take = countSubsetsWithSum(arr, target-arr[n], n-1);
        
        dp[n][target] = take+nontake;
        return dp[n][target] ;
    }

    private int countSubsetsWithSumIterationDP(int[] arr,int target,int n,int[][] dp){
        for(int i=0;i<arr.length;i++) dp[i][0] = 1;
        if(arr[0]==0) dp[0][0] =2;
        else dp[0][0]=1;

        if(arr[0]!=0 && arr[0]<=target)
        dp[0][arr[0]] = 1;

         for(int i=1;i<=n;i++){
            
            for(int j=1;j<=target;j++){
                int take =0,nontake =0;
                nontake = dp[i-1][j]; 
                if(j>=arr[i]) take = dp[i-1][j-arr[i]];
                dp[i][j] = take+nontake;
            }
         }
        return dp[n][target] ;
    }
 }

import java.util.Arrays;

public class TargetSumPositiveNegetive {
    
    TargetSumPositiveNegetive(){
        int[] arr = {1,2,3,1};
        int target =3,total =0;
        for(int i:arr) total +=i;
        if(total-target <=0 || (total-target)%2==1) {
            System.out.println("Not possible");
            return;
        }
        target = (total-target)/2;
        System.out.println(" findTargetSumPositiveNegetive==> "+findTargetSumPositiveNegetive(arr,target,arr.length-1));
        int[][] dp = new int[arr.length][target+1];
        for(int i=0;i<arr.length;i++) Arrays.fill(dp[i], -1);
        System.out.println(" findTargetSumPositiveNegetiveDP==> "+findTargetSumPositiveNegetiveDP(arr,target,arr.length-1,dp));
        for(int i=0;i<arr.length;i++) Arrays.fill(dp[i], 0);
        System.out.println(" findTargetSumPositiveNegetiveIterativeDP==> "+findTargetSumPositiveNegetiveIterativeDP(arr,target,arr.length-1,dp));
    }

    public static void main(String[] args) {
        new TargetSumPositiveNegetive();
    }

    private int findTargetSumPositiveNegetive(int[] coins,int target,int n){
        if(n==0) {
            if(coins[n]==target) return 1;
            else return 0;
        }
        if(target==0) return 1;

        int take = 0,nontake=0; 
        if(target>=coins[n]) take = findTargetSumPositiveNegetive(coins, target-coins[n], n-1);
        nontake = findTargetSumPositiveNegetive(coins, target, n-1);
        return take+nontake;
    }

    private int findTargetSumPositiveNegetiveDP(int[] arr,int target,int n,int[][] dp){
        if(n == 0){
            if(target==0 && arr[0]==0)
                return 2;
            if(target==0 || target == arr[0])
                return 1;
            return 0;
        }
        
        if(dp[n][target]!=-1)
            return dp[n][target];
            
        int notTaken = findTargetSumPositiveNegetiveDP(arr,target,n-1,dp);
        
        int taken = 0;
        if(arr[n]<=target)
            taken = findTargetSumPositiveNegetiveDP(arr,target-arr[n],n-1,dp);
            
        return dp[n][target]= (notTaken + taken);
    }

    private int findTargetSumPositiveNegetiveIterativeDP(int[] num,int tar,int n,int[][] dp){
        int mod =(int)(Math.pow(10,9)+7);
        if(num[0] == 0) dp[0][0] =2;  // 2 cases -pick and not pick
    else dp[0][0] = 1;  // 1 case - not pick
    
    if(num[0]!=0 && num[0]<=tar) dp[0][num[0]] = 1;  // 1 case -pick
    
    for(int ind = 1; ind<n; ind++){
        for(int target= 0; target<=tar; target++){
            
            int notTaken = dp[ind-1][target];
    
            int taken = 0;
                if(num[ind]<=target)
                    taken = dp[ind-1][target-num[ind]];
        
            dp[ind][target]= (notTaken + taken)%mod;
        }
    }
    return dp[n-1][tar];
    }


}


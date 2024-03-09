public class EqualSubsetSum {
    EqualSubsetSum(){
        int[] arr = {1,2,1,5,1};
        int k=0;
        for(int i:arr) k+=i;
        k/=2;
        System.out.println(" isEqualSubsetSumRecursive==> "+isEqualSubsetSumRecursive(arr, arr.length-1, k));
        int[][] dp = new int[arr.length][k+1];
        for(int i=0;i<arr.length;i++) for(int j=0;j<k+1;j++) dp[i][j]=-1;
        System.out.println(" isEqualSubsetSumRecursiveDP==> "+isEqualSubsetSumRecursiveDP(arr, arr.length-1, k,dp));
        for(int i=0;i<arr.length;i++) for(int j=0;j<k+1;j++) dp[i][j]=0;
        System.out.println(" isEqualSubsetSumIterativeDP==> "+isEqualSubsetSumIterativeDP(arr, arr.length-1, k,dp));
    }

    public static void main(String[] args) {
        new EqualSubsetSum();
    }

    private boolean isEqualSubsetSumRecursive(int[] arr,int n,int target){
        if(target ==0) return true;
        if(n==0) return arr[n]==target;

        boolean take=false,nontake=false;

        nontake = isEqualSubsetSumRecursive(arr, n-1, target);
        if(target >= arr[n]) take = isEqualSubsetSumRecursive(arr, n-1, target-arr[n]);
        return take || nontake;
    }

    private boolean isEqualSubsetSumRecursiveDP(int[] arr,int n,int target,int[][] dp){
        if(target ==0) return true;
        if(n==0) return arr[n]==target;
        if(dp[n][target]!=-1) return dp[n][target]==1;
        boolean take=false,nontake=false;

        nontake = isEqualSubsetSumRecursiveDP(arr, n-1, target,dp);
        if(target >= arr[n]) take = isEqualSubsetSumRecursiveDP(arr, n-1, target-arr[n],dp);
        dp[n][target] = (take || nontake)?1:0;
        return dp[n][target]==1;
    }

    private boolean isEqualSubsetSumIterativeDP(int[] arr,int n,int target,int[][] dp){
        
        for(int i=0;i<arr.length;i++) dp[i][0]= 1;
        int N= arr.length-1;
        for(int i=1;i<n;i++){
            for(int j=1;j<target;j++){
                boolean take=false,nontake=false;

                nontake = dp[n-1][target]==1;
                if(target >= arr[n]) take = dp[n-1][target-arr[n]]==1;
                dp[n][target] = (take || nontake)?1:0;
            }
        }
        return dp[arr.length-1][0]==1;
    }
}

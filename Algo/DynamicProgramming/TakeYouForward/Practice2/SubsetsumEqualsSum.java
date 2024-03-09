public class SubsetsumEqualsSum {
     
    SubsetsumEqualsSum(){
        int[] arr = {1,2,3,4};
        int k=9;
        int[][] dp = new int[arr.length][k+1];
        
        System.out.println(" findSubsetsumEqualsSumRecursion==> "+findSubsetsumEqualsSumRecursion(arr,k,arr.length-1));
        for(int i=0;i<dp.length;i++) for(int j=0;j<=k;j++) dp[i][j]=-1;
        System.out.println(" findSubsetsumEqualsSumRecursionDP ==> "+findSubsetsumEqualsSumRecursionDP(arr,k,arr.length-1,dp));
        for(int i=0;i<dp.length;i++) for(int j=0;j<=k;j++) dp[i][j]=0;
        System.out.println(" findSubsetsumEqualsSumIterationDP ==> "+findSubsetsumEqualsSumIterationDP(arr,k,dp));
    }

    public static void main(String[] args) {
        new SubsetsumEqualsSum();
    }

    private boolean findSubsetsumEqualsSumRecursion(int[] arr,int k,int n){

        if(k==0) return true;
        if(n==0) return k==arr[n];

        boolean take=false,nontake=false;

        if(k >= arr[n]) take = findSubsetsumEqualsSumRecursion(arr, k-arr[n], n-1);
        nontake = findSubsetsumEqualsSumRecursion(arr, k, n-1);

        return take | nontake;
    }

    private boolean findSubsetsumEqualsSumRecursionDP(int[] arr,int k,int n,int[][] dp){

        if(k==0) return true;
        if(n==0) return k==arr[n];
        if(dp[n][k]!=-1) return dp[n][k]==1;
        boolean take=false,nontake=false;
        nontake = findSubsetsumEqualsSumRecursionDP(arr, k, n-1,dp);
        if(k >= arr[n]) take = findSubsetsumEqualsSumRecursionDP(arr, k-arr[n], n-1,dp);
        
        dp[n][k] = (take || nontake)==true?1:0;
        return take || nontake;
    }

    private boolean findSubsetsumEqualsSumIterationDP(int[] arr,int K,int[][] dp){
        for(int i=0;i<arr.length;i++) dp[i][0]= 1;
        int N = arr.length-1;
        for(int n=1;n<N;n++){
            for(int k=1;k<=K;k++){
                boolean take=false,nontake=false;
                nontake = dp[n-1][k]==1;
                if(k >= arr[n])
                    take = dp[n-1][k-arr[n]]==1;
                
                dp[n][k] = (take || nontake)==true?1:0;
            }
        }
        return dp[N][0]==1;
    }
}

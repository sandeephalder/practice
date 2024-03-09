import java.util.Arrays;

public class CountpartitionsWithGivenDifference {
    CountpartitionsWithGivenDifference(){
        int[] arr = {1,2,6,4};
        int k=3,total=0;
        
        for(int i:arr) total+=i;
        if((total-k)<=0 || (total-k)%2!=0) {
            System.out.println("Not Possible");
            return;
        }
        k= (total-k)/2;
        int[][] dp = new int[arr.length][k+1];
        System.out.println(" findCountpartitionsWithGivenDifferenceRecursion ==> "+findCountpartitionsWithGivenDifferenceRecursion(arr,k,arr.length-1));
        for(int[] i:dp) Arrays.fill(i, -1);
        System.out.println(" findCountpartitionsWithGivenDifferenceRecursionDP ==> "+findCountpartitionsWithGivenDifferenceRecursionDP(arr,k,arr.length-1,dp));
        for(int[] i:dp) Arrays.fill(i, 0);
        System.out.println(" findCountpartitionsWithGivenDifferenceIteratioDP ==> "+findCountpartitionsWithGivenDifferenceIteratioDP(arr,k,arr.length-1,dp));
    }

    public static void main(String[] args) {
        new CountpartitionsWithGivenDifference();
    }

    private int findCountpartitionsWithGivenDifferenceRecursion(int[] arr,int target,int n){
        if(n==0) if(arr[n]==target) return 1; else return 0;
        if(target==0) return 1;

        int take =0,nontake =0;

        nontake = findCountpartitionsWithGivenDifferenceRecursion(arr, target, n-1);
        if(target>=arr[n]) take = findCountpartitionsWithGivenDifferenceRecursion(arr, target-arr[n], n-1);
        

        return take+nontake;
    }

    private int findCountpartitionsWithGivenDifferenceRecursionDP(int[] arr,int target,int n,int[][] dp){
        if(n==0) if(arr[n]==target) return 1; else return 0;
        if(target==0) return 1;
        if(dp[n][target] !=-1) return dp[n][target];
        int take =0,nontake =0;

        nontake = findCountpartitionsWithGivenDifferenceRecursion(arr, target, n-1);
        if(target>=arr[n]) take = findCountpartitionsWithGivenDifferenceRecursion(arr, target-arr[n], n-1);
        
        dp[n][target] = take+nontake;
        return dp[n][target];
    }

    private int findCountpartitionsWithGivenDifferenceIteratioDP(int[] arr,int target,int n,int[][] dp){
        
        return dp[n][target];
    }
}

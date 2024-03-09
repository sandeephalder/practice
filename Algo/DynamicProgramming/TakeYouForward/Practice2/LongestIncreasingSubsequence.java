import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        new LongestIncreasingSubsequence();
    }
    LongestIncreasingSubsequence(){
        int arr[] = {10,9,2,5,3,7,101,18};
        System.out.println(findLongestIncreasingSubsequence(arr, 0, -1));
        int[][] dp = new int[arr.length+1][arr.length+1];
        for(int i=0;i<arr.length;i++) Arrays.fill(dp[i], -1);
        System.out.println(findLongestIncreasingSubsequenceDP(arr, 0, -1,dp));
        System.out.println(findLongestIncreasingSubsequenceIterativeDP(arr, 0, 0));
    }

    private int findLongestIncreasingSubsequence(int[] arr,int current,int previous){
        int result=0,take=Integer.MIN_VALUE,nontake=Integer.MIN_VALUE;
        if(current>=arr.length) return 0;
        if(previous ==-1 || arr[current]>arr[previous])
        take = findLongestIncreasingSubsequence(arr, current+1, current)+1;
        nontake = findLongestIncreasingSubsequence(arr, current+1, previous);
        result = Math.max(take, nontake);
        return result;
    }

    private int findLongestIncreasingSubsequenceDP(int[] arr,int current,int previous,int[][] dp){
        int result=0,take=Integer.MIN_VALUE,nontake=Integer.MIN_VALUE;
        if(current>=arr.length) return 0;
        if(dp[current][previous+1]!=-1) return dp[current][previous+1];
        if(previous==-1 || arr[current]>arr[previous])
        take = findLongestIncreasingSubsequenceDP(arr, current+1, current,dp)+1;
        nontake = findLongestIncreasingSubsequenceDP(arr, current+1, previous,dp);
        result = Math.max(take, nontake);
        dp[current][previous+1]=result;
        return dp[current][previous+1];
    }

    private int findLongestIncreasingSubsequenceIterativeDP(int[] arr,int Current,int Previous){
        int result=0;
        int[][] dp = new int[arr.length+1][arr.length+1];
        for(int[] d:dp) Arrays.fill(d,0);
        for(int current=arr.length-1;current>=0;current--){
            for(int previous=current-1;previous>=-1;previous--){
                int take =0;
                if(previous==-1 || arr[current]>arr[previous])
                take = dp[current+1][current+1]+1;
                int nontake = dp[current+1][previous+1];
                result = Math.max(take, nontake);
                dp[current][previous+1]=result;
            }
        }
        printArray(dp);
        return dp[0][0];
    }
   

    private void printArray(int[][] arr){
        for(int[] ar: arr){
            System.out.println();
            for(int a:ar){
                System.out.print(" ==> "+a);
            }
        }
    }
}

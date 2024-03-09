package DynamicProgramming;

public class MaximumSumNonAdjacentElement {
    MaximumSumNonAdjacentElement(){
        int[] arr ={2,1,4,9};
        int[] dp = new int[arr.length]; 
        for(int i=0;i<dp.length;i++) dp[i] = -1;
        System.out.println(" maximumSumNonAdjacentElementRecursive "+maximumSumNonAdjacentElementRecursive(arr.length-1,arr));
        System.out.println(" maximumSumNonAdjacentElementRecursiveDP "+maximumSumNonAdjacentElementRecursiveDP(arr.length-1,arr,dp));
        for(int i=0;i<dp.length;i++) dp[i] = 0;
        System.out.println(" maximumSumNonAdjacentElementIterativeDP "+maximumSumNonAdjacentElementIterativeDP(arr.length-1,arr,dp));

        System.out.println(" maximumSumNonAdjacentElementIterative "+maximumSumNonAdjacentElementIterative(arr.length-1,arr));
    }

    public static void main(String[] args) {
        new MaximumSumNonAdjacentElement();
    }

    private int maximumSumNonAdjacentElementRecursive(int n,int[] array){
        if(n==0) return array[n];
        if(n<0) return 0;
        
        int take = array[n] + maximumSumNonAdjacentElementRecursive(n-2, array);
        int nonTake = maximumSumNonAdjacentElementRecursive(n-1, array);

        return Math.max(take, nonTake);
    }

    private int maximumSumNonAdjacentElementRecursiveDP(int n,int[] array,int[] dp){
        if(n==0) return array[n];
        if(n<0) return 0;
        if(dp[n]!=-1) return dp[n];
        int take = array[n] + maximumSumNonAdjacentElementRecursiveDP(n-2, array,dp);
        int nonTake = maximumSumNonAdjacentElementRecursiveDP(n-1, array,dp);
        dp[n] = Math.max(take, nonTake);
        return dp[n];
    }

    private int maximumSumNonAdjacentElementIterativeDP(int N,int[] array,int[] dp){
        dp[0] = array[0];
        for(int i=1;i<=N;i++){
            int take = array[i] ;
            if(i >1 ) take += dp[i-2];
            int nonTake = dp[i-1];
            dp[i] = Math.max(take, nonTake);
        }
      return dp[N];
    }

    private int maximumSumNonAdjacentElementIterative(int N,int[] array){
        int prevprev=0,prev = array[0],current=0;
        
        for(int i=1;i<array.length;i++){
            int take = array[i] ;
            if(i >1 ) take += prevprev;
            int nonTake = prev;
            current = Math.max(take, nonTake);
            prevprev=prev;
            prev=current;
        }
      return prev;
    }
}


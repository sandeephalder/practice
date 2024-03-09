class MaxSumNonAdjacentElements{

    public static void main(String[] args) {
        new MaxSumNonAdjacentElements();
    }

    MaxSumNonAdjacentElements(){
        int[] arr= {4,12,1,9};
        int[] dp = new int[arr.length];

        System.out.println(" maxSumNonAdjacentElementsRecursive===> "+maxSumNonAdjacentElementsRecursive(arr,arr.length-1));
        for(int i=0;i<dp.length;i++) dp[i]=-1;
        System.out.println(" maxSumNonAdjacentElementsRecursiveDP===> "+maxSumNonAdjacentElementsRecursiveDP(arr,arr.length-1,dp));
        for(int i=0;i<dp.length;i++) dp[i]=0;
        System.out.println(" maxSumNonAdjacentElementsIterativeDP===> "+maxSumNonAdjacentElementsIterativeDP(arr,arr.length-1,dp));
        System.out.println(" maxSumNonAdjacentElementsIterative===> "+maxSumNonAdjacentElementsIterative(arr,arr.length-1));
    }

    private int maxSumNonAdjacentElementsRecursive(int[] arr,int n){
       if(n==0) return arr[n]; 
       int pick = Integer.MIN_VALUE,nonpick=Integer.MIN_VALUE;

       pick  = arr[n] + maxSumNonAdjacentElementsRecursive(arr, n-2);

       nonpick  = 0 + maxSumNonAdjacentElementsRecursive(arr, n-1);

       return Math.max(pick, nonpick);
    }

    private int maxSumNonAdjacentElementsRecursiveDP(int[] arr,int n,int[] dp){
        if(n==0) return arr[n]; 
        if(n<0) return 0; 
        if(dp[n]!=-1) return dp[n];
        int pick = Integer.MIN_VALUE,nonpick=Integer.MIN_VALUE;
 
        pick  = arr[n] + maxSumNonAdjacentElementsRecursiveDP(arr, n-2,dp);
 
        nonpick  = 0 + maxSumNonAdjacentElementsRecursiveDP(arr, n-1,dp);
        dp[n] = Math.max(pick, nonpick);
        return dp[n];
     }

     private int maxSumNonAdjacentElementsIterativeDP(int[] arr,int n,int[] dp){
         dp[0] = arr[0];
         for(int i=1;i<arr.length;i++){
            int pick = Integer.MIN_VALUE,nonpick=Integer.MIN_VALUE;
              pick  = arr[i] ;
              if(i>1) pick += dp[i-2];
 
            nonpick  = 0 + dp[i-1];
            dp[i] = Math.max(pick, nonpick);
         }
        return dp[n];
     }

     private int maxSumNonAdjacentElementsIterative(int[] arr,int n){
        int prevprev = arr[0],prev =0,curr=0;
       
        for(int i=1;i<arr.length;i++){
           int pick = Integer.MIN_VALUE,nonpick=Integer.MIN_VALUE;
             pick  = arr[i] ;
             if(i>1) pick += prevprev;

           nonpick  = 0 + prev;
           curr = Math.max(pick, nonpick);
           prevprev =prev;
           prev=curr;
        }
       return prev;
    }
}
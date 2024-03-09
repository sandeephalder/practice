public class HouseRobber {
    HouseRobber(){
        int[] arr1= {25,12,1,9};
        int[] arr2= {12,1,9,26};
        int[] dp1 = new int[arr1.length];
        int[] dp2 = new int[arr1.length];
        System.out.println(" maxSumNonAdjacentElementsRecursive===> "+Math.max(houseRobberRecursive(arr1,arr1.length-1),houseRobberRecursive(arr2,arr2.length-1)));
       
       for(int i=0;i<dp1.length;i++) {
        dp1[i]=-1;
        dp2[i]=-1;
       }
        System.out.println(" maxSumNonAdjacentElementsRecursiveDP===> "+Math.max(houseRobberRecursiveDP(arr1,arr1.length-1,dp1),houseRobberRecursiveDP(arr2,arr2.length-1,dp2)));
        for(int i=0;i<dp1.length;i++) {
            dp1[i]=0;
            dp2[i]=0;
           }
        System.out.println(" maxSumNonAdjacentElementsIterativeDP===> "+Math.max(houseRobberIterativeDP(arr1,arr1.length-1,dp1),houseRobberIterativeDP(arr2,arr2.length-1,dp2)));
        System.out.println(" maxSumNonAdjacentElementsIterative===> "+Math.max(houseRobberIterative(arr1,arr1.length-1),houseRobberIterative(arr2,arr2.length-1)));
        
    }

    private int houseRobberRecursive(int[] arr, int n) {
        if(n==0) return arr[n];
        if(n<0) return 0;
        int take = Integer.MIN_VALUE,nontake = Integer.MIN_VALUE;

        take = houseRobberRecursive(arr, n-2) + arr[n];
        nontake = houseRobberRecursive(arr, n-1);
        return Math.max(take, nontake);
    }

    private int houseRobberRecursiveDP(int[] arr, int n,int[] dp) {
        if(n==0) return arr[n];
        if(n<0) return 0;
        if(dp[n]!=-1) return dp[n];
        int take = Integer.MIN_VALUE,nontake = Integer.MIN_VALUE;

        take = houseRobberRecursiveDP(arr, n-2,dp) + arr[n];
        nontake = houseRobberRecursiveDP(arr, n-1,dp);
        dp[n] = Math.max(take, nontake);
        return dp[n];
    }

    private int houseRobberIterativeDP(int[] arr, int n,int[] dp) {
        dp[0] = arr[0];
        for(int i=1;i<arr.length;i++){
        int take = Integer.MIN_VALUE,nontake = Integer.MIN_VALUE;

        take =  arr[i];
        if(i>1) take += dp[i-2];
        nontake = dp[i-1];
        dp[i] = Math.max(take, nontake);
        }
        return dp[n];
    }

    private int houseRobberIterative(int[] arr, int n) {
        int prevprev= 0,prev=arr[0],curent=0;
        for(int i=1;i<arr.length;i++){
        int take = Integer.MIN_VALUE,nontake = Integer.MIN_VALUE;

        take =  arr[i];
        if(i>1) take += prevprev;
        nontake = prev;
        curent = Math.max(take, nontake);
        prevprev=prev;
        prev=curent;
        }
        return curent;
    }

    public static void main(String[] args) {
        new HouseRobber();
    }
}

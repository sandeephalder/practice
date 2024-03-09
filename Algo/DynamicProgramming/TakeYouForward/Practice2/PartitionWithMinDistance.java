import java.util.Arrays;

public class PartitionWithMinDistance {
    PartitionWithMinDistance(){
        int[] arr = {1,2,3,4,5};
        int total =0;
        for(int i:arr) total +=i;
        System.out.println(" findPartitionWithMinDistanceRecursive==> "+findPartitionWithMinDistance(arr,total));
    }

    public static void main(String[] args) {
        new PartitionWithMinDistance();
    }
    private int findPartitionWithMinDistance(int[] arr,int total){

       boolean[][] dp = new boolean[arr.length][total+1];
      
       for(int i=0;i<arr.length;i++) {
        Arrays.fill(dp[i], false);
        dp[i][0] = true;
       }

       for(int x=1;x<arr.length;x++){
        boolean take=false,nontake=false;
        for(int s=1;s<=total;s++){
            if(s-arr[x]>=0) take = dp[x-1][s-arr[x]];
            nontake = dp[x-1][s];
            dp[x][s] = take || nontake;
        }
        
       }

      int result = Integer.MAX_VALUE;

      for(int s=1;s<=total;s++){
        int remain = Math.abs((total-s) - s);
        if(dp[arr.length-1][s]) result = Math.min(result, remain);
      }

      return result;

    }

}

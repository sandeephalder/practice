package tuf.DP;

import java.util.Arrays;

public class HouseRobber {

    int[] house1 = {1,5,2,1};
    int[] house2 = {5,2,1,6};
    int[] dp = new int[house1.length+1];
    HouseRobber(){
        int N = house1.length-1;
        Arrays.fill(dp,-1);
        /*int h1= findBestHouseRecursive(house1 , dp, N);
        Arrays.fill(dp,-1);
        int h2= findBestHouseRecursive(house2 , dp, N);
        System.out.println(Math.max(h1, h2));*/
        /*int h1= findBestHouseIterative(house1 , N);
        int h2= findBestHouseIterative(house2 , N);
        System.out.println(Math.max(h1, h2));*/

        int h1= findBestHouseIterativeEfficient(house1 , N);
        int h2= findBestHouseIterativeEfficient(house2 , N);
        System.out.println(Math.max(h1, h2));
    }

    public static void main(String[] args) {
        new HouseRobber();
    }


    private int findBestHouseRecursive(int[] house,int[] dp,int n){
        if(n<0) return 0;
        if(dp[n]!=-1) return dp[n];
        int first =0,second=0;
         second= findBestHouseRecursive(house, dp, n-1);
         first= findBestHouseRecursive(house, dp, n-2) + house[n] ;
        dp[n] = Math.max(first,second);
       return dp[n];
    }

    private int findBestHouseIterative(int[] house,int N){
        Arrays.fill(dp,0);
        dp[0] = house[0];
       
        
        for(int n=1;n<=N;n++){
            int first =0,second=0;
         second= n>0?dp[n-1]:0;
         first= n>1?(dp[n-2] + house[n] ):0;
        dp[n] = Math.max(first,second);
        }
       return dp[N];
    }

    private int findBestHouseIterativeEfficient(int[] house,int N){
       
        int prev = house[0];
        int current =0,prev_prev=0;
        for(int n=1;n<=N;n++){
            int first =0,second=0;
         second= n>0?prev:0;
         first= n>1?(prev_prev + house[n] ):0;
        current = Math.max(first,second);
        prev_prev=prev;
        prev=current;
        }
       return current;
    }

}

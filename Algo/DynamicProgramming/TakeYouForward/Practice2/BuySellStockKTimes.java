import java.util.Arrays;

public class BuySellStockKTimes {
    BuySellStockKTimes(){
      int[] stock = {3,3,5,0,0,3,1,4};
      int n = stock.length;
      System.out.println(maxBuySellStockKTimes(stock, 0, 2, 1));
      int[][][] dp =new int[n][3][2];
      for(int i=0;i<n;i++) for(int j=0;j<3;j++) Arrays.fill(dp[i][j], -1);
      
      System.out.println("Recursive DP "+maxBuySellStockKTimesDP(stock, 0, 2, 1, dp));
      System.out.println(maxBuySellStockKTimesIterativeDP(stock, n, 2, 1));
    }
    public static void main(String[] args) {
        new BuySellStockKTimes();
    }

    private int maxBuySellStockKTimes(int[] stock,int n,int cap,int buy){

        int result =0;

        if(n>=stock.length || cap ==0) return 0;

        if(buy==1){
            result = Math.max(maxBuySellStockKTimes(stock, n+1, cap, 0)-stock[n]
            ,maxBuySellStockKTimes(stock, n+1, cap, 1));
        }
        else{
            result = Math.max(maxBuySellStockKTimes(stock, n+1, cap-1, 1)+stock[n]
            ,maxBuySellStockKTimes(stock, n+1, cap, 0));
        }
        return result;
    }

    private int maxBuySellStockKTimesDP(int[] stock,int n,int cap,int buy,int[][][] dp){
        int result =0;

        if(n>=stock.length || cap ==0) return 0;
        if(dp[n][cap][buy]!=-1) return dp[n][cap][buy];
        if(buy==1){
            dp[n][cap][buy] = Math.max(maxBuySellStockKTimesDP(stock, n+1, cap, 0,dp)-stock[n]
            ,maxBuySellStockKTimesDP(stock, n+1, cap, 1,dp));
        }
        else{
            dp[n][cap][buy] = Math.max(maxBuySellStockKTimesDP(stock, n+1, cap-1, 1,dp)+stock[n]
            ,maxBuySellStockKTimesDP(stock, n+1, cap, 0,dp));
        }
       
        
        return dp[n][cap][buy];
    }

    private int maxBuySellStockKTimesIterativeDP(int[] stock,int N,int Cap,int Buy){
        int result =0;
        int[][][] dp =new int[N+1][2][3];
        for(int n = N-1; n>=0; n--)
            for(int buy = 0; buy<=1; buy++)
            Arrays.fill(dp[n][buy],0);
        
        for(int n = N-1; n>=0; n--){
            for(int buy = 0; buy<=1; buy++){
                for(int cap=1; cap<=2; cap++){
        if(buy==0){
            dp[n][buy][cap] = Math.max(dp[n+1][1][cap]-stock[n],dp[n+1][0][cap]);
        }
         if(buy==1){
            dp[n][buy][cap] = Math.max(dp[n+1][0][cap-1]+stock[n],dp[n+1][1][cap]);
        }
    
    }}}
        return dp[0][0][2];
    }
}

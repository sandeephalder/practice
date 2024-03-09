import java.util.Arrays;

public class BuySellStockWithFee {
    public static void main(String[] args) {
        new BuySellStockWithFee();
    }
    BuySellStockWithFee(){
        int[] stock = {1,3,2,8,4,9};
        int n = stock.length;
        int fee = 2;
        System.out.println(maxBuySellStockWithFeeRecursion(stock, 0, 1, fee)); 
        int[][] dp = new int[n][2];
        for(int[] d:dp) Arrays.fill(d, -1);
        System.out.println(maxBuySellStockWithFeeRecursionDP(stock, 0, 1, fee,dp));    
        System.out.println(maxBuySellStockWithFeeIterationDP(stock, n, 1, fee));
             
    }

    private int maxBuySellStockWithFeeRecursion(int[] stock,int n,int buy,int fee){
        int result =0;
        if(n>=stock.length) return 0;
        if(buy==1){
            result= Math.max(maxBuySellStockWithFeeRecursion(stock, n+1, 0, fee)-stock[n], 
            maxBuySellStockWithFeeRecursion(stock, n+1, 1, fee));
        }
        if(buy==0){
            result= Math.max(maxBuySellStockWithFeeRecursion(stock, n+1, 1, fee)+stock[n]-fee, 
            maxBuySellStockWithFeeRecursion(stock, n+1, 0, fee));
        }
        return result;
    }

    private int maxBuySellStockWithFeeIterationDP(int[] stock,int N,int Buy,int fee){      
        int[][] dp = new int[N+1][2];
        for(int[] d:dp) Arrays.fill(d, 0);
        for(int n=N-1;n>=0;n--)
        {
            for(int buy=0;buy<2;buy++){
                if(buy==1){
                    dp[n][buy]= Math.max(dp[n+1][0]-stock[n],dp[n+1][1]);
                }
                if(buy==0){
                    dp[n][buy]= Math.max(dp[n+1][1]+stock[n]-fee,dp[n+1][0]);
                }
            }
        }
       
        return dp[0][1];
    }

    private int maxBuySellStockWithFeeRecursionDP(int[] stock,int n,int buy,int fee,int[][] dp){
        int result =0;
        if(n>=stock.length) return 0;
        if(dp[n][buy]!=-1) return dp[n][buy];
        if(buy==1){
            result= Math.max(maxBuySellStockWithFeeRecursionDP(stock, n+1, 0, fee,dp)-stock[n], 
            maxBuySellStockWithFeeRecursionDP(stock, n+1, 1, fee,dp));
        }
        if(buy==0){
            result= Math.max(maxBuySellStockWithFeeRecursionDP(stock, n+1, 1, fee,dp)+stock[n]-fee, 
            maxBuySellStockWithFeeRecursionDP(stock, n+1, 0, fee,dp));
        }
        dp[n][buy]=result;
        return result;
    }
}

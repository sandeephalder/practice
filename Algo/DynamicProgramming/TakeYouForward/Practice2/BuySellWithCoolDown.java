import java.util.Arrays;

public class BuySellWithCoolDown {
    public static void main(String[] args) {
        new BuySellWithCoolDown();
    }
    BuySellWithCoolDown(){
        int[] stock = {4,9,0,4,10};
        System.out.println(maxBuySellWithCooldownRecursive(stock, 0, 1));
        int[][] dp = new int[stock.length][2];
        for(int i=0;i<stock.length;i++) Arrays.fill(dp[i], -1);
        System.out.println(maxBuySellWithCooldownRecursiveDP(stock, 0, 1,dp));
        System.out.println(maxBuySellWithCooldownIterativeDP(stock, stock.length, 1));
    }

    private int maxBuySellWithCooldownRecursive(int[] stock,int n,int buy){
        int result =0;
        if(n>=stock.length) return 0;

        if(buy==1){
            return Math.max(maxBuySellWithCooldownRecursive(stock, n+1, 0)-stock[n], maxBuySellWithCooldownRecursive(stock, n+1, 1));
        }
        if(buy==0){
            return Math.max(maxBuySellWithCooldownRecursive(stock, n+2, 1)+stock[n], maxBuySellWithCooldownRecursive(stock, n+1, 0));
        }
        return result;
    }

    private int maxBuySellWithCooldownRecursiveDP(int[] stock,int n,int buy,int[][] dp){
        
        if(n>=stock.length) return 0;
        if(dp[n][buy]!=-1) return dp[n][buy];
        if(buy==1){
            dp[n][buy]= Math.max(maxBuySellWithCooldownRecursiveDP(stock, n+1, 0,dp)-stock[n], maxBuySellWithCooldownRecursiveDP(stock, n+1, 1,dp));
        }
        if(buy==0){
            dp[n][buy]= Math.max(maxBuySellWithCooldownRecursiveDP(stock, n+2, 1,dp)+stock[n], maxBuySellWithCooldownRecursiveDP(stock, n+1, 0,dp));
        }
        return dp[n][buy];
    }

    private int maxBuySellWithCooldownIterativeDP(int[] stock,int N,int Buy){
        
        int[][] dp = new int[N+2][2];
        for(int i=0;i<N+2;i++) Arrays.fill(dp[i], 0);
        for(int n=N-1;n>=0;n--){
            for(int buy=0;buy<2;buy++){
                if(buy==1){
                    dp[n][buy]= Math.max(dp[n+1][0]-stock[n], dp[n+1][1]);
                }
                if(buy==0){
                    dp[n][buy]= Math.max(dp[n+2][1]+stock[n], dp[n+1][0]);
                }
            }
        }
        
        return dp[0][1];
    }
}

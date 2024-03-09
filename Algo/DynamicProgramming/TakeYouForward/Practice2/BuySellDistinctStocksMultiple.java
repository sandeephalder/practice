import java.util.Arrays;

public class BuySellDistinctStocksMultiple {
    BuySellDistinctStocksMultiple(){
        int[] stocks = {7,1,5,3,6,4};
        int I= stocks.length;
        System.out.println(buySellMaxRecursive(stocks, 0,0, true));
        int[][][] dp = new int[I][I][3];
        for(int i=0;i<I;i++)for(int j=0;j<I;j++) Arrays.fill(dp[i][j], -1);
        System.out.println(buySellMaxRecursiveDP(stocks, 0, 0, true, dp));
        System.out.println(buySellMaxIterativeDP(stocks, I, 0, true));
        
    }

    public static void main(String[] args) {
        new BuySellDistinctStocksMultiple();
    }

    private int buySellMaxRecursive(int[] stocks,int current,int previous,boolean buy){
        int result=0,take=0,nontake=0;
        if(current>=stocks.length) return 0;

        if(buy){
            take = buySellMaxRecursive(stocks, current+1, current, false);
            nontake = buySellMaxRecursive(stocks, current+1, previous, true);
        }
        else{
            if(stocks[current]-stocks[previous]>=0) 
            take = buySellMaxRecursive(stocks, current+1, current, true)+stocks[current]-stocks[previous];
            nontake = buySellMaxRecursive(stocks, current+1, previous, false);
        }
        result = Math.max(take, nontake);
        return result;
    }


    private int buySellMaxRecursiveDP(int[] stocks,int current,int previous,boolean buy,int[][][] dp){
        int result=0,take=0,nontake=0;
        if(current>=stocks.length) return 0;
        if(dp[current][previous][buy?1:0]!=-1) return dp[current][previous][buy?1:0];
        if(buy){
            take = buySellMaxRecursiveDP(stocks, current+1, current, false,dp);
            nontake = buySellMaxRecursiveDP(stocks, current+1, previous, true,dp);
        }
        else{
            if(stocks[current]-stocks[previous]>=0) 
            take = buySellMaxRecursiveDP(stocks, current+1, current, true,dp)+stocks[current]-stocks[previous];
            nontake = buySellMaxRecursiveDP(stocks, current+1, previous, false,dp);
        }
        result = Math.max(take, nontake);
        dp[current][previous][buy?1:0]= result;
        return result;
    }


    private int buySellMaxIterativeDP(int[] stocks,int Current,int Previous,boolean Buy){
        int profit=0;
        
        int[][] dp = new int[stocks.length+1][2];
        for(int i=0;i<Current;i++) Arrays.fill(dp[i], -1);
        dp[Current][0] = dp[Current][1] = 0;
     
            for(int ind= Current-1; ind>=0; ind--){
                for(int buy=0; buy<=1; buy++){
                if(buy==0){// We can buy the stock
                    profit = Math.max(0+dp[ind+1][0], -stocks[ind] + dp[ind+1][1]);
                }
        
                if(buy==1){// We can sell the stock
                    profit = Math.max(0+dp[ind+1][1], stocks[ind] + dp[ind+1][0]);
                }
                
                dp[ind][buy]  = profit;
            }
            }
        
        
        return dp[0][0];
    }
}

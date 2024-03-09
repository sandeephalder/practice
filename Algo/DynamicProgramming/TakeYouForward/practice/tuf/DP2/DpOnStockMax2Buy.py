from typing import List 
prices = [3,2,6,5,0,3]


class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        k=3
        N= len(prices)
        dp = [[[-1 for i in range(k)] for _ in range(2)] for _ in range(N)]

        return self.calculateMaxProfit(prices,dp,1,0,k-1)
        

    def calculateMaxProfit(self, prices: List[int],dp : List[List[List[int]]],buy : int,index : int,transactions :int ) -> int:
        N= len(prices)
        if index>=N or transactions<=0:
            return 0
        if dp[index][buy][transactions] != -1:
            return dp[index][buy][transactions]
        buyvalue= 0
        sellvalue=0
        if buy ==1:
            buyvalue = self.calculateMaxProfit(prices,dp,buy,index+1,transactions)
            buyvalue = max(buyvalue,-prices[index]+self.calculateMaxProfit(prices,dp,0,index+1,transactions))
        else:
            sellvalue = self.calculateMaxProfit(prices,dp,buy,index+1,transactions)
            sellvalue = max(sellvalue,prices[index]+self.calculateMaxProfit(prices,dp,1,index+1,transactions-1))
        
        dp[index][buy][transactions]= max(buyvalue,sellvalue)
        return dp[index][buy][transactions]      

sol = Solution()
print(sol.maxProfit(prices))
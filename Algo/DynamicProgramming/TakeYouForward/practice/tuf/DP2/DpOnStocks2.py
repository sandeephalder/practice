from typing import List 
prices = [1,2,3,4,5]


class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        dp = [[-1 for _ in range(2)] for _ in range(len(prices))] 
        
        return self.maxProfitRecursion(prices,dp,1,0)

    def maxProfitRecursion(self, prices: List[int],dp : List[List[int]],buy: int,index: int) -> int:
        N= len(prices)
        if index>=N:
            return 0
        if dp[index][buy] !=-1:
            return dp[index][buy]
        
        buyvalue=0
        sellvalue=0
        if buy==1:
            buyvalue = max(self.maxProfitRecursion(prices,dp,buy,index+1),-prices[index]+self.maxProfitRecursion(prices,dp,0,index+1))
        else:
            sellvalue = max((0+self.maxProfitRecursion(prices,dp,buy,index+1)),(prices[index]+self.maxProfitRecursion(prices,dp,1,index+1)))
        dp[index][buy] = max(sellvalue,buyvalue) 
        print('dp ',dp)
        return dp[index][buy] 

        

sol = Solution()
print(sol.maxProfit(prices))
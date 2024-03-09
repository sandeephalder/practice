from typing import List 
prices = [1,3,7,5,10,3]
fee = 3

class Solution:
    def maxProfit(self, prices: List[int], fee: int) -> int:
        dp = [[-1 for _ in range(2)] for _ in range(len(prices))] 
        
        return self.maxProfitRecursion(prices,dp,1,0,fee)

    def maxProfitRecursion(self, prices: List[int],dp : List[List[int]],buy: int,index: int,fee: int) -> int:
        N= len(prices)
        if index>=N:
            return 0
        if dp[index][buy] !=-1:
            return dp[index][buy]
        
        buyvalue=0
        sellvalue=0
        if buy==1:
            buyvalue = max(self.maxProfitRecursion(prices,dp,buy,index+1,fee),-prices[index]+self.maxProfitRecursion(prices,dp,0,index+1,fee))
        else:
            sellvalue = max((0+self.maxProfitRecursion(prices,dp,buy,index+1,fee)),((prices[index]-fee)+self.maxProfitRecursion(prices,dp,1,index+1,fee)))
        dp[index][buy] = max(sellvalue,buyvalue) 
        print('dp ',dp)
        return dp[index][buy] 

        

sol = Solution()
print(sol.maxProfit(prices,fee))
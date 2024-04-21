from typing import List
class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:

        N= len(arr)
        dp = [-1 for _ in range(N+1)]
        return self.findMaxSumAfterPartitioning(arr,dp,k,0,N)

    def findMaxSumAfterPartitioning(self, arr: List[int],dp: List[int], k: int,lo: int,hi:int) -> int:
        if lo==hi:
            return 0
        if dp[lo]!=-1:
            return dp[lo]
        maxReturn = -10**9
        tillMax=arr[lo]
        count=0
        for mid in range(lo,min(lo+k,hi)):
            tillMax=max(arr[mid],tillMax)
            count +=1
            val = self.findMaxSumAfterPartitioning(arr,dp,k,mid+1,hi) + count*tillMax
            #print(count,tillMax,val)
            maxReturn = max(maxReturn,val)
        dp[lo]=maxReturn
        return dp[lo]

arr = [1,15,7,9,2,5,10]
k = 3       
sol= Solution()
print(sol.maxSumAfterPartitioning(arr,k))
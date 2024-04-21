from typing import List

class Solution:
    def minCost(self, n: int, cuts: List[int]) -> int:
        size=len(cuts)
        
        cuts.sort()
        cuts.append(n)
        cuts.insert(0,0)
        print(cuts)
        N= len(cuts)
        dp=[[-1 for _ in range(N)] for _ in range(N)]
        res = self.finfMinCost(cuts,1,size,dp)
        print(dp)
        return res
    
    def finfMinCost(self,cuts,lo,hi,dp):
        if lo>hi:
            return 0
        
        mincost = 10**9
        if dp[lo][hi]!=-1:
            return dp[lo][hi]
        for mid in range(lo,hi+1):
            currentlen = cuts[hi+1]-cuts[lo-1]
            value = currentlen+ self.finfMinCost(cuts,lo,mid-1,dp)+self.finfMinCost(cuts,mid+1,hi,dp)
            mincost = min(value,mincost)
        dp[lo][hi]=mincost
        return dp[lo][hi]
cuts = [1,3,4,5]
n=7
sol = Solution()
print(sol.minCost(n,cuts))
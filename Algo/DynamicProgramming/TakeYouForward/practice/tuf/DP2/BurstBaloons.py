from typing import List 

class Solution:
    def maxCoins(self, nums: List[int]) -> int:
        N= len(nums)
        nums.append(1)
        nums.insert(0,1)
        dp = [[-1] * (N + 2) for _ in range(N + 2)]

        return self.findMaxCoins(nums,dp,0,N-1)

    def findMaxCoins(self, nums: List[int],dp: List[int],lo:int,hi:int) -> int:
        if lo>hi:
            return 0
        if dp[lo][hi]!=-1:
            return dp[lo][hi]
        maxBaloon= -10**9

        for mid in range(lo,hi+1):
            val = nums[lo-1]*nums[mid]*nums[hi+1] + self.findMaxCoins(nums,dp,lo,mid-1) + self.findMaxCoins(nums,dp,mid+1,hi)
            maxBaloon = max(maxBaloon,val)
        dp[lo][hi]=maxBaloon
        return dp[lo][hi]
    

nums = [3,1,5,8]
sol = Solution()
print(sol.maxCoins(nums))
from typing import List

class Solution:
    def findNumberOfLIS(self, nums: List[int]) -> int:
        n= len(nums)
        dp = [1]*n
        count = [1]*n
        maxi=-10**9
        for current in range(n):
            for prev in range(current):
                if nums[prev] < nums[current] and dp[current]< dp[prev]+1:
                    dp[current]= dp[prev]+1
                    count[current]=count[prev]
                elif nums[prev] < nums[current] and dp[current]== dp[prev]+1:
                    count[current] += count[prev]
            maxi = max(maxi,dp[current])
        numberoflongest=0

        for i in range(n):
            if maxi== dp[i]:
                numberoflongest += count[i]
        return numberoflongest

nums = [1,3,5,4,7]
sol = Solution()
print(sol.findNumberOfLIS(nums))
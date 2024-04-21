from typing import List


class Solution:
    def numSubarraysWithSum(self, nums: List[int], goal: int) -> int:
        sum=0
        n= len(nums)
        end=0
        myDict=dict()
        myDict[0]=1
        count=0
        while end<n:
            sum +=nums[end]
            if sum>=goal:
                count += myDict.get(sum-goal,0)
            myDict[sum]=myDict.get(sum,0)+1
            print(end,myDict,count)
            end+=1
        return count

nums = [1,0,1,0,1]
goal = 2
sol = Solution()
print(nums)
print(sol.numSubarraysWithSum(nums,goal))
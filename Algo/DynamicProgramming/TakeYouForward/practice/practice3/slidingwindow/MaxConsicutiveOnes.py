from typing import List
class Solution:
    def longestOnes(self, nums: List[int], k: int) -> int:
        start=0
        end=0
        maxlen=0
        n= len(nums)
        limit =k
        while end <n:
            val = nums[end]
            if val==0:
                limit-=1
            if val ==0 and limit <0:
                if nums[start]==1:
                    while nums[start]!=0:
                        start+=1
                limit+=1
                start+=1
            maxlen = max(maxlen,end-start+1)
            print(end,start,val,limit,maxlen)
            end+=1

        return maxlen


nums = [0]
k = 1
sol = Solution()
print(nums)
print(sol.longestOnes(nums,k))

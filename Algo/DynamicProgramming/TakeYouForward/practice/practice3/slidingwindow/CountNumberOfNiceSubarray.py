from typing import List


class Solution:
    def numberOfSubarrays(self, nums: List[int], k: int) -> int:
        start=0
        end=0
        n= len(nums)
        count=0
        length=0
        totalCount=0
        while end<n:
            if nums[end]%2==1:
                length+=1
                count=0
            if length==k:
                while start<end and nums[start]%2==0:
                    start+=1
                    count+=1
                count+=1
                start+=1
                length-=1
            totalCount +=count
            end+=1
        return totalCount


nums = [1,1,2,1,1]
k = 3

sol = Solution()
print(sol.numberOfSubarrays(nums,k))
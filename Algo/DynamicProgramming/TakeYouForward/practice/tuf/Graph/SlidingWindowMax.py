from typing import List 
nums = [1,-1]
k = 1
class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        queue=[]
        N  = len(nums)
        ans=[]
        if N<2:
            return nums

        for i in range(N):
            if i<k:
                if not queue:
                    queue.append(i)
                else:
                    if nums[i] > nums[queue[-1]]:
                        while queue and nums[i] > nums[queue[-1]]:
                            queue.pop()
                    queue.append(i)
                if k-1==i:
                    ans.append(nums[queue[0]])
            else:
                if nums[i] > nums[queue[-1]]:
                        while queue and nums[i] > nums[queue[-1]]:
                            queue.pop()
                        queue.append(i)
                else:
                    queue.append(i)
                ans.append(nums[queue[0]])
        #print(queue,ans)
        return ans

                        




sol  = Solution()

print(sol.maxSlidingWindow(nums,k))
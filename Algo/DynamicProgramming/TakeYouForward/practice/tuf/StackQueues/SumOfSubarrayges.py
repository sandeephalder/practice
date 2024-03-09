from typing import List 

array = [1,3,3]
class Solution:
    def subArrayRanges(self, arr: List[int]) -> int:
        res = 0
        n = len(arr)
        for i in range(n):
            minv= arr[i]
            maxv = arr[i]
            for j in range(i,n):
                minv = min(minv,arr[j])
                maxv = max(maxv,arr[j])
                res += maxv-minv
        return res
    

sol = Solution()
print(array)
print(sol.subArrayRanges(array))
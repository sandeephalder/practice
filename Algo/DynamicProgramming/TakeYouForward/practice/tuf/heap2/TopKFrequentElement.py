from typing import List
from collections import Counter
nums = [3,0,1,0]
k=1

class Solution:
        def topKFrequent(self, nums: List[int], k: int) -> List[int]:
                result =[]
                ranks  = Counter(nums)
                print(ranks) 
                for i,j in ranks.items():
                        result.append([j,i])
                result = sorted(result,key=lambda x:x[0],reverse=True)
                print(result)
                result = [j for _,j in result]                     
                return result[:k]
        

sol = Solution()
print(sol.topKFrequent(nums,k))



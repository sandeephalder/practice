from typing import List

class Solution:
    def subarraysWithKDistinct(self, nums: List[int], k: int) -> int:
        n=len(nums)
        start=0
        end=0
        myDict = dict()
        count=0
        while end<n:
            val = nums[end]
            myDict[val]= myDict.get(val,0)+1

            while len(myDict.keys())>k:
                sval = nums[start]
                myDict[sval] -=1
                if myDict[sval]==0:
                    del myDict[sval]
                start+=1
            
            if len(myDict.keys())==k:
                while len(myDict.keys())==k:
                    count+=1
                    sval = nums[start]
                    myDict[sval] -=1
                    if myDict[sval]==0:
                        del myDict[sval]
                    start+=1
            

            print(end,count,myDict)
            end+=1

        return count
    
nums = [1,2,1,2,3]
k = 2
sol = Solution()
#print(sol.subarraysWithKDistinct(nums,k))

s = dict()
if 1 not in s.keys():
    s[1]=dict()
if 1 not in s[1].keys():
    s[1][1]="myval"
print(s)



from typing import List

class Solution:
    def totalFruit(self, fruits: List[int]) -> int:
        mymap = {}
        l=0
        r=0
        mymap[fruits[l]]=1
        maxlen=0
        flen= len(fruits)
        while r<flen:
            curr= fruits[r]
            if curr in mymap:
                mymap[curr]+=1
            else:
                mymap[curr]=1

            while len(mymap.keys())>2:
                mymap[fruits[l]]-=1
                if mymap[fruits[l]] ==0:
                    del mymap[fruits[l]]
                    break 
                l+=1
            maxlen = max(maxlen,r-l+1)
            r+=1
        return maxlen


fruits = [1,2,3,2,2]
sol = Solution()
print(sol.totalFruit(fruits))
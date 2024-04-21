from collections import Counter
from typing import List
class Solution:
    def beautySum(self, s: str) -> int:
        return self.generateSubStrings(s)

    def generateSubStrings(self, s: str)-> int:
        n= len(s)
        res =set()
        for i in range(n):
            for j in range(n+1):
                if s[i:j] !="":
                    res.add(s[i:j])
        val =0
        for s in res:
            val += self.findBeautiful(s)
        return val

    def findBeautiful(self, s: str)-> int:
        c = Counter(s)
        l = c.values()
        #print(s,l)
        return max(l)-min(l)

s = "aabcb"
sol = Solution()
print(sol.generateSubStrings(s))
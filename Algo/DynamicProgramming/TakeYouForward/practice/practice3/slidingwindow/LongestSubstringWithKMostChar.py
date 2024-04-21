
class Solution:
    def lengthOfLongestSubstringKDistinct(self, s: str, k: int) -> int:
        myDict = dict()
        start=0
        end=0
        n= len(s)
        maxcount=0
        maxlen=0
        while end < n:
            val = s[end]
            myDict[val]= myDict.get(val,0)+1

            while len(myDict.keys())>k:
                val = s[start]
                myDict[val]-=1
                if myDict[val]==0:
                    del myDict[val]
                start+=1

            maxlen = max(maxlen,end-start+1)
            end+=1
        return maxlen




s = "eceba"
k = 2

sol = Solution()
print(sol.lengthOfLongestSubstringKDistinct(s,k))
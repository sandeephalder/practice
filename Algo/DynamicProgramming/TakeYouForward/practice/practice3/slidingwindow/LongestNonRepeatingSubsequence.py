class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        n= len(s)
        if n<2:
            return n
  
        myMap = dict()
        myMap[s[0]]=0
        start=0
        end=0
        maxval=1
        while  end+1 <n:
            end+=1
            val = s[end]
            if val in myMap.keys():
                if s[start]==val:
                    start+=1
                else:
                    while start< end and s[start]!=val:
                        del myMap[s[start]]
                        start+=1
                    while start<end and s[start]==val:
                        start+=1
            myMap[val]=end
            
            maxval = max(maxval,end-start+1)
            print(end,start,maxval,end-start+1)
        return maxval

s = "b"
sol = Solution()
print(sol.lengthOfLongestSubstring(s))
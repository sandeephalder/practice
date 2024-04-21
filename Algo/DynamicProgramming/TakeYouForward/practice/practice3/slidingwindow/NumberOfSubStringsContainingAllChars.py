
class Solution:
    def numberOfSubstrings(self, s: str) -> int:
        myDict = dict()
        start=0
        end=0
        n=len(s)
        count=0
        while end<n:
            val = s[end]
            myDict[val] = myDict.get(val,0)+1
            
            if len(myDict.keys())==3:
                next=n-end
                prev=0
                while len(myDict.keys())==3:
                    sval = s[start]
                    prev+=1
                    start+=1
                    myDict[sval] -=1
                    if myDict[sval]==0:
                        del myDict[sval]
                        break

                if next==0:
                    next=1
                if prev==0:
                    prev=1
                print(prev,next)
                count += next*prev
            end+=1
        return count


s = "ababbbc"
sol = Solution()
print(sol.numberOfSubstrings(s))
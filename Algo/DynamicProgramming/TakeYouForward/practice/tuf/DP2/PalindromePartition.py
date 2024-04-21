
class Solution:
    def minCut(self, s: str) -> int:
        N= len(s)
        dp=[[-1 for _ in range(N+1)] for _ in range(N+1)]
        return self.findMinCut(s,dp,0,N)-1

    def findMinCut(self, s: str,dp,lo:int,hi:int) -> int:
        if lo>=hi:
            return 0
        if dp[lo][hi]!=-1:
            return dp[lo][hi]
        minv= 10**9
        for i in range(lo,hi):
            if self.isPalindrome(s[lo:i+1]):
                val = 1+ self.findMinCut(s,dp,i+1,hi)
                minv = min(minv,val)
        #print('Testings lo= ',s[0:lo+1],' hi',s[lo+1:hi])
        dp[lo][hi]=minv
        return dp[lo][hi]

    def isPalindrome(self, s: str) -> bool:
        n= len(s)
        if n==0:
            return False
        return s[:]==s[::-1]

s = "aabc"

sol = Solution()
print(sol.minCut(s))


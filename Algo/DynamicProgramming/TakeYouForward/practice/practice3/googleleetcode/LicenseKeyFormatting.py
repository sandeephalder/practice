class Solution:
    def licenseKeyFormatting(self, s: str, k: int) -> str:
        s=s.upper().replace('-','')
        sl= len(s)
        if sl<=0:
            return ''
        rem=sl%k
        round=sl//k
        if rem!=0:
            ans=s[0:rem]+'-'
        else:
            ans=''
        for i in range(round):
            start=rem+(i*k)
            ans=ans+s[start:start+k]
            if i+1!=round:
                ans+='-'
        if ans[-1]=='-':
            ans=ans[:-1]
        if ans[0]=='-':
            ans=ans[1:]
        return ans

s = "5"
k = 2
sol = Solution()
print(sol.licenseKeyFormatting(s,k))
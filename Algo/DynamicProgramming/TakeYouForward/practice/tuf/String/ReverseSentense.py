class Solution:
    def reverseWords(self, s: str) -> str:
       
        l= s.split(' ')
        n= len(l)-1
        res=''
        for i in range(n,-1,-1):
            val=l[i].lstrip().rstrip()
            if val=='':
                continue
            #print('val == ',val)
            res =res+ ' '+val
        res =res.strip()
        return res
        
s = "the sky  is         blue"
sol = Solution()
print(sol.reverseWords(s))
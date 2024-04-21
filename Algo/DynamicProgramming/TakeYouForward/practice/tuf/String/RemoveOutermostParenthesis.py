class Solution:
    def removeOuterParentheses(self, s: str) -> str:
        left=0
        right=0
        res= ''
        start=0
        for i in range(len(s)):
            c= s[i:i+1]
            if c=='(':
                left+=1
            elif c==')':
                right+=1
            if left==right:
                res += s[start+1:i]
                left=0
                right=0
                start=i+1
        return res

s = "(()())(())(()(()))"
sol = Solution()
print(sol.removeOuterParentheses(s))
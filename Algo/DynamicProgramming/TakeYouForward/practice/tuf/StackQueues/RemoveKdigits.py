import re
num = "10200"
k = 1
class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        stack =[]
        counter=0
        if len(num) == k:
            return "0"
        for i in num:
            current = int(i)

            if len(stack)==0 or current >= stack[-1]:
                stack.append(current)
            else:
                while stack and current < stack[-1] and counter<k:
                    counter+=1
                    stack.pop()
                stack.append(current)
        l= len(num)-k
        if all(i==0 for i in stack[:l]):
            return '0'
        string = "".join(str(i) for i in stack[:l])
        print(string) 
        return self.stripZeros(string)
    
    def stripZeros(self,string):
        while len(string)!=0 and string[0]=='0':
            string = string[1:]
        return string

sol = Solution()

print(sol.stripZeros('001'))
#print(sol.removeKdigits(num,k))
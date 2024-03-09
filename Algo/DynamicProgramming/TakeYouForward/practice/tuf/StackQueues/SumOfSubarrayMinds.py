from typing import List

arr = [3,1,2,4]

class Solution:
    def sumSubarrayMins(self, arr: List[int]) -> int:
        modulo= 10**9+7
        mtsum=1
        N = len(arr)
        lstack = []
        lmins= [-1]*N
        rmins= [N]*N
        

        for i,j in enumerate(arr):
            while  lstack and j  <= arr[lstack[-1]]:
                lstack.pop()
            if lstack:
                lmins[i]=lstack[-1]
            lstack.append(i)

        lstack=[]

        for i in range(N-1,-1,-1):
            while  lstack and arr[i]  < arr[lstack[-1]]:
                lstack.pop()
            if lstack:
                rmins[i]=lstack[-1]
            lstack.append(i)

        #lmins=lmins[::-1]
        print(lmins)
        print(rmins)


        mtsum= sum((i - lmins[i]) * (rmins[i] - i) * value for i, value in enumerate(arr)) % modulo

        return mtsum
    

sol = Solution()
print(arr)
print(sol.sumSubarrayMins(arr))
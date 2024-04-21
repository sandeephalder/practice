from typing import List

def longestBitonicSubsequence(arr: List[int], n: int) -> int:
    
    maxr=-10**9
    dp1 =[1 for _ in range(n)]
    dp2 =[1 for _ in range(n)]
    for i in range(n):
        for prev in range(i):
            if arr[i]>arr[prev] and dp1[prev]+1 > dp1[i]:
                dp1[i]=dp1[prev]+1

    for i in range(n-1,-1,-1):
        for prev in range(n-1,i,-1):
            if arr[i]>arr[prev] and dp2[prev]+1 > dp2[i]:
                dp2[i]=dp2[prev]+1
    #print('dp => ',dp1)
    #print('dp => ',dp2)
    for i in range(n):
        maxr = max(maxr,dp1[i]+dp2[i]-1)
    return maxr
    



arr = [1,2,3,4]

print(longestBitonicSubsequence(arr,len(arr)))

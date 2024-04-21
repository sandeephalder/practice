from typing import List

def findMaxFruits(arr: List[int], n: int) -> int:
    if n<1:
        return n
    start=0
    end=1
    maxval=1
    first=arr[0]
    second=-1
    while end<n:
        val = arr[end]
        if second==-1 and first!=val:
            second=val
        if val != first and val !=second:
            first = arr[end-1]
            i=end-1
            while i>0 and arr[i] == first:
                i-=1
            second=val
            start=i+1

        maxval = max(maxval,end-start+1)
        print(val,first,second,maxval,start,end)
        end+=1
    return maxval

arr =[10,8,25,3,23,3,3,28,2,24,7,2,22,12,18,16,1,16,6,1,6,20,10,3,2,0,25,5,14]

print(findMaxFruits(arr,len(arr)))
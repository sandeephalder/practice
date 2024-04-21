from typing import *
import sys

height = [10, 40, 30, 10]
k=2
n=len(height)


def minimizeCost(n : int, k : int, heights : List[int]) -> int:
    return minimizeCostIterative(n,k,heights)
    #return minimizeCostInternal(n-1,k,heights)

def minimizeCostInternal(n : int, k : int, heights : List[int]) -> int:
    if n==0:
        return 0

    minval = sys.maxsize
    for i in range(1,k+1):
        if n-i>=0:
            temp= abs(heights[n]-heights[n-i]) + minimizeCostInternal(n-i,k,heights)
        minval= min(minval,temp)

    return minval

def minimizeCostIterative(nn : int, k : int, heights : List[int]) -> int:
    dp=[0]*(nn+1)
    
    for n in range(1,nn):
        minval = sys.maxsize
        for i in range(1,k+1):
            if n-i>=0:
                temp= abs(heights[n]-heights[n-i]) + dp[n-i]
                print(dp,minval,temp)
                minval= min(minval,temp)  
        dp[n]=minval
    return dp[nn-1]


print(minimizeCost(n,k,height))
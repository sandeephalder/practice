from typing import List

heights= [7 ,4 ,4 ,2 ,6 ,6 ,3 ,4]

def frogJump(n: int, heights: List[int]) -> int:
    if n==0:
        return 0
    
    prev1 = abs(heights[n]-heights[n-1])+frogJump(n-1,heights)
    prev2=10^19
    if n>1:
        prev2 = abs(heights[n]-heights[n-2])+frogJump(n-2,heights)
    print(prev1,prev2)
    return min(prev1,prev2)

print(frogJump(len(heights)-1,heights))


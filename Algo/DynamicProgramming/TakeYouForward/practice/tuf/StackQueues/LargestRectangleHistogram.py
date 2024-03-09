from typing import List 
heights = [0,9]
class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        N = len(heights)
        stack=[]
        left=[0]*N
        right=[0]*N
        result=0

        for i,j in enumerate(heights):
            while stack and j <= stack[-1][0]:
                stack.pop()
            if not stack:
                left[i] = 0
            else:
                left[i] = stack[-1][1]+1
            stack.append([j,i])
        print('Left ',left)
        stack=[]
        for i in range(N-1,-1,-1):
            while stack and heights[i] <= stack[-1][0]:
                stack.pop()
            if not stack:
                right[i] = N-1
            else:
                right[i] = stack[-1][1]-1
            stack.append([heights[i],i])
        print('right ',right)

        for i in range(N-1):
            result = max(result,heights[i]*(abs(right[i]-left[i]+1)))
        print('Result ',result)
        return result

sol = Solution()
print(sol.largestRectangleArea(heights))
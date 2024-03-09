from typing import List
asteroids = [-4,-1,10,2,-1,8,-9,-6,5,2]
class Solution:
    def asteroidCollision(self, asteroids: List[int]) -> List[int]:
        a=[]
        stack = []
        for i in asteroids[::-1]:
            if i <0:
                stack.append(i)
            else:
                if stack:
                    ans=None
                    while stack and stack[-1] < 0:
                        if i<abs(stack[-1]):
                            ans=None
                            break
                        elif i==abs(stack[-1]):
                            ans=None
                            stack.pop()
                            break
                        else:
                            ans=stack.pop()
                    if ans:
                        a.append(i)
  
                else:
                    a.append(i)
            print(' i ',i,' stack ',stack)
        for i in stack:
            a.append(i)
        a=a[::-1]
        return a

sol = Solution()
print(asteroids)
print(sol.asteroidCollision(asteroids))
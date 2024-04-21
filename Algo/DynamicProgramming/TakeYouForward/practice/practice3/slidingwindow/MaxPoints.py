from typing import List

class Solution:
    def maxScore(self, cardPoints: List[int], k: int) -> int:
        n= len(cardPoints)
        startsum=0
        endsum=sum(cardPoints[n-k:])
        maxsum=0
        
        for i in range(k+1):
            totalsum=0
            if i>0:
                #print(' start = ',i-1)
                startsum+=cardPoints[i-1]
                totalsum+=startsum
            if i<k:
                #print(' end = ',n-k+i)
                totalsum+=endsum
                endsum-=cardPoints[n-k+i]
            
            #print(' startsum ',startsum,' endsum ',endsum,' total = ',totalsum)
            maxsum =max(maxsum,totalsum)
        return maxsum

cardPoints = [1,79,80,1,1,1,200,1]
k = 3
sol = Solution()
print(sol.maxScore(cardPoints,k))

from typing import List 
from collections import Counter
words =  ["xbc","pcxbcf","xb","cxbc","pcxbc"]


class Solution:
    def longestStrChain(self, words: List[str]) -> int:
        words = sorted(words,key= lambda x:(len(x),x))
        print(words)
        N=len(words)
        max=1
        dp= [[-1 for _ in range(len(words)+1)] for _ in range(len(words))]
        '''for i in range(N):
            for j in range(i):
                if self.findIntersection(words[i],words[j]) and dp[j]+1 > dp[i]:
                    dp[i] = dp[j]+1
        
                if dp[i] > max:
                    max = dp[i]

        return max'''
        chain =[]
        ans = self.longestStrChainCalculate(words,dp,chain,0,-1)
        return ans
    

    def longestStrChainCalculate(self, words: List[str], dp: List[List[str]], chain: List[str],index: int,preindex: int) -> int:
        if index>=len(words):
            return 0
        take = 0
        if dp[index][preindex+1]!=-1:
            return dp[index][preindex+1]
        
        if  preindex==-1 or self.findIntersection(words[index],words[preindex]):
    
            chain.append(words[index])
            take = 1+self.longestStrChainCalculate(words,dp,chain,index+1,index)
            chain = chain[:-1]
        nontake = self.longestStrChainCalculate(words,dp,chain,index+1,preindex) 
        
        dp[index][preindex+1]=max(take,nontake)
        return dp[index][preindex+1]


    def findIntersection(self, s1: List[str],s2: List[str]) -> bool:
        # Check if s2 is a predecessor of s1
        if len(s1) != len(s2) + 1:
            return False

        first = 0
        second = 0
        if len(s2)==len(s1):
            #print('===',s1,s2)
            return False

        while first < len(s1):
            if second < len(s2) and s1[first] == s2[second]:
                first += 1
                second += 1
            else:
                first += 1

        return first == len(s1) and second == len(s2)
    
    
sol  = Solution()

print(' Final Result : ',sol.longestStrChain(words))

#print('Soln : ',sol.findIntersection('a','ba'))
from typing import List 

class Solution:

    def countSquares(self, matrix: List[List[int]]) -> int:
        m= len(matrix)
        n= len(matrix[0])
        dp = [[ 0 for _ in range(n)] for _ in range(m)]
        print(dp)
        for i in range(m):
            dp[i][0]=matrix[i][0]
        for i in range(n):
            dp[0][i] = matrix[0][i]

        for i  in range(1,m):
            for j in range(1,n):
                if matrix[i][j] == 0:
                    dp[i][j]=0
                else:
                    dp[i][j] = min(dp[i-1][j-1],min(dp[i-1][j],dp[i][j-1]))+1
        
        sum =0
        for i  in range(m):
            for j in range(n):
                sum += dp[i][j]
        
        return sum



matrix =[[0,1,1,1],[1,1,1,1],[0,1,1,1]]
sol = Solution()
print(sol.countSquares(matrix))
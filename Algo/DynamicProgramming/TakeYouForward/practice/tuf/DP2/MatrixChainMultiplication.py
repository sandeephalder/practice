
def mcm(p,n):
	p.sort()
	dp = [[0 for _ in range(n)] for _ in range(n)]
	'''ret = findMcM(p,dp,1,n-1)
	return ret'''
	for i in range(n-1,0,-1):
		for j in range(i+1,n):
			if i==j:
				dp[i][j]=0
			minvalue= 10**9
			for r in range(i,j):
				val = chain[i-1]*chain[j]*chain[r] + dp[i][r]+dp[r+1][j]
				minvalue = min(minvalue,val)
			dp[i][j]=minvalue
	return dp[1][n-1]
			

def findMcM(chain,dp,i,j):
	if i==j:
		return 0
	if dp[i][j]!=-1:
		return dp[i][j]
	minvalue= 10**9
	for r in range(i,j):
		val = chain[i-1]*chain[j]*chain[r] + findMcM(chain,dp,i,r)+findMcM(chain,dp,r+1,j)
		minvalue = min(minvalue,val)
	dp[i][j]=minvalue
	return dp[i][j]




chain =[10 ,15 ,20, 25]
print(mcm(chain,len(chain)))
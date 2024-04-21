class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        alpha = dict()
        start=0
        end=0
        maxval=0
        maxchar=0
        n= len(s)
        while end<n:
            val = s[end]

            if val in alpha.keys():
                alpha[val]+=1
            else:
                alpha[val]=1
            maxchar = max(maxchar,alpha[val])
            print('s  ',' start= ',start,' end= ',end,' val= ',val,' map= ',alpha[val],' maxchar ',maxchar,' calculation= ',(end-start-maxchar+1-k))
            if end-start-maxchar+1>k:
                alpha[s[start]]=alpha[s[start]]-1
                start+=1
            print('e  ',' start= ',start,' end= ',end,' val= ',val,' map= ',alpha[val],' maxchar ',maxchar,' calculation= ',(end-start-maxchar+1-k))
            print('\n')
            maxval = max(maxval,end-start+1)
            end+=1

        return maxval


s = "AABABBA"
k = 1

print(s)
sol = Solution()
print(sol.characterReplacement(s,k))
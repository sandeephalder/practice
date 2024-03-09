import heapq
from typing import List
tasks = ["A","A","A", "B","B","B"]
n = 2
class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        mydict = dict()

        for i in range(ord('A'),ord('Z')):
            key = str(chr(i))
            mydict[key]=0
        print(mydict)
        for i in tasks:
            if i in mydict.keys():
                mydict[i]=mydict[i]+1
            else:
                mydict[i]=1
        freqkeys = list(mydict.values())
        freqkeys.sort()
        maxvalue = freqkeys[len(freqkeys)-1]
        remain = (maxvalue-1)*n
        print(freqkeys)
        for i in range(len(freqkeys)-2,-1,-1):
             remain -= min(freqkeys[i],maxvalue-1)
        result = len(tasks)
        if remain>0:
            result += remain
        return result 


sol = Solution()
print(sol.leastInterval(tasks,n))
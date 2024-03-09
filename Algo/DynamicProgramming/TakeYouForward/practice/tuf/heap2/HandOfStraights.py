from typing import List 
import heapq
hand =[1,2,3,6,2,3,4,7,8]
groupSize = 3
class Solution:
    def isNStraightHand(self, hand: List[int], groupSize: int) -> bool:
        if len(hand)%groupSize!=0:
            return False
        mymap = dict()
        for i in hand:
            if i not in mymap:
                mymap[i]=1
            else:
                mymap[i] = mymap[i]+1
        print(mymap)
        mylist = list(mymap.keys())
        heapq.heapify(mylist)
        print(mylist)
        while mylist:
            start = heapq.nsmallest(1,mylist)[0]
            print('Start ',start)
            count=groupSize
            for i in range(start,start+count):
                if i not in mymap.keys():
                    return False
                mymap[i] = mymap[i]-1
                if mymap[i]==0:
                    if i !=mylist[0]:
                        return False
                    heapq.heappop(mylist)
                    
                    
        return True


sol = Solution()
print(sol.isNStraightHand(hand,groupSize))
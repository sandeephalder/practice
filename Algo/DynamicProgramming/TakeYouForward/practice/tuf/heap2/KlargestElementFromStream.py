import heapq
from typing import List
class KthLargest:

    minheap=[]
    size=0
    def __init__(self, k: int, nums: List[int]):
        self.size=k
        self.minheap=[]
        for i in nums:
            self.add(i)
        

    def add(self, val: int) -> int:
        res = 0
        if len(self.minheap)<self.size:
            heapq.heappush(self.minheap, val)
        else:
            if val > self.min():
                heapq.heappop(self.minheap)
                heapq.heappush(self.minheap, val)
        print(self.minheap)
        return self.minheap[0]
    
    def min(self) -> int:
        return heapq.nsmallest(1,self.minheap)[0]

init = [4, 5, 18, 2]
k=3
kl = KthLargest(k,init)
#print(kl.min())
print(kl.add(3))
print(kl.add(5))
print(kl.add(10))
print(kl.add(8))
print(kl.add(4))

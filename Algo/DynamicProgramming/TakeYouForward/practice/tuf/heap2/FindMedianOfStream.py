import heapq
from typing import List

import heapq

class MedianFinder:

    maxPQ=None
    minPQ=None

    def __init__(self):
        self.maxPQ= MaxPQ()
        self.minPQ= MinPQ()

    def addNum(self, num: int) -> None:
        if self.maxPQ.size()==0:
            self.maxPQ.enqueue(num)
        elif self.minPQ.size()==0:
            self.minPQ.enqueue(num)
        else:
            self.maxPQ.enqueue(num)
            self.rebalance()

    def dequeue(self) -> int:
        pass

    def rebalance(self) -> None:
        if(self.minPQ.size()==0 or self.maxPQ.size()==0 ):
            return 
        lo = self.maxPQ.peek()
        hi = self.minPQ.peek()
        
        if lo > hi:
             self.maxPQ.dequeue()
             self.minPQ.dequeue()
             self.maxPQ.enqueue(hi)
             self.minPQ.enqueue(lo)
        leftLen = self.maxPQ.size()
        rightLen = self.minPQ.size()
        
        while  abs(leftLen - rightLen) >1:

            lo = self.maxPQ.peek()
            hi = self.minPQ.peek()
            if leftLen < rightLen:
                self.minPQ.dequeue()  
                self.maxPQ.enqueue(hi)
            else:
                self.maxPQ.dequeue()  
                self.minPQ.enqueue(lo)
            leftLen = self.maxPQ.size()
            rightLen = self.minPQ.size() 

      
    def findMedian(self) -> float:
        self.rebalance()
        #self.print()
        leftLen = self.maxPQ.size()
        rightLen = self.minPQ.size()
        lo = self.maxPQ.peek()
        hi = self.minPQ.peek()   
        N= leftLen+rightLen
        print('lo = ',lo,' hi = ',hi)
        if N%2==0:
             print('Even')
             return float(float(float(lo)+float(hi))/2.0)
        else:
             print('Odd ')
             return float(lo)

    def print(self) -> None:
        print('Left ==>')
        self.maxPQ.print()
        print('Right ==>')
        self.minPQ.print()

class MaxPQ:
        
        queue= []

        def __init__(self):
            pass

        def enqueue(self, num: int) -> None:
            heapq.heappush(self.queue,(-1)*num)

        def dequeue(self) -> int:
            return (-1)*heapq.heappop(self.queue)
        
        def peek(self) -> int:
            if self.size()==0:
                 return None
            return (-1)*heapq.nsmallest(1,self.queue)[0]
        
        def size(self) -> int:
            return len(self.queue)
        
        def print(self) -> None:
                print(heapq.nlargest(len(self.queue),self.queue))
               
        

class MinPQ:
        
        queue= []

        def __init__(self):
            pass

        def enqueue(self, num: int) -> None:
            heapq.heappush(self.queue,num)

        def dequeue(self) -> int:
            return heapq.heappop(self.queue)
        
        def peek(self) -> int:
            if self.size()==0:
                 return None
            return heapq.nsmallest(1,self.queue)[0]
        
        def size(self) -> int:
            return len(self.queue)
        
        def print(self) -> None:
                print(heapq.nsmallest(len(self.queue),self.queue))  
        
mfc= MedianFinder()
medians = [-1,-2,-3,-4,-5]
#print(calculateMedian(medians))



#mfc.addNum(3)
#mfc.addNum(2)
mfc.addNum(1)
print(mfc.findMedian())


'''min = MaxPQ()
min.enqueue(3)
min.enqueue(2)
min.enqueue(1)
min.enqueue(4)
print(min.peek())
print(min.dequeue())
print(min.peek())
print(min.dequeue())
print(min.peek())
print(min.dequeue())
print(min.peek())
print(min.dequeue())
print(min.peek())
print(min.peek())
print(min.dequeue())
print(min.peek())'''



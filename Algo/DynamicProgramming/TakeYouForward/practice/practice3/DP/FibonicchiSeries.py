class Fibonacci:
    def calculateFebRecursion(self,n:int):
        if n ==0 :
            return n
        if n==1 :
            return n
        
        return self.calculateFebRecursion(n-1)+self.calculateFebRecursion(n-2)
    
    def calculateFebRecursionDynamic(self,n:int,arr):
        if n ==0 :
            return n
        if n==1 :
            return n
        if arr[n] !=-1:
            return arr[n]
        arr[n]=self.calculateFebRecursionDynamic(n-1,arr)+self.calculateFebRecursionDynamic(n-2,arr)
        return arr[n]
    
    def calculateFebRecursionIterative(self,n:int):
        prev2 = 1
        prev1 = 1
        curr=0
        if n<2:
            return n
        for i in range(2,n):
            curr = prev1+prev2
            prev2=prev1
            prev1=curr
            
        return curr

fib = Fibonacci()
n=19
array = [-1]*100
print('fib = ',fib.calculateFebRecursion(n))
print('fib dynamic = ',fib.calculateFebRecursionDynamic(n,array))
print('fib iterative = ',fib.calculateFebRecursionIterative(n))


from typing import List
array = [1, 3, 6, 5, 8, 19, 13, 4]
def countGreater(N: int, Q: int, arr: List[int], query: List[int]) -> List[int]:
    result=[]
    for i in query:
        result.append(findgt(arr,i))
    return result

def findgt(arr,index):
    res =0
    current = arr[index]
    for i in arr[index:]:
        if i>current:
            res+=1
    return res

print(array)

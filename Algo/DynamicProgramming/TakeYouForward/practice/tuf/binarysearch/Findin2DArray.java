package binarysearch;

import java.util.*;

public class Findin2DArray {

   int[][] matrix = 
   {
   {1,3,5,7},
   {10,11,16,20},
   {23,30,34,60}
    };
   int target=34;

   public static void main(String[] args) {
     new Findin2DArray();
   }

   Findin2DArray(){
    System.out.println(searchMatrix(matrix, target));
    //System.out.println(linearToCordinate(matrix, 7));
   }

   public boolean searchMatrix(int[][] matrix, int target) {
    int lo =0,M=matrix.length,N=matrix[0].length,hi=(M*N)-1,mid=0;
    while(lo<=hi){
        mid = (lo+hi)/2;
        List<Integer> res = linearToCordinate(matrix, mid);
        System.out.println(" mid= "+mid+" res= "+res);
        int val = matrix[res.get(0)][res.get(1)];
        System.out.println(" val= "+val);
        if(val<target) lo = mid+1;
        else if(val>target) hi = mid-1;
        else return true;
    }
    return false;
   }

   public List<Integer> linearToCordinate(int[][] matrix,int len){
  
    List<Integer> result = new ArrayList<>();
    int x=0,y=0,N=matrix[0].length;
    x=(int)Math.floor((double)len/(double)N);
    y=(len)%N;
    result.add(x);
    result.add(y);
    return result;
   }




}

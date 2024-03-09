package DP2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class FrogJump{

   int[] arr ={7 ,5 ,5 ,8 ,4, 9, 1, 1, 10 };
   public static void main(String[] args) {
      new FrogJump();
   }

   FrogJump(){
     int cache[]= new int[arr.length];
   Arrays.fill(cache,-1);
     System.out.println(frogJumpInternal(arr.length-1, arr,cache));
     System.out.println(frogJumpInternalIterator(arr.length-1, arr));
     System.out.println(frogJumpInternalIteratorSpaceOptimized(arr.length-1, arr));
   }

   public static int frogJumpInternal(int index, int heights[],int cache[]) {
    if(index<=0){
       return 0;
    }
   if(cache[index]!=-1) return cache[index];
   int r = (int)Math.pow(10, 4),l=(int)Math.pow(10, 4);
    //System.out.println(" index= "+index);
   
   l= frogJumpInternal(index-1, heights,cache)+Math.abs(heights[index-1]-heights[index]);
   if(index>1)
   r = frogJumpInternal(index-2, heights,cache)+Math.abs(heights[index-2]-heights[index]);
    //System.out.println(" index= "+index+" l= "+l+" r="+r);
    cache[index]=Math.min(l, r);
   return cache[index] ;
}

 public static int frogJumpInternalIterator(int n, int heights[]) {
    int cache[] = new int[n+1];
    Arrays.fill(cache,0);
   
   for(int i=1;i<=n;i++){
    int r = (int)Math.pow(10, 4),l=(int)Math.pow(10, 4);
      l= cache[i-1]+Math.abs(heights[i-1]-heights[i]);
      if(i>1)
      r= cache[i-2]+Math.abs(heights[i-2]-heights[i]);
      cache[i]=Math.min(l, r);
   }
    
   return cache[n] ;
}

 public static int frogJumpInternalIteratorSpaceOptimized(int n, int heights[]) {
    int current=0,previous=0;
   
   for(int i=1;i<=n;i++){
    int r = (int)Math.pow(10, 4),l=(int)Math.pow(10, 4);
      l= current+Math.abs(heights[i-1]-heights[i]);
      if(i>1)
      r= previous+Math.abs(heights[i-2]-heights[i]);
      previous=current;
      current=Math.min(l, r);
   }
    
   return current ;
}
.


}
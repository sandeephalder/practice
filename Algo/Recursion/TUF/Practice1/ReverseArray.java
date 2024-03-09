public class ReverseArray {
    
    public static void main(String[] args) {
        new ReverseArray();    
       }
   
       ReverseArray(){
           int[] arr = {1,2,3,4,5,6,7};
           reverseArray(arr, 0);
           for(int i:arr)System.out.print(" ==> "+i);
       }
   
       public void reverseArray(int[] arr,int index){
           int N = arr.length;

           if(index >= N/2) return;

            exch(arr,index,N-index-1);

            reverseArray(arr, index+1);
           
       }

       public void exch(int[] arr,int src,int dest){
           int temp = arr[src];
           arr[src]= arr[dest];
           arr[dest]=temp;
       }
   
   }
   
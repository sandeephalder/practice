public class SubsetSumIncreasingorder {
    public static void main(String[] args) {
        new SubsetSumIncreasingorder();
    }

    SubsetSumIncreasingorder(){
        int[] arr = {0,1,2,3,4,5};
    
        subsetSumIncreasingorder(arr, 0, 0);
    }

    private void subsetSumIncreasingorder(int[] arr,int sum,int index){
       if(index >= arr.length) {
        System.out.println(sum);
        return;
       }

       subsetSumIncreasingorder(arr,sum+arr[index],index+1);
       subsetSumIncreasingorder(arr,sum,index+1);
    }

   
    
}

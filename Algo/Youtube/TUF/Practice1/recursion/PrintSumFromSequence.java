package recursion;

public class PrintSumFromSequence {
    public static void main(String[] args) {
     new PrintSumFromSequence();    
    }
 PrintSumFromSequence(){
    int[] arr = {1,0,1,2};
    int[] buffer0 = new int[0];
    System.out.println("generateSumOfSubsequences");
    generateSumOfSubsequences(arr,buffer0,0,3);
    System.out.println("generateSumOfFirstSubsequence");
    generateSumOfFirstSubsequence(arr,buffer0,0,3);
    System.out.println("countSumOfSubsequences"+countSumOfSubsequences(arr,buffer0,0,3));
    
 }

 private int countSumOfSubsequences(int[] arr,int[] buffer,int index,int target){
    int sum =0;
    if(index >= arr.length) {
        if(checkArray(buffer,target)) return 1 ;else return 0;
    }
    sum += countSumOfSubsequences(arr,buffer,index+1,target);
    buffer = addToArray(buffer, arr[index]);
    sum += countSumOfSubsequences(arr,buffer,index+1,target);
    return sum;
}

 private void generateSumOfSubsequences(int[] arr,int[] buffer,int index,int target){
    if(index >= arr.length) {
        checkArray(buffer,target);
        return;
    }
    generateSumOfSubsequences(arr,buffer,index+1,target);
    buffer = addToArray(buffer, arr[index]);
    generateSumOfSubsequences(arr,buffer,index+1,target);

}

 private boolean generateSumOfFirstSubsequence(int[] arr,int[] buffer,int index,int target){
    if(index >= arr.length) {
        if(checkArray(buffer,target))
        return true;
        else return false;
    }
    if(generateSumOfFirstSubsequence(arr,buffer,index+1,target)) return true; 
    buffer = addToArray(buffer, arr[index]);
    if(generateSumOfFirstSubsequence(arr,buffer,index+1,target)) return true; 
    return false;
}

 private int[] addToArray(int[] arr,int element){
    int[] nwArray = new int[arr.length+1];
    System.arraycopy(arr, 0, nwArray, 0, arr.length);
    nwArray[nwArray.length-1]=element;
    return nwArray;
}

private boolean checkArray(int arr[],int target){
    
    int sum=0;
    boolean result = false;
    for(int i: arr)
        sum += i;
    if(sum == target) {
        result=true;
        printArray(arr);
    }

    return result;
}

private void printArray(int arr[]){
    System.out.println();
    for(int i: arr)
        System.out.print("==>"+i);
    System.out.println();
}

}

public class PrintAllCombinationsOfSum {
    PrintAllCombinationsOfSum(){
        int[] arr = {0,1,2,3,4,5};
        int[] buffer = new int[0];
        printAllCombinationsOfSum(arr, buffer, 0, 5);
    }
    public static void main(String[] args) {
        new PrintAllCombinationsOfSum();
    }
    private void printAllCombinationsOfSum(int[] arr,int[] buffer,int index,int target){
        if(index >= arr.length || sumArray(buffer) > target) return;
        if(sumArray(buffer) == target) {
            printArray(buffer);
            return;
        };
        if(arr[index]==0) index++;
        printAllCombinationsOfSum(arr, buffer, index+1, target);
        buffer = addToArray(buffer, arr[index]);
        printAllCombinationsOfSum(arr, buffer, index, target);
    }

    private int[] addToArray(int[] arr,int element){
        int[] nwArray = new int[arr.length+1];
        System.arraycopy(arr, 0, nwArray, 0, arr.length);
        nwArray[nwArray.length-1]=element;
        return nwArray;
    }
    
    private int sumArray(int arr[]){
        
        int sum=0;
        for(int i: arr)
            sum += i;
        return sum;
    }
    
    private void printArray(int arr[]){
        System.out.println();
        for(int i: arr)
            System.out.print("==>"+i);
        System.out.println();
    }

}

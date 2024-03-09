package recursion;

public class ReverseArray {

    public static void main(String[] args) {
        new ReverseArray();
    }

    ReverseArray(){
        int[] arr = {1,2,3,4,5,6,7,8,9};
        int[] buffer = new int[arr.length];
        reverseArrayByBuffer(arr, buffer, 0);
        print(buffer);
        reverseArray(arr, 0);
        print(arr);
    }

    private void reverseArrayByBuffer(int[] arr,int[] buffer,int index){
        if(index>=arr.length) return;
        buffer[index] = arr[arr.length-(index+1)];
        reverseArrayByBuffer(arr, buffer, index+1);
    }

    private void reverseArray(int[] arr,int index){
        int len = arr.length-1,mid = len/2;
        if(index>=mid) return;
        exch(arr,index,len-index);
        reverseArray(arr, index+1);
    }

    private void exch(int[] a,int src,int dest){
        int temp = a[src];
        a[src] = a[dest];
        a[dest] = temp;
    }

    private void print(int arr[]){
        System.out.println();
        for(int i: arr)
            System.out.print("==>"+i);
        System.out.println();
    }
}

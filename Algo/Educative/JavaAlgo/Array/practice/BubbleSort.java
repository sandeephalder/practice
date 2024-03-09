package practice;

public class BubbleSort {
    public static void main(String[] args) {
        new BubbleSort();
    }
    BubbleSort(){
        int arr[] = {1, 2, 4, -5, -10, 6, 3}; 
        int N= arr.length;
        print(arr);
        sort(arr,0,N-1);
        print(arr);
    }

    private void print(int[] arr){
        System.out.println();
        for(int i:arr) System.out.print(" ==> "+i);
        System.out.println();
    }
    private void sort(int[] arr,int lo,int hi){
      for(int i=0;i<arr.length;i++){
          for(int j=0;j<arr.length-1;j++){
              if(arr[j] > arr[j+1]) exch(arr,j,j+1);
          }
      }
    }

    private void exch(int[] arr,int start,int end){
        //System.out.println(start+" ==> "+end);
		int temp =arr[start];
		arr[start] = arr[end];
		arr[end] = temp;
		
	}
}

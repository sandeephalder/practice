class CheckRemoveEven {

    public static void main(String[] args) {
        int arr[] = {1, 2, 4, 5, 10, 6, 3}; 
        removeEven(arr);
    }

	public static int[] removeEven(int[] arr) {
		int N= arr.length,start=0,end=N-1;
		
		while(start<N && end > start ){
			while(start<N) if(arr[start]%2==0) break; else start++;
			while(end >0) if(arr[end]%2==1) break; else end--;
			exch(arr,start,end);
		}
		exch(arr,start,end);
		int temp[] = new int[start];
		for(int i=0;i<start;i++){
			temp[i]=arr[i];

		}
		return temp; // change this and return the correct result array
	}

	private static int[] exch(int[] arr,int start,int end){
        //System.out.println(start+" ==> "+end);
		int temp =arr[start];
		arr[start] = arr[end];
		arr[end] = temp;
		return arr;
	}
}
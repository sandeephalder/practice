public class MinHeap {
    int N=10,TOP=0;
    int[] arr ;
    public static void main(String[] args) {
        MinHeap minHip = new MinHeap();
        minHip.insert(6);
      
        minHip.insert(10);

         minHip.insert(4);

        minHip.insert(456);
        minHip.insert(16);
        minHip.insert(451);
        minHip.insert(761);
        minHip.insert(901); 
        minHip.insert(1);
       // minHip.insert(765);
       // minHip.insert(232);
        minHip.print();
        System.out.println(minHip.deleteMax());
        minHip.print();
        System.out.println(minHip.deleteMax());
        minHip.print();
        System.out.println(minHip.deleteMax());
        minHip.print();
        System.out.println(minHip.deleteMax());
        minHip.print();
        System.out.println(minHip.deleteMax());
        minHip.print();
        System.out.println(minHip.deleteMax());
        minHip.print();
    }

    MinHeap(){
        arr = new int[N];
    }

    private int deleteMax(){
     int max =arr[1];
      exch(arr, 1, TOP--);
      arr[TOP+1]=0;
      sink(1);
     return max;
    }

    private void insert(int val){
        if(TOP>=N) return;
       arr[++TOP] = val;
       swim(TOP);
    }

    private void sink(int index){
        while(index*2<N){
            int j= index*2;
            if(j<N && arr[j+1] >arr[j]) j++;
            if(arr[index]>arr[j]) break;
            exch(arr,index,j);
            index=j;
        }
    }

    private void swim(int index){
       while(index>1 && arr[index]>arr[index/2]){
           System.out.println(index+ " index "+index/2);
          exch(arr,index,index/2);
          index=index/2;
       }
    
    }

    private void print(){
        System.out.println(" TOP"+TOP);
        for(int i:arr) System.out.print(" ==> "+i);
        System.out.println();
    }

    private void exch(int[] arr,int start,int end){
      
		int temp =arr[start];
		arr[start] = arr[end];
		arr[end] = temp;
	}
    
}

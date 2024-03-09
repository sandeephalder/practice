public class IndexSort {
    
    public static void main(String[] args) {
        new IndexSort();
    }

    IndexSort(){
        int[] arr = {4,3,7,2,0,1,1,3,2,5,7,8,9};
        print(arr);
        sort(arr);
        //print(arr);
    }

    private void sort(int[] arr){
        int N= arr.length,l=11;
        int[] aux = new int[l];
        int temp[] = new int[N];

        for(int i=0;i<N;i++) aux[arr[i]+1]++;
        print(aux);

        for(int i=1;i<l;i++) aux[i]+=aux[i-1];
        print(aux);

        for(int i=0;i<N;i++) temp[aux[arr[i]]++]= arr[i];
        print(temp);

        for(int i=0;i<N;i++) arr[i]= temp[i];  
        print(temp);
    }

    private void print(int[] arr){
        System.out.println();
        for(int i:arr) System.out.print(" ==> "+i);
    }
}

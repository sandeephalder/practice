package binarysearch;

public class FindRowWithMax1s {
    int[][] ones = 
       {{0,  1,  1 },
        { 1,  1,  1 },
        { 0,  1,  1}};

    public static void main(String[] args) {
        new FindRowWithMax1s();
    }

    FindRowWithMax1s(){
        System.out.println(findMax1s(ones));
        //System.out.println(find1s(ones, 0));
    }


    private int findMax1s(int[][] arr){
        int lo=0,N=arr[0].length,hi=N,mid=0,res=-1;
        while (lo<=hi) {
            mid = (lo+hi)/2;
            res = find1s(arr, mid);
            if(res!=-1){
                hi= mid-1;
            }
            else{
                lo = mid+1;
            }
        }
        return res;
    }

    private int find1s(int[][] arr,int index){
        int N= arr.length;
        for(int i=0;i<N;i++){
            if(arr[i][index]==1) return i;
        }
        return -1;
    }

}

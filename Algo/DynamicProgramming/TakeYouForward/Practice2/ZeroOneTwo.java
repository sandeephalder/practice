public class ZeroOneTwo {
    ZeroOneTwo(){
        int nums[] = {2,0,1};
        sortZeroOneTwo(nums);
        print(nums);
    }

    public static void main(String[] args) {
        new ZeroOneTwo();
    }

    private void sortZeroOneTwo(int nums[]){
        int start=0,end=nums.length-1,mid=0,partition=1;
        while(end>=mid){
           if(nums[mid]<partition) swap(nums, start++, mid++);
           else if(nums[mid]>partition) swap(nums, mid, end--);
           else mid++;
        }
        System.out.println("start ==> "+start+" mid ==> "+mid+" end ==> "+end);
        
    }

    private void swap(int[] arr,int src,int dest){
        int temp = arr[src];
        arr[src]=arr[dest];
        arr[dest]=temp;
    }

    private void print(int[] arr){
        System.out.println();
        for(int a:arr) System.out.print(" ===> "+a);
        System.out.println();
    }
}

package Arrays;

public class ReversePairs {
    int[] arr = {1,3,2,3,1};
    public static void main(String[] args) {
        new ReversePairs();
    }

    ReversePairs(){
        System.out.println(reversePairs(arr));
    }

    public int reversePairs(int[] nums) {
        return sort(nums,0,nums.length-1);
    }

    public int sort(int[] nums,int lo,int hi){
        if(lo>=hi) return 0;
        int mid = (lo+hi)/2;

        int l = sort(nums, lo, mid);
        int r = sort(nums, mid+1, hi);
        int c = countPairs(nums, lo, mid, hi);
        merge(nums, lo, mid, hi);
        return l+r+c;
    }

    public static int countPairs(int[] arr, int low, int mid, int high) {
        int right = mid + 1;
        int cnt = 0;
        for (int i = low; i <= mid; i++) {
            while (right <= high && arr[i] > 2 * arr[right]) right++;
            cnt += (right - (mid + 1));
        }
        return cnt;
    }


    public void merge(int[] nums,int lo,int mid,int hi){
        int count=0,N=nums.length;
        int[] temp = new int[N];
        for(int i=lo;i<=hi;i++) temp[i]=nums[i];
        int j= lo,k=mid+1;
        for(int i=lo;i<=hi;i++){
            if(j>mid) arr[i]=temp[k++];
            else if(k>hi) arr[i]=temp[j++];
            else if(temp[k]>temp[j]) arr[i]=temp[j++];
            else {
                arr[i]=temp[k++];
                
            }
        }
    }
}

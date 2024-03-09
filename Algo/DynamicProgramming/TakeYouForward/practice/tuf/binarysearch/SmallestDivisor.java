package binarysearch;

public class SmallestDivisor {
    int[] smallestDivisor = {44,22,33,11,1};
    int threshold = 5;
    public static void main(String[] args) {
        new SmallestDivisor();
    }

    SmallestDivisor(){
        System.out.println(smallestDivisor(smallestDivisor, threshold));
    }

    public int smallestDivisor(int[] nums, int threshold) {
        int lo=1,hi = max(smallestDivisor),mid=0,div=0;
        while(lo<=hi){
            mid = (lo+hi)/2;
            div = divisor(nums, mid);
            System.out.println(" lo= "+lo+" mid= "+mid+" hi= "+hi+" div= "+div);
            if(div<=threshold) hi = mid-1;
            else lo = mid+1;
            
        }
        return lo;
    }

    private int max(int[] arr){
        int max = Integer.MIN_VALUE;
        for(int i:arr) max = Math.max(max, i);
        return max;
    }

    public int divisor(int[] nums, int divisor) {
        int res =0;
        for(int i:smallestDivisor){
            int r = (int)Math.ceil((double)i/(double)divisor);
           
            res += r;
        }
        return res;
    }
}

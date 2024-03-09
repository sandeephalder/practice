package binarysearch;

public class NthRoot {
    public static void main(String[] args) {
        int n=27,m=3;
        System.out.println(NthRoot(n, m));
    }

    public static int NthRoot(int n, int m) {
        int lo=1,hi=n,mid=0;
        long val=0;
        while(lo<=hi){
            mid = (lo+hi)/2;
            val = (long)Math.pow(mid, m);
            if(val<=n) lo = mid+1;
            else hi = mid-1;
        }
        return hi;
    }
}

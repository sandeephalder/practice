package binarysearch;

public class SqrtofNumber {
    public static void main(String[] args) {
        long number = 0;
        System.out.println(sqrtN(number));
    }


    public static int sqrtN(long N) {
		int lo=1,hi=(int)N,mid=0;
        long val=0;
        while(lo<=hi){
            mid = (lo+hi)/2;
            val = mid*mid;
           if(val<=N)
             lo = mid+1;
           else hi = mid-1;
        }
        return hi;
	}
}

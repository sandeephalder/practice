package binarysearch;

public class MinimumDaysForBanquets {
    int[] bloomDay = {5,37,55,92,22,52,31,62,99,64,92,53,34,84,93,50,28};
    int bookey=8,day=2;
    public static void main(String[] args) {
        new MinimumDaysForBanquets();
    }

    MinimumDaysForBanquets(){
        System.out.println(minDays(bloomDay, bookey, day));
       //System.out.println(findBookey(bloomDay, 10, day));
    }

    public int minDays(int[] bloomDay, int m, int k) {
        int lo =min(bloomDay),hi = max(bloomDay),mid=0;
        if(bloomDay.length<(m*k)) return -1;
        while(lo<=hi){
            mid = (lo+hi)/2;
            int res = findBookey(bloomDay, mid, k);
            System.out.println(" mid= "+mid+" lo= "+lo+" hi= "+hi);
           // if(res==m) return m;
            if(res>=m) hi = mid-1;
            else lo = mid+1;
        }
        return lo;
    }

    int max(int[] arr){
        int max = Integer.MIN_VALUE;
        for(int i:arr) max = Math.max(max, i);
        return max;
    }

    int min(int[] arr){
        int max = Integer.MAX_VALUE;
        for(int i:arr) max = Math.min(max, i);
        return max;
    }

    public int findBookey(int[] bloomDay,int thresholdday, int consiqutive) {
        int bookey=0,d=0;
        for(int i:bloomDay){
            if(i<=thresholdday){
                d++;
            }
            else{
                d=0;
            }
            if(d>=consiqutive){
                bookey++;
                d=0;
            }
        }
        return bookey;
    }
}

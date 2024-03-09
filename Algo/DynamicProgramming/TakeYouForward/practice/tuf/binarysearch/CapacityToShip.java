package binarysearch;

public class CapacityToShip {

    int[] weights = {3,2,2,4,1,4};
    int days=3;

    public static void main(String[] args) {
        new CapacityToShip();
    }

    CapacityToShip(){
        shipWithinDays(weights, days);
        System.out.println(shipWithinDays(weights, days));
    }

    public int shipWithinDays(int[] weights, int days) {
        int sum =0,max= Integer.MIN_VALUE;
        for(int i:weights){
            sum += i;
            max= Math.max(i, max);
        }
        System.out.println(" max= "+max+" sum= "+sum);
        int lo = max,hi = sum,mid=0;
        while(lo<=hi){
            mid = (lo+hi)/2;
            int d = findCapacity(weights, mid);
            if(d>=days) lo = mid+1;
            else hi = mid-1;
        }
        return lo;
    }

    public int findCapacity(int[] weights, int capacity) {
        int day=0,c=capacity;
        for(int w:weights){
            if(c>w) 
                c=c-w;
            if(c<=w) 
            {
                c= capacity;
                day++;
            }
            
        }
        return day;
    }

}

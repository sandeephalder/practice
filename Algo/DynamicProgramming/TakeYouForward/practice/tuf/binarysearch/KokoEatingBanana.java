package binarysearch;

import java.util.Arrays;

public class KokoEatingBanana {

    int piles[] = {30,11,23,4,20};
    int h=6;
    public static void main(String[] args) {
        new KokoEatingBanana();
    }

    KokoEatingBanana(){
        System.out.println(minEatingSpeed(piles, h));
        //System.out.println(kokoEatingTime(piles, 22));
    }

    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int mid =0,res=0,N=piles.length;
        
        int lo = 1,hi = piles[N-1];
        //System.out.println(" min= "+min+" max= "+max);
        while(lo<=hi){
            mid = (lo+hi)/2;
            res = kokoEatingTime(piles, mid);
            //System.out.println(" mid= "+mid+" res= "+res);
           
            if(res<=h) {
                hi = mid-1;
            }
            else {
                lo = mid+1;
            } 
            System.out.println(" mid= "+mid+" lo= "+lo+" hi= "+hi);
            
        }
        return lo;
    }

    public int kokoEatingTime(int[] piles,int k) {
        int res=0;
        for(int i:piles){
            //System.out.println(" i= "+i+" first= "+Math.floor(i/k)+" remainder= "+((i%k)>0?1:0));
            
            res += Math.ceil((double)(i) / (double)(k));// i/k+((i%k)>0?1:0);
        }
        return res;
    }
}

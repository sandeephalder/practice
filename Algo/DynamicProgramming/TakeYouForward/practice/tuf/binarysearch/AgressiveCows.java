package binarysearch;

import java.util.Arrays;

public class AgressiveCows {
    int arr[] = {4, 2 ,1, 3 ,6},k=2,N=arr.length;
    public static void main(String[] args) {
        new AgressiveCows();
    }

    AgressiveCows(){
        Arrays.sort(arr);
        System.out.println(aggressiveCows(arr, k));
        //System.out.println(doesCowFit(arr, k, 1));
    }

    public int aggressiveCows(int []stalls, int k) {
        int lo =1,hi= stalls[N-1],mid=0,res=-1;
        while(lo<=hi){
            mid = (lo+hi)/2;
            boolean result = doesCowFit(stalls, k, mid);
            System.out.println("mid== "+mid+" result== "+result);
            if(result){
                lo = mid+1;
                res=mid;
            }
            else{
                hi = mid-1;
            }
        }
        return res;
    }

    public boolean doesCowFit(int[] stalls,int cow,int space){
        int c=0,dist=0;
        for(int i=1;i<N;i++){
            dist += stalls[i]-stalls[i-1];
            if(dist>=space) {
                c++;
                dist=0;
            }
            if(c>=cow-1) break;
           
        }
        if(c==cow-1) return true;
        return false;
    }
}

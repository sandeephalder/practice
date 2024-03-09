package GreedyAlgo;

import java.util.Arrays;

public class CandyDistribution {
    int[] priority = {1,3,4,5,2};
    public static void main(String[] args) {
        new CandyDistribution();
    }

    CandyDistribution(){
        System.out.println(candy(priority));
    }

    public int candy(int[] ratings) {
        int count=0,N=ratings.length,MIN=(int)Math.pow(10, 4)*3,prefix=ratings[0],suffix=ratings[N-1];
        int result[] = new int[N];
        Arrays.fill(result,1);
        for(int i=0;i<N;i++){
            if(ratings[i]>prefix) result[i]=Math.max(result[i], result[i-1]+1);
            prefix=ratings[i];
        }
        for(int i=N-1;i>-1;i--){
           if(ratings[i]>suffix) result[i]=Math.max(result[i], result[i+1]+1);
            suffix=ratings[i];
        }
               
        for(int i=0;i<N;i++){
            if(i==N-1) suffix=result[N-1];
            else suffix=result[i+1];
            if(i==0) prefix=result[0];
            else prefix=result[i-1];
            int diff = result[i] - Math.max(suffix, prefix);
            if(diff>1) result[i] = result[i]-diff+1;
        }
        count= Arrays.stream(result).sum();
        print(result);
        return count;
    }

    public void print(int[] arr){
        System.out.println();
        for(int i:arr) System.out.print(" ==> "+i);
        System.out.println();
    }
}

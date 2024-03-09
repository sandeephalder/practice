package GreedyAlgo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FindMinNumberCoins {
   
    static int amount=90;

    public static void main(String[] args) {
        System.out.println(MinimumCoins(amount));
    }


     public static List<Integer> MinimumCoins(int n) {
        int[] coins ={1, 2, 5, 10, 20, 50, 100, 500, 1000};
        int N = coins.length;
        
        List<Integer> result = new ArrayList<>();
        for(int i=N-1;i>=0;i--){
            if(coins[i]<=n){
                
                for(int j=0;j<(n/coins[i]);j++)
                result.add(coins[i]);
                n= n%coins[i];
            }
            if(n<=0) break;
        }
        return result;
    }
}

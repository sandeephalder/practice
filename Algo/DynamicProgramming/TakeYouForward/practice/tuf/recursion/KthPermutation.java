package tuf.recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class KthPermutation {
    int N= 6;
    List<Integer> list = IntStream.range(1, N+1).boxed().collect(Collectors.toList());
    int K= 99;
    KthPermutation(){
        List<Integer> result = new ArrayList<>();  
        findKthNumber(list, result, K-1);
        System.out.println(result);
    }

    private void findKthNumber(List<Integer> list,List<Integer> result,int k){
        int n= list.size();
        if(n<2 ) {
            result.add(list.get(k));
            return;
        }

        int fact = factorial(n-1);
        
        int pointer = (k)/fact;
        k= (k)%fact;
        int value = Integer.valueOf(list.get(pointer));
        
        result.add(value);
        list.remove(pointer);
        System.out.println(result+" k= "+k+" pointer= "+pointer+" list"+ list+" value="+value);
        findKthNumber(list, result, k);
    }

    private int factorial(int src){
        if(src<1) return 1;
        return src*factorial(src-1);
    }
    
    public static void main(String[] args) {
        new KthPermutation();
    }
}

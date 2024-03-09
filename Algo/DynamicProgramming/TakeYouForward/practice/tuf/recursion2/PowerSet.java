package recursion2;

import java.util.Arrays;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class PowerSet {
    String[] arr = {"a","b","c"};
    public static void main(String[] args) {
        new PowerSet();
    }

    PowerSet(){
        for(int i=0;i<(1<<(4-1));i++){
            int[] mask = {0,0,0};
            for(int j=0;j<3;j++){
                if((i&(1<<j))==(1<<j)) mask[j]=1;
            }
            String ans="";
            for(int j=0;j<mask.length;j++){
                if(mask[j]==1) ans+=arr[j];
            }
            
            System.out.println(ans);
        }
      
    }
}

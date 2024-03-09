import java.util.ArrayList;
import java.util.List;

public class SubsetSumUnique {
    public static void main(String[] args) {
        new SubsetSumUnique();
    }

    SubsetSumUnique(){
    int[] arr = {1,2,2,2,3,3};
    generateSubsetSumUnique(arr,new ArrayList<>(),0);
    }


    private void generateSubsetSumUnique(int[] arr,List<Integer> buffer,int index){
        System.out.println(buffer);

        for(int i=index;i<arr.length;i++){
            if( i> index && arr[i] > arr[i-1]) continue;

            buffer.add(arr[i]);
            generateSubsetSumUnique(arr,buffer,i+1);
            buffer.remove(buffer.size()-1);
        }

    }
    
}

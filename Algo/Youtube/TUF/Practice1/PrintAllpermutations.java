import java.util.ArrayList;
import java.util.List;

public class PrintAllpermutations {
    public static void main(String[] args) {
        new PrintAllpermutations();
    }

    PrintAllpermutations(){
        int[] arr = {1,2,3};
        int[] mask = {0,0,0,0,0};
        //generatePrintAllpermutations(arr,new ArrayList<Integer>(),mask,0);
        generatePrintAllPermutationsSpaceSave(arr,new ArrayList<Integer>(),0);
    }

    private void generatePrintAllPermutationsSpaceSave(int[] arr,List<Integer> buffer,int index){
        if(index >= arr.length) {
            System.out.println(buffer);
            return;
        }

        for(int i=index;i<arr.length;i++){
            swap(arr,index,i);
            buffer.add(arr[index]);
            generatePrintAllPermutationsSpaceSave(arr, buffer, index+1);
            swap(arr, index, i);
            buffer.remove(buffer.size()-1);
        }

    }


    private void generatePrintAllpermutations(int[] arr,List<Integer> buffer,int[] mask,int index){
        if(index >= arr.length) {
            System.out.println(buffer);
            return;
        }

        for(int i=index;i<arr.length;i++){
            if(mask[i] ==1) continue;

            mask[i]=1;
            buffer.add(arr[i]);
            generatePrintAllpermutations(arr,buffer,mask,i+1);
            buffer.remove(buffer.size()-1);
            mask[i]=0;
        }
    }

    private void swap(int[] arr,int src,int dest){
        int temp = arr[src];
        arr[src] = arr[dest];
        arr[dest] = temp;
    }

    
}

public class LSD {
    public static void main(String[] args) {
        new LSD();
    }
    LSD(){
        
        String[] strs = {"qas","xdf","awwe","gnh","qaa","vbn","wet","nvn","zss","pold","zaa","aa"};
        int N=strs.length;
        sort(strs);
    }

    private void sort(String[] arr){
        int N=arr.length,M=4,O=27;
        

        for(int k=M-1;k>=0;k--){
            int[] aux = new int[O];
            String temp[] = new String[N];
            for(int i=0;i<N;i++){  
                int val = charAt(arr[i],k);
                if(val!=-1)
                aux[val+1]++;
            }

            for(int i=1;i<O;i++){  
                aux[i] += aux[i-1];
            }

            print(aux);
            for(int i=0;i<N;i++){  
                int val = charAt(arr[i],k);
                if(val!=-1)
                temp[aux[val]++]= arr[i];
            }
            
            for(int i=0;i<N;i++){  
            arr[i] = temp[i];
            }

            print(arr);
        }
        

    }

    private int charAt(String str,int index){
        int N=str.length();
        if(index>=N) return 0;
        return str.charAt(index)-97;
    }

    private void print(int[] arr){
        System.out.println("\nprint integer");
        for(int i:arr) System.out.print(" ==> "+i);
    }

    private void print(String[] arr){
        System.out.println("print string");
        for(String i:arr) System.out.print(" ==> "+i);
    }
}


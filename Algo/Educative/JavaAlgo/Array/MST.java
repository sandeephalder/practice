public class MST {
    public static void main(String[] args) {
        new MST();
    }

    MST(){
        String[] strs = {"qas","xdf","awwe","gnh","qaa","vbn","wet","nvn","zss","pold","zaa","aa"};
        int N=strs.length;
        sort(strs);
    }

    private void sort(String[] arr){
        
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

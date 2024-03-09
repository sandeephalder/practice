public class KMPStringMatch {
    int[][] dfa;
    int TOTAL_CHAR=26;
    public static void main(String[] args) {
        new KMPStringMatch();
    }

    KMPStringMatch(){
        String haystack="haslrhgbkvlfrpotuirdznjbkeri";
        String needle="aaaaaaa";
        int M=haystack.length();
        int N= needle.length();
        dfa = new int[TOTAL_CHAR][N];
        buildDFA(needle, TOTAL_CHAR, N, dfa);
        match(haystack, needle,M,N,dfa);
    }

    public void buildDFA(String needle,int M,int N,int[][] dfa){
        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                dfa[i][j]=0;
                if(charAt(needle, j)==i) dfa[i][j]=j+1;
            }
        }
        print(dfa,M,N);
    }

    public boolean match(String haystack,String needle,int M,int N,int[][] dfa){
        boolean result=false;
        return result;
    }

    private int charAt(String str,int index){
        int N=str.length();
        if(index>=N) return 0;
        return str.charAt(index)-97;
    }

    
    private void print(int[][] dfa,int M,int N){
        System.out.println("\nprint integer");
        for(int i=0;i<M;i++){
            System.out.println();
            for(int j=0;j<N;j++) System.out.print(" ==> "+dfa[i][j]);            
        }
        
    }
}

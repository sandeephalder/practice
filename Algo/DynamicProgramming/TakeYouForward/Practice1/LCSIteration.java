public class LCSIteration {
    
    public static void main(String[] args) {
        new LCSIteration();
    }

    LCSIteration(){
        String s="abcd";
        String t = "safbghdcrtd";
        int M=s.length(),N=t.length();
        int result = lcs(s, t,M,N,initBuffer(M, N)); 
        System.out.println(result);
    }

    int[][] initBuffer(int N,int K){
        int[][] buffer = new int[N+1][K+1]; 
        for(int i =0;i<=N;i++)
        for(int j=0;j<=K;j++)
        buffer[i][j]=-1;
        return buffer;
    }

   

    public int lcs(String s, String t,int m,int n,int[][] buffer) {
       
    
        for(int i=0;i<=m;i++) buffer[i][0]=0;
        for(int i=0;i<=n;i++) buffer[0][i]=0;

        for(int i=1;i<=m;i++)
        {
            for(int j=1;j<=n;j++){
                if(s.charAt(i-1)==t.charAt(j-1)) buffer[i][j] = 1+ buffer[i-1][j-1]; 
                else buffer[i][j] = Math.max(buffer[i-1][j],buffer[i][j-1]); 
            }
        }
        return buffer[m][n];
    }
}

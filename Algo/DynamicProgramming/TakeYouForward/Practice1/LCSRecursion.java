public class LCSRecursion {
    public static void main(String[] args) {
        new LCSRecursion();
    }

    LCSRecursion(){
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
        if(m<=0 || n <=0 ) return 0;
        if(buffer[m][n] !=-1) return buffer[m][n];
        if(s.charAt(m-1)==t.charAt(n-1)) return 1 + lcs(s, t, m-1, n-1, buffer);

        int result = Math.max(lcs(s, t, m-1, n, buffer), lcs(s, t, m, n-1, buffer));
        buffer[m][n]=result;
		return result;
    }
}

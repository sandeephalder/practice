package DP2;

public class MinimumMatrixPath {

    /*int[][] matrix = {{1, 2, 10, 4},
                    {100, 3, 2, 1},
                    {1, 1, 20, 2},
                    {1, 2, 2, 1}};*/
    
    int[][] matrix = {{10, 2 ,3},
    {3 ,7, 2},
    {8 ,1 ,5}};
    int M= matrix.length,N=matrix[0].length,MIN=-(int)(10e5);
    public static void main(String[] args) {
        new MinimumMatrixPath();
    }

    MinimumMatrixPath(){
        System.out.println(" Recursive: "+getMaxPathSumRecursive(matrix));
        System.out.println(" Iterative : "+getMaxPathSumIterative(matrix));
        System.out.println(" Iterative Efficient : "+getMaxPathSumIterativeEfficient(matrix));
    }

    public  int getMaxPathSumRecursive(int[][] matrix) {
        int M= matrix.length,N=matrix[0].length,MAX=-(int)(10e6);
        int[][] dp = null;
        for(int i=0;i<M;i++){
            dp = new int[M][N];
            MAX=Math.max(MAX,getMaxPathSumRecursive(matrix, dp,0, i));
        }
        
        return MAX;
    }

    public int getMaxPathSumRecursive(int[][] matrix,int[][] dp,int x,int y) {
        int M= matrix.length,N=matrix[0].length;
        if(y<0 || y >N-1) return MIN;
        if(x==M-1) return matrix[x][y]; 
        int d=MIN,l=MIN,r=MIN;

        d= getMaxPathSumRecursive(matrix, dp, x+1, y);
        l= getMaxPathSumRecursive(matrix, dp, x+1, y-1);
        r= getMaxPathSumRecursive(matrix, dp, x+1, y+1);

        dp[x][y] = Math.max(d,Math.max(l, r))+matrix[x][y];

        return dp[x][y];
    }

    public  int getMaxPathSumIterative(int[][] matrix) {
        int M= matrix.length,N=matrix[0].length,MAX=-(int)(10e6);
        int[][] dp = null;
        for(int i=0;i<M;i++){
            dp = new int[M][N];
            MAX=Math.max(MAX,getMaxPathSumIterativeInternal(matrix,dp,i));
        }
        
        return MAX;
    }

    public int getMaxPathSumIterativeInternal(int[][] matrix,int[][] dp,int yy) {
        int M= matrix.length,N=matrix[0].length;
        for(int i=0;i<N;i++) dp[M-1][i] = matrix[M-1][i];
        for(int x=M-2;x>=0;x--){
            for(int y=N-1;y>=0;y--){
                int d=MIN,l=MIN,r=MIN;
                if(y<0 || y >=N-1) continue;
                 d= dp[x+1][y];
                if(y>0)
                l= dp[x+1] [y-1];
                r= dp[x+1] [y+1];
                dp[x][y] = Math.max(d,Math.max(l, r))+matrix[x][y];
            }
        }
        
        return dp[0][yy];
    }


     public  int getMaxPathSumIterativeEfficient(int[][] matrix) {
        int M= matrix.length,N=matrix[0].length,MAX=-(int)(10e6);
       
        for(int i=0;i<M;i++){
            MAX=Math.max(MAX,getMaxPathSumIterativeEfficient(matrix,i));
        }
        
        return MAX;
    }

    public int getMaxPathSumIterativeEfficient(int[][] matrix,int yy) {
        int M= matrix.length,N=matrix[0].length;
        int[] current= new int[N];
        int[] next= new int[N];
        for(int i=0;i<N;i++) next[i] = matrix[M-1][i];
        for(int x=M-2;x>=0;x--){
            for(int y=N-1;y>=0;y--){
                int d=MIN,l=MIN,r=MIN;
                if(y<0 || y >=N-1) continue;
                 d= next[y];
                if(y>0)
                l= next[y-1];
                r= next[y+1];
                current[y] = Math.max(d,Math.max(l, r))+matrix[x][y];
            }
            next = current.clone();
        }
        
        return current[yy];
    }

}

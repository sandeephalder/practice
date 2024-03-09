public class MaxPathSumMetricsVariableStart {
    int N=3;
    int MIN_NUMBER= -Integer.MIN_VALUE/2;
    MaxPathSumMetricsVariableStart(){
        int[][] arr= {{1,100,1},{2,2,3},{3,1,20}};
        int[][] dp = new int[N][N];
        int max= MIN_NUMBER;
        for(int i=0;i<N;i++)
         max = Math.max(max, findMaxPathSumMetricsVariableStartRecursive(arr, 0, i));
        System.out.println("findMaxPathSumMetricsVariableStartRecursive==> "+max);
        max= MIN_NUMBER;
        for(int i=0;i<N;i++){
            for(int x=0;x<N;x++) for(int y=0;y<N;y++) dp[x][y]=-1;
            max = Math.max(max, findMaxPathSumMetricsVariableStartRecursiveDP(arr, 0, i,dp));
            
        }
        System.out.println("findMaxPathSumMetricsVariableStartRecursiveDP==> "+max);
        max= MIN_NUMBER;
       
            for(int x=0;x<N;x++) for(int y=0;y<N;y++) dp[x][y]=0;
            max = Math.max(max, findMaxPathSumMetricsVariableStartIterativeDP(arr,dp));
            
        
        System.out.println("findMaxPathSumMetricsVariableStartIterativeDP==> "+max);
    }

    public static void main(String[] args) {
        new MaxPathSumMetricsVariableStart();
    }

   private int findMaxPathSumMetricsVariableStartRecursive(int[][] arr,int x,int y){
    if(y > N-1 || y <0) return MIN_NUMBER;
    
    if(x ==N-1 ) return arr[x][y];

        int left=MIN_NUMBER,right=MIN_NUMBER,up=MIN_NUMBER;

        left = arr[x][y]+findMaxPathSumMetricsVariableStartRecursive(arr, x+1, y-1);
        right = arr[x][y]+findMaxPathSumMetricsVariableStartRecursive(arr, x+1, y+1);
        up = arr[x][y]+findMaxPathSumMetricsVariableStartRecursive(arr, x+1, y);

        return Math.max(up, Math.max(left, right));
    }  

    private int findMaxPathSumMetricsVariableStartRecursiveDP(int[][] arr,int x,int y,int[][] dp){
        if(y > N-1 || y <0) return MIN_NUMBER;
        
        if(x ==N-1 ) return arr[x][y];

        if(dp[x][y] !=-1) return dp[x][y];
    
            int left=MIN_NUMBER,right=MIN_NUMBER,up=MIN_NUMBER;
    
            left = arr[x][y]+findMaxPathSumMetricsVariableStartRecursiveDP(arr, x+1, y-1,dp);
            right = arr[x][y]+findMaxPathSumMetricsVariableStartRecursiveDP(arr, x+1, y+1,dp);
            up = arr[x][y]+findMaxPathSumMetricsVariableStartRecursiveDP(arr, x+1, y,dp);

            dp[x][y] = Math.max(up, Math.max(left, right));
    
            return dp[x][y];
        }  

        private int findMaxPathSumMetricsVariableStartIterativeDP(int[][] arr,int[][] dp){
            for(int x=0;x<N;x++) dp[0][x] = arr[0][x];
            for(int x=1;x<N;x++) {
                int left=MIN_NUMBER,right=MIN_NUMBER,up=MIN_NUMBER;
                for(int y=0;y<N;y++) {
                    if(y>0 ) left = arr[x][y]+dp[x-1][y-1];
                    if(y<N-1 )right = arr[x][y]+dp[x-1][y+1];
                    up = arr[x][y]+dp[x-1][y];
        
                    dp[x][y] = Math.max(up, Math.max(left, right));
                }
            }
            int max= MIN_NUMBER;
            for(int x=0;x<N;x++) max = Math.max(max,dp[N-1][x]);
                return max;
            }

  
}

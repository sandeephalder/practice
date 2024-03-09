public class NinjaTraining {


    NinjaTraining(){
        int[][] arr = {{1,2,5},{3,1,1},{7,3,3}};
        System.out.println(" ninjaTrainingRecursive ==> "+ninjaTrainingRecursive(arr, 2, -1));
        int[][] dp =new int[3][3];
        for(int i=0;i<3;i++) for(int j=0;j<3;j++) dp[i][j] = -1;
        System.out.println(" ninjaTrainingRecursiveDP ==> "+ninjaTrainingRecursiveDP(arr, 2, 2,dp));
        System.out.println(" ninjaTrainingIterationDP ==> "+ninjaTrainingIterationDP(arr,dp));
    }

    public static void main(String[] args) {
        new NinjaTraining();
    }

   

    private int ninjaTrainingRecursive(int[][] arr,int level,int doneWork){
        if(level==0) {
            int m = Integer.MIN_VALUE;
            for(int i=0;i<3;i++){
                if(i!=doneWork) m= Math.max(m, arr[level][i]);
            }
            return m;
        }
       
        int max = Integer.MIN_VALUE,current=Integer.MIN_VALUE;
        for(int i=0;i<3;i++){
            if(i!=doneWork)
            current = ninjaTrainingRecursive(arr,level-1,i) + arr[level][i];
            max= Math.max(current, max);
        }
        return max;
    }

    private int ninjaTrainingRecursiveDP(int[][] arr,int level,int doneWork,int[][] dp){
        if(level==0) {
            int m = Integer.MIN_VALUE;
            for(int i=0;i<3;i++){
                if(i!=doneWork) m= Math.max(m, arr[level][i]);
            }
            return m;
        }
        
        if(dp[level][doneWork]!=-1) return dp[level][doneWork];
        int max = Integer.MIN_VALUE,current=Integer.MIN_VALUE;
        for(int i=0;i<3;i++){
            if(i!=doneWork)
            current = ninjaTrainingRecursive(arr,level-1,i) + arr[level][i];
            max= Math.max(current, max);
        }
        dp[level][doneWork]=max;
        return max;
    }

    private int ninjaTrainingIterationDP(int[][] arr,int[][] dp){
        for(int i=0;i<3;i++) for(int j=0;j<3;j++) 
            dp[i][j] = 0;
        dp[0][0] = Math.max(arr[0][1],arr[0][2]);
        dp[0][1] = Math.max(arr[0][0],arr[0][2]);
        dp[0][2] = Math.max(arr[0][1],arr[0][0]);
       
        int maxlevel=Integer.MIN_VALUE;
        for(int level=1;level<3;level++){
            
            for(int last =0;last<3;last++){
                int max = Integer.MIN_VALUE,current=Integer.MIN_VALUE;
                for(int task =0;task<3;task++){
                    if(task!=last)
                    current = dp[level-1][task] + arr[level][task];
                    max= Math.max(max, current);
                }
                dp[level][last]=max;
            }
            
           
           
        }
        for(int i:dp[2]) maxlevel = Math.max(maxlevel, i);
        return maxlevel;
    }

}

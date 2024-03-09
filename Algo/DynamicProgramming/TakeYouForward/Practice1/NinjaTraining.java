public class NinjaTraining {
    //int input[][] = {{10 ,40 ,70},{20 ,50, 80},{30 ,60, 90}},N=3,K=3,buffer[][];
    int input[][] = {{ 10, 40 ,70},{20, 50, 80},{30 ,60 ,90}},N=3,K=3,buffer[][];
     
   


    
    public static void main(String[] args) {
        new NinjaTraining();
    }

    NinjaTraining(){
        int results= ninjaTraining(N-1,K,input,initBuffer());
        System.out.println(results);
    }

    int[][] initBuffer(){
        buffer = new int[N+1][K+1]; 
        for(int i =0;i<=N;i++)
        for(int j=0;j<=K;j++)
        buffer[i][j]=-1;
        return buffer;
    }

    private int ninjaTraining(int day,int level,int[][] input,int[][] buffer){
        if(day==0){
            int max=0;
            for(int i=0;i<K;i++){
                if(i!=level)
                max = Math.max(input[0][i], max);
            }
            return max;
        }
        if(buffer[day][level] != -1) return buffer[day][level];
        int max=0;
        for(int i=0;i<K;i++){
            if(i!=level){
                int point = input[day][i] +ninjaTraining(day-1,i,input,buffer);
                max = Math.max(point, max);
            }
           
        }
        buffer[day][level]=max;
        return max;
    }
}

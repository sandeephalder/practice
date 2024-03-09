public class NinjaTrainingIterator {
   // int input[][] = {{ 10, 40 ,70},{20, 50, 80},{30 ,60 ,90}},N=3,K=3,buffer[][];
    int input[][] = {{ 1, 2 ,5},{3, 1, 1},{3, 3, 3}},N=3,K=3,buffer[][];
     
     
    
    
    public static void main(String[] args) {
        new NinjaTrainingIterator();
    }

    NinjaTrainingIterator(){
        int results= ninjaTraining(input,initBuffer());
        System.out.println(results);
    }

    int[][] initBuffer(){
        buffer = new int[N+1][K+1]; 
        for(int i =0;i<=N;i++)
        for(int j=0;j<=K;j++)
        buffer[i][j]=-1;
        return buffer;
    }

    private int ninjaTraining(int[][] input,int[][] buffer){
        

        buffer[0][0]=Math.max(input[0][1], input[0][2]);
        buffer[0][1]=Math.max(input[0][0], input[0][2]);
        buffer[0][2]=Math.max(input[0][1], input[0][0]);
        buffer[0][3]=Math.max(Math.max(input[0][1], input[0][2]),buffer[0][1]);
        
        for(int day=1;day<N;day++){
            for(int level =0;level<K+1;level++){
                buffer[day][level]=0;
                for(int task=0;task<K;task++){
                    if(task!=level){
                        int point = input[day][task] +buffer[day-1][task];
                        buffer[day][level] = Math.max(point, buffer[day][level]);
                    }
                   
                }

                            }
       
       
        
    }
        
        return buffer[N-1][K];
    }
}



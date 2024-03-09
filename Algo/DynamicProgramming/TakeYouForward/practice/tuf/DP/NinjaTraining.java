package tuf.DP;

import java.util.Arrays;

public class NinjaTraining {

    int[][] training = {{10,40,70},{20,50,80},{30,60,90}};
    //int[][] training = {{10,50,1},{5,100,11}};
    int DAYS = training.length-1;
    int SUBJECTS = training[0].length-1;
    int[][] dp = new int[DAYS+2][SUBJECTS+2];


    public static void main(String[] args) {
        new NinjaTraining();
    }

    NinjaTraining(){
        for(int i=0;i<=DAYS;i++) Arrays.fill(dp[i], -1);
        int max =Integer.MIN_VALUE;
        //for(int i=0;i<=SUBJECTS;i++) max = Math.max(max,findBestTraining(training, dp, 0, i));
        max = findBestTrainingIteration(training);
        System.out.println(max);

        max = findBestTrainingIterationEfficient(training);
        System.out.println(max);

        
    }

    private int findBestTraining(int[][] training,int[][] dp,int day,int subject){
        if(day>DAYS) return 0;
        if(dp[day][subject]!=-1) return dp[day][subject];
        int max = 0,s=0;
        for(int sub=0;sub<=SUBJECTS;sub++){
            s= 0;
            if(sub==subject) continue;
            s = findBestTraining(training, dp, day+1, sub) + training[day][sub];
            max = Math.max(max,s);
        }
        dp[day][subject]=max;
        return max;
    }

    private int findBestTrainingIteration(int[][] training){
      for(int i=0;i<=DAYS;i++) Arrays.fill(dp[i], 0);
      
      dp[0][0] = Math.max(training[0][1],training[0][2]); 
      dp[0][1] = Math.max(training[0][0],training[0][2]); 
      dp[0][2] = Math.max(training[0][1],training[0][0]); 
      dp[0][3] = Math.max(training[0][1],Math.max(training[0][2], training[0][0]));     

      for(int day=1;day<=DAYS;day++){
         for(int current=0;current<=SUBJECTS;current++){
            dp[day][current] = 0;
            for(int prev=0;prev<=SUBJECTS;prev++){
                if(prev==current) continue;
                int s = training[day][prev] + dp[day-1][prev];
                dp[day][current] = Math.max(dp[day][current], s);
            }
         }
      }

      return dp[DAYS][SUBJECTS];
    }

    private int findBestTrainingIterationEfficient(int[][] training){
        int[] prev = new int[SUBJECTS+2];
        for(int i=0;i<=DAYS;i++) Arrays.fill(prev, 0);
        
        prev[0] = Math.max(training[0][1],training[0][2]); 
        prev[1] = Math.max(training[0][0],training[0][2]); 
        prev[2] = Math.max(training[0][1],training[0][0]); 
        prev[3] = Math.max(training[0][1],Math.max(training[0][2], training[0][0]));     
        int[] temp = new int[SUBJECTS+2];
        for(int day=1;day<=DAYS;day++){
           Arrays.fill(temp,0);
           for(int current=0;current<=SUBJECTS;current++){
              temp[current] = 0;
              for(int pre=0;pre<=SUBJECTS;pre++){
                  if(pre==current) continue;
                  int s = training[day][pre] + prev[pre];
                  temp[current] = Math.max(dp[day][current], s);
              }
           }
        }
  
        return temp[SUBJECTS];
      }

}

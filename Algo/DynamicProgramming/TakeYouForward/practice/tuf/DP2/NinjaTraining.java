package DP2;

import java.util.Arrays;

public class NinjaTraining {
    int[][] points = {{10, 40, 70},
                          {20, 50, 80},
                          {30, 60, 90}};

   //  int[][] points = {{10, 50, 1},
    //                      {50, 100, 11}};

                    
    public static void main(String[] args) {
        new NinjaTraining();
    }

    NinjaTraining(){
        int n = points.length; // Get the number of days
        System.out.println("Recursive : "+ninjaTraining(n, points)); 
        System.out.println("Iterative: "+findTrainingIterative(points));
        System.out.println("Iterative Efficient : "+findTrainingIterativeEfficient(points));
        
    }

       private int ninjaTraining(int n, int[][] points) {
        // Initialize a memoization table with -1 values
        int dp[][] = new int[n][4];
        for (int[] row : dp)
            Arrays.fill(row, -1);

        return findTraining(points, dp, 0,1);
    }

    private int findTraining(int[][] points,int[][] dp,int day,int prevTraining){
        int DAY=points.length,SUBJECT=points[0].length;
        if(day>=DAY){
            return 0;
        }
        int maxPoint=0;
        for(int subject=0;subject<SUBJECT;subject++){
            if(subject==prevTraining) continue;
            int l= findTraining(points, dp, day+1, subject) + points[day][subject];
            maxPoint = Math.max(maxPoint, l) ;
            dp[day][subject] = l;
        }
        
        return maxPoint;
    }

    private int findTrainingIterative(int[][] points){
        int DAY=points.length,SUBJECT=points[0].length;
        int dp[][] = new int[DAY][SUBJECT];
        
        for(int day=0;day<DAY;day++){
            int maxPoint=0;
            for(int subject=0;subject<SUBJECT;subject++){
            
            int l=  points[day][subject];
            if(day>0) l += findMax(dp, DAY, SUBJECT, day, subject);
            if(Math.max(maxPoint, l)>maxPoint){
                maxPoint =  l;
                //System.out.println("Day "+day+" prevSubject "+prevSubject);
            }
            
            dp[day][subject] = l;
        }
        }
        return dp[DAY-1][1];
    }

     private int findTrainingIterativeEfficient(int[][] points){
        int DAY=points.length,SUBJECT=points[0].length;
        int current[] = new int[SUBJECT];
        int prev[] = new int[SUBJECT];
        
        for(int day=0;day<DAY;day++){
            int maxPoint=0;
            for(int subject=0;subject<SUBJECT;subject++){
            
            int l=  points[day][subject];
            if(day>0) l += findMaxEfficient(prev, DAY, SUBJECT, day, subject);
            if(Math.max(maxPoint, l)>maxPoint){
                maxPoint =  l;
                //System.out.println("Day "+day+" prevSubject "+prevSubject);
            }
            
            current[subject] = l;
        }
        for(int subject=0;subject<SUBJECT;subject++) prev[subject]=current[subject];
        }
        return current[1];
    }

    private int findMax(int[][] dp,int DAY,int SUBJECT,int day,int subject){
        int max=0;
        for(int s=0;s<SUBJECT;s++){
            if(s==subject) continue;
            max = Math.max(max, dp[day-1][s]);
        }
        return max;
    }

    private int findMaxEfficient(int[] dp,int DAY,int SUBJECT,int day,int subject){
        int max=0;
        for(int s=0;s<SUBJECT;s++){
            if(s==subject) continue;
            max = Math.max(max, dp[s]);
        }
        return max;
    }
}

package GreedyAlgo;


import java.util.*;

public class JobScheduling {

    static class Job implements  Comparable<Job>{
        int id,dueDate,reward;

        

        public Job(int[] s) {
            this.id = s[0];
            this.dueDate = s[1];
            this.reward = s[2];
        }

        public int[] getArray(){
            int[] c = new int[2];
            c[0]= this.id;
            c[1]= this.dueDate;
            c[2]= this.reward;
            return c;
        }



        @Override
        public String toString() {
            return "Job [id=" + id + ", dueDate=" + dueDate + ", reward=" + reward + "]";
        }

        @Override
        public int compareTo(Job that) {
            return Integer.compare(that.reward, this.reward);
        }
        
    }

    static int[][] Jobs = {{1, 1, 30}, {2, 3, 40}, {3, 2, 10}};

    public static void main(String[] args) {
       print(jobScheduling(Jobs));
    }

    public static int[] jobScheduling(int [][]jobs) {
        int maxTime=0,jobsCount=0,profit=0;
        List<Job> j = new ArrayList<>();
        for(int[] i:jobs) {
            maxTime= Math.max(maxTime, i[1]);
            j.add(new Job(i));
        }
        Collections.sort(j);
        System.out.println(j);
        int[] calculate = new int[maxTime];
        Arrays.fill(calculate,0);
        for(Job job:j){
            int dueDate=job.dueDate-1;
            while(dueDate>-1 && calculate[dueDate]!=0) dueDate--;
            if(calculate[dueDate]==0) {
                calculate[dueDate]= job.reward;
                jobsCount++;
                profit+=job.reward;
            }

        }
        int[] result = new int[2];
        result[0]=jobsCount;
        result[1]=profit;
        return result;
    }

    private static void print(int[] res){
        System.out.println();
        System.out.println(" Jobs= "+res[0]+" Profit= "+res[1]);
    }
}

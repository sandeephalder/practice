package GreedyAlgo;

import java.util.Arrays;

import GreedyAlgo.FractionalKnapShack.Item;

public class MaxMeetings {
   static  class Task implements  Comparable<Task>{
        int start,end,pos;

        

        public Task(int start, int end, int pos) {
            this.start = start;
            this.end = end;
            this.pos = pos;
        }

       

        @Override
        public String toString() {
            return "Task [start=" + start + ", end=" + end + ", pos=" + pos + "]";
        }



        @Override
        public int compareTo(Task o2) {
            
            if (end < o2.end)
            return -1;
            else if (end > o2.end)
            return 1;
            else if(pos < o2.pos)
            return -1;
            return 1; 
        }
        
    }
    public static void main(String[] args) {
       int[] start= {668, 300 ,36 ,895 ,704},
        end = {1480 ,623 ,370 ,1569 ,1369 };
        System.out.println(maximumMeetings(start, end));
    }

    public static int maximumMeetings(int []start, int []end) {
        Task[] tasks =sort(start, end);
        int meetings=1,s=tasks[0].start,e=tasks[0].end,N=start.length;
      
        for(int i=1;i<N;i++){
            if(e>=tasks[i].start){
                continue;
            }
            else {
                meetings++;
                s=tasks[i].start;
                e=tasks[i].end;
            }
        }
        return meetings;
    }

    public static Task[] sort(int []start, int []end){
        int N= start.length;
        Task[] task = new Task[N];
        for(int i=0;i<N;i++){
            task[i]= new Task(start[i], end[i],i+1);
        }
        Arrays.sort(task);
        print(task);
        return task;
    }


    public static void print(Task[] arr){
        System.out.println();
        for(Task i:arr) System.out.print(" ==> "+i);
    }
}

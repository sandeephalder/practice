public class ClimbingStairs {
    int dpBuffer[] = new int[11];
    public static void main(String[] args) {
        new ClimbingStairs();
    }

    ClimbingStairs(){
        for(int i=0;i<11;i++)
        {
            dpBuffer[i]=-1;
        }
        System.out.println(climbingStairs(10));
    }

    int climbingStairs(int stairs){
        if(stairs<2) return stairs;
        if(dpBuffer[stairs]!=-1) return dpBuffer[stairs];
        int result = climbingStairs(stairs-1) + climbingStairs(stairs-2);
        dpBuffer[stairs]=result;
        return result ;
    }
}

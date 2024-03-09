public class ClimbingKStairs {
    int dpBuffer[] = new int[11];
    int k= 3;
    public static void main(String[] args) {
        new ClimbingKStairs();
    }

    ClimbingKStairs(){
        for(int i=0;i<11;i++)
        {
            dpBuffer[i]=-1;
        }
        System.out.println(climbingKStairs(10));
    }

    int climbingKStairs(int stairs){
        
        if(stairs<2) return stairs;
        if(dpBuffer[stairs]!=-1) return dpBuffer[stairs];
        
        int result =0;
        for(int i=0;i<k;i++){
            
        
                result += climbingKStairs(stairs-i-1); 
        
            
        }
        
        dpBuffer[stairs]=result;
        return result ;
    }
}

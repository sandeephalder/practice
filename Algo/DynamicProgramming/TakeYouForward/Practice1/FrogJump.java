
public class FrogJump {
    int dpBuffer[] = new int[11];
    int jump[] = {30,10,60,10,60,50};
    public static void main(String[] args) {
        new FrogJump();
    }

    FrogJump(){
        for(int i=0;i<11;i++)
        {
            dpBuffer[i]=-1;
        }
        System.out.println(jumpStairs(5));
        
    }

    int jumpStairs(int stairs){
        if(stairs<2) return stairs;
        if(dpBuffer[stairs]!=-1) return dpBuffer[stairs];
        int left=Integer.MAX_VALUE,right=Integer.MAX_VALUE,result;
        left = Math.abs(jump[stairs]-jump[stairs-1]) + jumpStairs(stairs-1);
        if (stairs > 1)
        right=  Math.abs(jump[stairs]-jump[stairs-2]) + jumpStairs(stairs-2);
        result = Math.min(left, right) ;
        dpBuffer[stairs]=result;
        return result ;
    }
}

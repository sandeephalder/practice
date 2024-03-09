
public class FrogJumpIterator {
    int dpBuffer[] = new int[11];
    int jump[] = {30,10,60,10,60,50};
    public static void main(String[] args) {
        new FrogJumpIterator();
    }

    FrogJumpIterator(){
        for(int i=0;i<11;i++)
        {
            dpBuffer[i]=-1;
        }
        System.out.println(jumpStairs(6));
        
    }

    int jumpStairs(int stairs){
     
        int prev1=0,prev2=0,current=0,l,r;
        for(int i=1;i<stairs;i++){
            l = Math.abs(jump[i]-jump[i-1])  + prev1;
            r= Integer.MAX_VALUE;
            if(i>1)
            r = Math.abs(jump[i]-jump[i-2])  + prev2;
            current = Math.min(l, r) ;
            prev2=prev1;
            prev1=current;
        }
        return prev1 ;

    }
}

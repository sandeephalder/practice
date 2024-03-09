package bitmanupulation;

public class intro {
    int N = 8,i=2;
    public static void main(String[] args) {
        new intro();
    }

    intro(){
        System.out.println(" Get Bit "+getBit(N, i));
        System.out.println(" Set Bit "+setBit(N, i));
        System.out.println(" Remove Bit "+removeBit(N, i));
        System.out.println(" isOdd "+isOdd(N, i));
        System.out.println(" Check if power of 2 "+checkIfPowerof2(N));
        System.out.println(" Count number of set bits "+countNumberofSetBits(N));
        System.out.println(" Set Righter Bits "+setRighterBits(N));
        System.out.println(" Swap Numbers ");
        swapNumbers(2,3);
    }

    public int getBit(int val,int index){
        int right =index-1;
        return (val>>right)&1;
    }

    public int setBit(int val,int index){
        return val|(1<<index-1);
    }

    public int removeBit(int val,int index){
        int res =val;
        if(getBit(val, index)==1) res=val^(1<<(index-1));
        return res;
    }

    public boolean isOdd(int val,int index){
        return (val&1)==1;
    }

    public boolean checkIfPowerof2(int val){
        int res=0;
        for(int i=0;i<32;i++) if(getBit(val, i)==1) res++;
        return res==1;
    }

    public int countNumberofSetBits(int val){
        int res=0;
        for(int i=0;i<32;i++) if(getBit(val, i)==1) res++;
        return res;
    }

    public int setRighterBits(int val){
        int res=0;
        for(int i=0;i<32;i++) 
        if(getBit(val, i)==0) {
            res = val | (1<<(i));
            break;
        }
        return res;
    }

    public void swapNumbers(int a,int b){
        a = a^b;
        b = a^b;
        a = a^b;
        System.out.println(" a= "+a+" b= "+b);
    }

    public int minBitFlips(int start, int goal) {
        int s = start^goal,res=0;
        for(int i=0;i<32;i++) if(getBit(s, i)==1) res++;
        return res;
    }
}

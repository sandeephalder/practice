class Fibinacchi{
    private final int FIB =10;
    private int[] dpBuffer = new int[11];
    public static void main(String[] args) {
        
       new Fibinacchi();
    }

    Fibinacchi(){
        for (int i=0;i<11;i++)
        dpBuffer[i]=-1;
        fib(FIB);
        
    }

    private int fib(int num){
        if(num < 2){
            System.out.println(" ==> "+num);
            return num;
        }
       
        if(dpBuffer[num]!=-1)
        return dpBuffer[num];
        int res = fib(num-1)+fib(num-2);
        dpBuffer[num]=res;
        System.out.println(" ==> "+res);
        return res;
    }
}
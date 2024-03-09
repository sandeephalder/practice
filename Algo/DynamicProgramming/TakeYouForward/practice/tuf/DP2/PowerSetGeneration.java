package DP2;

public class PowerSetGeneration {
    char[] cha = {'a','b','c','d','e'};
    int size=5,I=1<<size;
    public static void main(String[] args) {
        new PowerSetGeneration();
    }

    PowerSetGeneration(){
        
        for(int i=0;i<=I;i++){
            int[] arr = new int[size];
            String res= "";
            for(int y=0;y<size;y++){
                if((i&(1<<y))==(1<<y)) arr[y]=1;
            }

            for(int y=0;y<size;y++)
            {
                if(arr[y]==1) res+=cha[y];
                //System.out.println("y= "+y+" "+arr[y]);
            }
            

            System.out.println(res);
        }
    }
}

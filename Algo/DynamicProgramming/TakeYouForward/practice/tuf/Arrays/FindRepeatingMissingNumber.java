package Arrays;

public class FindRepeatingMissingNumber {

    static int[] arr = {1, 2, 1};

    public static void main(String[] args) {
        int[] result = findMissingRepeatingNumbers(arr);
        System.out.println(" a = "+result[0]+" b= "+result[1]);
    }
    
    public static int[] findMissingRepeatingNumbers(int[] arr) {
        int n= arr.length;
        long nsum=(n*(n+1))/2,nsqueqre= ((n*(n+1)*(2*n+1))/6),aplusb=0,a2minusb=0,aminusb=0,tsum=0,tsqueare=0,a=0,b=0;
        for(int i:arr) {
            tsum += i;
            tsqueare += i*i;
        }
        
        aminusb = nsum - tsum;
        a2minusb = nsqueqre -  tsqueare;
        aplusb = a2minusb/aminusb;
        a = (aplusb+aminusb)/2;
        b= aplusb-a;
        int[] res = new int[2];
        res[1]=(int)a;
        res[0]=(int)b;
        return res;
    }
}

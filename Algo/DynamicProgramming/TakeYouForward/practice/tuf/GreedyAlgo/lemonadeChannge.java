package GreedyAlgo;

public class lemonadeChannge {


    public static void main(String[] args) {
        int bill[] = {
            5 ,10,5 ,10, 5 ,20, 20 };
        System.out.println(lemonadeChange(bill));
    }

    public static boolean lemonadeChange(int []bill) {
        int five=0,ten=0;
        boolean ans=true;
        for(int i:bill){
            System.out.println("Bill "+i);
            if(i==5) five++;
            else if(i==10) {
               
                if(five<1) return false;
                ten++;
                five--;
                System.out.println(" in  10 index "+i+" five= "+five);
            }
            else{
                
                if(ten<1 && five <3 || five<1) return false;
                if(ten>=1){
                ten--;
                five--;
                }
                else five -=3;
                System.out.println(" in  20 index "+i+" five= "+five+" ten= "+ten);
            }
        }
        return ans;
    }
}

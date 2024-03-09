package recursion2;

public class FindAllOperations {

    String number ="247";
    int target= 3;
    public static void main(String[] args) {
        new FindAllOperations();
    }

    FindAllOperations(){
        System.out.println(findAllOperations(number, 0, 0));
    }

    private boolean findAllOperations(String number,int index,int total){
        if(total==target) {
            System.out.println(total);
            return true;
        }

        if(index>=number.length()){
            return false;
        }
        
        int inum = Integer.parseInt(number.charAt(index)+"");

        for(int i=0;i<3;i++){
            if(i==0) total += inum;
            if(i==1) total -= inum;
            if(i==2) total *= inum;
            if(findAllOperations(number, index+1, total)) return true;
        }

        return false;

    }
}

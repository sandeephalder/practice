public class MinimumInsertionsStringAToB {
    public static void main(String[] args) {
        new MinimumInsertionsStringAToB();
    }
    MinimumInsertionsStringAToB(){
        String s1 = "abcd";
        String s2 ="abcd";
        int i=s1.length(),j=s2.length();

        int result = 0;
        result = findMinimumInsertionsStringAToBRecursion(s1, s2, i-1, j-1);
        result = (i+ j) - (2*result);
        System.out.println(" findMinimumInsertionsStringAToBRecursion  "+result);
    }

    private int findMinimumInsertionsStringAToBRecursion(String s1,String s2,int i,int j){
        int result =0;
        if(i<0||j<0) return 0;

        if(s1.charAt(i)==s2.charAt(j)){
            result = findMinimumInsertionsStringAToBRecursion(s1, s2, i-1, j-1)+1;
        }
        else{
            result = Math.max(findMinimumInsertionsStringAToBRecursion(s1, s2, i-1, j), 
            findMinimumInsertionsStringAToBRecursion(s1, s2, i, j-1));
        }
        return result;
    }
}

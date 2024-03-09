package tuf.recursion;

public class Checkpalindrome {
    Checkpalindrome(){
        String str = "maDam";
        System.out.println(checkIfPalindrome(str,0));
    }

    public static void main(String[] args) {
        new Checkpalindrome();
    }

    private boolean checkIfPalindrome(String str,int i){
        int j= str.length()-1-i;

        if(i>=j) return true;

        if(!checkpalindrome(str, i, j)) return false;

        boolean result  = checkIfPalindrome(str, i+1);

        return result;
    }

    private boolean checkpalindrome(String str,int src,int dest){
        System.out.println(src+" compare "+dest);
        return str.charAt(src) == str.charAt(dest);
    }
}

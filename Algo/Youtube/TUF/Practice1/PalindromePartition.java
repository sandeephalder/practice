import java.util.ArrayList;
import java.util.List;

public class PalindromePartition {
    public static void main(String[] args) {
        new PalindromePartition();
    }
    PalindromePartition(){
        String string = "abba";
        partitionPalindrome(0,string, new ArrayList<String>());
    }

    private void partitionPalindrome(int index,String str,List<String> path){
        if(index== str.length()) {
            System.out.println(path);
            return;
        }

        for(int i=index;i<str.length();i++){
            if(isPalindrome(str,index,i)){
                path.add(str.substring(index, i+1));
                partitionPalindrome(i+1,str,path);
                path.remove(path.size()-1);
            }
        }
    }

    private boolean isPalindrome(String str,int start, int end){
        while(end>start){
            if(str.charAt(start++)!=str.charAt(end--)) return false;
        }
        return true;
    }
}

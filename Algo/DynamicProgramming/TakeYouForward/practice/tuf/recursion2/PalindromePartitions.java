package recursion2;

import java.util.*;

public class PalindromePartitions {

    String input ="aaaa";
    public static void main(String[] args) {
        new PalindromePartitions();
    }

    PalindromePartitions(){
        List<List<String>> result = new ArrayList<>();
        findAllCombinations(input, 0, new ArrayList<>(), result);
        System.out.println(result);
    }
    
    private void findAllCombinations(String ip,int index,List<String> level,List<List<String>> result){
        if(index>=ip.length()){
            result.add(new ArrayList<>(level));
            return;
        }

        for(int i=index;i<ip.length();i++){
            String str = ip.substring(index, i+1);
            if(!isPalindrome(str)) continue;
            level.add(str);
            findAllCombinations(ip, i+1, level, result);
            level.remove(level.size()-1);
        }
    }

    private boolean isPalindrome(String str){
        if(Objects.isNull(str) || str.length()==0) return false;
        for(int i=0;i<str.length()/2;i++){
            if(str.charAt(i)!=str.charAt(str.length()-1-i)) return false;
        }
        return true;
    }

}

package recursion2;

import java.util.*;


public class WordBreak {

    String s = "penapple";

    String[] dict={"apple","pen"};

    public static void main(String[] args) {
        new WordBreak();
    }

    WordBreak(){
        System.out.println(wordBreak(s, Arrays.asList(dict)));
    }

    public boolean wordBreak(String s, List<String> wordDict) {

        Set<String> uniqueDict = new HashSet<>(wordDict);
        
        return wordBreakFind(s, uniqueDict, 0);
    }

    public boolean wordBreakFind(String s,Set<String> uniqueDict,int index) {
        if(uniqueDict.contains(s)){

            return true;
        }
        boolean result =false;
        for(int i=index;i<s.length();i++){
            String first = s.substring(0, i);
            String second = s.substring(i, s.length());
            
            if(!uniqueDict.contains(first)) continue;
            System.out.println("first= "+first+" second= "+second+" index= "+index);
            if(wordBreakFind(second, uniqueDict, 0)) return true;
        }
        return result;
    }
}

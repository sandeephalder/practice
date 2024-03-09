package tuf.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder1 {

    String[] strings = {"hot","dot","dog","lot","log","cog"};
    String beginWord = "hit", endWord = "cog";
    public static void main(String[] args) {
        new WordLadder1();
    }

    WordLadder1(){
        System.out.println(ladderLength(beginWord, endWord, Arrays.asList(strings)));
        /*Set<String> sets = new HashSet<>();
        sets.addAll(Arrays.asList(strings));
        
        System.out.println(findMatchingStrings(strings[4], sets));*/
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int level=1;
        Set<String> sets = new HashSet<>();
        sets.addAll(wordList);
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        while(!queue.isEmpty()){
            int N = queue.size();
            List<String> levelStrings  = new ArrayList<>();
            level++;
            for(int i=0;i<N;i++){
                String node = queue.poll();
                
                if(sets.contains(node)) sets.remove(node);
                levelStrings.addAll(findMatchingStrings(node, sets));
            }
            for(String n:levelStrings) {
                
                if(n.equals(endWord)) {
                    System.out.println(n+" ==> "+level);
                    return level;
                }
                queue.offer(n);
            }
        }
        return 0;
    }


    public List<String> findMatchingStrings(String string,Set<String> sets){
        List<String> result = new ArrayList<>();
        int N = string.length();
        char c ='a';
        for(int i=0;i<N;i++){
            for(int chars=0;chars<26;chars++)
             {
                String temp = string.substring(0,i)+String.valueOf((char)(c+chars))+string.substring(i+1, N);
                if(sets.contains(temp)) result.add(temp);
             }
            
        }
        return result;
    }


}

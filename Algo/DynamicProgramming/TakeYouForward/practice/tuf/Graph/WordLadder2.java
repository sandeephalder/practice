package tuf.Graph;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder2 {

    class Node{
        List<String> nodes = new ArrayList<>();
        int level=0;
        public String getLatestNode(){
            if(!nodes.isEmpty()){
                return nodes.get(nodes.size()-1);
            }
            return null;
        }
    }
    
String[] strings = {"hot","dot","dog","lot","log","cog"};
    String beginWord = "hit", endWord = "cog";
    public static void main(String[] args) {
        new WordLadder2();
    }

    WordLadder2(){
        System.out.println(ladderLength(beginWord, endWord, Arrays.asList(strings)));
        /*Set<String> sets = new HashSet<>();
        sets.addAll(Arrays.asList(strings));
        
        System.out.println(findMatchingStrings(strings[4], sets));*/
    }

    public List<List<String>> ladderLength(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new LinkedList<>();
        Set<String> sets = new HashSet<>();
        sets.addAll(wordList);
        Queue<Node> queue = new LinkedList<>();
        Node begainNode = new Node();
        begainNode.nodes.add(beginWord);
        begainNode.level=1;
        queue.offer(begainNode);
        while(!queue.isEmpty()){
            Node node = queue.poll();
            String nodeString = node.getLatestNode();
            int level = node.level;
            sets.remove(nodeString);
            for(String n:findMatchingStrings(nodeString,sets)){
                Node newNode = new Node();
                newNode.nodes.addAll(node.nodes);
                newNode.nodes.add(n);
                newNode.level=level+1;
                queue.offer(newNode);
                if(n.equals(endWord)) result.add(newNode.nodes);
            }
        }
        return result;
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

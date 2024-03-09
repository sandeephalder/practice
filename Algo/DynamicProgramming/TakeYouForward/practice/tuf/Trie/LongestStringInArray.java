package tuf.Trie;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class LongestStringInArray{

    String[] input = {"aa","abab","sds","abc"};

    public static void main(String[] args) {
        new LongestStringInArray();
    }
    
  class Node{
    final int SIZE= 128;
    Node[] next;
    boolean isEnd;

    Node(){
      next = new Node[SIZE];
      isEnd=false;
    } 
  }

  Node root;

  LongestStringInArray(){
    root = new Node();
    Map<Integer,Integer> count=new HashMap<>();
    
    for(String ip:input){
      count.put(0,1);
      root = new Node();
    for(int i=0;i<ip.length();i++){
      insert(ip.substring(i),count);
    } 
    System.out.println(count);
    }

  }


  public void insert(String str,Map<Integer,Integer> count){
    Node node= root;
    int N = str.length();

    for(int i=0;i<N;i++){
      char c = str.charAt(i);
      if(node.next[c]==null) {
        node.next[c]=new Node();
        count.put(0,count.get(0)+1);
      }
      node = node.next[c];
    }
    node.isEnd=true;
  }



}
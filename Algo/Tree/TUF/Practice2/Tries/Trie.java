package Tries;

import java.util.HashMap;
import java.util.Map;

class Trie {

    class Node {
        int MAX = 26;
        Node next[] = new Node[MAX];
        boolean end = false;
    }

    Node root;

    public static void main(String[] args) {
        new Trie();
    }

    Trie() {
      Map<Integer,Integer> map  = new HashMap<>();
      for(int i=0;i<10;i++) map.put(i,i);
    }
}




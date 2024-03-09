public class Trie {
    class TrieNode{
        String value;
        TrieNode[] nodes= new TrieNode[26];
        TrieNode(String value){
            this.value=value;
        }

        public String toString(){
            return "( value=="+value+" )";
        }
    }
    TrieNode root;
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.root= trie.insert(trie.root,"sandeep","halder", 0);
        trie.root = trie.insert(trie.root,"sand","manual", 0);
        
        System.out.println("get "+trie.get(trie.root, "sand", 0));
        System.out.println(trie.startsWith(trie.root, "san", 0));
    }

 
    public TrieNode insert(TrieNode node,String key,String value,int index){
      if(node==null) node= new TrieNode(null);
       
        if(index==key.length()) {
            node.value=value;
            return node;
        }
        node.nodes[charAt(key, index)] = insert(node.nodes[charAt(key, index)], key,value, index+1);
        return node;
    }

    public TrieNode get(TrieNode node,String key,int index){
        if(index==key.length()) return node;
        if(node==null) return node;
        node = get(node.nodes[charAt(key, index)], key, index+1);
        return node;
    }

    public boolean startsWith(TrieNode node,String prefix,int index) {
        System.out.println("startsWith prefix= "+prefix+" index= "+index+" char At "+charAt(prefix, index));
        if(index==prefix.length()) {
            
            if(node.value!=null) return true;
            
            for(TrieNode n:node.nodes){
                if(n!=null) return true;
            }
            
            return false;
        }
        if(node==null) return false;
        if(node.nodes[charAt(prefix, index)]==null) return false;
        return startsWith(node.nodes[charAt(prefix, index)], prefix, index+1);
    }

    private int charAt(String str,int index){
        int N=str.length();
        if(index>=N) return 0;
        return str.charAt(index)-97;
    }

}

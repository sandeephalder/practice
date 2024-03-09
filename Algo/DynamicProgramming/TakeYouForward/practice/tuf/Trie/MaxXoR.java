package tuf.Trie;

public class MaxXoR {

    int[] arr = {3,10,5,25,2,8};

    class Node{
        int value=-1;
        int SIZE=2;
        String endValue="";
        Node next[]= new Node[SIZE]; 
        Node(int value){
            this.value=value;
        }
    }

    Node root;

    public static void main(String[] args) {
        new MaxXoR();
    }
    
    MaxXoR(){ 
        root = new Node(-1); 
        for(int i:arr) insert(numberToBinaryString(i));
        System.out.println(getMaxXoR(numberToBinaryString(5)));
    }

    private String numberToBinaryString(int number){
        return String.format("%08d", Integer.parseInt(Integer.toBinaryString(number)));
    }

    private void insert(String str){
        Node node = root;
        int N = str.length();
        //System.out.println();
        for(int i=0;i<N;i++){
            char c = (char)((char)str.charAt(i)-(char)'0');
            //System.out.print(" ==>"+(int)c);
            if(node.next[c]==null) node.next[c] = new Node(c);
            node = node.next[c];
        }
        node.endValue=str;
    }

    private int getMaxXoR(String str){
        Node node = root;
        int N = str.length();
        System.out.println();
        for(int i=0;i<N;i++){
            char c = (char)((char)str.charAt(i)-(char)'0');
            //System.out.print(" ==>"+(int)c);
        
            if(c==0){
                if(node.next[1]!=null) {
                    node=node.next[1];
                }
                else if(node.next[0]!=null) node=node.next[0];
                //else return -1;
               
            }
            else{
                if(node.next[0]!=null) {
                    node=node.next[0];
                }
                else if(node.next[1]!=null) node=node.next[1];
                //else return -1;
            }
        }
        return Integer.parseInt(node.endValue,2);
    }
}

package tuf.Trie;

public class MaxXoRWithCeling {
    int[] arr = {0,1,2,3,4};
    int[][] query = {{3,1},{1,3},{5,6}};

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
        new MaxXoRWithCeling();
    }
    
    MaxXoRWithCeling(){ 
        root = new Node(-1); 
        for(int i:arr) insert(numberToBinaryString(i));
        for(int[] i: query)
        System.out.println(getMaxXoRCapped(numberToBinaryString(i[0]),numberToBinaryString(i[1])));
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

    private int getMaxXoRCapped(String str,String max){
        Node node = root;
        int N = str.length();
        System.out.println();
        for(int i=0;i<N;i++){
            char c = (char)((char)str.charAt(i)-(char)'0');
            char cap = (char)((char)max.charAt(i)-(char)'0');
        
            if(c==0){
                if(node.next[1]!=null) {
                    node=node.next[1];
                }
                else if(node.next[0]!=null) node=node.next[0];
               
            }
            else{
                if(node.next[0]!=null) {
                    node=node.next[0];
                }
                else if(node.next[1]!=null) node=node.next[1];
               
            }
        }
        return Integer.parseInt(node.endValue,2);
    }
}

package LinkedList;

public class BuildLinkedList {

    Node root;
    
    BuildLinkedList(int[] arr){
        for(int i:arr) buildList(i);
    }

    public Node getRoot(){
        return this.root;
    }

    public void buildList(int val){
        Node node = new Node(val);
        if(root==null) {
            root=node;
            return;
        }
        Node temp =root;
        while(temp.next!=null) temp = temp.next;
        temp.next=node;
    }

    public void print(){
        Node temp =root;
        System.out.println("\nLinked List :");
        while(temp!=null) {
            System.out.print(" ==> "+temp.val);
            temp = temp.next;
        }
    }

    public void print(Node n){
        Node temp =n;
        System.out.println("\nLinked List :");
        while(temp!=null) {
            System.out.print(" ==> "+temp.val);
            temp = temp.next;
        }
    }
}

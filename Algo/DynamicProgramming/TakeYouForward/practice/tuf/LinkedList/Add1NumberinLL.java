package LinkedList;

public class Add1NumberinLL {
    int[] arr = {9,9,9,0};
    public static void main(String[] args) {
        new Add1NumberinLL();
    }

    Add1NumberinLL(){
        BuildLinkedList linkedList = new BuildLinkedList(arr);
        int n = add(linkedList.getRoot());
        Node newn= linkedList.getRoot();
        if(n!=0){
         newn= new Node(n);
            newn.next=linkedList.getRoot();
        }
        linkedList.print(newn);
    }

    private int add(Node root) {
      if(root==null) return 1;

      int carry = add(root.next);
      int val = root.val+carry;
      System.out.println(" carry= "+carry+" val= "+root.val);
      root.val=val%10;
      return val/10;
    }
}

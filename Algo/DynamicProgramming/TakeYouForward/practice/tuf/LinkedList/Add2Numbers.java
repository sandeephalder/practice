package LinkedList;

public class Add2Numbers {
    int[] arr1 = {9,9,9,9};
    int[] arr2 = {1,1,1,1,1};
    public static void main(String[] args) {
        new Add2Numbers();
    }

    Add2Numbers(){
        BuildLinkedList linkedList1 = new BuildLinkedList(arr1);
        BuildLinkedList linkedList2 = new BuildLinkedList(arr2);
        linkedList1.print();
        linkedList2.print();
        Node added  = addTwoNumbers(linkedList1.getRoot(), linkedList2.getRoot());
        linkedList1.print(added);
    }

    public Node addTwoNumbers(Node l1, Node l2) {
        Node added = new Node(0);
        return add(l1, l2, added,0,0).next;
    }

    public Node add(Node l1, Node l2,Node root,int carry,int count) {
        int sum=0,i1=0,i2=0;
        if(l1==null && l2==null) {
            if(carry<=0) return root;
            Node n = new Node(carry);
            root.next=n;
            return root;
        }
        if(l1!=null) {
            i1=l1.val;
        }
        if(l2!=null) {
            i2=l2.val;
        }
        sum=carry+i1+i2;
        System.out.println("\n i1= "+i1+" i2= "+i2+" sum= "+sum +" carry= "+carry+" count= "+count);
        Node node = new Node(sum%10);
        carry = sum/10;
        
        root.next = add(l1!=null?l1.next:null,l2!=null?l2.next:null, node, carry,count+1);
        return root;
    }
}

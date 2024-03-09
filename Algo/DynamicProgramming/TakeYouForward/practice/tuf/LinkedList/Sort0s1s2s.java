package LinkedList;

public class Sort0s1s2s {
    int[] arr = {1,2,0,1,2,1,0,2,0,1,3};
    public static void main(String[] args) {
        new Sort0s1s2s();
    }

    Sort0s1s2s(){
        BuildLinkedList linkedList = new BuildLinkedList(arr);
        linkedList.print();
        Node n = sortList(linkedList.root);
        linkedList.print(n);
    }

    public Node sortList(Node head) {
        Node zeros=new Node(0),one=new Node(0),twos=new Node(0),o=one,tw=twos,z=zeros;
        if(head==null || (head!=null && head.next==null)) return head;
        while(head!=null){
            if(head.val==0) {
                zeros.next=new Node(0);
                zeros=zeros.next;
            }
            else if(head.val==1) {
                one.next=new Node(1);
                one=one.next;
            }
            else if(head.val==2) {
                twos.next=new Node(2);
                twos=twos.next;
            }
            head=head.next;
        }
        zeros.next=o.next;
        one.next= tw.next;
        return z.next;
    }
}

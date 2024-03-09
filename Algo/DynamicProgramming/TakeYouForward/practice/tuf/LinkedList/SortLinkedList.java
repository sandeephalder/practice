package LinkedList;

public class SortLinkedList {
    int[] arr = {-1,5,3,4,0};
    public static void main(String[] args) {
        new SortLinkedList();
    }


    SortLinkedList(){
        BuildLinkedList linkedList = new BuildLinkedList(arr);
        Node n = sort(linkedList.root);
        System.out.println(" Value: "+n.val);
        linkedList.print();
    }

 
  
    public Node sort(Node head) {
        if (head == null || head.next == null)
          return head;
        Node mid = getMidNode(head);

        Node left = sort(head);
        Node right = sort(mid);

        return merge(left, right);
       
      }

     private Node merge(Node left,Node right){
        Node newRoot=new Node(-1),temp=newRoot;;
      
           while(left!=null && right!=null){
          
              if(left.val>right.val){
                temp.next = right;
                temp=temp.next;
                 right=right.next;
             }
             else{
                temp.next = left;
               temp=temp.next;
                left=left.next;
             }
            
           }

           if(right!=null) {
            temp.next = right;
         
           }

            if(left!=null) {
              temp.next = left;
                    
        }         
        return newRoot.next;
    }

  
    private Node getMidNode(Node node){
        Node slow = node,fast=node,prev=null;
        while(fast != null && fast.next!=null){
            prev=slow;
            slow = slow.next;
            fast= fast.next.next;
        }
       
        prev.next=null;
        return slow;
    }
}

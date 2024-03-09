public class MyLinkedList {
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
      
        list.addAtIndex(0,10);
        list.print();
        list.addAtIndex(0,20);
        list.print();
        list.addAtIndex(1,30);
        list.print();
      
       // list.addAtIndex(4, 6);
        System.out.println(list.get(4));
        //list.print();
       
        //list.print();
    }

   
     Node head;
     int index;
     public MyLinkedList() {
         head=null;
         index=0;
     }
     
     public int get(int index) {
         if(index >= this.index || head==null || index <0) return -1;
         Node curr= head;
         for(int i=0;i<index;i++)
           curr=curr.next;
         if(curr==null)
         return -1;
         else return curr.val;
     }

     public void print() {
       if(head==null) {
        System.out.println("\nEmpty List");   
        return;
       };
       System.out.println("\nList ===> ");   
       Node curr= head;
        while(curr!=null){
            System.out.print("==>"+curr.val);
            curr = curr.next;
        }
    }
     
     public void addAtHead(int val) {
         Node node = new Node(val);
         this.index++;
         if(head==null) head = node;
         else {
             node.next=head;
             head=node;
         }
         
     }
     
     public void addAtTail(int val) {
        Node node = new Node(val);
        this.index++;
        if(head==null) head = node;
        else {
            Node curr= head;
            
            while(curr !=null && curr.next!=null){
                curr=curr.next;
            }
            if(curr.next==null){
                curr.next=node;
            }
        }
     }
     
     public void addAtIndex(int index, int val) {
        if(index==0) {
            addAtHead(val);
            return;
        }
        if(index == this.index) {
            addAtTail(val);
            return;
        }
        if(index > this.index || head==null || index <0) return ;
        
        this.index++;
       
        Node curr= head;
        Node node = new Node(val); 
        for(int i=0;i<index-1;i++)
          curr=curr.next;
      
        node.next=curr.next;
        curr.next=node;
     }
     
     public void deleteAtIndex(int index) {
        if(index >= this.index || head==null || index <0) return ;
        this.index--;
        if(index==0 && head.next==null) {
            head =null;
            return;
        }
        if(index==0 && head.next!=null) {
            head =head.next;
            return;
        }
        
        Node curr= head;
       
        for(int i=0;i<index-1;i++)
          curr=curr.next;
      
        if(curr==null || curr.next==null) return;
        else if(curr.next!=null) curr.next=curr.next.next;
       
     }
}
class Node{
    int val;
    Node next;
    Node(int val){
        this.val=val;
    }  
 }
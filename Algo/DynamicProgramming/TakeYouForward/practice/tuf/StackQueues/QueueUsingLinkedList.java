package StackQueues;

public class QueueUsingLinkedList<T> {
    Node<T> root=null;
    int size=0;

    public static void main(String[] args) {
        QueueUsingLinkedList<Double> queue = new QueueUsingLinkedList<>(); 
        queue.offer(1.0);
        queue.offer(2.0);
        queue.offer(3.0);
        queue.offer(4.0);
        queue.offer(5.0);
        queue.offer(6.0);
        queue.offer(7.0);
        queue.offer(8.0);
        System.out.println(" size= "+queue.size()+" capacity= "+queue.capacity());
        queue.print();
        System.out.println(queue.poll());
        queue.print();
        System.out.println(queue.poll());
        queue.print();
        System.out.println(queue.poll());
        queue.print();
        System.out.println(queue.poll());
        queue.print();
        System.out.println(queue.poll());
        queue.print();
        System.out.println(queue.poll());
        queue.print();
        System.out.println(queue.poll());
        queue.print();
        System.out.println(queue.poll());
        queue.print();
        System.out.println(queue.poll());
        queue.print();
        System.out.println(queue.poll());

        queue.offer(1.0);
        queue.print();
        queue.offer(2.0);
        queue.print();
        queue.offer(3.0);
        queue.print();
        queue.offer(4.0);
        queue.print();
        queue.offer(5.0);
        queue.print();
        queue.offer(6.0);
        queue.print();
        queue.offer(7.0);
        queue.print();
        queue.offer(8.0);
        queue.print();
       
    }

    public void offer(T val){
        Node<T> node = new Node<>(val);
        if(root!=null) 
              node.nextNode=root;
          root = node;
        size++;
     }
  
     public void print(){
      Node<T> node = this.root;
      System.out.println();
      while(node!=null){
          System.out.print(" ==> "+node.val);
          node=node.nextNode;
      }
      System.out.println();
     }
  
     public T poll(){
        Node<T> node = this.root;
        Node<T> prev = null;
        T val = null;
        while(node!=null && node.nextNode!=null){
            prev= node;
            node=node.nextNode;
        }
        if(node==null) return null;
        size--;
        if(prev==null) {
            val = root.val;
            root=null;
            return val;
        }
       val = node.val;
        prev.nextNode=null;
        
        return val;
     }
  
     public int size(){
          return this.size;
      }
  
      public int capacity(){
          return this.size;
      }
}

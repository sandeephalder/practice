package StackQueues;



public class StackUsingLinkedList<T> {
    Node<T> root=null;
    int size=0;
    public static void main(String[] args) {
        StackUsingLinkedList<Double> stack = new StackUsingLinkedList<>();
        stack.push(1.0);
        stack.push(2.0);
        stack.push(3.0);
        stack.push(4.0);
        stack.push(5.0);
        stack.push(6.0);
        stack.push(7.0);
        stack.push(8.0);
        System.out.println(" size= "+stack.size());
        stack.print();
        System.out.println(stack.pop());
        stack.print();
        System.out.println(stack.pop());
        stack.print();
        System.out.println(stack.pop());
        stack.print();
        System.out.println(stack.pop());
        stack.print();
        System.out.println(stack.pop());
        stack.print();
        System.out.println(stack.pop());
        stack.print();
        System.out.println(stack.pop());
        stack.print();
        System.out.println(stack.pop());
        stack.print();
        System.out.println(stack.pop());
    }

   public void push(T val){
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

   public T pop(){
    if(root==null) return null;
    size--;
    T val = root.val;
    root=root.nextNode;
    return val;
   }

   public int size(){
        return this.size;
    }

    public int capacity(){
        return this.size;
    }
}

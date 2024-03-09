package StackQueues;

public class Node<T> {
    T val;
    Node<T> nextNode;

    public Node(T val) {
        this.val = val;
    }

    public Node(T val, Node<T> nextNode) {
        this.val = val;
        this.nextNode = nextNode;
    }
}

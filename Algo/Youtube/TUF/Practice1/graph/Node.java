package graph;

public class Node
{
 int src;
 int dest;
 int weight;

 
public Node(int src, int dest, int weight) {
    this.src = src;
    this.dest = dest;
    this.weight = weight;
}


public int getSrc() {
    return src;
}
public void setSrc(int src) {
    this.src = src;
}
public int getDest() {
    return dest;
}
public void setDest(int dest) {
    this.dest = dest;
}
public int getWeight() {
    return weight;
}
public void setWeight(int weight) {
    this.weight = weight;
}

@Override
public String toString() {
    return "Node [dest=" + dest + ", src=" + src + ", weight=" + weight + "]";
}

 
}
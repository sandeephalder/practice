package Graph;

public class GraphNode implements Comparable<GraphNode>{
    int src,dest,value;

    

    public GraphNode(int src, int dest, int value) {
        this.src = src;
        this.dest = dest;
        this.value = value;
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

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "GraphNode [dest=" + dest + ", src=" + src + ", value=" + value + "]";
    }

    @Override
    public int compareTo(GraphNode graph) {
        return Integer.valueOf(this.value).compareTo(Integer.valueOf(graph.value));
    }
   
}

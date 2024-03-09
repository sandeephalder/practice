package Graph.MST;

public class Edge implements Comparable<Edge>{

    int v;
    int w;
    int weight;

    
    

    public int getV() {
        return v;
    }


    public void setV(int v) {
        this.v = v;
    }


    public int getW() {
        return w;
    }


    public void setW(int w) {
        this.w = w;
    }


    public int getWeight() {
        return weight;
    }


    public void setWeight(int weight) {
        this.weight = weight;
    }


    public Edge(int v, int w, int weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }


    public int either(){
        return v;
    }
    public int other(int n){
        if(n==v) return w;
        else return v;
    }

    @Override
    public int compareTo(Edge that) {
       
        if(this.weight < that.weight) return -1;
        else if(this.weight > that.weight) return 1;
        else return 0;
    }


    @Override
    public String toString() {
        return "Edge [v=" + v + ", w=" + w + ", weight=" + weight + "]";
    }

}

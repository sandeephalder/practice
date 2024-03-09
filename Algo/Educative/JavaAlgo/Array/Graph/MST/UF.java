package Graph.MST;

public class UF {
    int V;
    int[] arr; 
    public static void main(String[] args) {
        UF uf = new UF(10);
        uf.join(0, 3);
        uf.join(4, 3);
        uf.join(4, 9);
        uf.join(6, 9);
        System.out.println(uf.isConnected(0,5));
    }

    UF(int V){
      this.V=V;
      arr = new int[V]; 
      for(int i=0;i<V;i++) arr[i]=i;
    }

    public void join(int v,int w){
        int src = arr[v];
        int dest = arr[w];
        for(int i=0;i<V;i++) if(arr[i]==src) arr[i]=dest;
    }
    public boolean isConnected(int v,int w){
            return arr[v]==arr[w];
    }
}

package tuf.Graph;

public class FloyedMarshall {

    int[][] edges = new int[4][3];
    int verticies =5;
    int[][] distance = new int[verticies][verticies];
    int max = (int)Math.pow(10, 5);

    public static void main(String[] args) {
        new FloyedMarshall();
    }

    FloyedMarshall(){
        edges[0] =new int[]{1,2,4};
        edges[1] =new int[]{1,3,3};
        edges[2] =new int[]{2,4,7};
        edges[3] =new int[]{3,4,-2};
        for(int i=0;i<verticies;i++){
            for(int j=0;j<verticies;j++){
                distance[i][j]=max;
                if(i==j) distance[i][j]=0;
            }
        }

        for(int[] e: edges){
            distance[e[0]][e[1]]=e[2];
        }
        for(int hops=0;hops<verticies;hops++)
        for(int i=0;i<verticies;i++){
            for(int j=0;j<verticies;j++){
                if(distance[i][hops]==max || distance[hops][j] ==max) continue;
                distance[i][j] = Math.min(distance[i][j],distance[i][hops]+distance[hops][j]);
            }
        }
        print(distance);
    }

    public void print(int[][] arr){
        System.out.println();
        for(int[] i:arr){
            System.out.println();
            for(int j:i)
            System.out.print(" ==> "+j);
        }
    }
}

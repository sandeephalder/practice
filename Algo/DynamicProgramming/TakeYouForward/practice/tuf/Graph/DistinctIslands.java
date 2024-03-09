package tuf.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;


public class DistinctIslands {

     int[][] arr = {{1,1,0,1,1},{1,0,0,0,0},{0,0,0,0,1},{1,1,0,1,1}};
     int M= arr.length,N=arr[0].length;
     boolean[][] visited= new boolean[M][N];
    
     int[] x = {-1,0,1};
     int[] y = {-1,0,1};

    
    public static void main(String[] args) {
        new DistinctIslands();
        new Object();
    }

    DistinctIslands(){
        for(int i=0;i<M;i++) Arrays.fill(visited[i], false);
        System.out.println("Size ==> "+distinctIsland(arr, M, N));
        
    }


    public int distinctIsland(int[][] arr, int n, int m) 
	{
        Queue<Point> queue = new LinkedList<>();
        Set<Shape> set = new HashSet<>();
        for(int i=0;i<M;i++) Arrays.fill(visited[i], false);
        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                if(!visited[i][j]){
                     Shape s = findShape(arr, i, j, queue);
                     if(s!=null)
                     set.add(s);
                }
            }
        }
        //System.out.println(set);
		return set.size();
	}

    public Shape findShape(int[][] arr, int x, int y,Queue<Point> queue){
        Shape shape = new Shape();
        Point start= new Point(x,y);
        if(arr[x][y]==0) return null;
        queue.offer(start);
        while(!queue.isEmpty()){
            Point point = queue.poll();
            visited[point.x][point.y] = true;
            for(Point p:adj(arr,point)){
                if(!visited[p.x][p.y]) {
                    shape.buildShape(p);
                    visited[p.x][p.y]=true;
                }
            }
        }
        shape.normalizeShape();
        return shape;
    }

    public List<Point> adj(int[][] arr, Point point){
        int M = arr.length,N= arr[0].length;
        int m=point.x;
        int n=point.y;
        List<Point> result = new ArrayList<>();
        if(arr[m][n]!=1) return result;
        for(int xh:x){
            for(int yh:y){
                int xx=m+xh;
                int yy= n+yh;
                if(xx<0||xx>=M||yy<0||yy>=N|| (xx==m&&yy==n)) continue;
                if(arr[xx][yy]==1){
                    Point node = new Point(xx,yy);
                    result.add(node);
                }
            }
        }
        return result;
    }

}

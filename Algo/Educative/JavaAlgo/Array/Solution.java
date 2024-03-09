public class Solution {
    public static void main(String[] args) {
        new Solution();
    }

    Solution(){
        int[][] grid = {{2147483647,-1,0,2147483647},{2147483647,2147483647,2147483647,-1},{2147483647,-1,2147483647,-1},{0,-1,2147483647,2147483647}};
          wallsAndGates(grid);
    }

    public void wallsAndGates(int[][] rooms) {
        int M=rooms.length,N=rooms[0].length;
        
        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                if(rooms[i][j]==0)
                    traverseRoom(rooms,i,j,M,N,1);
            }
        }
        print(rooms);
    }
    
    private void traverseRoom(int[][] rooms,int x,int y,int M,int N,int counter){
        if(x<0 || y <0 || x>=M || y>=N || rooms[x][y]==-1) return;
        
        if(rooms[x][y]==0 && counter !=1) return;
        if(counter !=1)
        rooms[x][y]= Math.min(counter,rooms[x][y]);
        
        counter++;
        
        traverseRoom(rooms,x-1,y,M,N,counter);
      
        traverseRoom(rooms,x+1,y,M,N,counter);
        
        traverseRoom(rooms,x,y-1,M,N,counter);
      
        traverseRoom(rooms,x,y+1,M,N,counter);
    }
    
     private void print(int[][] grid){
        int N=grid[0].length,M=grid.length;
         for(int i=0;i<M;i++) {
             System.out.println();
            for(int j=0;j<N;j++){
                System.out.print(" ==> "+grid[i][j]);
            }
        }
    }
    
    
}

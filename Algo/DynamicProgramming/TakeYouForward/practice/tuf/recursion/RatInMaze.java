package tuf.recursion;
import java.util.ArrayList;
import java.util.List;

public class RatInMaze {

   int N =4;
   int maze[][] = {{1, 0, 0, 0},
         {1, 1, 0, 1}, 
         {1, 1, 0, 0},
         {0, 1, 1, 1}};

    boolean visited[][] = new boolean[N][N];

    RatInMaze(){
        init();
        List<String> result = new ArrayList<>();
        visited[0][0]=true;
        ratInMaze(maze,0,0, visited, "", result);
        System.out.println(result);
    }

    private void init(){
        for(int i=0;i<N;i++)
            for(int j=0;j<N;j++)
                visited[i][j]=false;
    }

    public static void main(String[] args) {
        new RatInMaze();
    }

    private boolean ratInMaze(int[][] maze,int x,int y,boolean[][] visited,String path,List<String> result){
        int N = maze.length-1;
        if(x==N && y==N){
            result.add(path);
            return true;
        }
        
        if(isPossible(maze, x, y, "D", visited))
        {
            path+="D";
            visited[x+1][y] = true;
            ratInMaze(maze, x+1, y, visited, path, result);
            visited[x+1][y] = false;
            path = path.substring(0, path.length()-1);
            
        }
        if(isPossible(maze, x, y, "L", visited))
        {
            path+="L";
            visited[x][y-1] = true;
           ratInMaze(maze, x, y-1, visited, path, result);
            visited[x][y-1] = false;
            path = path.substring(0, path.length()-1);
            
        }
        if(isPossible(maze, x, y, "R", visited))
        {
            path+="R";
            visited[x][y+1] = true;
            ratInMaze(maze, x, y+1, visited, path, result);
            visited[x][y+1] = false;
            path = path.substring(0, path.length()-1);
            
        }
        if(isPossible(maze, x, y, "U", visited))
        {
            path+="U";
            visited[x-1][y] = true;
            ratInMaze(maze, x-1, y, visited, path, result);
            visited[x-1][y] = false;
            path = path.substring(0, path.length()-1);
            
        }

        return false;
    }

    private boolean isPossible(int[][] maze,int x,int y,String direction,boolean[][] visited){
        int N = maze.length-1;

        if(x<0 || x> N || y<0 || x>N) return false;
        switch(direction){
            case "D":
            if((x+1)>N || maze[x+1][y] !=1 || visited[x+1][y]) return false;
            break;
            case "L":
            if((y-1)<0 || maze[x][y-1] !=1 || visited[x][y-1]) return false;
            break;
            case "R":
            if((y+1)>N ||maze[x][y+1] !=1 || visited[x][y+1]) return false;
            break;
            case "U":
            if((x-1)<0 || maze[x-1][y] !=1 || visited[x-1][y]) return false;
            break;
        }
        return true;
    }


}

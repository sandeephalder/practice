public class RatInAMaze {
    char[] direction = {'D','L','R','U'};
    int[][] maze = {{1,0,0,0},{1,1,0,1},{1,1,0,0},{0,1,1,1}};
    boolean[][] visited;
    int MAX=4;
    RatInAMaze(){
        //System.out.println(canMove(maze, 1, 0, direction[2]));
        visited = new boolean[MAX][MAX];
        for(int i=0;i<MAX;i++)
        for(int j=0;j<MAX;j++)
        visited[i][j]=false;
        runARace(maze, 0, 0, "");
    }

    public static void main(String[] args) {
        new RatInAMaze();
    }

    private void runARace(int[][] maze,int x,int y,String  path){
        if(x==MAX-1 && y == MAX-1) {
            System.out.println(path);
            return;
        }

        if(x >= MAX || y >= MAX) return;

        for(int i=0;i<direction.length;i++){
            if(canMove(maze, x, y, direction[i])){

                switch (direction[i]){
                    case 'D':
                    visited[x][y]=true;
                    runARace(maze, x+1, y, path+direction[i]);
                    visited[x][y]=false;
                    break;
                    case 'U':
                    visited[x][y]=true;
                    runARace(maze, x-1, y, path+direction[i]);
                    visited[x][y]=false;
                    break;
                    case 'R':
                    visited[x][y]=true;
                    runARace(maze, x, y+1, path+direction[i]);
                    visited[x][y]=false;
                    break;
                    case 'L':
                    visited[x][y]=true;
                    runARace(maze, x, y-1, path+direction[i]);
                    visited[x][y]=false;
                    break;
                }
            }
        }
        
    }

    private boolean canMove(int[][] maze,int x,int y,char dir){
        if(maze[x][y] ==0) return false;
        switch (dir){
            case 'D':
            if((x+1) < MAX && !visited[x+1][y] &&  maze[x+1][y]==1) return true;
            break;
            case 'U':
            if((x-1) >=0  && !visited[x-1][y] && maze[x-1][y]==1) return true;
            break;
            case 'R':
            if((y+1) < MAX && !visited[x][y+1] && maze[x][y+1]==1) return true;
            break;
            case 'L':
            if((y-1) >=0 && !visited[x][y-1] && maze[x][y-1]==1) return true;
            break;
        }
        return false;
    }


}

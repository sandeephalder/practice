public class TwoDArraySearch {
    TwoDArraySearch(){
        int[][] arr = {{1,3}};
        System.out.println(searchMatrix(arr,3));
        ;
    }
    public static void main(String[] args) {
        new TwoDArraySearch();
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int column = findInColumn(matrix,target);
        System.out.println(column);
        if(column ==-1) return false;
        int row = findInRow(matrix, column, target);
        System.out.println(row);
        if(row==-1) return false;
        return matrix[column][row]==target;
    }
    
    public int findInRow(int[][] matrix,int column, int target){
        int hi = matrix[0].length-1,lo=0,mid=0;
        
        while(hi>=lo){
            mid = lo + (hi-lo)/2;
            if(target<matrix[column][mid]) hi = mid-1;
            else if(target>matrix[column][mid]) lo = mid+1;
            else return mid;
        }
        return -1;
    }
    
    public int findInColumn(int[][] matrix, int target){
        int hi = matrix.length-1,lo=0,mid=0;
        if(hi ==0 ) return 0;
        while(hi>=lo){
            mid = lo + (hi-lo)/2;
            if(target<matrix[mid][0]) hi = mid-1;
            else if(target>matrix[mid][0]) lo = mid+1;
            else return mid;
        }
        return lo-1;
    }
}

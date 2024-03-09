package binarysearch;

import java.util.Arrays;

public class FindPickElement {

    public static void main(String[] args) {
        new FindPickElement();
    }

    int[][] mat = {
        {10,20,15},
        {21,30,14},
        {7,16,32}
    };


    FindPickElement(){
        print(findPeakGrid(mat));
        //print(findPeakElement(mat, 0, 1));
    }

    public int[] findPeakGrid(int[][] mat) {
        int M=mat.length,N=mat[0].length,x=0,y=0;
        int[] result=new int[2];
        int[] res = new int[9];
        Arrays.fill(res,-1);
        while(res[0]==-1){
            res = findPeakElement(mat, x, y);
            if(res[0]==0){
                result[0]=res[1];
                result[1]=res[2];
                return result;
            }
            for(int i=1;i<8;){
                if(res[i]!=-1){
                    x= res[i];
                    y= res[i+1];
                    break;
                }
                i+=2;
            }
        }
        return result;
    }

    public int[] findPeakElement(int[][] mat,int x,int y) {
        int[] result=new int[9];
        Arrays.fill(result, -1);
        int M=mat.length,N=mat[0].length,l=-1,r=-1,u=-1,d=-1,current=0;
        if(y<0 || y>=N || x<0 || x>=M) return result;
        current=mat[x][y];
        if(y-1>=0) l = mat[x][y-1];
        if(y+1<N) r = mat[x][y+1];
        if(x-1>=0) u = mat[x-1][y];
        if(x+1<M) d = mat[x+1][y];
        if(l<current && r<current && u<current && d<current) {
            result[0]=0;
            result[1]=x;
            result[2]=y;
        }
        else{
            
            result[0]=-1;
            if(l>current) {
                result[1]=x;
                result[2]=y-1;
            }
            if(r>current) {
                result[3]=x;
                result[4]=y+1;
            }
            if(u>current) {
                result[5]=x-1;
                result[6]=y;
            }
            if(d>current) {
                result[7]=x+1;
                result[8]=y;
            }
        }
        return result;
    }

    private void print(int[] arr){
        System.out.println();
        for(int i:arr) System.out.print(" ==> "+i);
    }
}

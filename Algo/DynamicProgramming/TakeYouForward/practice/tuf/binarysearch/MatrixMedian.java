package binarysearch;

import java.util.PriorityQueue;
import java.util.Queue;

public class MatrixMedian {
    int[][] mat = 
    {{ 1, 5, 7, 9, 11 },
          { 2, 3, 4, 8, 9 },
          { 4, 11, 14, 19, 20 },
          { 6, 10, 22, 99, 100 },
          { 7, 15, 17, 24, 28 }};
    int M=mat.length,N=mat[0].length;

    MatrixMedian(){
        System.out.println(findMedian(mat, M, N));
    }

    public static void main(String[] args) {
        new MatrixMedian();
    }

    public int findMedian(int matrix[][], int m, int n) {
        int l= M*N,med=(l-1)/2,median=0;
        Queue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<M;i++)
        for(int j=0;j<N;j++)
        pq.add(matrix[i][j]);
        for(int i=0;i<med;i++)
        pq.poll();
        median = pq.poll();
        if(l%2==0) median = (pq.poll()+median)/2;
        return median;
    }
}

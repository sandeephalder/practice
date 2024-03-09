package tuf.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class RecursionBasics {
    public static void main(String[] args) {
       new RecursionBasics();

    }

    RecursionBasics() {
        try{
        System.out.println("Print name N times");
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please input N times");
        int N = Integer.parseInt(bf.readLine());
        printNames(N);
        Scanner scan = new Scanner(System.in);
        System.out.println("Please input N countdown");
        N = scan.nextInt();
        countDown(N);
        System.out.println("Please input N countup");
        N = scan.nextInt();
        countUpBackTrack(N);
        System.out.println("Please input N sum");
        N = scan.nextInt();
        System.out.println( sumUpSingle(N));
        System.out.println("Please input N factorial");
        N = scan.nextInt();
        System.out.println( factorialSingle(N));
       
        }
        catch(IOException exception){

        }
    }

    private void printNames(int N){
        if(N<=0) return;
        System.out.println("Sandeep");
        printNames(--N);
    }

    private void countDown(int N){
        if(N<0) return;
        System.out.println(N);
        countDown(--N);
    }

    private void countUp(int N,int count){
        if(N<0) return;
        System.out.println(count);
        countUp(--N,++count);
    }

  

    private void countUpBackTrack(int N){
        if(N<=0) return; 
        countUpBackTrack(--N);
        System.out.println(N);
    }

    private void sumUp(int N,int sum){
        if(N<=0) {
            System.out.println(sum);
            return;
        }
        sumUp(--N,sum+N+1);
        
    }

    
    private int sumUpSingle(int N){
        if(N<=0) {
            return N;
        }
        int sum = sumUpSingle(N-1)+N;
        return sum;
    }
    private int factorialSingle(int N){
        if(N<=1) {
            return N;
        }
        return factorialSingle(N-1)*N;
      
    }
    


}

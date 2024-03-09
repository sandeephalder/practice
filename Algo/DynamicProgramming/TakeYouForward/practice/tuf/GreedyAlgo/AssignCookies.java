package GreedyAlgo;

import java.util.Arrays;

public class AssignCookies {
    int[] s = {1,2,3};
    int[] g= {1,2};
    public static void main(String[] args) {
        new AssignCookies();
    }

    AssignCookies(){
       
        System.out.println(findContentChildren(g, s));
    }

     public int findContentChildren(int[] g, int[] s) {
        int count=0,l=0,r=0;
        Arrays.sort(g);
        Arrays.sort(s);
        print(s);
        print(g);
        while(l<s.length && r<g.length){
            if(s[l]>=g[r]){
                count++;
                
                r++;
            }
         
                l++;
                
           
        }
        return count;
    }

    public void print(int[] arr){
        System.out.println();
        for(int i:arr) System.out.print(" ==> "+i);
    }
}

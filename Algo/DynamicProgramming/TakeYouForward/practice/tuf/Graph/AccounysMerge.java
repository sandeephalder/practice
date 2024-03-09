package tuf.Graph;

import java.util.*;


public class AccounysMerge {

    String[][] input= {{"Gabe","Gabe0@m.co","Gabe3@m.co","Gabe1@m.co"},
    {"Kevin","Kevin3@m.co","Kevin5@m.co","Kevin0@m.co"},
    {"Ethan","Ethan5@m.co","Ethan4@m.co","Ethan0@m.co"},
    {"Hanzo","Hanzo3@m.co","Hanzo1@m.co","Hanzo0@m.co"},
    {"Hanzo","Hanzo3@m.co","Hanzo1@m.co","Hanzo2@m.co"},
    {"Kevin","Kevin6@m.co","Kevin7@m.co","Kevin0@m.co"},
    {"Gabe","Gabe0@m.co","Gabe4@m.co","Gabe5@m.co"},
    {"Fern","Fern5@m.co","Fern1@m.co","Fern0@m.co"}};

    int V = input.length;
    int[] disjointSet = new int[V];
    public static void main(String[] args) {
        new AccounysMerge();
    }

    AccounysMerge(){
        List<List<String>> accounts = new ArrayList<>();
        for(int i=0;i<V;i++) {
            accounts.add(Arrays.asList(input[i]));
            disjointSet[i]=i;
        }

        System.out.println(accountsMerge(accounts));
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> result = new ArrayList<>();
        
        Map<Integer,String> firstPart = new HashMap<>();
        Map<String,Integer> secondPart = new HashMap<>();
        for(int i=0;i<10;i++){
            List<String> plane = accounts.get(i);
            result.add(new ArrayList<>());
            int planeSize = plane.size();
            for(int j=0;j<planeSize;j++){
                if(j==0){
                    firstPart.put(i, plane.get(j));
                }
                else{
                    if(!secondPart.containsKey(plane.get(j)))
                    secondPart.put(plane.get(j), i);
                    else{
                        int existing = secondPart.get(plane.get(j));
                        join(i, existing);
                    }
                }
            }
        }

        for(int i=0;i<V;i++){
          int relativeIndex = disjointSet[i];
          if(result.get(relativeIndex).size()==0){
            result.get(relativeIndex).add(firstPart.get(relativeIndex));
          }
        }

        for(String key:secondPart.keySet()){
            int relativeIndex = disjointSet[secondPart.get(key)];
            result.get(relativeIndex).add(key);
        }
        
     
        return result;
    }

    private void join(int src,int dest){
        int s = disjointSet[src];
        int t= disjointSet[dest];
        for(int i=0;i<V;i++) if(disjointSet[i]==s) disjointSet[i]=t;
    }

     private boolean isConnected(int src,int dest){
        return disjointSet[src]==disjointSet[dest];
    }
}

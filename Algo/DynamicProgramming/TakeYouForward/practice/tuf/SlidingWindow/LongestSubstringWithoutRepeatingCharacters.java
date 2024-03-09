package SlidingWindow;

import java.util.*;

public class LongestSubstringWithoutRepeatingCharacters {

    String pattern  = "tmmzuxt";
    int len = pattern.length();
    public static void main(String[] args) {
        new LongestSubstringWithoutRepeatingCharacters();
    }

    LongestSubstringWithoutRepeatingCharacters(){
        System.out.println("Brut Force: "+(findAllSubsequencesBrut(pattern)));
        System.out.println("Semi Efficient: "+findAllSubsequencesSemiEfficient(pattern));
        System.out.println("Efficient: "+findAllSubsequencesEfficient(pattern));
    }

    private Set<String> findAllSubsequencesBrut(String str){
        Set<String> result = new HashSet<>();
        int[] mask = new int[len];
        
        for(int i=0;i<(1<<len);i++){
            Arrays.fill(mask, 0);
            String s = "";
            for(int j=0;j<len;j++){
                if((i&(1<<j))==(1<<j)) mask[j]=1;
            }
            for(int j=0;j<len;j++){
                if(mask[j]==1) s+= str.charAt(j);
            }
            if(hasDuplicate(s)){
                //System.out.println(s);
                result.add(s);
            }
            
        }
        return result;
    }

    private boolean hasDuplicate(String str){
        Set<Character> set = new HashSet<>();
        for(Character c:str.toCharArray()){
            if(set.contains(c)) return false;
            set.add(c);
        }
        return true;
    }

    private int findAllSubsequencesSemiEfficient(String str){
        Set<Character> set = new HashSet<>();
        int l=0,r=0,max=Integer.MIN_VALUE;
        if(len==0) return len;
        while(r<len && l<len){
            
            char c = str.charAt(r);
          
            if(set.contains(c)){
                
                while(str.charAt(l)!=c) {
                    set.remove(str.charAt(l));
                    l++;
                }
                l++;
                //System.out.println(c+" Contains "+l);
            }
            else{
                set.add(c);
            }
            
            //System.out.println(" l= "+l+" r= "+r+" set= "+set+" c= "+c);
            max= Math.max(max,r-l+1);
            r++;
        }
        return max;
    }
    private int findAllSubsequencesEfficient(String str){
        int max=Integer.MIN_VALUE,l=0,r=0;
        Map<Character,Integer> map = new HashMap<>();
        while(l<len && r < len){
            char c = str.charAt(r);

            if(map.containsKey(c))
                l = map.get(c)+1;
                map.put(c, r);
          

            max = Math.max(max, r-l );
            r++;
        }
        return max;
    }

}

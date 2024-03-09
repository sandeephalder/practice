public class LongestCommonPrefixInStrings {
    LongestCommonPrefixInStrings(){
        String[] strs = {"a"};
        int min=Integer.MAX_VALUE;
        for(String s:strs) {
            min = Math.min(min,s.length());
        }
        System.out.println("==>"+longestCommonPrefix(strs,0,min));
    }

    public static void main(String[] args) {
        new LongestCommonPrefixInStrings();
    }

    public String longestCommonPrefix(String[] strs,int n,int m) {
        if(n>=m || m==0) return "";
        boolean matched = true;
        char c = strs[0].charAt(n);
        for(String s:strs) {
           if(s.charAt(n)!=c) matched=false;
        }
        if(!matched){
            return "";
        }
        else return c+""+longestCommonPrefix(strs, n+1,m);
    }
}

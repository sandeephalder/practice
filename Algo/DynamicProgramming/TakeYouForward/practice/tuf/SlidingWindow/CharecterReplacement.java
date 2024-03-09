package SlidingWindow;

public class CharecterReplacement {

    String s = "ABAB";
    int k = 2;
    public static void main(String[] args) {
        new CharecterReplacement();
    }

    CharecterReplacement(){
        System.out.println(characterReplacement(s, k));
    }

    public int characterReplacement(String s, int k) {
        int l=0,r=0,N=s.length(),max=0,res=0;
        int[] arr = new int[27];
        while(r<N){
            char c = s.charAt(r);
            arr[c-'A']++;
            max = Math.max(max,arr[c-'A']);
            if(r-l+1-max>k){
                arr[s.charAt(l)-'A']--;
                l++;
            }
            res = Math.max(r-l+1, res);
            r++;
        }
     return res;
    }

    public int characterReplacementJunk(String s, int k) {
        int N= s.length(),count=0,convert=k,max=0;
        char c=0,frequent=0,ignfrequent=0;
        for(int i=0;i<N;i++){
            convert=k;
            count=0;
            frequent=0;
            for(int j=i;j<N;j++){
                c = s.charAt(j);
                if(frequent==0) frequent=c;
                if(c==frequent || --convert>=0) count++;
                else break;
            }
            max = Math.max(max, count);

            convert=k;
            count=0;
            ignfrequent=0;
            for(int j=i;j<N;j++){
                c = s.charAt(j);
                if(frequent!=c) ignfrequent=c;
                if(c==ignfrequent || --convert>=0) count++;
                else if(ignfrequent==0) continue;
                else break;
            }
            max = Math.max(max, count);
        }
        return max;
    }
}

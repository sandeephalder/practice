package tuf.recursion;

import java.util.ArrayList;

public class BinaryOnesandZeroes {
    public static void main(String[] args) {
        System.out.println(generateString(4));
    }

    public static ArrayList<String> generateString(int k) {
		ArrayList<String> result = new ArrayList<>();
		genString(k, "", result);
		return result;
	}

	public static void genString(int k,String res,ArrayList<String> result) {
		if(k<=0){
			result.add(new String(res));
			return;
		}
		genString(k-1, res+"0", result);
        if(res.length()==0 || (res.length()>0 && res.charAt(res.length()-1)!='1'))
		genString(k-1, res+"1", result);
	}
}

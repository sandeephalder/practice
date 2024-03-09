package recursion2;

import java.util.*;

public class LetterCombinationsInPhonekeypad {

    Map<Integer,List<Character>> keypad = new HashMap<>();
    String input= "24";
    public static void main(String[] args) {
        new LetterCombinationsInPhonekeypad();
    }

    LetterCombinationsInPhonekeypad(){
        buildKeypad();
        int size = input.length();
        String[] list = getCharsFromKeys(input).toArray(new String[0]);
        List<String> result = new ArrayList<>();
        findAllCombinations(list, 0, size, "", result);
        System.out.println(result);
    }
    private void findAllCombinations(String[] list,int index,int size,String level,List<String> result){
       
        if(level.length()==size){
            result.add(level);
            return;
        }
        
        if(level.length()>size || index >=list.length){
            return;
        }
        
        level+=list[index];
            
        findAllCombinations(list, index+1, size, level, result);
        
        level = level.substring(0, level.length()-1);
      
        
        findAllCombinations(list, index+1, size, level, result);
        
    }

    private List<String> getCharsFromKeys(String ip){
        Set<String> unique = new HashSet<>();
        for(int i=0;i<ip.length();i++){
            for(char c:keypad.get(Integer.parseInt(""+ip.charAt(i))))
            unique.add(""+c);
        }
        //System.out.println(unique);
        return unique.stream().map(str->str+"").toList();
    } 

    private void buildKeypad(){
        keypad.put(2, new ArrayList<>());
        keypad.get(2).add('a');
        keypad.get(2).add('b');
        keypad.get(2).add('c');
        keypad.put(3, new ArrayList<>());
        keypad.get(3).add('d');
        keypad.get(3).add('e');
        keypad.get(3).add('f');
        keypad.put(4, new ArrayList<>());
        keypad.get(4).add('g');
        keypad.get(4).add('h');
        keypad.get(4).add('i');
        keypad.put(5, new ArrayList<>());
        keypad.get(5).add('j');
        keypad.get(5).add('k');
        keypad.get(5).add('l');
        keypad.put(6, new ArrayList<>());
        keypad.get(6).add('m');
        keypad.get(6).add('n');
        keypad.get(6).add('o');
        keypad.put(7, new ArrayList<>());
        keypad.get(7).add('p');
        keypad.get(7).add('q');
        keypad.get(7).add('r');
        keypad.get(7).add('s');
        keypad.put(8, new ArrayList<>());
        keypad.get(8).add('t');
        keypad.get(8).add('u');
        keypad.get(8).add('v');
        keypad.put(9, new ArrayList<>());
        keypad.get(9).add('w');
        keypad.get(9).add('x');
        keypad.get(9).add('y');
        keypad.get(9).add('z');
    }
}

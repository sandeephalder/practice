package myjava.mystreams.singleresponsibility;

import java.util.function.BiFunction;

public class ProcessPair {
    public static Integer processPair(IntegerPair integerPair,BiFunction<Integer,Integer,Integer> action){
        
        return  action.apply(integerPair.getA(), integerPair.getB());
    }
}

package myjava.mystreams.singleresponsibility;

public class IntegerPair {
    Integer a,b;

    public IntegerPair(Integer a, Integer b) {
        this.a = a;
        this.b = b;
    }

    public Integer getA() {
        return a;
    }

    public void setA(Integer a) {
        this.a = a;
    }

    public Integer getB() {
        return b;
    }

    public void setB(Integer b) {
        this.b = b;
    }

    @Override
    public String toString() {
        return "IntegerPair [a=" + a + ", b=" + b + "]";
    }
    
    
}

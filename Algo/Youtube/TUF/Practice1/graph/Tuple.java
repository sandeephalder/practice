package graph;

public class Tuple implements Comparable{
   int a,b;

   
public Tuple(int a, int b) {
    this.a = a;
    this.b = b;
}

public int getA() {
    return a;
}

public void setA(int a) {
    this.a = a;
}

public int getB() {
    return b;
}

public void setB(int b) {
    this.b = b;
}

@Override
public int compareTo(Object arg0) {
    // TODO Auto-generated method stub
    return 0;
}
   
}

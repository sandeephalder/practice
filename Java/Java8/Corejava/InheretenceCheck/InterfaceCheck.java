package InheretenceCheck;

public interface InterfaceCheck {
    int a=10;
    static int b=89;
    static final int c=34;
    public final static int d=54;

    abstract int addAbstract(int a,int b);

    default int add(int a,int b){
        return a+b;
    }

    static int sub(int a,int b){
        return a-b;
    }
}

package myjava.mystreams.CreationalPattern.Singleton;

public enum SingletonEnum {
    INSTANCE;

    public static SingletonEnum build(){
        return INSTANCE;
    }
}

package myjava.mystreams.CreationalPattern.Singleton;

import java.util.Optional;

public class SingletonOld {
    
    private SingletonOld()
    {
        
    }

    private static Optional<SingletonOld> INSTANCE = Optional.empty();

    public static SingletonOld build(){
        synchronized(SingletonOld.class){
            if(INSTANCE.isEmpty()) INSTANCE = Optional.of(new SingletonOld());
            return INSTANCE.get();
        }  
    }
}

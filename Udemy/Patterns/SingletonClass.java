import java.io.Serializable;

class SingletonClass implements Cloneable,Serializable {

    public static SingletonClass INSTANCE;

    private SingletonClass(){
        
    }

   
    protected Object readResolve(){
        return (Object)INSTANCE;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException
    {
        return super.clone();
    }

    public SingletonClass getInstance(){
        synchronized(this){
            if(INSTANCE==null)
            INSTANCE = new SingletonClass();
            return INSTANCE;
        }
       
    }
}
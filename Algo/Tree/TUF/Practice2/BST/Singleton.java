package BST;
public class Singleton {

    private static Singleton INSTANCE ;
    
    private Singleton(){

    }

    public static Singleton getInstance(){

        synchronized(INSTANCE){
            if(INSTANCE == null )
            INSTANCE = new Singleton();
            return INSTANCE;
        }
       
    }
}

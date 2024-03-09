package Factory;

public class FactoryBuilder {
     
    public static Factory getFactory(FactoryType type){
        if(type == FactoryType.TATA){
            return new TataFactory();
        }
        else return null;
    }
}

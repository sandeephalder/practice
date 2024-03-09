package myjava.mystreams.CreationalPattern.FactoryPattern;

public class ShapeAbstactFactory {
    
    public static Factory getShapeFactory(String factory){
        if(factory.equals("3d")) return new ThreeDShapeFactory();
        if(factory.equals("2d")) return new ShapeFactory();
        return null;
    } 
}

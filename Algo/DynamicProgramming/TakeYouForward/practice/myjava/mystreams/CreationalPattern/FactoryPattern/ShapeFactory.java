package myjava.mystreams.CreationalPattern.FactoryPattern;

public class ShapeFactory implements Factory{

    @Override
    public Shape getShape(String shape) {
        if(shape.equals("circle")) return new Circle();
        else if(shape.equals("triangle")) return new Triangle();
        else if(shape.equals("rectangle")) return new Rectangle();
        else return null;
    }
    
}

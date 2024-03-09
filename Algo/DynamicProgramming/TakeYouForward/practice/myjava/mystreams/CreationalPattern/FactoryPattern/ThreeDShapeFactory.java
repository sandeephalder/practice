package myjava.mystreams.CreationalPattern.FactoryPattern;

public class ThreeDShapeFactory implements Factory{
    
    @Override
    public Shape getShape(String shape) {
        if(shape.equals("sphere")) return new Sphere();
        else if(shape.equals("cube")) return new Pyramid();
        else if(shape.equals("pyramid")) return new Cube();
        else return null;
    }
}

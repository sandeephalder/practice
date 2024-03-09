package myjava.mystreams.CreationalPattern.FactoryPattern;

public class RenderMyShape {
    public static void main(String[] args) {
        new RenderMyShape();
    }

    RenderMyShape(){
        ShapeAbstactFactory.getShapeFactory("3d").getShape("sphere").draw();
        ShapeAbstactFactory.getShapeFactory("2d").getShape("rectangle").draw();
    }
}

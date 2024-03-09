package tuf.Graph;

public class Point {
    int x,y;
    Object o = new Object();
    Point(int x,int y){
        this.x=x;
        this.y=y;
    }

    @Override
    public boolean equals(Object o){
        Point other = (Point)o;
        return this.x==other.x && this.y == other.y;
    }

    @Override
    public int hashCode(){
        return toString().hashCode();
    }


    @Override
    public String toString(){
        return "{ x= "+x+" , y= "+y+" }";
    }
}

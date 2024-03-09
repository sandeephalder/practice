package tuf.Graph;

import java.util.ArrayList;
import java.util.List;

public class Shape {

      List<Point> structure = new ArrayList<>();
        int lowX=Integer.MAX_VALUE,lowY=Integer.MAX_VALUE;
        void normalizeShape(){
            List<Point> newstructure = new ArrayList<>();
            for(Point edge: structure) {
                Point newPoint  = new Point(edge.x-lowX, edge.y-lowY);
                newstructure.add(newPoint);
            }
            structure=newstructure;
        }

        void buildShape(Point point){
            if(point.x<lowX) this.lowX=point.x;
            if(point.y<lowY) this.lowY=point.y;
            structure.add(point);
        }

        @Override
         public String toString(){
            String str = "";
            for(Point p:structure) str += "\n"+p.toString()+"\n";
            return str;
        }

        @Override
        public  int hashCode(){
            return toString().hashCode();
        }

        @Override
        public boolean equals(Object o){
            Shape other = (Shape)o;
            if(this.structure.size()!=other.structure.size()) return false;
            for(int i=0;i<other.structure.size();i++) if(!this.structure.get(i).equals(other.structure.get(i))) return false;
            return true;
        }
          
}

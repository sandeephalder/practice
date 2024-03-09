package myjava.mystreams.BehavioralPatter.IteratorPattern;

public class RunIterators {
    public static void main(String[] args) {
        new RunIterators();
    }

    RunIterators(){
        int[] i = {2,5,1,5,435,35,46,3645,6};
        String[] s = {"hgudsf","ierut","bvhdfjh","uoiwytuio","hjyj","fahgdsxgfhas","yiukuy"};
        StringIterator stringIterator = new StringIterator(s);
        NumberIterator numberIterator = new NumberIterator(i);
            System.out.println();
        while(stringIterator.hasNext()) System.out.print(" ==>"+stringIterator.next());
        System.out.println();
        while(numberIterator.hasNext()) System.out.print(" ==."+numberIterator.next());
        System.out.println();
    }
}

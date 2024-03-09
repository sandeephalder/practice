package myjava.mystreams.BehavioralPatter.Templatepattern;

public class QuickSort extends SortTemplate{

    @Override
    public void init() {
        System.out.println("Init Quick sort");
    }

    @Override
    public void sorting() {
        System.out.println("Sorting Quick sort");
    }

    @Override
    public void display() {
        System.out.println("Display Quick sort");
    }
    
}

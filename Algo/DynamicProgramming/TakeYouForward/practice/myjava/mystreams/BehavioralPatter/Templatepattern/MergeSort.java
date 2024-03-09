package myjava.mystreams.BehavioralPatter.Templatepattern;

public class MergeSort extends SortTemplate{

    @Override
    public void init() {
        System.out.println("Init Merge sort");
    }

    @Override
    public void sorting() {
        System.out.println("Sorting Merge sort");
    }

    @Override
    public void display() {
        System.out.println("Display Merge sort");
    }
    
}

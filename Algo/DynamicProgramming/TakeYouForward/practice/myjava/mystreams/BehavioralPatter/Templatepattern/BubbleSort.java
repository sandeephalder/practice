package myjava.mystreams.BehavioralPatter.Templatepattern;

public class BubbleSort extends SortTemplate{

    @Override
    public void init() {
        System.out.println("Init Bubble sort");
    }

    @Override
    public void sorting() {
        System.out.println("Sorting Bubble sort");
    }

    @Override
    public void display() {
        System.out.println("Display Bubble sort");
    }
    
}

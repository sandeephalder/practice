package myjava.mystreams.BehavioralPatter.Templatepattern;

public abstract class SortTemplate implements Template{

    @Override
    public void sort() {
       init();
       sorting();
       display();
    }    
}

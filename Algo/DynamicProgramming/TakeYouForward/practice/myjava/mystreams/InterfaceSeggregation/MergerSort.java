package myjava.mystreams.InterfaceSeggregation;

public class MergerSort implements Sort,MergeHelper{
    @Override
    public int[] sort(int[] s) {
        System.out.println("This is Merge sort");
        return null;
    }

    @Override
    public int[] merge(int[] input) {
        System.out.println("This is Merge operation");
        return null;
    }
}

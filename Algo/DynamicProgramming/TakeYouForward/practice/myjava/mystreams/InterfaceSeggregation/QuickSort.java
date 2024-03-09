package myjava.mystreams.InterfaceSeggregation;

public class QuickSort implements Sort,PartitionSort{
    @Override
    public int[] sort(int[] s) {
        System.out.println("This is Quick sort");
        return null;
    }

    @Override
    public int partition(int[] arr) {
        System.out.println("This is Merge Operation");
        return -1;
    }
}

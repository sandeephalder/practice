package myjava.mystreams.BehavioralPatter.Templatepattern;

public class RunSort {
    public static void main(String[] args) {
        new RunSort();
    }

    RunSort(){
        BubbleSort bubbleSort = new BubbleSort();
        MergeSort mergeSort = new MergeSort();
        QuickSort quickSort = new QuickSort();

        bubbleSort.sort();
        mergeSort.sort();
        quickSort.sort();
    }
}

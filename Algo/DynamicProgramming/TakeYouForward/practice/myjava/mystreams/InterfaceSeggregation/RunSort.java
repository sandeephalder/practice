package myjava.mystreams.InterfaceSeggregation;

public class RunSort {
    public static void main(String[] args) {
        new RunSort();
    }

    RunSort(){
        Sort buSort = new Bubblesort();
        Sort mSort = new MergerSort();
        MergeHelper mSortMerge = new MergerSort();
        Sort qSort = new QuickSort();

        buSort.sort(null);
        mSort.sort(null);
        mSortMerge.merge(null);
        qSort.sort(null);
    }
}

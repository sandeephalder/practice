package myjava.mystreams.StructuralPattern.FacadePattern;

public class SorterDeck {
    
    BubbleSort bubbleSort = new BubbleSort();
    MergeSort mergeSort = new MergeSort();
    QuickSort quickSort = new QuickSort();

    public void startQuickSort(){
        quickSort.sort();
    }

    public void startBubbleSort(){
        bubbleSort.sort();
    }

    public void startMergeSort(){
        mergeSort.sort();
    }
}

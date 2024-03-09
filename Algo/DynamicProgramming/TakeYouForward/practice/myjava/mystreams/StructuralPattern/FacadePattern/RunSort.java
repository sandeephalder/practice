package myjava.mystreams.StructuralPattern.FacadePattern;

public class RunSort {
    public static void main(String[] args) {
        new RunSort();
    }

    RunSort(){
        SorterDeck sorterDeck = new SorterDeck();
        sorterDeck.startBubbleSort();
        sorterDeck.startMergeSort();
        sorterDeck.startQuickSort();
    }
}

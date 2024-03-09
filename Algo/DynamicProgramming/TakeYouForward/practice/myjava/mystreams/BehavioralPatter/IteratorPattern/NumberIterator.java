package myjava.mystreams.BehavioralPatter.IteratorPattern;

public class NumberIterator implements Iterator<Integer> {
    private int[] numbers;
    private int index=0;


    public NumberIterator(int[] numbers) {
        this.numbers = numbers;
    }


    @Override
    public boolean hasNext() {
       return index < numbers.length;
    }


    @Override
    public Integer next() {
      return numbers[index++];
    }


  

    
}

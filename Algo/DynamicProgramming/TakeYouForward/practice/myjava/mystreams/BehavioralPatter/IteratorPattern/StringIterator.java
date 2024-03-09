package myjava.mystreams.BehavioralPatter.IteratorPattern;

public class StringIterator implements Iterator<String> {
    private String[] numbers;
    private int index=0;


    public StringIterator(String[] numbers) {
        this.numbers = numbers;
    }


    @Override
    public boolean hasNext() {
       return index < numbers.length;
    }


    @Override
    public String next() {
      return numbers[index++];
    }
    
}

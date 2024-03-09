package myjava.mystreams.StructuralPattern.AdapterPattern;

public class BiCycleAdapter implements Vehicle{

    private BiCycle biCycle;

   

    public BiCycleAdapter(BiCycle biCycle) {
        this.biCycle = biCycle;
    }



    @Override
    public void accelerate() {
       biCycle.paddle();
    }
    
}

package myjava.mystreams.BehavioralPatter.CommandPattern;

public class SwitchOnLight implements Command{

    private Light light;

    

    public SwitchOnLight(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.switchOn();
    }
    
}

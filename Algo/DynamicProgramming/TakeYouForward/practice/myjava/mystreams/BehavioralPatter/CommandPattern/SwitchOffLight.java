package myjava.mystreams.BehavioralPatter.CommandPattern;

public class SwitchOffLight implements Command{

    private Light light;

    

    public SwitchOffLight(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.switchOff();
    }
    
}

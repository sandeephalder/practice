package myjava.mystreams.BehavioralPatter.CommandPattern;

public class CommandRunner {
    public static void main(String[] args) {
        new CommandRunner();
    }

    CommandRunner(){
        CommandProcessor commandProcessor = new CommandProcessor();
        Light light = new Light();
        SwitchOffLight switchOffLight = new SwitchOffLight(light);
        SwitchOnLight switchOnLight = new SwitchOnLight(light);
        SwitchOffLight switchOffLight2 = new SwitchOffLight(light);

        commandProcessor.addCommand(switchOffLight);
        commandProcessor.addCommand(switchOnLight);
        commandProcessor.addCommand(switchOffLight2);

        commandProcessor.executeCommandChain();
    }
}

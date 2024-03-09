package myjava.mystreams.BehavioralPatter.CommandPattern;

import java.util.ArrayList;
import java.util.List;

public class CommandProcessor {
    List<Command> commands ;

    public CommandProcessor() {
        this.commands = new ArrayList<>();
    }

    public void addCommand(Command command){
        commands.add(command);
    }

    public void deleteCommand(Command command){
        commands.remove(command);
    }

    public void executeCommandChain(){
        commands.stream().forEach(c-> c.execute());
    }
}

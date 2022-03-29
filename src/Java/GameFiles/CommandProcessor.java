package Java.GameFiles;

import java.util.List;

/**
 * checks if verb can be performed with noun (after being validated by Text Parser)
 */
public class CommandProcessor {

    private List<String> command;



    public void Processor(List<String> validCommand) {
        command = validCommand;

        if (command.get(0).equals("go")){
            //move engine

        }
        else if (command.get(0).equals("get")) {
            //get engine
            GetEngine(command.get(1));
        }
        else if (command.get(0).equals("look")) {
            //look engine
        }
        else if (command.get(0).equals("use")) {
            //Use engine
        }
        else if(command.get(0).equals("commands")){

        }
    }

    private void MoveEngine(){}

    private void GetEngine(String noun){
        //get item from JSON file

    }

    private void LookEngine(){}

    private void UseEngine(){}
}

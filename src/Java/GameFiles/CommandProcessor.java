package Java.GameFiles;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/**
 * checks if verb can be performed with noun (after being validated by Text Parser)
 */
public class CommandProcessor {

    private List<String> command;
    Player player = new Player();
    JSONParser jsonParser = new JSONParser();
    FileReader itemReader;

    public void processCommand(List<String> validCommand) throws IOException, ParseException {
        command = validCommand;

        if (command.get(0).equals("go")){
            //move engine

        }
        else if (command.get(0).equals("get")) {
            //get engine
            getEngine(command.get(1));
        }
        else if (command.get(0).equals("look")) {
            //look engine
            lookEngine(command.get(1));
        }
        else if (command.get(0).equals("use")) {
            //Use engine
        }
        else if (command.get(0).equals("quit")) {
            //quit engine
            quitEngine(command.get(1));
        }
        else if (command.get(0).equals("help")) {
            //help engine
        }
    }

    private void moveEngine(){}

    private void getEngine(String noun) throws IOException, ParseException {
        //get item from JSON file
        itemReader = new FileReader("src/Java/External_Files/inventory.json");
        JSONArray fileArray = (JSONArray) jsonParser.parse(itemReader);
        //System.out.println(inventory);

        JSONObject inventory = (JSONObject) fileArray.get(0);
        JSONObject item = (JSONObject) inventory.get("inventory");
        //JSONObject item = (JSONObject) inventory.get("inventory");

        String itemName = (String) item.get("itemName");
        System.out.println(itemName);

        if (noun.equals(itemName)){
            player.addItems(itemName);

        }
        //player.addItems(itemName);
    }

    private void lookEngine(String noun){
        //get location from JSON file
    }

    private void useEngine(String noun){}

    private void quitEngine(String noun){
        if (noun.equals("game")) {
            System.out.println("Quitting now...");
            System.exit(0);
        }
    }

    private void helpEngine(String noun){

    }
}

package Java.GameFiles;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Starts and initializes game and keeps it running, the "heart" of the program
 */
public class GameEngine {

    private TextParser parser;
    //private CommandProcessor processor;
    private JSONParserClass jsonParserClass;
    private GameLogic logic;
    private BufferedReader in;
    //private JSONParser jsonParser;
    //private FileReader reader;
    //private JSONArray file;
    private List<Location> locations;
    //private Location location;
    private Player player;
    private List<String> command;
    private String input;
    private Location playerLocation;


    public GameEngine() throws IOException, ParseException {
        parser = new TextParser();
        //processor = new CommandProcessor();
        jsonParserClass = new JSONParserClass();
        logic = new GameLogic();
        //locations = new ArrayList<>();
        in = new BufferedReader(new InputStreamReader(System.in));
        locations = jsonParserClass.locationParser();
        //jsonParser = new JSONParser();
        //reader = new FileReader("src/Java/External_Files/location.json");
        //file = (JSONArray) jsonParser.parse(reader);
        player = new Player();
    }

    /*public void locationParser() {

        for (Object o : file){
            JSONObject obj = (JSONObject) o;
            String name = (String) obj.get("locationName");
            String description = (String) obj.get("locationDescription");
            JSONArray locItems = (JSONArray) obj.get("locationItems");
            JSONArray locDirections = (JSONArray) obj.get("locationDirections");

            location = new Location(name, description, locItems, locDirections);
            //System.out.println(location);
            locations.add(location);
        }

    }*/

    public void startGame() throws IOException, ParseException  {
        //String input;
        //locationParser();

        player.setPlayerLocation(locations.get(2));
        playerLocation = player.getPlayerLocation();
        System.out.println("Welcome to Lone Survivor, a text-based adventure game! ");
        System.out.println("You were a passenger on a plane that crash landed into a forest in the middle of nowhere.");
        System.out.println("As you awaken from unconsciousness, you quickly realize you are the only survivor aboard the crash.");
        System.out.println("You must make it back to civilization or survive until rescue. Good luck.");
        System.out.println("******************************************************");

        while (true) {
            //logic.playerInterface();
            playerInterface();
        }

    }

    public void playerInterface() throws IOException, ParseException {
        //playerLocation.getName()
        System.out.println("******************************************************");
        System.out.println("You are currently located in " + playerLocation.getName().toUpperCase());
        System.out.println("Enter a command (or 'help commands' to see a list of commands): ");
        input = in.readLine();
        parser.InitialInput(input);
        if (parser.getValidCommand().size() == 2) {
            command = parser.getValidCommand();
            //processor.processCommand(command);
            commandProcessor();
        }
    }

    public void commandProcessor() throws IOException, ParseException {
        if (command.get(0).equals("go")){
            //move engine
            moveEngine(command.get(1));
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
            helpEngine(command.get(1));
        }
    }

    private void moveEngine(String noun){

        Map<String, String> playerDirection = playerLocation.getDirection();
        String choice = playerDirection.get(noun);

        for (int i = 0; i < locations.size(); i++) {
            if (choice.equals(locations.get(i).getName())) {
                player.setPlayerLocation(locations.get(i));
            }
        }
        /*if (playerLocation.getDirection().get(0).containsKey(noun)) {
            player.setPlayerLocation(locations.get(1));

        }
        else if (playerLocation.getDirection().get(1).containsKey(noun)){
            player.setPlayerLocation(locations.get(3));
        }*/
        playerLocation = player.getPlayerLocation();
    }

    private void getEngine(String noun) throws IOException, ParseException {
        //get item from JSON file
        //reader = new FileReader("src/Java/External_Files/location.json");
        //JSONArray fileArray = (JSONArray) jsonParser.parse(reader);

        //JSONObject inventory = (JSONObject) fileArray.get(0); //this line needs to be based on where the player is
        //JSONObject item = (JSONObject) inventory.get("inventory");
        //String itemName = (String) inventory.get("locationItems");

        //String itemName = (String) item.get("itemName");
        //System.out.println(itemName);
        if (noun.equals("inventory")) {
            System.out.println(player.getItems());
        }
        List<String> playerItem = playerLocation.getItems();

        if (playerItem.contains(noun)){
            player.addItems(noun);
            //need to remove items from location after picking it up
            for (int i = 0; i < locations.size(); i++) {
                if (locations.get(i).getItems().contains(noun)){
                    locations.get(i).getItems().remove(noun);
                    System.out.println(noun + " was removed from " + locations.get(i).getName());
                }
            }

        }
        else {
            System.out.println("There is no " + noun);
        }

    }

    private void lookEngine(String noun) throws IOException, ParseException {
        //get location from JSON file
        //based on players location, will determine where player can go, what they can do
        //You look around and see to the north: first class, south: service area
        //you see the following items: flashlight, life jacket


        System.out.println("You look around and see: ");
        System.out.println(playerLocation.getDescription());
        System.out.println("Items: " + playerLocation.getItems());
        System.out.println("Directions: " + playerLocation.getDirection());

        /*for (Location location : locations) {
            //JSONObject location = (JSONObject) fileArray.get(0);
            //display location name, location description, then directions, then items that can be picked up

            //String location = (String) locationName.get("locationName");
            //System.out.println(obj);
            //JSONObject location = (JSONObject) obj;

            //JSONArray locItems = (JSONArray) location.get("locationItems");
            //JSONArray locDirections = (JSONArray) location.get("locationDirections");

            System.out.println(location.getName());
            System.out.println(location.getDescription());
            System.out.println(location.getItems());
            System.out.println(location.getDirection());
        }*/




    }

    private void useEngine(String noun){}

    private void quitEngine(String noun){
        if (noun.equals("game")) {
            System.out.println("Quitting now...");
            System.exit(0);
        }
    }

    private void helpEngine(String noun) throws IOException, ParseException {
        if (noun.equals("commands")) {
            //reader = new FileReader("src/Java/External_Files/CommandList.json");
            //JSONArray fileInfo = (JSONArray) jsonParser.parse(reader);
            //JSONObject gameInfo = (JSONObject) fileInfo.get(2);
            //System.out.println(gameInfo);
            System.out.println(jsonParserClass.commandParser().get(2));
        }
        else if (noun.equals("game")){
            //reader = new FileReader("src/Java/External_Files/GameInfo.json");
            //JSONObject fileInfo = (JSONObject) jsonParser.parse(reader);
            //String gameInfo = (String) fileInfo.get("gameInfo");
            //System.out.println(gameInfo);
            System.out.println(jsonParserClass.gameInfoParser());
        }
    }
}

package Java.GameFiles;

import org.json.simple.parser.ParseException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Starts game and keeps it running, the "heart" of the program
 */
public class GameEngine {

    private TextParser parser;
    private CommandProcessor processor;
    private GameLogic logic;
    private BufferedReader in;


    public GameEngine() throws IOException, ParseException {
        //parser = new TextParser();
        //processor = new CommandProcessor();
        logic = new GameLogic();
        //in = new BufferedReader(new InputStreamReader(System.in));
    }

    public void startGame() throws IOException, ParseException  {
        String input;

        //need to create JSON file to give user the story prompt of the game
        System.out.println("You were a passenger on a plane that crash landed into a forest in the middle of nowhere.");
        System.out.println("As you awaken from unconsciousness, you quickly realize you are the only survivor aboard the crash.");
        System.out.println("You must make it back to civilization or survive until rescue. Good luck.");
        System.out.println("******************************************************");

        while (true) {
            logic.playerInterface();
        }
        /*System.out.println("Enter a command (or 'help game' to see a list of commands): ");

        input = in.readLine();
        parser.InitialInput(input);
        List<String> command = parser.getValidCommand();
        processor.processCommand(command);*/

        //need to send validated command to command processor

    }
}

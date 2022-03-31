package Java.GameFiles;

import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Takes input, gives player their current state, and decides logic of the game (the brain)
 */
public class GameLogic {

    private TextParser parser;
    private CommandProcessor processor;
    private BufferedReader in;
    private String input;
    private List<String> command;


    public GameLogic() throws IOException, ParseException {
        parser = new TextParser();
        processor = new CommandProcessor();

        in = new BufferedReader(new InputStreamReader(System.in));
    }

    public void playerInterface() throws IOException, ParseException {
        System.out.println("Enter a command (or 'help commands' to see a list of commands): ");
        input = in.readLine();
        parser.InitialInput(input);
        command = parser.getValidCommand();
        processor.processCommand(command);

    }
}

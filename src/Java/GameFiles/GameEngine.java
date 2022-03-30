package Java.GameFiles;

import org.json.simple.parser.ParseException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class GameEngine {

    private TextParser parser;
    private CommandProcessor processor;
    private BufferedReader in;
    public Player player;

    public GameEngine() throws FileNotFoundException {
        parser = new TextParser();
        processor = new CommandProcessor();
        in = new BufferedReader(new InputStreamReader(System.in));
    }

    public void startGame() throws IOException, ParseException  {
        String input;

        System.out.println("Enter a command (or to see a list of commands type 'commands'): ");

        input = in.readLine();
        parser.InitialInput(input);
        List<String> command = parser.getValidCommand();
        processor.processCommand(command);
        //need to send validated command to command processor

    }
}

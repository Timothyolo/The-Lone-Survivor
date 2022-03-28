package Java.GameFiles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class GameEngine {

    private TextParser parser = new TextParser();
    private CommandProcessor processor = new CommandProcessor();
    private BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public void startGame() throws IOException {
        String input;

        System.out.println("Enter a command: ");

        input = in.readLine();
        parser.InitialInput(input);
        List<String> command = parser.getValidCommand();
        processor.Processor(command);
        //need to send validated command to command processor

    }
}

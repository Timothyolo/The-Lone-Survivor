package Java.GameFiles;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * checks if command has valid verb and noun
 */
public class TextParser {

        //parser should lowercase all words, remove white spaces and articles, separate the verbs and nouns
        //Ingest Text, Parse it, Identify Keywords, Process Command


    JSONParser jsonParser;
    List<String> validCommand;
    FileReader reader;
    //String text;

    public TextParser() throws FileNotFoundException {
        jsonParser = new JSONParser();
        validCommand = new ArrayList<>();
        reader = new FileReader("src/Java/External_Files/CommandList.json");

    }

    /*public TextParser(String input) {
        text = input;
    }*/

    public List<String> getValidCommand() {
        return validCommand;
    }

    public void InitialInput(String text) throws IOException, ParseException {
        List<String> command;

        String newStr = text.trim().toLowerCase();

        if (newStr == "") {
            System.out.println("Please enter a command.");
        }
        else {
            command = TokenizeCommand(newStr);
            command.forEach((str) -> System.out.println(str));
            ParseCommand(command);

        }

    }

    public List<String> TokenizeCommand(String text) {
        String delims = " \t,.:;?!\"'";
        List<String> tokenList = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(text, delims);

        String x;
        while(tokenizer.hasMoreTokens()) {
            x = tokenizer.nextToken();
            tokenList.add(x);
        }

        return tokenList;
    }

    public void ParseCommand(List<String> command) throws IOException, ParseException {
        String verb;
        String noun;

        JSONArray file = (JSONArray) jsonParser.parse(reader);

        JSONObject verbObj = (JSONObject) file.get(0);
        JSONObject nounObj = (JSONObject) file.get(1);

        JSONArray verbList = (JSONArray) verbObj.get("verb");
        JSONArray nounList = (JSONArray) nounObj.get("noun");


        //List<String> verbList = new ArrayList<>(Arrays.asList("go", "get", "look", "use", "quit", "help"));
        //List<String> nounList = new ArrayList<>(Arrays.asList("radio", "compass", "flare", "inflatable raft", "flashlight", "life jacket", "food", "knife", "around", "north", "south", "west", "east", "game"));

        //need case for help game
        if (command.size() != 2) {
            System.out.println("Valid command must contain only two words. Type 'help game' for a list of valid commands.");
        }
        /*else if (command.get(0).equals("quit")){
            System.exit(0);
        }*/
        else {
            verb = command.get(0);
            if (!verbList.contains(verb)) {
                System.out.println(verb + " is not a valid action");
            }
            else{
                validCommand.add(verb);
            }
            noun = command.get(1);
            if (!nounList.contains(noun)) {
                System.out.println("There is no " + noun);
            }
            else {
                validCommand.add(noun);
            }
        }


    }

}

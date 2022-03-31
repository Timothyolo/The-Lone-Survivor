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
    JSONArray file;
    JSONObject verbObj;
    JSONObject nounObj;
    JSONObject commObj;

    JSONArray verbList;
    JSONArray nounList;
    JSONArray commList;
    //String text;

    public TextParser() throws IOException, ParseException {
        jsonParser = new JSONParser();
        validCommand = new ArrayList<>();
        reader = new FileReader("src/Java/External_Files/CommandList.json");
        file = (JSONArray) jsonParser.parse(reader);
        verbObj = (JSONObject) file.get(0);
        nounObj = (JSONObject) file.get(1);
        commObj = (JSONObject) file.get(2);
        verbList = (JSONArray) verbObj.get("verb");
        nounList = (JSONArray) nounObj.get("noun");
        commList = (JSONArray) commObj.get("valid commands");
    }

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
        String comm;
        //reader = new FileReader("src/Java/External_Files/CommandList.json");
        //JSONArray file = (JSONArray) jsonParser.parse(reader);

        /*JSONObject verbObj = (JSONObject) file.get(0);
        JSONObject nounObj = (JSONObject) file.get(1);
        JSONObject commObj = (JSONObject) file.get(2);

        JSONArray verbList = (JSONArray) verbObj.get("verb");
        JSONArray nounList = (JSONArray) nounObj.get("noun");
        JSONArray commList = (JSONArray) commObj.get("valid commands");*/

        if (command.size() != 2) {
            System.out.println("Valid command must contain only two words. Type 'help game' for a list of valid commands.");
        }
        /*else if (command.get(0).equals("quit")){
            System.exit(0);
        }*/
        else {
            verb = command.get(0);
            noun = command.get(1);

            if (verbList.contains(verb) && nounList.contains(noun)) {
                comm = verb + " " + noun;
                if (commList.contains(comm)) {
                    validCommand.clear();
                    validCommand.add(verb);
                    validCommand.add(noun);
                }
                else {
                    System.out.println(comm + " is not a valid action");
                }

            }
            else{
                System.out.println(verb + noun + " is not a valid action");
            }

            /*if (!nounList.contains(noun)) {
                System.out.println("There is no " + noun);
            }
            else {
                validCommand.add(noun);
            }*/

        }


    }

}

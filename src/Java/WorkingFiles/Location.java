package Java.WorkingFiles;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Location {

    public static void main(String[] args)
    {

        JSONParser jsonParser = new JSONParser();  // This helps to read our json file

        try (FileReader reader = new FileReader("src/Java/Location.json"))
        {
            Object obj = jsonParser.parse(reader);

            JSONArray location = (JSONArray) obj;
            System.out.println(location);

            location.forEach( loc -> parseLocationObject( (JSONObject) loc ) );

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private static void parseLocationObject(JSONObject location)
    {
        //testing: getting items from the location object
        JSONObject locationObject = (JSONObject) location.get("location");

        String direction = (String) locationObject.get("direction");
        System.out.println(direction);

        String locationID = (String) locationObject.get("locationID");
        System.out.println(locationID);


    }
}
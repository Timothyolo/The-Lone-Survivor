package Java.WorkingFiles;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Inventory {

    public static void main(String[] args)
    {

        JSONParser jsonParser = new JSONParser();  // This helps to read our json file

        try (FileReader reader = new FileReader("src/Java/External_Files/inventory.json"))
        {
            Object obj = jsonParser.parse(reader);

            JSONArray inventory = (JSONArray) obj;
            System.out.println(inventory);

            inventory.forEach( inv -> parseInventoryObject( (JSONObject) inv ) );

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private static void parseInventoryObject(JSONObject inventory)
    {
        //Player can get items from the inventory
        JSONObject inventoryObject = (JSONObject) inventory.get("inventory");

        String itemName = (String) inventoryObject.get("itemName");
        System.out.println("Make a call with " + itemName);

        String itemAttribute = (String) inventoryObject.get("itemAttribute");
        System.out.println(itemAttribute);

        String itemLocation = (String) inventoryObject.get("itemLocation");
        System.out.println(itemLocation);

    }
}
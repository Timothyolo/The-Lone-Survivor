package Java.GameFiles;

import java.util.ArrayList;

public class Player {

    private String name;
    private ArrayList<String> inventory;

    public Player(String name, ArrayList<String> items) {
        this.name = name;
        this.inventory = items;
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getItems() {
        return inventory;
    }

    public void addItems(String item) {
        inventory.add(item);
        //inventory.add(item);
    }

    public void performAction() {

    }
}

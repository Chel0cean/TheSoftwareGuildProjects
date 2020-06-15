package dao;

import dto.Item;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author chelseamiller
 */
public class VendingMachineDaoFileImpl implements VendingMachineDao {

    private final String ROSTER_FILE;
    public static final String DELIMITER = "::";

    public VendingMachineDaoFileImpl() {
        ROSTER_FILE = "roster.txt";
    }

    public VendingMachineDaoFileImpl(String rosterTextFile) {
        ROSTER_FILE = rosterTextFile;
    }

    private Map<String, Item> items = new HashMap<>();

    @Override
    public Item addItem(String name, Item item) throws VendingMachinePersistenceException {
        loadRoster();
        Item newItem = items.put(name, item);
        writeRoster();
        return newItem;
    }

    @Override
    public void editItem(String oldName, Item newItem) throws VendingMachinePersistenceException {
        loadRoster();
        items.remove(oldName);
        items.put(newItem.getName(), newItem);
        writeRoster();

    }

    @Override
    public Item getItem(String name) throws VendingMachinePersistenceException {
        loadRoster();
        Item item;
        try {
            item = items.get(name);
        } catch (NullPointerException ex) {
            item = null;

        }
        return item;
    }

    @Override
    public List<Item> getAllItems() throws VendingMachinePersistenceException {
        loadRoster();
        return new ArrayList(items.values());
    }

    @Override
    public Item removeItem(String name) throws VendingMachinePersistenceException {
        loadRoster();
        Item removedItem = items.remove(name);
        writeRoster();
        return removedItem;
    }

    private Item unmarshallItem(String itemAsText) {

        String[] itemTokens = itemAsText.split(DELIMITER);

        String name = itemTokens[0];
        int inventoryCount = Integer.parseInt(itemTokens[1]);
        BigDecimal cost = new BigDecimal(itemTokens[2]);

        Item itemFromFile = new Item(name);

        itemFromFile.setInventoryCount(inventoryCount);

        itemFromFile.setCost(cost);

        return itemFromFile;
    }

    private void loadRoster() throws VendingMachinePersistenceException {
        Scanner scanner;

        try {

            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(ROSTER_FILE)));
        } catch (FileNotFoundException e) {
            throw new VendingMachinePersistenceException(
                    "-_- Could not load roster data into memory.", e);
        }

        String currentLine;

        Item currentItem;

        while (scanner.hasNextLine()) {

            currentLine = scanner.nextLine();

            currentItem = unmarshallItem(currentLine);

            items.put(currentItem.getName(), currentItem);
        }

        scanner.close();
    }

    private String marshallItem(Item anItem) {

        String itemAsText = anItem.getName() + DELIMITER;

        itemAsText += Integer.toString(anItem.getInventoryCount()) + DELIMITER;

        itemAsText += anItem.getCost().toString();

        return itemAsText;
    }

    private void writeRoster() throws VendingMachinePersistenceException {

        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(ROSTER_FILE));
        } catch (IOException e) {
            throw new VendingMachinePersistenceException(
                    "Could not save item data.", e);
        }

        String itemAsText;
        List<Item> itemList = new ArrayList(items.values());
        for (Item currentItem : itemList) {

            itemAsText = marshallItem(currentItem);

            out.println(itemAsText);

            out.flush();
        }

        out.close();
    }

}

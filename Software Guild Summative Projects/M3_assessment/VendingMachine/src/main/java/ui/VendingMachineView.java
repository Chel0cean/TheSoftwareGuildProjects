package ui;

import dto.Item;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author chelseamiller
 */
public class VendingMachineView {

    private UserIO io;

    public VendingMachineView(UserIO io) {
        this.io = io;
    }

    //
    //--------------------------All Menus--------------------
    //
    //
    public int printUserMenuAndGetSelection() {
        int answer = 0;
        do {
            io.print("Main Menu");
            io.print("1. Purchase Items");
            io.print("2. Admin services");
            io.print("3. Exit");
            try {
                answer = io.readInt("Please select from the above choices.", 1, 3);
                return answer;
            } catch (NumberFormatException e) {
                io.print("Entry is invalid, must be numerical and between 1-3.");
            }
        } while (answer == 0);

        return answer;
    }

    public int printAdminMenuAndGetSelection() {
        int answer = 0;

        do {
            io.print("Admin Menu");
            io.print("1. List Items");
            io.print("2. Create New Item");
            io.print("3. View an Item");
            io.print("4. Edit an Item");
            io.print("5. Remove an Item");
            io.print("6. Return to Main Menu");

            try {
                answer = io.readInt("Please select from the above choices.", 1, 6);
                return answer;
            } catch (NumberFormatException e) {
                io.print("Entry is invalid, must be numerical and between 1-6.");
            }

        } while (answer == 0);

        return answer;
    }

    public int printEditMenuAndGetSelection() {
        int answer = 0;

        do {
            io.print("Which of the following fields would you like to update? (answer numerically)");
            io.print("1.Name: ");
            io.print("2.Inventory Count: ");
            io.print("3.Cost: ");
            io.print("4.Return to Main Menu");

            try {
                answer = io.readInt("Please select from the above choices.", 1, 4);
                return answer;
            } catch (NumberFormatException e) {
                io.print("Entry is invalid, must be numerical and between 1-4.");
            }

        } while (answer == 0);

        return answer;
    }
    //
    //-------------------------All getters and prompts--------------------
    //
    //

    public Item getNewItemInfo() {

        String name = io.readString("Please enter the Item's name");
        int inventoryCount = io.readInt("Please enter the Item's inventory count");
        BigDecimal itemCost = io.readBigDecimal("Please enter the Item's cost");

        Item currentItem = new Item(name);
        currentItem.setInventoryCount(inventoryCount);
        currentItem.setCost(itemCost);
        return currentItem;
    }

    public String getItemNameChoice() {
        return io.readString("Please enter the Item's name.");
    }

    public boolean promptToContinueEditing() {
        String answer = io.readString("Continue editing this item? (y/n)");
        return answer.equals("y");
    }

    public String promptNameUpdate() {
        String update = io.readString("Please enter the Item's name:");
        return update;
    }

    public int promptInventoryCountUpdate() {
        int update = 0;
        do {
            try {
                update = io.readInt("Please enter the Item's inventory count:");
                return update;
            } catch (NumberFormatException e) {
                io.print("Entry is invalid, must be numerical.");
            }
        } while (update == 0);
        return update;
    }

    public BigDecimal promptCostUpdate() {
        BigDecimal update = null;
        do {
            try {
                update = io.readBigDecimal("Please enter the Item's cost:");
                return update;
            } catch (NumberFormatException e) {
                io.print("Entry is invalid, must be numerical.");
            }
        } while (update.equals(null));
        return update;
    }

    //
    //-------------------------All admin function displays--------------------
    //
    //
    public void displayItem(Item item) {
        if (item != null) {
            io.print(item.getName());
            io.print("Inventory count: " + String.valueOf(item.getInventoryCount()));
            io.print("Cost: $" + item.getCost().toString());
            io.print("");
        } else {
            io.print("No such item.");
        }
    }

    public void displayItemList(List<Item> itemList) {
        io.print("~~~~~~~~~~~~~~~~~~~All Items~~~~~~~~~~~~~~~~~~~");
        itemList.stream().map((currentItem) -> String.format("~%s : inventory count: %s cost: %s",
                currentItem.getName(),
                currentItem.getInventoryCount(),
                currentItem.getCost())).forEachOrdered((itemInfo) -> {
            io.print(itemInfo);
        });
        io.print("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    public void displayRemoveResult(Item itemRecord) {
        if (itemRecord != null) {
            io.print("Item successfully removed.");
        } else {
            io.print("No such item.");
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }

    //
    //-----------------------------All banners-------------------
    //
    //
    public void displayCreateItemBanner() {

        io.print("=== Create Item ===");
    }

    public void displayCreateSuccessBanner() {

        io.readString(
                "Item successfully created.  Please hit enter to continue");
    }

    public void displayEditItemBanner() {
        io.print("=== Edit Item ===");
    }

    public void displayNameUpdatedBanner(String name) {
        io.print(name + "'s name has been updated.");
    }

    public void displayInventoryCountUpdatedBanner(String name) {
        io.print(name + "'s inventory count has been updated.");
    }

    public void displayCostUpdatedBanner(String name) {
        io.print(name + "'s cost has been updated.");
    }

    public void displayDisplayAllBanner() {

        io.print("=== Display All Items ===");
    }

    public void displayDisplayItemBanner() {
        io.print("=== Display Item ===");
    }

    public void displayRemoveItemBanner() {
        io.print("=== Remove Item ===");
    }

    public void displayPurchaseSuccessBanner(Item item) {
        io.print("=== Purchase Success! ===");
        io.print(item.getName() + " dispensed below. Enjoy!");
    }

    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }

    public void displayExitBanner() {
        io.print("");
        io.print("Good Bye!!!");
        io.print("");
    }
}

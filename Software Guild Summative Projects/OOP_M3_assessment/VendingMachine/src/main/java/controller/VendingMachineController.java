package controller;

import dao.VendingMachinePersistenceException;
import dto.Change;
import dto.Item;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import service.VendingMachineDataValidationException;
import service.VendingMachineOutOfStockException;
import service.VendingMachineServiceLayer;
import ui.UserIO;
import ui.UserIOConsoleImpl;
import ui.VendingMachineView;

/**
 *
 * @author chelseamiller
 */
public class VendingMachineController {

    private final VendingMachineView view;
    private final VendingMachineServiceLayer service;
    private final UserIO io = new UserIOConsoleImpl();

    public VendingMachineController(VendingMachineServiceLayer service, VendingMachineView view) {
        this.service = service;
        this.view = view;
    }

    //   
    //-----------------------Main Menu------------------------
    //
    //
    public void run() throws VendingMachineDataValidationException, VendingMachineOutOfStockException, VendingMachinePersistenceException {
        boolean keepGoing = true;
        
            while (keepGoing) {

                int menuSelection = getUserMenuSelection();

                switch (menuSelection) {
                    case 1:
                        purchaseItems();
                        break;
                    case 2:
                        admin();
                        break;
                    case 3:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }

            }
            exitMessage();
       
    }

    //
    //---------------------first function of main menu--------------------
    //
    //
    private void purchaseItems() throws VendingMachinePersistenceException, VendingMachineDataValidationException, VendingMachineOutOfStockException {

        List<Item> itemList = service.getAllItems();
        List<Item> itemsAvailable = itemList.stream().filter((i) -> i.getInventoryCount() > 0)
                .collect(Collectors.toList());

        BigDecimal emptyBank = new BigDecimal("00.00");
        BigDecimal bank;
        view.displayItemList(itemsAvailable);
        io.print("");
        bank = getMoney(emptyBank);
        String input = io.readString("Enter the name of the item you would like to purchase:");
        Item item = service.getItemUser(input);
        do {
            if (item != null) {
                completeTransaction(bank, item);
                break;

            } else {
                int result =0;
                do{
                try{
                result = io.readInt("Would you like to choose another item (1) or have your money refunded (2)?", 1, 2);
                }catch(NumberFormatException e){
                 io.print("Entry is invalid, must be either 1 or 2.");   
                }
                } while(result ==0); 
                
                switch (result) {
                    case 1:
                        view.displayItemList(itemsAvailable);
                        input = io.readString("Enter the name of the item you would like to purchase:");
                        item = service.getItemUser(input);
                        break;
                    case 2:
                        giveChange(bank);
                        bank = emptyBank;
                        break;
                }
            }
        } while (!(bank.equals(emptyBank)));
    }

    //
    //--------------all 5 functions used in purchase function-----------------
    //
    //
    private BigDecimal getMoney(BigDecimal bank) {
        BigDecimal userBank = null;
        boolean keepGoing;
        do {
            try {
                userBank = (io.readBigDecimal("Please insert money: " + "(current bank is $" + bank + ")")).setScale(2);
                keepGoing = false;
            } catch (NumberFormatException e) {
                io.print("Entry is invalid, must be numerical. ");
                keepGoing = true;
            }
        } while (keepGoing && (userBank == null));
        return userBank;
    }

    private void completeTransaction(BigDecimal bank, Item item) throws VendingMachinePersistenceException, VendingMachineOutOfStockException, VendingMachineDataValidationException {
        BigDecimal emptyBank = new BigDecimal("00.00");
        do {
            BigDecimal cost = item.getCost();
            int difference = bank.compareTo(cost);

            switch (difference) {
                case -1:
                    int answer = notEnoughMoney(bank, cost, item);
                    switch (answer) {
                        case 1:
                            bank = bank.add(getMoney(bank));
                            break;

                        case 2:
                            giveChange(bank);
                            bank = emptyBank;
                            break;

                    }
                    break;
                case 0:
                    enoughMoney(item);
                    bank = emptyBank;
                    break;
                case 1:
                    enoughMoney(item);
                    giveChange(bank.subtract(cost));
                    bank = emptyBank;
                    break;
                default:
                    unknownCommand();
            }

        } while (!(bank.equals(emptyBank)));
    }

    private int notEnoughMoney(BigDecimal bank, BigDecimal cost, Item item) {
        io.print(item.getName() + " costs $" + cost + ". You've only paid " + "$" + bank + ".");
        int answer = 0;
        do {
            try {
                answer = io.readInt("Would you like to add more money (1) or cancel and have your money refunded(2)?", 1, 2);
            } catch (NumberFormatException e) {
                io.print("Entry is invalid, must be either 1 or 2.");
            }
        } while (answer == 0);

        return answer;

    }

    private void enoughMoney(Item item) throws VendingMachineOutOfStockException, VendingMachineDataValidationException, VendingMachinePersistenceException {
        service.purchaseItem(item);
        view.displayPurchaseSuccessBanner(item);

    }

    private void giveChange(BigDecimal change) throws VendingMachineOutOfStockException, VendingMachineDataValidationException, VendingMachinePersistenceException {
        Change currentChange = service.giveChange(change);
        io.print("Your change totals $" + currentChange.getTotal() + " and will be dispensed as:");
        if (currentChange.getQuarters() > 1) {
            io.print(currentChange.getQuarters() + " quarters");
        }
        if (currentChange.getQuarters() == 1) {
            io.print(currentChange.getQuarters() + " quarter");
        }
        if (currentChange.getDimes() > 1) {
            io.print(currentChange.getDimes() + " dimes");
        }
        if (currentChange.getDimes() == 1) {
            io.print(currentChange.getDimes() + " dime");
        }
        if (currentChange.getNickels() > 1) {
            io.print(currentChange.getNickels() + " nickels");
        }
        if (currentChange.getNickels() == 1) {
            io.print(currentChange.getNickels() + " nickel");
        }
        if (currentChange.getPennies() > 1) {
            io.print(currentChange.getPennies() + " pennies");
        }
        if (currentChange.getPennies() == 1) {
            io.print(currentChange.getPennies() + " penny");
        }
        io.print("");

    }

    //
    //---------------second function of main menu---------------------
    //
    //
    private void admin() throws VendingMachineDataValidationException, VendingMachineOutOfStockException, VendingMachinePersistenceException {
        String password = io.readString("Please enter password:");
        if (password.equals("abcd")) {
            runAdmin();
        } else {
            io.print("Password incorrect.");
            run();
        }
    }

    //
    //-------function that runs if admin password is correct, extension of 2nd main menu choice.---------------
    //
    //
    public void runAdmin() throws VendingMachineDataValidationException, VendingMachineOutOfStockException {
        boolean keepGoing = true;
        int menuSelection;
        try {
            while (keepGoing) {

                menuSelection = getAdminMenuSelection();

                switch (menuSelection) {
                    case 1:
                        listItems();
                        break;
                    case 2:
                        createItem();
                        break;
                    case 3:
                        viewItem();
                        break;
                    case 4:
                        editItem();
                        break;
                    case 5:
                        removeItem();
                        break;
                    case 6:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }

            }

        } catch (VendingMachinePersistenceException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    //
    //---------------All 5 functions used in admin menu---------------------
    //
    //
    private void createItem() throws VendingMachinePersistenceException {
        view.displayCreateItemBanner();
        boolean hasErrors;
        do {
            Item currentItem = view.getNewItemInfo();
            try {
                service.createItem(currentItem);
                view.displayCreateSuccessBanner();
                hasErrors = false;
            } catch (VendingMachineOutOfStockException | VendingMachineDataValidationException e) {
                hasErrors = true;
                view.displayErrorMessage(e.getMessage());
            }
        } while (hasErrors);
    }

    private void editItem() throws VendingMachinePersistenceException, VendingMachineDataValidationException, VendingMachineOutOfStockException {
        boolean editingItem = true;
        view.displayEditItemBanner();
        String editedItem = view.getItemNameChoice();
        Item item = service.getItem(editedItem);
        if (item == null) {
            editingItem = false;
        }
        view.displayItem(item);
        try {
            while (editingItem) {
                int editMenuSelection = getEditMenuSelection();
                switch (editMenuSelection) {
                    case 1:
                        updateName(item);
                        editingItem = view.promptToContinueEditing();
                        break;
                    case 2:
                        updateInventoryCount(editedItem);
                        editingItem = view.promptToContinueEditing();
                        break;
                    case 3:
                        updateCost(editedItem);
                        editingItem = view.promptToContinueEditing();
                        break;

                    case 4:
                        editingItem = false;
                        break;

                    default:
                        unknownCommand();

                }

            }

        } catch (VendingMachinePersistenceException e) {
            view.displayErrorMessage(e.getMessage());
        }

    }

    private void viewItem() throws VendingMachinePersistenceException {
        view.displayDisplayItemBanner();
        String name = view.getItemNameChoice();
        Item item = service.getItem(name);
        view.displayItem(item);
    }

    private void listItems() throws VendingMachinePersistenceException {
        view.displayDisplayAllBanner();
        List<Item> itemList = service.getAllItems();
        view.displayItemList(itemList);
    }

    private void removeItem() throws VendingMachinePersistenceException {
        view.displayRemoveItemBanner();
        String name = view.getItemNameChoice();
        service.removeItem(name);
        view.displayRemoveItemBanner();
    }

    //
    //------------All 3 functions used in edit menu---------------------
    //
    //
    public void updateName(Item oldItem) throws VendingMachinePersistenceException, VendingMachineOutOfStockException, VendingMachineDataValidationException {
        String oldName = oldItem.getName();
         String newName = view.promptNameUpdate();
        oldItem.setName(newName);
        Item newItem = oldItem;
        service.editItem(oldName, newItem);
        view.displayNameUpdatedBanner(newItem.getName());

    }

    public void updateInventoryCount(String editedItem) throws VendingMachinePersistenceException, VendingMachineOutOfStockException, VendingMachineDataValidationException {
        int inventoryCount = view.promptInventoryCountUpdate();
        Item item = service.getItem(editedItem);
        item.setInventoryCount(inventoryCount);
        service.editItem(item.getName(), item);
        view.displayInventoryCountUpdatedBanner(item.getName());

    }

    public void updateCost(String editedItem) throws VendingMachinePersistenceException, VendingMachineOutOfStockException, VendingMachineDataValidationException {
        BigDecimal cost = view.promptCostUpdate();
        Item item = service.getItem(editedItem);
        item.setCost(cost);
        service.editItem(item.getName(), item);
        view.displayCostUpdatedBanner(item.getName());

    }

    //
    //-------------all 3 menu selection functions-------------------
    //
    //
    private int getUserMenuSelection() {
        return view.printUserMenuAndGetSelection();
    }

    private int getAdminMenuSelection() {
        return view.printAdminMenuAndGetSelection();
    }

    private int getEditMenuSelection() {
        return view.printEditMenuAndGetSelection();
    }

    //
    //------------utility functions-----------------
    //
    //
    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }

}

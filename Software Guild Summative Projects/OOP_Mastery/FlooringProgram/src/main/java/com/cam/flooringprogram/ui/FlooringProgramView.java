package com.cam.flooringprogram.ui;

import com.cam.flooringprogram.dto.Order;
import com.cam.flooringprogram.dto.Product;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

/**
 *
 * @author chelseamiller
 */
public class FlooringProgramView {

    private UserIO io = new UserIOConsoleImpl();

    public FlooringProgramView(UserIO io) {
        this.io = io;
    }

    //
    //--------------------------All IO functions--------------------
    //
    //
    public void print(String msg) {
        io.print(msg);
    }

    public BigDecimal readBigDecimal(String prompt) {
        return io.readBigDecimal(prompt);
    }

    public double readDouble(String prompt) {
        return io.readDouble(prompt);
    }

    public double readDouble(String prompt, double min, double max) {
        return io.readDouble(prompt, min, max);
    }

    public float readFloat(String prompt) {
        return io.readFloat(prompt);
    }

    public float readFloat(String prompt, float min, float max) {
        return io.readFloat(prompt, min, max);
    }

    public int readInt(String prompt) {
        return io.readInt(prompt);
    }

    public int readInt(String prompt, int min, int max) {
        return io.readInt(prompt, min, max);
    }

    public long readLong(String prompt) {
        return io.readLong(prompt);
    }

    public long readLong(String prompt, long min, long max) {
        return io.readLong(prompt, min, max);
    }

    public String readString(String prompt) {
        return io.readString(prompt);
    }

    //
    //--------------------------All Menu functions--------------------
    //
    //
    public int printMainMenuAndGetSelection() {
        int answer = 0;

        do {
            io.print("Flooring Program");
            io.print("1. Display Orders");
            io.print("2. Add an Order");
            io.print("3. Edit an Order");
            io.print("4. Remove an Order");
            io.print("5. Export All Data");
            io.print("6. Quit");

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
            io.print("1. Customer Name");
            io.print("2. State");
            io.print("3. Material Type");
            io.print("4. Area");
            io.print("5. Return to Main Menu");

            try {
                answer = io.readInt("Please select from the above choices.", 1, 5);
                return answer;
            } catch (NumberFormatException e) {
                io.print("Entry is invalid, must be numerical and between 1-5.");
            }

        } while (answer == 0);

        return answer;
    }

    //
    //--------------------------Confirmation--------------------
    //
    //
    public int confirmOrderSave(Order currentOrder) {
        displayOrder(currentOrder);

        int answer = 0;
        do {
            io.print("Do you wish to save the above Order?");
            io.print("1. Save Order");
            io.print("2. Cancel (Order will not be saved)");

            try {
                answer = io.readInt("Please select from the above choices.", 1, 2);
                return answer;
            } catch (NumberFormatException e) {
                io.print("Entry is invalid, must be numerical and between 1-2.");
            }
        } while (answer == 0);

        return answer;

    }

    public int confirmDeleteOrder(Order currentOrder) {

        displayOrder(currentOrder);

        int answer = 0;
        do {
            io.print("Do you wish to delete the above Order?");
            io.print("1. Delete Order");
            io.print("2. Cancel (Order will not be deleted)");

            try {
                answer = io.readInt("Please select from the above choices.", 1, 2);
                return answer;
            } catch (NumberFormatException e) {
                io.print("Entry is invalid, must be numerical and between 1-2.");
            }
        } while (answer == 0);

        return answer;

    }

    //
    //--------------------------All get functions--------------------
    //
    //
    public LocalDate getOrderDate() {
        LocalDate orderDate = null;
        boolean valid = false;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        do {
            String dateAsString = io.readString("Please enter the installation date(MM-dd-yyyy)");

            try {
                orderDate = LocalDate.parse(dateAsString, formatter);
                valid = true;
            } catch (DateTimeParseException e) {
                print("Entry is invalid, must be entered in the format: 'MM-dd-yyyy' (ex: December 31st, 2050 would be 12-31-2050)");
                valid = false;
            }
        } while (valid == false);
        return orderDate;
    }

    public String getCustomerName() {

        String updatedEntry = io.readString("Please input Customer Name:");
        return updatedEntry;

    }

    public String getState(List<String> allStates) {
        for (String i : allStates) {
            io.print(i);

        }
        String updatedEntry = io.readString("Please input State Abbreviation (ex: 'CA'): ");
        return updatedEntry;

    }

    public String getProductType(List<Product> allProducts) {
        String updatedEntry = null;
        io.print("Material: Material Cost Per Sq Ft | Labor Cost Per Sq Ft");
        io.print("________________________________________________________");
        for (Product i : allProducts) {
            io.print(i.getMaterialType() + ": $" + i.getMaterialCostSqFt() + " | $" + i.getLaborCostSqFt());

        }
        io.print("---------------------------------------");
        String userEntry = io.readString("Please input Material Type: ");
        if (userEntry.length() > 1) {
            updatedEntry = userEntry.substring(0, 1).toUpperCase() + userEntry.substring(1).toLowerCase();
        }
        return updatedEntry;

    }

    public String getArea() {
        String updatedEntry = null;
        updatedEntry = io.readString("Please input Area: ");
        return updatedEntry;

    }

    //
    //--------------------------All Display functions--------------------
    //
    //
    public void displayOrder(Order currentOrder) {
        io.print("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        io.print("Order Number: " + Integer.toString(currentOrder.getOrderNumber()));
        io.print("Order Date: " + currentOrder.getOrderDate().toString());
        io.print("Customer Name: " + currentOrder.getCustomerName());
        io.print("State: " + (currentOrder.getState()).getName());
        io.print("Floor Material: " + currentOrder.getProduct().getMaterialType());
        io.print("Area: " + currentOrder.getArea().toString());
        io.print("Total cost of materials: $" + currentOrder.getMaterialCostTotal());
        io.print("Total cost of labor: $" + currentOrder.getLaborCostTotal());
        io.print("Tax: $" + currentOrder.getTaxCostTotal());
        io.print("Total Cost: $" + currentOrder.getTotalCost());
        io.print("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    public void displayOrders(List<Order> allOrdersFromDate) {
        io.print("~~~~~~~~~~~~~~~~~~~All Orders~~~~~~~~~~~~~~~~~~~");
        allOrdersFromDate.stream().map((currentOrder) -> String.format("Order Number: ~%s : Customer Name: %s State: %s Tax Rate: %s Material Type: %s Area: %s Tax Cost: $%s Total: $%s",
                currentOrder.getOrderNumber(), currentOrder.getCustomerName(), currentOrder.getState().getAbbreviation(), currentOrder.getTaxRate(), currentOrder.getProduct().getMaterialType(), currentOrder.getArea(), currentOrder.getMaterialCostPerSqFt(), currentOrder.getLaborCostPerSqFt(), currentOrder.getTaxCostTotal(), currentOrder.getTotalCost()
        )).forEachOrdered((orderInfo) -> {
            io.print(orderInfo);
        });
        io.print("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

    }

    public void displayExitBanner() {
        io.print("");
        io.print("Exiting Program.");
        io.print("");

    }

    public void displayAllOrdersBanner() {

    }

    public void displayCreateOrderSuccessBanner(int orderNumber) {
        io.print("*********************");
        io.print("Order Number " + orderNumber + " successfully created.");
    }

    public void displayCreateBanner() {
        io.print("=== Create Order ===");

    }

    public void displayEditOrderBanner() {
        io.print("=== Edit Order ===");
    }

    public void displayEditSuccessbanner(int orderNumber) {
        io.print("*********************");
        io.print("Order Number " + orderNumber + " successfully updated.");

    }

    public void displayDeleteOrderBanner() {
        io.print("=== Delete Order ===");
    }

    public void displayDeleteOrderSuccessBanner(int orderNumber) {
        io.print("*********************");
        io.print("Order Number " + orderNumber + " successfully deleted.");
    }

    public void displayExportDataBanner() {
        io.print("=== Export Data ===");
    }

    public void displayExportSuccessBanner() {
        io.print("*********************");
        io.print("All data has been exported.");
    }

    public int getOrderNumber() {
        int orderNumber = 0;
        boolean valid = false;
        do {
            try {
                orderNumber = readInt("Please input order number:");
                valid = true;
            } catch (NumberFormatException e) {
                print("Entry must be numerical.");
                valid = false;
            }
        } while (valid == false);
        return orderNumber;
    }

    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }
}

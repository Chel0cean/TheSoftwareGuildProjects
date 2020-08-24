package com.cam.flooringprogram.controller;

import com.cam.flooringprogram.dao.FlooringProgramPersistenceException;
import com.cam.flooringprogram.dto.Order;
import com.cam.flooringprogram.dto.Product;
import com.cam.flooringprogram.dto.State;
import com.cam.flooringprogram.service.FlooringProgramService;
import com.cam.flooringprogram.service.FlooringProgramUserValidationException;
import com.cam.flooringprogram.ui.FlooringProgramView;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author chelseamiller
 */
public class FlooringProgramController {
    
    private final FlooringProgramView view;
    private final FlooringProgramService service;
    boolean keepTrying;
    
    public FlooringProgramController(FlooringProgramView view, FlooringProgramService service) {
        this.service = service;
        this.view = view;
        
    }
    
    public void run() throws FlooringProgramPersistenceException, FlooringProgramUserValidationException {
        service.loadAssistingCollections();
        boolean keepGoing = true;
        
        while (keepGoing) {
            
            int menuSelection = view.printMainMenuAndGetSelection();
            
            switch (menuSelection) {
                case 1:
                    displayOrders();
                    break;
                case 2:
                    createOrder();
                    break;
                case 3:
                    editOrder();
                    break;
                case 4:
                    removeOrder();
                    break;
                case 5:
                    exportData();
                    break;
                case 6:
                    keepGoing = false;
                    break;
                default:
                    unknownCommand();
            }
            
        }
        view.displayExitBanner();
        
    }
    
    private void createOrder() throws FlooringProgramPersistenceException, FlooringProgramUserValidationException {
        keepTrying = false;
        view.displayCreateBanner();
        Order newOrder = new Order(service.getOrderNumber());
        do {
            String customerName = view.getCustomerName();
            while (customerName.length() == 0) {
                System.out.println("*Field is required*");
                customerName = view.getCustomerName();
            }
            if (service.validateCustomerName(customerName) != true) {
                view.print("Customer name may only contain characters [a-z], [0-9], and special characters [.,].");
                keepTrying = false;
            } else {
                newOrder.setCustomerName(customerName);
                keepTrying = true;
            }
        } while (keepTrying == false);
        
        List<String> states = service.getStateAbbreviationList();
        State stateForOrder = null;
        String stateString;
        keepTrying = false;
        while (keepTrying == false) {
            stateString = view.getState(states);
            if (stateString != null && stateString.length() > 0) {
                stateForOrder = service.getState(stateString.toUpperCase());
                if (stateForOrder != null) {
                    keepTrying = true;
                } else {
                    keepTrying = false;
                    view.print("*Entry is not a recognized state for ordering in, please choose a state from the list below.*");
                }
            } else {
                view.print("*Field is required*");
            }
            
        }
        
        newOrder.setState(stateForOrder);
        newOrder.setTaxRate(stateForOrder.getTaxRate());
        List<Product> products = service.getProducts();
        
        String productType = null;
        Product productForOrder = null;
        keepTrying = false;
        while (keepTrying == false) {
            try {
                productType = view.getProductType(products);
                try {
                    productForOrder = service.getProduct(productType);
                    
                    if (productForOrder == null) {
                        view.print("");
                        view.print("*Please enter a valid product type from the list below*");
                        view.print("");
                        view.print("");
                        keepTrying = false;
                    } else {
                        keepTrying = true;
                    }
                } catch (Exception e) {
                    view.print("");
                    view.print("*Please enter a valid product type from the list below*");
                    keepTrying = false;
                    view.print("");
                    view.print("");
                }
            } catch (Exception e) {
                keepTrying = false;
                view.print("");
                view.print("*Field is required*");
                view.print("");
                view.print("");
            }
            
        }
        newOrder.setLaborCostPerSqFt(productForOrder.getLaborCostSqFt());
        newOrder.setMaterialCostPerSqFt(productForOrder.getMaterialCostSqFt());
        newOrder.setProduct(productForOrder);
        keepTrying = false;
        String areaAsString;
        do {
            areaAsString = view.getArea();
            if (areaAsString.length() > 0) {
                try {
                    BigDecimal area = new BigDecimal(areaAsString);
                    if (area.compareTo(new BigDecimal("100.00")) == -1) {
                        System.out.println("*Minimum order size is 100 sq ft.*");
                        keepTrying = false;
                    } else {
                        newOrder.setArea(area);
                        keepTrying = true;
                    }
                } catch (Exception e) {
                    System.out.println("*Area input must be numerical Ex: '2100.50'*");
                    keepTrying = false;
                }
            } else {
                view.print("*Field is required*");
                keepTrying = false;
            }
        } while (keepTrying == false);
        
        LocalDate orderDate = null;
        while (orderDate == null) {
            try {
                orderDate = view.getOrderDate();
            } catch (Exception e) {
                System.out.println("*The order date must be entered numerically in the following format: MM-dd-yyyy (example; December 31st, 2050 would be '12-31-2050'*.");
                orderDate = null;
            }
            
            while (orderDate != null && orderDate.isBefore(LocalDate.now())) {
                System.out.println("*Order date must be in the future*");
                orderDate = view.getOrderDate();
            }
        }
        newOrder.setOrderDate(orderDate);
        newOrder.setLaborCostTotal(service.calculateLaborCostTotal(newOrder));
        newOrder.setMaterialCostTotal(service.calculateMaterialCostTotal(newOrder));
        newOrder.setTaxCostTotal(service.calculateTaxCostTotal(newOrder));
        newOrder.setTotalCost(service.calculateTotalCost(newOrder));
        int answer = view.confirmOrderSave(newOrder);
        if (answer == 1) {
            service.createOrder(newOrder);
            view.displayCreateOrderSuccessBanner(newOrder.getOrderNumber());
        } else {
            System.out.println("*Order cancelled.*");
        }
        
    }
    
    private void editOrder() throws FlooringProgramPersistenceException, FlooringProgramUserValidationException {
        view.displayEditOrderBanner();
        int orderNumber = view.getOrderNumber();
        LocalDate orderDate = view.getOrderDate();
        Order currentOrder = null;
        boolean valid = false;
        try {
            currentOrder = service.getOrder(orderNumber, orderDate);
            valid = true;
        } catch (NullPointerException e) {
            view.print("*Order not found*");
            valid = false;
        }
        if (valid) {
            view.displayOrder(currentOrder);
            boolean keepGoing = true;
            
            while (keepGoing) {
                
                int menuSelection = view.printEditMenuAndGetSelection();
                
                switch (menuSelection) {
                    case 1:
                        updateCustomerName(currentOrder);
                        break;
                    case 2:
                        updateState(currentOrder);
                        break;
                    case 3:
                        updateProduct(currentOrder);
                        break;
                    case 4:
                        updateArea(currentOrder);
                        break;
                    case 5:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }
                
            }
            
            view.print("Order number " + orderNumber + " successfully updated.");
            view.displayExitBanner();
        }
        
    }
    
    private void removeOrder() throws FlooringProgramPersistenceException {
        view.displayDeleteOrderBanner();
        Order orderToBeDeleted = null;
        boolean valid = false;
        int orderNumber = view.getOrderNumber();
        LocalDate orderDate = view.getOrderDate();
        try {
            orderToBeDeleted = service.getOrder(orderNumber, orderDate);
            valid = true;
        } catch (NullPointerException e) {
            view.print("*Order not found*");
            valid = false;
        }
        if (valid) {
            int answer = view.confirmDeleteOrder(orderToBeDeleted);
            
            if (answer == 1) {
                int deletedNumber = service.removeOrder(orderNumber, orderDate);
                view.displayDeleteOrderSuccessBanner(deletedNumber);
            }
        }
    }
    
    private void displayOrders() throws FlooringProgramPersistenceException {
        view.displayAllOrdersBanner();
        keepTrying = false;
        do {
            try {
                LocalDate date = view.getOrderDate();
                keepTrying = true;
                try {
                    List allOrdersFromDate = service.getOrders(date);
                    view.displayOrders(allOrdersFromDate);
                } catch (NullPointerException e) {
                    view.print("*No orders scheduled for this date.*");
                }
            } catch (Exception e) {
                view.print("*Field is required and must be completed in the following format: MM-dd-YYYY (ex: December 31st, 2050 would be '12-31-2050')");
                keepTrying = false;
            }
        } while (keepTrying == false);
    }
    
    private void exportData() throws FlooringProgramPersistenceException {
        view.displayExportDataBanner();
        view.print("Exporting your data will erase past orders as well as update current orders on your backup file.");
        view.print("This cannot be undone.");
        String answer = view.readString("If you would like to export data press 1. If not, hit any other key.");
        if (answer.equals("1")) {
            if (service.exportData() == true) {
                view.displayExportSuccessBanner();
            } else {
                view.print("*No orders to export*");
            }
        }
    }
    
    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }
    
    private void updateCustomerName(Order currentOrder) throws FlooringProgramPersistenceException, FlooringProgramUserValidationException {
        view.print("Current Customer Name:");
        view.print(currentOrder.getCustomerName());
        keepTrying = false;
        do {
            String newCustomerName = view.getCustomerName();
            if (newCustomerName.length() > 0) {
                
                if (service.validateCustomerName(newCustomerName) != true) {
                    view.print("Customer name may only contain characters [a-z], [0-9], and special characters [.,].");
                    keepTrying = false;
                } else {
                    currentOrder.setCustomerName(newCustomerName);
                    keepTrying = true;
                    
                    int answer = view.confirmOrderSave(currentOrder);
                    if (answer == 1) {
                        service.editOrder(currentOrder);
                        view.print("Customer name successfully updated.");
                    }
                }
            } else {
                view.print("");
                view.print("*Customer name remains " + currentOrder.getCustomerName() + "*");
                view.print("");
                keepTrying = true;
            }
        } while (keepTrying == false);
    }
    
    private void updateState(Order currentOrder) throws FlooringProgramPersistenceException {
        view.print("Current State:");
        view.print(currentOrder.getState().getAbbreviation());
        view.print("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        List<String> states = service.getStateAbbreviationList();
        String newState = view.getState(states);
        if (newState.length() > 0) {
            State orderState = service.getState(newState.toUpperCase());
            currentOrder.setState(orderState);
            currentOrder.setTaxCostTotal(service.calculateTaxCostTotal(currentOrder));
            currentOrder.setTotalCost(service.calculateTotalCost(currentOrder));
            
            int answer = view.confirmOrderSave(currentOrder);
            if (answer == 1) {
                service.editOrder(currentOrder);
                view.print("Order state successfully updated.");
            }
        } else {
            view.print("");
            view.print("*State remains " + currentOrder.getState().getName() + "*");
            view.print("");
            
        }
    }
    
    private void updateProduct(Order currentOrder) throws FlooringProgramPersistenceException {
        view.print("Current Product:");
        view.print(currentOrder.getProduct().getMaterialType());
        List<Product> products = service.getProducts();
        keepTrying = false;
        String productType = null;
        do {
            try {
                productType = view.getProductType(products);
                if (productType.length() > 0 && productType != null) {
                    Product orderProduct = service.getProduct(productType);
                    if (orderProduct != null) {
                        currentOrder.setProduct(orderProduct);
                        currentOrder.setLaborCostTotal(service.calculateLaborCostTotal(currentOrder));
                        currentOrder.setMaterialCostTotal(service.calculateMaterialCostTotal(currentOrder));
                        currentOrder.setTaxCostTotal(service.calculateTaxCostTotal(currentOrder));
                        currentOrder.setTotalCost(service.calculateTotalCost(currentOrder));
                        
                        int answer = view.confirmOrderSave(currentOrder);
                        if (answer == 1) {
                            service.editOrder(currentOrder);
                            view.print("Order product successfully updated.");
                            
                        }
                        keepTrying = true;
                    } else {
                        view.print("*Material type not found, please choose from the list below.*");
                        keepTrying = false;
                    }
                }
            } catch (Exception e) {
                view.print("");
                view.print("*Product remains " + currentOrder.getProduct().getMaterialType() + "*");
                view.print("");
                keepTrying = true;
            }
        } while (keepTrying == false);
    }
    
    private void updateArea(Order currentOrder) throws FlooringProgramPersistenceException {
        keepTrying = false;
        view.print("Current Area:");
        view.print(currentOrder.getArea().toString());
        BigDecimal area;
        do {
            String areaAsString = view.getArea();
            if (areaAsString.length() > 0) {
                
                try {
                    area = new BigDecimal(areaAsString);
                    if (area.compareTo(new BigDecimal("100.00")) == -1) {
                        view.print("Minimum order size is 100 sq ft.");
                        keepTrying = false;
                    } else {
                        currentOrder.setArea(area);
                        int answer = view.confirmOrderSave(currentOrder);
                        
                        if (answer == 1) {
                            service.editOrder(currentOrder);
                            view.print("Order area successfully updated.");
                        }
                        keepTrying = true;
                    }
                } catch (Exception e) {
                    System.out.println("Area input must be numerical Ex: '2100.50'");
                    keepTrying = false;
                }
                
            } else {
                view.print("");
                view.print("*Area remains " + currentOrder.getArea() + "*");
                view.print("");
                keepTrying = true;
            }
        } while (keepTrying == false);
    }
}

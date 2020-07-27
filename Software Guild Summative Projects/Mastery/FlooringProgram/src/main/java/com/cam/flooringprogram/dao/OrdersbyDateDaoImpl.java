package com.cam.flooringprogram.dao;

import com.cam.flooringprogram.dto.Order;
import com.cam.flooringprogram.dto.Product;
import com.cam.flooringprogram.dto.State;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 * @author chelseamiller
 */
public class OrdersbyDateDaoImpl implements OrdersbyDateDao {
StateTaxDaoImpl stateDao;
ProductCostDaoImpl productDao;
   // private StateTaxDaoImpl StateDao = new StateTaxDaoImpl();
    //private ProductCostDaoImpl ProductDao = new ProductCostDaoImpl();
    
    
    DateTimeFormatter formatterForFile = DateTimeFormatter.ofPattern("MMddyyyy");
    DateTimeFormatter formatterForUser = DateTimeFormatter.ofPattern("MM-dd-yyyy");

    public String ROSTER_FOLDER;
    public static final String DELIMITER = ",";
    private HashMap<LocalDate, Map<Integer, Order>> allOrders = new HashMap<LocalDate, Map<Integer, Order>>();
    
   
    public OrdersbyDateDaoImpl(StateTaxDaoImpl newStateDao,
ProductCostDaoImpl newProductDao) {
        ROSTER_FOLDER = "OrdersByDate/";
        this.stateDao =newStateDao;
        this.productDao=newProductDao;

    }

    public OrdersbyDateDaoImpl(String directory,StateTaxDaoImpl newStateDao,
ProductCostDaoImpl newProductDao) {
        ROSTER_FOLDER = directory;
        this.stateDao =newStateDao;
        this.productDao=newProductDao;
     
    }

    @Override
    public Order getOrder(int orderNumber, LocalDate date) throws FlooringProgramPersistenceException {
        loadCollection();
        Map<Integer, Order> orders = new HashMap<>(allOrders.get(date));

        return orders.get(orderNumber);
    }

    @Override
    public List getOrdersbyDate(LocalDate date) throws FlooringProgramPersistenceException {
        loadCollection();
        Map<Integer, Order> ordersAsMap = new HashMap<Integer, Order>(allOrders.get(date));
        List<Order> ordersAsList = ordersAsMap.values().stream().collect(Collectors.toList());

        return ordersAsList;
    }

    @Override
    public HashMap getAllOrders() throws FlooringProgramPersistenceException {
        loadCollection();
        return allOrders;
    }

    @Override
    public Order createOrder(int orderNumber, Order order) throws FlooringProgramPersistenceException {

        try {
            loadCollection();
        } catch (NullPointerException e) {
            throw new FlooringProgramPersistenceException(
                    "-_- Could not loadCollection.", e);
        }

        Map<Integer, Order> allOrdersFromDate = new HashMap<>();

        if (allOrders != null && allOrders.get(order.getOrderDate()) != null) {
            allOrdersFromDate = allOrders.get(order.getOrderDate());
            allOrders.remove(order.getOrderDate());

        }
        allOrdersFromDate.put(orderNumber, order);
        Order newOrder = allOrdersFromDate.get(orderNumber);
        allOrders.put(order.getOrderDate(), allOrdersFromDate);
        

        try {
            writeCollection();
        } catch (NullPointerException e) {
            throw new FlooringProgramPersistenceException(
                    "-_- Could not writeCollection.", e);
        }

        return newOrder;

    }

    @Override
    public Order editOrder(Order currentOrder) throws FlooringProgramPersistenceException {
        Map<Integer, Order> allOrdersFromDate = new HashMap<>();
        loadCollection();
        allOrdersFromDate = allOrders.get(currentOrder.getOrderDate());
        allOrdersFromDate.remove(currentOrder.getOrderNumber());
        allOrdersFromDate.put(currentOrder.getOrderNumber(), currentOrder);
        allOrders.put(currentOrder.getOrderDate(), allOrdersFromDate);
        writeCollection();
        return allOrders.get(currentOrder.getOrderDate()).get(currentOrder.getOrderNumber());
    }

    @Override
    public Order removeOrder(int orderNumber, LocalDate date) throws FlooringProgramPersistenceException {
        loadCollection();
        Order deletedOrder = getOrder(orderNumber, date);
        allOrders.get(date).remove(orderNumber);
        writeCollection();
        return deletedOrder;
    }

    private Order unmarshallOrder(String orderAsText) throws FlooringProgramPersistenceException {

        String[] orderTokens = orderAsText.split(DELIMITER);

        int orderNumber = Integer.parseInt(orderTokens[0]);
        Order orderFromFile = new Order(orderNumber);
        String customerName = addCommas(orderTokens[1]);
        try {
            State currentState = stateDao.getState(orderTokens[2]);
            orderFromFile.setState(currentState);
        } catch (NullPointerException e) {
            throw new FlooringProgramPersistenceException(
                    "-_- state is null", e);
        }
        BigDecimal taxRate = new BigDecimal(orderTokens[3]);
        try {
            Product currentProduct = productDao.getProduct(orderTokens[4]);
            orderFromFile.setProduct(currentProduct);
        } catch (NullPointerException e) {
            throw new FlooringProgramPersistenceException(
                    "-_- product is null", e);
        }
        BigDecimal area = new BigDecimal(orderTokens[5]);
        BigDecimal materialCostPerSqFt = new BigDecimal(orderTokens[6]);
        BigDecimal laborCostPerSqFt = new BigDecimal(orderTokens[7]);
        BigDecimal materialCost = new BigDecimal(orderTokens[8]);
        BigDecimal laborCost = new BigDecimal(orderTokens[9]);
        BigDecimal tax = new BigDecimal(orderTokens[10]);
        BigDecimal total = new BigDecimal(orderTokens[11]);

        orderFromFile.setCustomerName(customerName);
        orderFromFile.setArea(area);
        orderFromFile.setLaborCostTotal(laborCost);
        orderFromFile.setMaterialCostTotal(materialCost);
        orderFromFile.setTaxCostTotal(tax);
        orderFromFile.setTotalCost(total);

        orderFromFile.setLaborCostPerSqFt(laborCostPerSqFt);
        orderFromFile.setTaxRate(taxRate);
        orderFromFile.setMaterialCostPerSqFt(materialCostPerSqFt);

        return orderFromFile;
    }

    private String marshallOrder(Order anOrder) {

        String customerNameNoCommas = removeCommas(anOrder.getCustomerName());

        String orderAsText = Integer.toString(anOrder.getOrderNumber()) + DELIMITER;

        orderAsText += customerNameNoCommas + DELIMITER;

        orderAsText += anOrder.getState().getAbbreviation() + DELIMITER;

        orderAsText += anOrder.getTaxRate().toString() + DELIMITER;

        orderAsText += anOrder.getProduct().getMaterialType() + DELIMITER;

        orderAsText += anOrder.getArea().toString() + DELIMITER;

        orderAsText += anOrder.getMaterialCostPerSqFt().toString() + DELIMITER;

        orderAsText += anOrder.getLaborCostPerSqFt().toString() + DELIMITER;

        orderAsText += anOrder.getMaterialCostTotal().toString() + DELIMITER;

        orderAsText += anOrder.getLaborCostTotal().toString() + DELIMITER;

        orderAsText += anOrder.getTaxCostTotal().toString() + DELIMITER;

        orderAsText += anOrder.getTotalCost().toString();

        return orderAsText;
    }

    private LocalDate getDateFromFile(String fileName) {

        LocalDate orderDate;
        String a = fileName.replace("Orders_", "");
        String b = a.replace(".txt", "");
        orderDate = LocalDate.parse(b, formatterForFile);
        return orderDate;
    }

    private String removeCommas(String oldCustomerName) {
        String newCustomerName;
        newCustomerName = oldCustomerName.replaceAll(",", "32COMMA23");
        return newCustomerName;
    }

    private String addCommas(String formattedCustomerName) {
        String customerName;
        customerName = formattedCustomerName.replaceAll("32COMMA23", ",");
        return customerName;
    }

    private void loadCollection() throws FlooringProgramPersistenceException {
        File directory = new File(ROSTER_FOLDER);
        LocalDate date = null;
        Map<Integer, Order> orderMap = null;

        if (directory.isDirectory()) {

            File[] files = directory.listFiles();
            if (directory.length() > 0) {
                for (File currentFile : files) {
                    Scanner scanner;
                    if (currentFile.isFile()) {

                        try {

                            scanner = new Scanner(
                                    new BufferedReader(
                                            new FileReader(currentFile)));
                        } catch (FileNotFoundException e) {
                            throw new FlooringProgramPersistenceException(
                                    "-_- Could not load roster data into memory.", e);
                        }

                        String currentLine;

                        Order currentOrder = null;
                        orderMap = new HashMap<Integer, Order>();
                        while (scanner.hasNextLine()) {

                            currentLine = scanner.nextLine();
                            if (!currentLine.matches("OrderNumber,CustomerName,State,TaxRate,ProductType,Area,CostPerSquareFoot,LaborCostPerSquareFoot,MaterialCost,LaborCost,Tax,Total")) {

                                currentOrder = unmarshallOrder(currentLine);

                                currentOrder.setOrderDate(getDateFromFile(currentFile.getName()));

                                int orderNumber = currentOrder.getOrderNumber();

                                orderMap.put(orderNumber, currentOrder);
                                date = currentOrder.getOrderDate();
                            }

                        }
                        scanner.close();

                    }

                    allOrders.put(date, orderMap);

                }
            } else {
                System.out.println("Not correctly reading files.");
            }
        } else {
            System.out.println("Folder is not a directory");
        }

    }

    private void writeCollection() throws FlooringProgramPersistenceException {
        File dir = new File(ROSTER_FOLDER);
        dir.mkdir();
        List<LocalDate> allDates = new ArrayList(allOrders.keySet());
        PrintWriter out;
        if (!allDates.isEmpty()) {
            for (int i = 0; i < allDates.size(); i++) {
                LocalDate currentDate = allDates.get(i);

                String orderDate;
                orderDate = currentDate.toString();

                String[] dateTokens = orderDate.split("-");
                String day = dateTokens[2];
                String month = dateTokens[1];
                String year = dateTokens[0];

                String fileName = ROSTER_FOLDER + "Orders_" + month + day + year + ".txt";
                File newFile = new File(fileName);
              
                Map<Integer, Order> ordersToBeWritten = new HashMap<>(allOrders.get(currentDate));
                
                List<Order> allOrdersFromDate = new ArrayList(ordersToBeWritten.values());
             

                try {
                    out = new PrintWriter(new FileWriter(fileName));
                } catch (IOException e) {
                    throw new FlooringProgramPersistenceException(
                            "Could not save data.", e);
                }

                String orderAsText;

                out.println("OrderNumber,CustomerName,State,TaxRate,ProductType,Area,CostPerSquareFoot,LaborCostPerSquareFoot,MaterialCost,LaborCost,Tax,Total");

                for (Order currentOrder : allOrdersFromDate) {

                    orderAsText = marshallOrder(currentOrder);

                    out.println(orderAsText);

                    out.flush();
                }

                out.close();
                ordersToBeWritten.clear();
            }
        } else {
            System.out.println("Hashmap is empty.");
        }

    }

}



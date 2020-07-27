package com.cam.flooringprogram.dao;

import static com.cam.flooringprogram.dao.OrdersbyDateDaoImpl.DELIMITER;
import com.cam.flooringprogram.dto.Order;
import com.cam.flooringprogram.dto.State;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 *
 * @author chelseamiller
 */
public class BackupDaoImpl implements BackupDao {

    String BACKUP_FILE;
    String header ="Order Date, Order Number, Customer Name, State, Tax Rate, Product, Area, Material Cost per Sq Ft, Labor Cost per Sq Ft, Material Cost Total, Labor Cost Total, Tax Cost Total, Total Cost";
    private HashMap<LocalDate, Map<Integer, Order>> allOrders;

    public BackupDaoImpl() {
        BACKUP_FILE = "backup.txt";

    }

    public BackupDaoImpl(String backupFile) {
        BACKUP_FILE = backupFile;

    }

    

    @Override
    public void WriteBackupEntry(HashMap<LocalDate, Map<Integer, Order>> allOrders) throws FlooringProgramPersistenceException {
        PrintWriter out;
        Iterator it = allOrders.entrySet().iterator();

        try {
            out = new PrintWriter(new FileWriter(BACKUP_FILE));
        } catch (IOException e) {
            throw new FlooringProgramPersistenceException(
                    "Could not save backup data.", e);
        }
      
            String orderAsText;
            
              List<HashMap<Integer, Order>> orderByDate = new ArrayList(allOrders.values());
              out.println(header);
              
              for(Map currentMap : orderByDate){
              List<Order> orderList = new ArrayList(currentMap.values());    
              
                
            for (Order currentOrder : orderList) {

                orderAsText = MarshallOrders(currentOrder);

                out.println(orderAsText);

                out.flush();
            }

        }
        //}
        out.close();
    }

    @Override
    public String MarshallOrders(Order anOrder) {
        String orderAsText = anOrder.getOrderDate().toString() + DELIMITER;
        orderAsText += Integer.toString(anOrder.getOrderNumber()) + DELIMITER;

        orderAsText += anOrder.getCustomerName() + DELIMITER;

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

}

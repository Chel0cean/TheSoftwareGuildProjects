package com.cam.flooringprogram.dao;

import com.cam.flooringprogram.dto.Product;
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
public class ProductCostDaoImpl implements ProductCostDao {

    private final String ROSTER_FILE;
    public static final String DELIMITER = ",";
     String Title ="ProductType,CostPerSquareFoot,LaborCostPerSquareFoot";

    public ProductCostDaoImpl() {
        ROSTER_FILE = "product.txt";
    }

    public ProductCostDaoImpl(String productTextFile) {
        ROSTER_FILE = productTextFile;
    }
    private Map<String, Product> products = new HashMap<>();

    @Override
    public Product createProduct(String materialType, Product product) throws FlooringProgramPersistenceException {
        loadCollection();
        Product newProduct = products.put(materialType, product);
        writeCollection();
        return newProduct;
    }

    @Override
    public Product editProduct(String oldMaterialType, Product newProduct) throws FlooringProgramPersistenceException {
        loadCollection();
        products.remove(oldMaterialType);
        products.put(newProduct.getMaterialType(), newProduct);
        writeCollection();
        return newProduct;
    }

    @Override
    public Product removeProduct(String materialType) throws FlooringProgramPersistenceException {
        loadCollection();
        Product removedProduct = products.remove(materialType);
        writeCollection();
        return removedProduct;
    }

    @Override
    public Product getProduct(String materialType) throws FlooringProgramPersistenceException {
       loadCollection();
        Product product;
        try {
            product = products.get(materialType);
        } catch (NullPointerException ex) {
            product = null;

        }
        return product;
    }
    
    
     @Override
        public List<Product> getAllProducts() throws FlooringProgramPersistenceException{
      loadCollection();
        return new ArrayList(products.values());
    }

    private Product unmarshallProductCost(String productAsText) throws FlooringProgramPersistenceException {
     
        String[] productTokens = productAsText.split(DELIMITER);

        String materialType = productTokens[0];
        BigDecimal materialCostSqFt = new BigDecimal(productTokens[1]);
        BigDecimal laborCostSqFt = new BigDecimal(productTokens[2]);

        Product productFromFile = new Product(materialType);

        productFromFile.setMaterialCostSqFt(materialCostSqFt);

        productFromFile.setLaborCostSqFt(laborCostSqFt);

        return productFromFile;
    }



    private void loadCollection() throws FlooringProgramPersistenceException {
    Scanner scanner;

        try {

            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(ROSTER_FILE)));
        } catch (FileNotFoundException e) {
            throw new FlooringProgramPersistenceException(
                    "-_- Could not load collection data into memory.", e);
        }

        String currentLine;

        Product currentProduct;

        while (scanner.hasNextLine()) {

            currentLine = scanner.nextLine();
if(!currentLine.contains(Title)){
            currentProduct = unmarshallProductCost(currentLine);

            products.put(currentProduct.getMaterialType(), currentProduct);
        }
        }
        scanner.close();
    }

    private void writeCollection() throws FlooringProgramPersistenceException{
       PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(ROSTER_FILE));
        } catch (IOException e) {
            throw new FlooringProgramPersistenceException(
                    "Could not save product data.", e);
        }

        String productAsText;
        out.println(Title);
        List<Product> productList = new ArrayList(products.values());
        for (Product currentProduct : productList) {

            productAsText = marshallProductCost(currentProduct);

            out.println(productAsText);

            out.flush();
        }

        out.close();
    }
    
    

     private String marshallProductCost(Product aProduct) {
         
      String productAsText = aProduct.getMaterialType() + DELIMITER;

        productAsText += aProduct.getMaterialCostSqFt().toString() + DELIMITER;

        productAsText += aProduct.getLaborCostSqFt().toString();

        return productAsText;
    }
}
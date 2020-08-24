
package com.cam.flooringprogram.dao;

import com.cam.flooringprogram.dto.Product;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author chelseamiller
 */
public interface ProductCostDao {
    public Product createProduct(String materialType, Product newProduct)throws FlooringProgramPersistenceException;
    public Product editProduct(String oldMaterialType, Product newProduct)throws FlooringProgramPersistenceException;
    public Product removeProduct(String materialType)throws FlooringProgramPersistenceException;
    public Product getProduct(String materialType)throws FlooringProgramPersistenceException;
    public List<Product> getAllProducts() throws FlooringProgramPersistenceException;
}

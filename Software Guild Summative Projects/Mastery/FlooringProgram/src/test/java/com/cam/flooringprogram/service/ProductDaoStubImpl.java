package com.cam.flooringprogram.service;

import com.cam.flooringprogram.dao.FlooringProgramPersistenceException;
import com.cam.flooringprogram.dao.ProductCostDao;
import com.cam.flooringprogram.dto.Product;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author chelseamiller
 */
public class ProductDaoStubImpl implements ProductCostDao {

    public Product onlyProduct;

    public ProductDaoStubImpl() {
        onlyProduct = new Product("Splinters");
        onlyProduct.setLaborCostSqFt(new BigDecimal("10"));
        onlyProduct.setMaterialCostSqFt(new BigDecimal("4.00"));

    }

    public ProductDaoStubImpl(Product testProduct) {
        this.onlyProduct = testProduct;
    }

    @Override
    public Product createProduct(String materialType, Product newProduct) throws FlooringProgramPersistenceException {
        if (materialType.equals(onlyProduct.getMaterialType())) {
            return onlyProduct;
        } else {
            return null;
        }
    }

    @Override
    public Product editProduct(String oldMaterialType, Product newProduct) throws FlooringProgramPersistenceException {
        onlyProduct.setMaterialType(oldMaterialType);
        onlyProduct = newProduct;
        return onlyProduct;
    }

    @Override
    public Product removeProduct(String materialType) throws FlooringProgramPersistenceException {
        if (materialType.equals(onlyProduct.getMaterialType())) {
            return onlyProduct;
        } else {
            return null;
        }
    }

    @Override
    public Product getProduct(String materialType) throws FlooringProgramPersistenceException {
        if (materialType.equals(onlyProduct.getMaterialType())) {
            return onlyProduct;
        } else {
            return null;
        }
    }

    @Override
    public List<Product> getAllProducts() throws FlooringProgramPersistenceException {
        List<Product> productList = new ArrayList<>();
        productList.add(onlyProduct);
        return productList;
    }

}

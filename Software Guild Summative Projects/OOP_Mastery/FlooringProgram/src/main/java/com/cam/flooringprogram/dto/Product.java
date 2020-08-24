
package com.cam.flooringprogram.dto;

import java.math.BigDecimal;
import java.util.Objects;

/**
 *
 * @author chelseamiller
 */
public class Product {
 String materialType;
 BigDecimal materialCostSqFt;
 BigDecimal laborCostSqFt;

    public Product(String materialType, BigDecimal materialCostSqFt, BigDecimal laborCostSqFt) {
this.materialType= materialType;
this.materialCostSqFt=materialCostSqFt;
this.laborCostSqFt=laborCostSqFt;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.materialType);
        hash = 67 * hash + Objects.hashCode(this.materialCostSqFt);
        hash = 67 * hash + Objects.hashCode(this.laborCostSqFt);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Product other = (Product) obj;
        if (!Objects.equals(this.materialType, other.materialType)) {
            return false;
        }
        if (!Objects.equals(this.materialCostSqFt, other.materialCostSqFt)) {
            return false;
        }
        if (!Objects.equals(this.laborCostSqFt, other.laborCostSqFt)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Product{" + "materialType=" + materialType + ", materialCostSqFt=" + materialCostSqFt + ", laborCostSqFt=" + laborCostSqFt + '}';
    }

    public String getMaterialType() {
        return materialType;
    }

    public void setMaterialType(String materialType) {
        this.materialType = materialType;
    }

    public BigDecimal getMaterialCostSqFt() {
        return materialCostSqFt;
    }

    public void setMaterialCostSqFt(BigDecimal materialCostSqFt) {
        this.materialCostSqFt = materialCostSqFt;
    }

    public BigDecimal getLaborCostSqFt() {
        return laborCostSqFt;
    }

    public void setLaborCostSqFt(BigDecimal laborCostSqFt) {
        this.laborCostSqFt = laborCostSqFt;
    }

    public Product(String materialType) {
        this.materialType = materialType;
    }
}

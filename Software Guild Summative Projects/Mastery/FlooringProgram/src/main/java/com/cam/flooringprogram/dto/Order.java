package com.cam.flooringprogram.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author chelseamiller
 */
public class Order {
  
    
    public Order(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    LocalDate orderDate;
    int orderNumber;
    String customerName;
    State state;
    BigDecimal taxRate;
    Product product;
    BigDecimal materialCostPerSqFt;
    BigDecimal laborCostPerSqFt;
    BigDecimal area;
    BigDecimal laborCostTotal;
    BigDecimal materialCostTotal;
    BigDecimal taxCostTotal;
    BigDecimal totalCost;

    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }

    public BigDecimal getMaterialCostPerSqFt() {
        return materialCostPerSqFt;
    }

    public void setMaterialCostPerSqFt(BigDecimal materialCostPerSqFt) {
        this.materialCostPerSqFt = materialCostPerSqFt;
    }

    public BigDecimal getLaborCostPerSqFt() {
        return laborCostPerSqFt;
    }

    public void setLaborCostPerSqFt(BigDecimal laborCostPerSqFt) {
        this.laborCostPerSqFt = laborCostPerSqFt;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public State getState() {
        return state;
    }

    public void setState(State thisState) {
       
        this.state =thisState;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public BigDecimal getArea() {
        return area;
    }

    public void setArea(BigDecimal area) {
        this.area = area;
    }

    public BigDecimal getLaborCostTotal() {
        return laborCostTotal;
    }

    public void setLaborCostTotal(BigDecimal laborCostTotal) {
        this.laborCostTotal = laborCostTotal;
    }

    public BigDecimal getMaterialCostTotal() {
        return materialCostTotal;
    }

    public void setMaterialCostTotal(BigDecimal materialCostTotal) {
        this.materialCostTotal = materialCostTotal;
    }

    public BigDecimal getTaxCostTotal() {
        return taxCostTotal;
    }

    public void setTaxCostTotal(BigDecimal taxCostTotal) {
        this.taxCostTotal = taxCostTotal;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.orderDate);
        hash = 83 * hash + this.orderNumber;
        hash = 83 * hash + Objects.hashCode(this.customerName);
        hash = 83 * hash + Objects.hashCode(this.state);
        hash = 83 * hash + Objects.hashCode(this.taxRate);
        hash = 83 * hash + Objects.hashCode(this.product);
        hash = 83 * hash + Objects.hashCode(this.materialCostPerSqFt);
        hash = 83 * hash + Objects.hashCode(this.laborCostPerSqFt);
        hash = 83 * hash + Objects.hashCode(this.area);
        hash = 83 * hash + Objects.hashCode(this.laborCostTotal);
        hash = 83 * hash + Objects.hashCode(this.materialCostTotal);
        hash = 83 * hash + Objects.hashCode(this.taxCostTotal);
        hash = 83 * hash + Objects.hashCode(this.totalCost);
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
        final Order other = (Order) obj;
        if (this.orderNumber != other.orderNumber) {
            return false;
        }
        if (!Objects.equals(this.customerName, other.customerName)) {
            return false;
        }
        if (!Objects.equals(this.orderDate, other.orderDate)) {
            return false;
        }
        if (!Objects.equals(this.state, other.state)) {
            return false;
        }
        if (!Objects.equals(this.taxRate, other.taxRate)) {
            return false;
        }
        if (!Objects.equals(this.product, other.product)) {
            return false;
        }
        if (!Objects.equals(this.materialCostPerSqFt, other.materialCostPerSqFt)) {
            return false;
        }
        if (!Objects.equals(this.laborCostPerSqFt, other.laborCostPerSqFt)) {
            return false;
        }
        if (!Objects.equals(this.area, other.area)) {
            return false;
        }
        if (!Objects.equals(this.laborCostTotal, other.laborCostTotal)) {
            return false;
        }
        if (!Objects.equals(this.materialCostTotal, other.materialCostTotal)) {
            return false;
        }
        if (!Objects.equals(this.taxCostTotal, other.taxCostTotal)) {
            return false;
        }
        if (!Objects.equals(this.totalCost, other.totalCost)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Order{" + "orderDate=" + orderDate + ", orderNumber=" + orderNumber + ", customerName=" + customerName + ", state=" + state + ", taxRate=" + taxRate + ", product=" + product + ", materialCostPerSqFt=" + materialCostPerSqFt + ", laborCostPerSqFt=" + laborCostPerSqFt + ", area=" + area + ", laborCostTotal=" + laborCostTotal + ", materialCostTotal=" + materialCostTotal + ", taxCostTotal=" + taxCostTotal + ", totalCost=" + totalCost + '}';
    }

}

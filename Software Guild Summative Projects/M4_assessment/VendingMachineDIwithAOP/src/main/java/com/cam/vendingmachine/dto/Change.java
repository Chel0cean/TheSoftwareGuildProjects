
package com.cam.vendingmachine.dto;

import java.math.BigDecimal;
import java.util.Objects;

/**
 *
 * @author chelseamiller
 */
public class Change {
 BigDecimal total;
 int quarters;
 int dimes;
 int nickels;
 int pennies;
 
 public Change(BigDecimal total) {
        this.total = total;
    }
    

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public int getQuarters() {
        return quarters;
    }

    public void setQuarters(int quarters) {
        this.quarters = quarters;
    }

    public int getDimes() {
        return dimes;
    }

    public void setDimes(int dimes) {
        this.dimes = dimes;
    }

    public int getNickels() {
        return nickels;
    }

    public void setNickels(int nickels) {
        this.nickels = nickels;
    }

    public int getPennies() {
        return pennies;
    }

    public void setPennies(int pennies) {
        this.pennies = pennies;
    }

    @Override
    public String toString() {
        return "Change{" + "total=" + total + ", quarters=" + quarters + ", dimes=" + dimes + ", nickels=" + nickels + ", pennies=" + pennies + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.total);
        hash = 79 * hash + this.quarters;
        hash = 79 * hash + this.dimes;
        hash = 79 * hash + this.nickels;
        hash = 79 * hash + this.pennies;
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
        final Change other = (Change) obj;
        if (this.quarters != other.quarters) {
            return false;
        }
        if (this.dimes != other.dimes) {
            return false;
        }
        if (this.nickels != other.nickels) {
            return false;
        }
        if (this.pennies != other.pennies) {
            return false;
        }
        return Objects.equals(this.total, other.total);
    }
}

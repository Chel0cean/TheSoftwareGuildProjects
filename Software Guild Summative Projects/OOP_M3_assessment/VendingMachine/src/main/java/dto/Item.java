package dto;

import java.math.BigDecimal;
import java.util.Objects;

/**
 *
 * @author chelseamiller
 */
public class Item {

    private String Name;
    private int inventoryCount;
    private BigDecimal cost;

    public Item(String Name) {
        this.Name = Name;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.Name);
        hash = 71 * hash + this.inventoryCount;
        hash = 71 * hash + Objects.hashCode(this.cost);
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
        final Item other = (Item) obj;
        if (this.inventoryCount != other.inventoryCount) {
            return false;
        }
        if (!Objects.equals(this.Name, other.Name)) {
            return false;
        }
        return Objects.equals(this.cost, other.cost);
    }

    @Override
    public String toString() {
        return "Item{" + "Name=" + Name + ", inventoryCount=" + inventoryCount + ", cost=" + cost + '}';
    }

    public int getInventoryCount() {
        return inventoryCount;
    }

    public void setInventoryCount(int inventoryCount) {
        this.inventoryCount = inventoryCount;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = (cost).setScale(2);
    }

}

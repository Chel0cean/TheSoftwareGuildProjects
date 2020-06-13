package lesson6ex;

/**
 *
 * @author chelseamiller
 */
public class StateCapitals3 {

    String name;
    String population;
    String squareMileage;
           
    StateCapitals3(String name, String population, String squareMileage) {
        this.name = name;
        this.population = population;
        this.squareMileage = squareMileage;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public String getSquareMileage() {
        return squareMileage;
    }

    public void setSquareMileage(String squareMileage) {
        this.squareMileage = squareMileage;
    }
    
}

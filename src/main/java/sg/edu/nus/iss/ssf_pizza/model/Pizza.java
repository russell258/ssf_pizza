package sg.edu.nus.iss.ssf_pizza.model;

import java.io.Serializable;

import jakarta.json.JsonObject;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

//implement serializable so its static variables can be used?? 
public class Pizza implements Serializable{
    @NotNull(message="Must select a pizza")
    private String pizza;

    @NotNull(message = "Must select a pizza size")
    private String size;

    @Min(value = 1, message = "You must order at least 1 pizza")
    @Max(value=10, message = "You can only order a maximum of 10 pizzas")
    private int quantity;

    public String getPizza() {
        return pizza;
    }
    public void setPizza(String pizza) {
        this.pizza = pizza;
    }
    public String getSize() {
        return size;
    }
    public void setSize(String size) {
        this.size = size;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public static Pizza create(JsonObject o){
        Pizza p = new Pizza();
        p.setPizza(o.getString("pizza"));
        p.setSize(o.getString("size"));
        p.setQuantity(o.getInt("quantity"));

        return p;
    }
    
}

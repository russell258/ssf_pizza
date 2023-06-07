package sg.edu.nus.iss.ssf_pizza.model;

import java.io.Serializable;
import java.io.StringReader;



import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;

public class Order implements Serializable{
    private String id;
    private double totalCost=0;
    private Pizza pizza;
    private Delivery delivery;

    public Order (Pizza p, Delivery d){
        this.pizza = p;
        this.delivery = d;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public double getTotalCost() {
        return totalCost;
    }
    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }
    public Pizza getPizza() {
        return pizza;
    }
    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }
    public Delivery getDelivery() {
        return delivery;
    }
    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }

    public String getName() {return this.getDelivery().getName();}
    public String getPizzaName() {return this.getPizza().getPizza();}
    public String getAddress() {return this.getDelivery().getAddress();}
    public String getPhoneNumber() {return this.getDelivery().getPhoneNumber();}
    public boolean getRush() {return this.getDelivery().isRush();}
    public String getComments() {return this.getDelivery().getComments();}
    public String getSize() {return this.getPizza().getSize();}
    public int getQuantity() {return this.getPizza().getQuantity();}

    //total cost will not include rush, try different
    public double getPizzaCost(){
        return this.getRush() ? this.getTotalCost() - 2 : this.getTotalCost();
    }

    //convert string to json object
    public static JsonObject toJSON(String json){
        JsonReader r = (JsonReader) Json.createReader(new StringReader(json));
        return r.readObject();
    }

    //convert string to java class object Order
    public static Order create(String jsonStr){
        JsonObject o = toJSON(jsonStr);
        Pizza p = Pizza.create(o);
        Delivery d = Delivery.create(o);
        Order ord = new Order(p, d);
        ord.setId(o.getString("orderId"));
        ord.setTotalCost(o.getJsonNumber("total").doubleValue());
        return ord;
    }

    public JsonObject toJSON(){
        return Json.createObjectBuilder()
            .add("orderId",this.getId())
            .add("name",this.getName())
            .add("address",this.getAddress())
            .add("phone",this.getPhoneNumber())
            .add("rush",this.getRush())
            .add("comments",this.getComments())
            .add("pizza",this.getPizzaName())
            .add("size",this.getSize())
            .add("quantity",this.getQuantity())
            .add("total",this.getTotalCost())
            .build();
    }

}

package sg.edu.nus.iss.ssf_pizza.model;

import java.io.Serializable;

import jakarta.json.JsonObject;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class Delivery implements Serializable{
    
    @NotNull(message = "name cannot be null")
    @Size(min=3, message = "Your name cannot be less than 3 chars")
    @NotBlank(message = "name cannot be blank")
    private String name;

    @NotNull(message = "address cannot be null")
    @NotBlank(message = "address cannot be blank")
    private String address;

    @NotNull(message = "number cannot be null")
    @NotBlank(message = "number cannot be blank")
    @Pattern(regexp="^[0-9]{8,}$", message="Must be a valid phone number")
    private String phoneNumber;

    private boolean rush=false;
    private String comments;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public boolean isRush() {
        return rush;
    }
    public void setRush(boolean rush) {
        this.rush = rush;
    }
    public String getComments() {
        return comments;
    }
    public void setComments(String comments) {
        this.comments = comments;
    }
    
    public static Delivery create(JsonObject o){
        Delivery d = new Delivery();
        d.setName(o.getString("name"));
        d.setAddress(o.getString("address"));
        d.setPhoneNumber(o.getString("phoneNumber"));
        d.setRush(o.getBoolean("rush"));
        d.setComments(o.getString("comments"));
        System.out.println(d.toString());
        return d;
    }
}

package sg.edu.nus.iss.ssf_pizza.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import sg.edu.nus.iss.ssf_pizza.model.Pizza;

@Service
public class PizzaService {
    
    public static final String[] PIZZA_NAMES ={
        "bella",
        "margherita",
        "marinara",
        "spianatacalabrese",
        "trioformaggio"
    };

    public static final String[] PIZZA_SIZES = {
        "sm",
        "md",
        "lg",
    };

    //declare variable
    private final Set<String> pizzaNames;
    private final Set<String> pizzaSizes;

    //use HashSet so can use the .contains function below
    public PizzaService(){
        pizzaNames = new HashSet<String>(Arrays.asList(PIZZA_NAMES));
        pizzaSizes = new HashSet<String>(Arrays.asList(PIZZA_SIZES));
    }

    // checks for the Pizza Type and Size for Task 2 
    public List<ObjectError> validatePizzaOrder(Pizza p){
        List<ObjectError> errors = new LinkedList<>();
        FieldError error;
        if (!pizzaNames.contains(p.getPizza().toLowerCase())){
            error = new FieldError("pizza", "pizza","We do not have the following %s pizza"
            .formatted(p.getPizza()));
            errors.add(error);
        }

        if (!pizzaSizes.contains(p.getSize().toLowerCase())){
            error = new FieldError("pizza","size","We do not have the following %s pizz size"
            .formatted(p.getSize()));
            errors.add(error);
        }

        return errors;
    }

}

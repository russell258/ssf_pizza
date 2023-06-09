package sg.edu.nus.iss.ssf_pizza.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import sg.edu.nus.iss.ssf_pizza.model.Order;
import sg.edu.nus.iss.ssf_pizza.service.PizzaService;

@RestController
@RequestMapping(path="/order")
public class PizzaRestController {
    @Autowired
    private PizzaService pSvc;

    @GetMapping(path="{orderId}")
    public ResponseEntity<String> getOrderDetails(@PathVariable String orderId){
        Optional<Order> p = pSvc.getOrderByOrderId(orderId);
        if (p.isEmpty()){
            JsonObject error = Json.createObjectBuilder()
                                    .add("message","Order %s is not found"
                                    .formatted(orderId))
                                    .build();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error.toString());
        }

        return ResponseEntity.ok(p.get().toJSON().toString());
    }
}

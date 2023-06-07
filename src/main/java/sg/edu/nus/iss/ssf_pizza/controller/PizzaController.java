package sg.edu.nus.iss.ssf_pizza.controller;

import org.apache.tomcat.util.http.parser.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import sg.edu.nus.iss.ssf_pizza.model.Pizza;

@Controller
@RequestMapping(consumes="application/x-www-form-url-encoded")
public class PizzaController {
    
    @PostMapping(path="/pizza")
    public String postPizza(Model m, HttpSession session, @Valid Pizza pizza, BindingResult result){
        
        if(result.hasErrors()){
            return "index";
        }
        session.setAttribute("pizza", pizza);
        m.addAttribute(null, result);

 
    }

}

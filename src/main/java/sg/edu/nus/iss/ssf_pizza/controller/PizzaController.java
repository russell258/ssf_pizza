package sg.edu.nus.iss.ssf_pizza.controller;

import org.apache.tomcat.util.http.parser.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(consumes=MediaType.APPLICATION_FORM_URLENCODED_VALUE)
public class PizzaController {
    
    @PostMapping(path="/pizza")
    public 

}

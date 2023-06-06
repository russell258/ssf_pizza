package sg.edu.nus.iss.ssf_pizza.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import sg.edu.nus.iss.ssf_pizza.model.Pizza;

@Controller
public class IndexPageController {
    
    //this is so the index.html can be moved from static to templates and then we just call it.
    @GetMapping(path="/")
    public String showLandingPage(Model m){
        m.addAttribute("pizza", new Pizza());
        return "index";
    }

}

package t_package.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class mvcControler {
    @GetMapping("/asd")
    public String dsds(Model model){
        return "page";
    }
}

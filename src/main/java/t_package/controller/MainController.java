package t_package.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ticket")
public class MainController {

    @GetMapping
    public String my_ticket(){
        return "lestGo";
    }

}

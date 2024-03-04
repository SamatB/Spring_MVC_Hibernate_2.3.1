package beganov.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HelloController {

    @GetMapping("/hello")
    public String hello(ModelMap model) {
        String hello = "Hello! It's Spring MVC project";
        model.addAttribute("hello", hello);
        return "home";
    }
}

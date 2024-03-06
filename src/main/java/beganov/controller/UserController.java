package beganov.controller;

import beganov.entity.User;
import beganov.service.UserService;
import beganov.service.serviceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserServiceImpl userService;

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService =  userService;
    }

    @GetMapping
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.getUsers());
        return "users";
    }

    @GetMapping("/addUser")
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        return "addUser";
    }

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("users") User user) {
        userService.addUser(user);
        return "redirect:/users";
    }

    @GetMapping("/updatePage")
    public String updatePage(Model model, @RequestParam("id") long id) {
        model.addAttribute("userUpdate", userService.getUserById(id));
        return "updateUser";
    }

    @PostMapping("/update")
    public String updateUser(@ModelAttribute("userUpdate") User user, @RequestParam("id") long id) {
        userService.updateUser(user, id);
        return "redirect:/users";
    }

    @GetMapping("/delete")
    public String deleteUser(@RequestParam("id") long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }

    @GetMapping("/getUser")
    public String getUserById(@RequestParam("id") long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "users";
        //Зачем этот метод?
    }
}

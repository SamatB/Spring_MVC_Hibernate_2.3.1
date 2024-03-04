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

    @GetMapping("/{id}/update")
    public String updatePage(Model model, @PathVariable("id") long id) {
        model.addAttribute("userUpdate", userService.getUserById(id));
        return "updateUser";
    }

    @PostMapping("/{id}")
    public String updateUser(@ModelAttribute("userUpdate") User user, @PathVariable("id") long id) {
        userService.updateUser(user, id);
        return "redirect:/users";
    }

    @PostMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        User user = userService.getUserById(id);
        userService.deleteUser(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}")
    public String getUserById(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "users";
    }
}

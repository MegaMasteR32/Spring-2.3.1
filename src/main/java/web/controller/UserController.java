package web.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.Model.User;
import web.Service.UserService;

@Controller
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping(value = "/")
    public String index(Model model){

        model.addAttribute("allUsers", userService.getAllUsers());
        return "users";
    }

    @GetMapping("/new")
    public String addNewUser(Model model) {
        model.addAttribute("user", new User());

        return "new";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.saveUsers(user);

        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String edit(Model model, @PathVariable("id") int id){
        model.addAttribute("user",userService.getById(id));


        return "update";
    }
    @PatchMapping("/update")
public String updateUser(@ModelAttribute("user") User user, @PathVariable("id") int id){
        userService.update(id, user);
        return "delete";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(Model model, @PathVariable("id") int id){
    userService.delete(id);
    return "redirect:/";
    }



}
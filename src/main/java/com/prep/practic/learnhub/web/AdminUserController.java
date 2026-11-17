package com.prep.practic.learnhub.web;

import com.prep.practic.learnhub.dto.CreateUserRequest;
import com.prep.practic.learnhub.dto.UserDto;
import com.prep.practic.learnhub.domain.Role;
import com.prep.practic.learnhub.service.UserService;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/users")
public class AdminUserController {
    private final UserService userService;

    public AdminUserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String list(Model model) {
        List<UserDto> users = userService.listUsers(Pageable.unpaged()).getContent();
        model.addAttribute("users", users);
        return "admin/users/list";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("user", new CreateUserRequest());
        model.addAttribute("roles", Role.values());
        return "admin/users/form";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute CreateUserRequest req) {
        userService.createUser(req);
        return "redirect:/admin/users";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        UserDto user = userService.getUser(id);
        model.addAttribute("user", user);
        model.addAttribute("roles", Role.values());
        return "admin/users/form";
    }

    @PostMapping("/edit/{id}")
    public String edit(@PathVariable Long id,
                       @ModelAttribute CreateUserRequest req) {
        // For now reuse createUser, but ideally implement updateUser
        // You can extend service with update logic
        userService.createUser(req);
        return "redirect:/admin/users";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        // implement deleteUser in service/repo
        userService.deleteUser(id);
        return "redirect:/admin/users";
    }
}

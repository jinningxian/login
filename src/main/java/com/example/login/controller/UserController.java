package com.example.login.controller;

import com.example.login.model.User;
import com.example.login.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/manager")
    public String getUsersPage(Model model, Pageable pageable) {
        pageable = PageRequest.of(pageable.getPageNumber(), 10); // 10 records per page

        Page<User> usersPage = userRepository.findAll(pageable);
        model.addAttribute("usersPage", usersPage);

        return "manager";
    }

/*    @GetMapping("/users/{username}")
    public String getUserDetail(@PathVariable("username") String username, Model model) {
        User user = userRepository.findByUsername(username);
        model.addAttribute("user", user);
        return "userDetail";
    }*/
}

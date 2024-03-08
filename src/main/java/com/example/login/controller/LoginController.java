package com.example.login.controller;


import com.example.login.model.User;
import com.example.login.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository;
    @GetMapping("/home")
    public String homePage(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        User user = userRepository.findByUsername(username);
        model.addAttribute("user", user);
        boolean isManager = user.getRole().equals(User.Role.MANAGER);

        model.addAttribute("isManager", isManager);
        return "home";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/logout")
    public String logout() {
        // Invalidate current session
        SecurityContextHolder.clearContext();
        return "redirect:/login?logout";
    }


/*    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest) {
        // Here you can use loginRequest.getUsername() and loginRequest.getPassword()
        // to authenticate the user against your stored user credentials

        // For demonstration, let's just print the username and password
        System.out.println("Username: " + loginRequest.getUsername());
        System.out.println("Password: " + loginRequest.getPassword());

        // Redirect to home or return an appropriate response based on the authentication result
        return "redirect:/home";
    }*/
}

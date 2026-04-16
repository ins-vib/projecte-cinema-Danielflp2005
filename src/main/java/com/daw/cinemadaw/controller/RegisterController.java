package com.daw.cinemadaw.controller;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.daw.cinemadaw.domain.cinema.User.Role;
import com.daw.cinemadaw.domain.cinema.User.User;
import com.daw.cinemadaw.repository.UserRepository;

@Controller
public class RegisterController {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public RegisterController(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/register")
    public String showRegisterForm() {
        return "register";
    }

    @PostMapping("/register")
    public String register(@RequestParam String username,
                           @RequestParam String password,
                           @RequestParam String confirmPassword,
                           RedirectAttributes attrs) {

        if (!password.equals(confirmPassword)) {
            attrs.addFlashAttribute("error", "Las contraseñas no coinciden.");
            return "redirect:/register";
        }

        if (userRepository.findByUsername(username).isPresent()) {
            attrs.addFlashAttribute("error", "El nombre de usuario ya está en uso.");
            return "redirect:/register";
        }

        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPassword(passwordEncoder.encode(password));
        newUser.setRole(Role.CLIENT);
        userRepository.save(newUser);

        attrs.addFlashAttribute("success", "Cuenta creada correctamente. ¡Ya puedes iniciar sesión!");
        return "redirect:/login";
    }
}

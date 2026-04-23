package com.daw.cinemadaw.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.daw.cinemadaw.domain.cinema.LoyaltyCard;
import com.daw.cinemadaw.service.LoyaltyService;

@Controller
public class LoyaltyController {

    private final LoyaltyService loyaltyService;

    public LoyaltyController(LoyaltyService loyaltyService) {
        this.loyaltyService = loyaltyService;
    }

    @GetMapping("/client/loyalty")
    public String viewCard(Authentication auth, Model model) {
        loyaltyService.findByUsername(auth.getName())
                .ifPresent(card -> model.addAttribute("loyaltyCard", card));
        return "client/loyalty-card";
    }

    @PostMapping("/client/loyalty/register")
    public String register(Authentication auth, RedirectAttributes attrs) {
        LoyaltyCard card = loyaltyService.register(auth.getName());
        attrs.addFlashAttribute("success",
                "¡Tarjeta registrada! Tu número: " + card.getCardNumber());
        return "redirect:/client/loyalty";
    }
}

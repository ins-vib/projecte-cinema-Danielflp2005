package com.daw.cinemadaw.service;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.daw.cinemadaw.domain.cinema.LoyaltyCard;
import com.daw.cinemadaw.domain.cinema.User.User;
import com.daw.cinemadaw.repository.LoyaltyCardRepository;
import com.daw.cinemadaw.repository.UserRepository;

@Service
@Transactional
public class LoyaltyService {

    /** Points earned per euro spent. */
    public static final int POINTS_PER_EURO = 10;
    /** Points required for 1€ discount. */
    public static final int POINTS_PER_DISCOUNT_EURO = 100;

    private final LoyaltyCardRepository repo;
    private final UserRepository userRepository;

    public LoyaltyService(LoyaltyCardRepository repo, UserRepository userRepository) {
        this.repo = repo;
        this.userRepository = userRepository;
    }

    public Optional<LoyaltyCard> findByUsername(String username) {
        return repo.findByUserUsername(username);
    }

    /**
     * Creates a new LoyaltyCard for the user. Returns existing card if already
     * registered.
     */
    public LoyaltyCard register(String username) {
        return repo.findByUserUsername(username).orElseGet(() -> {
            User user = userRepository.findByUsername(username)
                    .orElseThrow(() -> new IllegalStateException("User not found: " + username));
            LoyaltyCard card = new LoyaltyCard();
            card.setUser(user);
            card.setPoints(0);
            card.setMemberSince(LocalDate.now());
            card.setCardNumber("LUM-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase());
            return repo.save(card);
        });
    }

    /**
     * Maximum euro discount the card can give for a given order total.
     * Discount is capped so it never exceeds what the user owes.
     */
    public double computeDiscount(LoyaltyCard card, double orderTotal) {
        double maxFromPoints = card.getPoints() / (double) POINTS_PER_DISCOUNT_EURO;
        return Math.min(maxFromPoints, orderTotal);
    }

    /**
     * Deducts points corresponding to the applied euro discount.
     * Only whole-euro multiples are deducted (100 pts per euro).
     */
    public void deductPoints(LoyaltyCard card, double euroDiscount) {
        int pointsUsed = (int) Math.floor(euroDiscount * POINTS_PER_DISCOUNT_EURO);
        card.setPoints(Math.max(0, card.getPoints() - pointsUsed));
        repo.save(card);
    }

    /**
     * Adds earned points after a successful purchase.
     * Points are earned on the net amount actually paid.
     */
    public void addPoints(String username, double amountPaid) {
        repo.findByUserUsername(username).ifPresent(card -> {
            int earned = (int) Math.floor(amountPaid * POINTS_PER_EURO);
            card.setPoints(card.getPoints() + earned);
            repo.save(card);
        });
    }
}

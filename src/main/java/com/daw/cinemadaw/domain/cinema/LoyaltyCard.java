package com.daw.cinemadaw.domain.cinema;

import java.time.LocalDate;

import com.daw.cinemadaw.domain.cinema.User.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class LoyaltyCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(optional = false)
    @JoinColumn(name = "user_id", unique = true)
    private User user;

    @Column(nullable = false, unique = true)
    private String cardNumber;

    @Column(nullable = false)
    private int points = 0;

    @Column(nullable = false)
    private LocalDate memberSince;

    public LoyaltyCard() {}

    public Long getId() { return id; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public String getCardNumber() { return cardNumber; }
    public void setCardNumber(String cardNumber) { this.cardNumber = cardNumber; }

    public int getPoints() { return points; }
    public void setPoints(int points) { this.points = points; }

    public LocalDate getMemberSince() { return memberSince; }
    public void setMemberSince(LocalDate memberSince) { this.memberSince = memberSince; }

    /** Euro value of current points (100 pts = 1€). */
    public double getDiscountValue() {
        return points / 100.0;
    }
}

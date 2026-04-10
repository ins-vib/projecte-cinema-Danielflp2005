package com.daw.cinemadaw.cart;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

@Service
@SessionScope
public class CartService {

    private final Map<Long, CartItem> items = new LinkedHashMap<>();

    public void addOrReplace(Long screeningId, List<Long> seatIds) {
        items.put(screeningId, new CartItem(screeningId, seatIds));
    }

    public void remove(Long screeningId) {
        items.remove(screeningId);
    }

    public Map<Long, CartItem> getItems() {
        return Collections.unmodifiableMap(items);
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public void clear() {
        items.clear();
    }

    public int getItemCount() {
        return items.values().stream()
                .mapToInt(item -> item.getSeatIds().size())
                .sum();
    }
}

package com.daw.cinemadaw.cart;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CartItem implements Serializable {

    private Long screeningId;
    private List<Long> seatIds;

    public CartItem() {}

    public CartItem(Long screeningId, List<Long> seatIds) {
        this.screeningId = screeningId;
        this.seatIds = new ArrayList<>(seatIds);
    }

    public Long getScreeningId() { return screeningId; }
    public void setScreeningId(Long screeningId) { this.screeningId = screeningId; }
    public List<Long> getSeatIds() { return seatIds; }
    public void setSeatIds(List<Long> seatIds) { this.seatIds = seatIds; }
}

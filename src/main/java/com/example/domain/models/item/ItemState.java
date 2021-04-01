package com.example.domain.models.item;

public enum ItemState {
    PRISTINE(0),
    SLIGHTLY_DAMAGED(5),
    DAMAGED(10);

    private final int discount;

    ItemState(int discount) {
        this.discount = discount;
    }

    public int getDiscount(){
        return discount;
    }
}

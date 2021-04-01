package com.example.domain.models.item;

public enum OverViewUrgency {
    STOCK_LOW(1),
    STOCK_MEDIUM(2),
    STOCK_HIGH(3);

    private final int urgency;
    OverViewUrgency(int urgency) {
        this.urgency = urgency;
    }

    public int getUrgency(){return this.urgency;}
}

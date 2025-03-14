package net.osslabz.crypto;

import java.util.Arrays;
import java.util.List;


public enum OrderStatus {

    PREPARED(false),

    ERROR(true),

    /**
     * Initial order when instantiated
     */
    PENDING_NEW(false),
    /**
     * Initial order when placed on the order book at exchange
     */
    NEW(false),
    /**
     * Partially match against opposite order on order book at exchange
     */
    PARTIALLY_FILLED(false),
    /**
     * Fully match against opposite order on order book at exchange
     */
    FILLED(true),
    /**
     * Waiting to be removed from order book at exchange
     */
    PENDING_CANCEL(false),
    /**
     * Order was partially canceled at exchange
     */
    PARTIALLY_CANCELED(false),
    /**
     * Removed from order book at exchange
     */
    CANCELED(true),
    /**
     * Waiting to be replaced by another order on order book at exchange
     */
    PENDING_REPLACE(false),
    /**
     * Order has been replace by another order on order book at exchange
     */
    REPLACED(true),
    /**
     * Order has been triggered at stop price
     */
    STOPPED(false),
    /**
     * Order has been rejected by exchange and not place on order book
     */
    REJECTED(true),
    /**
     * Order has expired it's time to live or trading session and been removed from order book
     */
    EXPIRED(true),
    /**
     * Order is open and waiting to be filled
     */
    OPEN(false),
    /**
     * Order has been either filled or cancelled
     */
    CLOSED(true),
    /**
     * The exchange returned a state which is not in the exchange's API documentation. The state of the order cannot be confirmed.
     */
    UNKNOWN(false);

    private boolean isFinal;


    OrderStatus(boolean isFinal) {

        this.isFinal = isFinal;
    }


    public boolean isFinal() {

        return isFinal;
    }


    public List<OrderStatus> getFinal() {

        return Arrays.stream(OrderStatus.values()).filter(OrderStatus::isFinal).toList();
    }
}
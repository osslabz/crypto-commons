package net.osslabz.crypto;

public enum OrderStatus {

    PREPARED,

    ERROR,

    /**
     * Initial order when instantiated
     */
    PENDING_NEW,
    /**
     * Initial order when placed on the order book at exchange
     */
    NEW,
    /**
     * Partially match against opposite order on order book at exchange
     */
    PARTIALLY_FILLED,
    /**
     * Fully match against opposite order on order book at exchange
     */
    FILLED,
    /**
     * Waiting to be removed from order book at exchange
     */
    PENDING_CANCEL,
    /**
     * Order was partially canceled at exchange
     */
    PARTIALLY_CANCELED,
    /**
     * Removed from order book at exchange
     */
    CANCELED,
    /**
     * Waiting to be replaced by another order on order book at exchange
     */
    PENDING_REPLACE,
    /**
     * Order has been replace by another order on order book at exchange
     */
    REPLACED,
    /**
     * Order has been triggered at stop price
     */
    STOPPED,
    /**
     * Order has been rejected by exchange and not place on order book
     */
    REJECTED,
    /**
     * Order has expired it's time to live or trading session and been removed from order book
     */
    EXPIRED,
    /**
     * Order is open and waiting to be filled
     */
    OPEN,
    /**
     * Order has been either filled or cancelled
     */
    CLOSED,
    /**
     * The exchange returned a state which is not in the exchange's API documentation. The state of the order cannot be confirmed.
     */
    UNKNOWN;
}
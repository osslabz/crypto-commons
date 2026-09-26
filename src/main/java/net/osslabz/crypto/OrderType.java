package net.osslabz.crypto;

public enum OrderType {
    MARKET,
    LIMIT,
    /** A limit order the exchange rejects instead of letting it take liquidity. */
    POST_ONLY,
    /** Fills what it can right away, cancels the rest. */
    IMMEDIATE_OR_CANCEL,
    /** Fills completely right away or not at all. */
    FILL_OR_KILL,
    /** A stop-loss or take-profit order, for exchanges that report both as one type. */
    STOP_LOSS_TAKE_PROFIT
}

package net.osslabz.crypto;

import java.util.Objects;

/**
 * Identifies a trading asset (a currency pair on a specific exchange).
 *
 * @param exchange
 * @param currencyPair
 */
public record TradingAsset(Exchange exchange, CurrencyPair currencyPair) {
    public TradingAsset {
        Objects.requireNonNull(exchange, "exchange cannot be null");
        Objects.requireNonNull(currencyPair, "currencyPair cannot be null");
    }
}
package net.osslabz.crypto;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

    public TradingAsset(Exchange exchange, String baseCurrencyCode, String counterCurrencyCode) {
        this(exchange, new CurrencyPair(baseCurrencyCode, counterCurrencyCode));
    }

    public String baseCurrencyCode() {
        return currencyPair.baseCurrencyCode();
    }

    public String counterCurrencyCode() {
        return currencyPair.counterCurrencyCode();
    }

    @JsonIgnore
    public String getLabel() {
        return "%s-%s".formatted(exchange, currencyPair.getLabel());
    }
}
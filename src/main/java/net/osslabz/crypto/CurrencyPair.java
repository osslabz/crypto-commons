package net.osslabz.crypto;


import java.util.Objects;

/**
 * Identifies a currency pair.
 *
 * @param baseCurrencyCode
 * @param counterCurrencyCode
 */
public record CurrencyPair(String baseCurrencyCode, String counterCurrencyCode) {

    public CurrencyPair {
        Objects.requireNonNull(baseCurrencyCode, "baseCurrencyCode cannot be null");
        Objects.requireNonNull(counterCurrencyCode, "counterCurrencyCode cannot be null");
    }

    public String getLabel() {
        return "%s-%s".formatted(this.baseCurrencyCode, this.counterCurrencyCode);
    }
}
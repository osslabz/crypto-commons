package net.osslabz.crypto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Objects;

/**
 * Identifies a currency pair.
 */
public record CurrencyPair(String baseCurrencyCode, String counterCurrencyCode) {

    public CurrencyPair {
        Objects.requireNonNull(baseCurrencyCode, "baseCurrencyCode cannot be null");
        Objects.requireNonNull(counterCurrencyCode, "counterCurrencyCode cannot be null");
    }

    public static CurrencyPair fromString(String currencyPair) {
        Objects.requireNonNull(currencyPair, "currencyPair cannot be null");
        if (!currencyPair.contains("-")) {
            throw new IllegalArgumentException("currencyPair must contain '-'");
        }
        String[] split = currencyPair.split("-", -1);
        if (split[0].isEmpty() || split[1].isEmpty()) {
            throw new IllegalArgumentException("currencyPair must have a currency code on both sides of '-'");
        }

        return new CurrencyPair(split[0], split[1]);
    }

    @JsonIgnore
    public String getLabel() {
        return "%s-%s".formatted(this.baseCurrencyCode, this.counterCurrencyCode);
    }

    @Override
    public String toString() {
        return "%s[%s]".formatted(this.getClass().getSimpleName(), this.getLabel());
    }
}

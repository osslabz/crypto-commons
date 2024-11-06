package net.osslabz.crypto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Objects;

public record OhlcAsset(TradingAsset tradingAsset, Interval interval) {

    public OhlcAsset {
        Objects.requireNonNull(tradingAsset, "tradingAsset cannot be null");
        Objects.requireNonNull(interval, "interval cannot be null");
    }

    public OhlcAsset(Exchange exchange, CurrencyPair currencyPair, Interval interval) {
        this(new TradingAsset(exchange, currencyPair), interval);
    }

    public OhlcAsset(Exchange exchange, String baseCurrencyCode, String counterCurrencyCode, Interval interval) {
        this(new TradingAsset(exchange, new CurrencyPair(baseCurrencyCode, counterCurrencyCode)), interval);
    }

    public Exchange exchange() {
        return tradingAsset.exchange();
    }

    public CurrencyPair currencyPair() {
        return tradingAsset.currencyPair();
    }

    public String baseCurrencyCode() {
        return currencyPair().baseCurrencyCode();
    }

    public String counterCurrencyCode() {
        return currencyPair().counterCurrencyCode();
    }

    @JsonIgnore
    public String getLabel() {
        return "%s-%s".formatted(tradingAsset.getLabel(), interval.name());
    }

    @Override
    public String toString() {
        return "%s[%s]".formatted(this.getClass().getSimpleName(), this.getLabel());
    }
}
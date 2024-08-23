package net.osslabz.crypto;

import com.fasterxml.jackson.annotation.JsonIgnore;

public record OhlcAsset(TradingAsset tradingAsset, Interval interval) {

    public Exchange exchange() {
        return tradingAsset.exchange();
    }

    public CurrencyPair currencyPair() {
        return tradingAsset.currencyPair();
    }

    @JsonIgnore
    public String getLabel() {
        return "%s-%s".formatted(tradingAsset.getLabel(), interval.name());
    }
}
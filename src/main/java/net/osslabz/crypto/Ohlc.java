package net.osslabz.crypto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.ZonedDateTime;


@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Ohlc {

    private OhlcAsset asset;

    private ZonedDateTime updateTime;

    @EqualsAndHashCode.Include
    private ZonedDateTime openTime;

    private ZonedDateTime closeTime;

    private BigDecimal openPrice;

    private BigDecimal highPrice;

    private BigDecimal lowPrice;

    private BigDecimal closePrice;

    private BigDecimal avgPrice;

    private BigDecimal volume;

    private Long numTrades;

    public CurrencyPair getCurrencyPair() {
        return this.asset.currencyPair();
    }

    public Interval getInterval() {
        return this.asset.interval();
    }
}
package net.osslabz.crypto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.ZonedDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Ohlc {

    @EqualsAndHashCode.Include
    private OhlcAsset asset;

    @EqualsAndHashCode.Include
    private ZonedDateTime openTime;

    private ZonedDateTime closeTime;

    private BigDecimal openPrice;

    private BigDecimal highPrice;

    private BigDecimal lowPrice;

    private BigDecimal closePrice;

    private BigDecimal avgPrice;

    private BigDecimal quantity;

    private BigDecimal volume;

    private Long numTrades;

    private ZonedDateTime updateTime;


    public TradingAsset tradingAsset() {
        return asset.tradingAsset();
    }

    public Exchange exchange() {
        return asset.exchange();
    }

    public CurrencyPair currencyPair() {
        return asset.currencyPair();
    }

    public Interval interval() {
        return asset.interval();
    }

    public String baseCurrencyCode() {
        return currencyPair().baseCurrencyCode();
    }

    public String counterCurrencyCode() {
        return currencyPair().counterCurrencyCode();
    }

    public boolean isBullish() {
        return this.openPrice != null && this.closePrice != null && this.openPrice.compareTo(this.closePrice) < 0;
    }

    public boolean isBearish() {
        return this.openPrice != null && this.closePrice != null && this.openPrice.compareTo(this.closePrice) > 0;
    }

    public BigDecimal getPriceDiffAsPercentageOpenToClose() {
        return CryptoMathUtils.getPriceDiffAsPercentage(this.closePrice, this.openPrice);
    }
}
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

    private BigDecimal volume;

    private Long numTrades;

    private ZonedDateTime updateTime;
}
package net.osslabz.crypto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import org.junit.jupiter.api.Test;

class OhlcTest {

    private static final OhlcAsset ASSET = new OhlcAsset(Exchange.COINBASE, "BTC", "EUR", Interval.PT1M);

    private static final ZonedDateTime OPEN_TIME = ZonedDateTime.of(2025, 3, 1, 12, 0, 0, 0, ZoneOffset.UTC);

    private static Ohlc candle(String openPrice, String closePrice) {
        return Ohlc.builder()
                .asset(ASSET)
                .openTime(OPEN_TIME)
                .openPrice(openPrice == null ? null : new BigDecimal(openPrice))
                .closePrice(closePrice == null ? null : new BigDecimal(closePrice))
                .build();
    }

    @Test
    void exposesAssetParts() {
        Ohlc ohlc = candle("1", "2");
        assertEquals(ASSET.tradingAsset(), ohlc.tradingAsset());
        assertEquals(Exchange.COINBASE, ohlc.exchange());
        assertEquals(new CurrencyPair("BTC", "EUR"), ohlc.currencyPair());
        assertEquals(Interval.PT1M, ohlc.interval());
        assertEquals("BTC", ohlc.baseCurrencyCode());
        assertEquals("EUR", ohlc.counterCurrencyCode());
    }

    @Test
    void risingCandleIsBullish() {
        Ohlc ohlc = candle("100", "110");
        assertTrue(ohlc.isBullish());
        assertFalse(ohlc.isBearish());
        assertEquals(new BigDecimal("0.1"), ohlc.getPriceDiffAsPercentageOpenToClose());
    }

    @Test
    void fallingCandleIsBearish() {
        Ohlc ohlc = candle("110", "100");
        assertFalse(ohlc.isBullish());
        assertTrue(ohlc.isBearish());
    }

    @Test
    void flatOrIncompleteCandleIsNeitherBullishNorBearish() {
        for (Ohlc ohlc : new Ohlc[] {candle("1", "1"), candle(null, "1"), candle("1", null)}) {
            assertFalse(ohlc.isBullish(), ohlc::toString);
            assertFalse(ohlc.isBearish(), ohlc::toString);
        }
        assertNull(candle(null, "1").getPriceDiffAsPercentageOpenToClose());
    }

    @Test
    void keyIsDerivedFromAssetAndOpenTimeOnce() {
        Ohlc ohlc = candle("1", "2");
        OhlcKey key = ohlc.getKey();
        assertEquals(new OhlcKey(ASSET, OPEN_TIME), key);
        assertSame(key, ohlc.getKey());
    }

    @Test
    void keyNeedsAssetAndOpenTime() {
        assertThrows(NullPointerException.class, () -> new Ohlc().getKey());
    }

    @Test
    void assetPartsNeedAnAsset() {
        assertThrows(NullPointerException.class, () -> new Ohlc().exchange());
    }

    @Test
    void equalityConsidersOnlyAssetAndOpenTime() {
        Ohlc ohlc = candle("1", "2");
        assertEquals(ohlc, candle("3", "4"));
        assertEquals(ohlc.hashCode(), candle("3", "4").hashCode());
        assertNotEquals(
                ohlc, ohlc.toBuilder().openTime(OPEN_TIME.plusMinutes(1)).build());
    }
}

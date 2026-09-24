package net.osslabz.crypto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class OhlcAssetTest {

    private final OhlcAsset asset = new OhlcAsset(Exchange.MEXC, "BTC", "USDT", Interval.PT5M);

    @Test
    void constructorsAgreeOnTheSameAsset() {
        TradingAsset tradingAsset = new TradingAsset(Exchange.MEXC, "BTC", "USDT");
        assertEquals(new OhlcAsset(tradingAsset, Interval.PT5M), asset);
        assertEquals(new OhlcAsset(Exchange.MEXC, new CurrencyPair("BTC", "USDT"), Interval.PT5M), asset);
    }

    @Test
    void exposesTradingAssetParts() {
        assertEquals(Exchange.MEXC, asset.exchange());
        assertEquals(new CurrencyPair("BTC", "USDT"), asset.currencyPair());
        assertEquals("BTC", asset.baseCurrencyCode());
        assertEquals("USDT", asset.counterCurrencyCode());
    }

    @Test
    void labelAppendsInterval() {
        assertEquals("MEXC-BTC-USDT-PT5M", asset.getLabel());
        assertEquals("OhlcAsset[MEXC-BTC-USDT-PT5M]", asset.toString());
    }

    @Test
    void rejectsMissingTradingAssetOrInterval() {
        TradingAsset tradingAsset = new TradingAsset(Exchange.MEXC, "BTC", "USDT");
        assertThrows(NullPointerException.class, () -> new OhlcAsset(null, Interval.PT5M));
        assertThrows(NullPointerException.class, () -> new OhlcAsset(tradingAsset, null));
    }
}

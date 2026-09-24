package net.osslabz.crypto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class TradingAssetTest {

    private final TradingAsset asset = new TradingAsset(Exchange.KRAKEN, "ETH", "EUR");

    @Test
    void buildsCurrencyPairFromCodes() {
        assertEquals(new TradingAsset(Exchange.KRAKEN, new CurrencyPair("ETH", "EUR")), asset);
        assertEquals("ETH", asset.baseCurrencyCode());
        assertEquals("EUR", asset.counterCurrencyCode());
    }

    @Test
    void labelPrefixesCurrencyPairWithExchange() {
        assertEquals("KRAKEN-ETH-EUR", asset.getLabel());
        assertEquals("TradingAsset[KRAKEN-ETH-EUR]", asset.toString());
    }

    @Test
    void rejectsMissingExchangeOrCurrencyPair() {
        CurrencyPair pair = new CurrencyPair("ETH", "EUR");
        assertThrows(NullPointerException.class, () -> new TradingAsset(null, pair));
        assertThrows(NullPointerException.class, () -> new TradingAsset(Exchange.KRAKEN, null));
    }
}

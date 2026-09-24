package net.osslabz.crypto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import org.junit.jupiter.api.Test;

class OhlcKeyTest {

    private static final OhlcAsset ASSET = new OhlcAsset(Exchange.BINANCE, "BTC", "USDT", Interval.PT1H);

    private static final ZonedDateTime OPEN_TIME = ZonedDateTime.of(2025, 3, 1, 12, 0, 0, 0, ZoneOffset.UTC);

    @Test
    void labelCombinesAssetAndIsoOpenTime() {
        OhlcKey key = new OhlcKey(ASSET, OPEN_TIME);
        assertEquals("OhlcAsset[BINANCE-BTC-USDT-PT1H]-2025-03-01T12:00:00Z", key.getLabel());
        assertEquals(key.getLabel(), key.toString());
    }

    @Test
    void rejectsMissingAssetOrOpenTime() {
        assertThrows(NullPointerException.class, () -> new OhlcKey(null, OPEN_TIME));
        assertThrows(NullPointerException.class, () -> new OhlcKey(ASSET, null));
    }
}

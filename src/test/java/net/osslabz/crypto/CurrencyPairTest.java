package net.osslabz.crypto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CurrencyPairTest {

    @Test
    void parsesBaseAndCounterCodeFromLabel() {
        assertEquals(new CurrencyPair("BTC", "USDT"), CurrencyPair.fromString("BTC-USDT"));
    }

    @Test
    void labelJoinsCodesWithDash() {
        assertEquals("BTC-USDT", new CurrencyPair("BTC", "USDT").getLabel());
    }

    @Test
    void toStringNamesTypeAndLabel() {
        assertEquals("CurrencyPair[BTC-USDT]", new CurrencyPair("BTC", "USDT").toString());
    }

    @Test
    void rejectsMissingCodes() {
        NullPointerException base = assertThrows(NullPointerException.class, () -> new CurrencyPair(null, "USDT"));
        assertEquals("baseCurrencyCode cannot be null", base.getMessage());
        NullPointerException counter = assertThrows(NullPointerException.class, () -> new CurrencyPair("BTC", null));
        assertEquals("counterCurrencyCode cannot be null", counter.getMessage());
    }

    @Test
    void rejectsNullLabel() {
        assertThrows(NullPointerException.class, () -> CurrencyPair.fromString(null));
    }

    @Test
    void rejectsLabelWithoutDash() {
        IllegalArgumentException e =
                assertThrows(IllegalArgumentException.class, () -> CurrencyPair.fromString("BTCUSDT"));
        assertEquals("currencyPair must contain '-'", e.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"BTC-", "-USDT", "-", "BTC--USDT"})
    void rejectsLabelWithAnEmptyCode(String label) {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> CurrencyPair.fromString(label));
        assertEquals("currencyPair must have a currency code on both sides of '-'", e.getMessage());
    }

    @Test
    void serializesCodesWithoutLabel() throws Exception {
        assertEquals(
                "{\"baseCurrencyCode\":\"BTC\",\"counterCurrencyCode\":\"USDT\"}",
                new ObjectMapper().writeValueAsString(new CurrencyPair("BTC", "USDT")));
    }
}

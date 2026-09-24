package net.osslabz.crypto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

class CryptoMathUtilsTest {

    @Test
    void positiveValueIsLargerZero() {
        assertTrue(CryptoMathUtils.isLargerZero(new BigDecimal("0.00000001")));
    }

    @Test
    void zeroNegativeAndNullAreNotLargerZero() {
        assertFalse(CryptoMathUtils.isLargerZero(new BigDecimal("0.000")));
        assertFalse(CryptoMathUtils.isLargerZero(new BigDecimal("-1")));
        assertFalse(CryptoMathUtils.isLargerZero(null));
    }

    @Test
    void priceDiffIsCurrentMinusReferenceWithoutTrailingZeros() {
        assertEquals(
                new BigDecimal("-2.5"), CryptoMathUtils.getPriceDiff(new BigDecimal("7.50"), new BigDecimal("10.00")));
    }

    @Test
    void priceDiffIsNullWhenEitherPriceIsMissing() {
        assertNull(CryptoMathUtils.getPriceDiff(null, BigDecimal.ONE));
        assertNull(CryptoMathUtils.getPriceDiff(BigDecimal.ONE, null));
    }

    @Test
    void priceDiffAsPercentageIsRatioToReferenceRoundedToEightDigits() {
        assertEquals(
                new BigDecimal("0.1"),
                CryptoMathUtils.getPriceDiffAsPercentage(new BigDecimal("110"), new BigDecimal("100")));
        assertEquals(
                new BigDecimal("0.33333333"),
                CryptoMathUtils.getPriceDiffAsPercentage(new BigDecimal("4"), new BigDecimal("3")));
    }

    @Test
    void priceDiffAsPercentageIsNullWhenEitherPriceIsMissing() {
        assertNull(CryptoMathUtils.getPriceDiffAsPercentage(null, BigDecimal.ONE));
        assertNull(CryptoMathUtils.getPriceDiffAsPercentage(BigDecimal.ONE, null));
    }

    @Test
    void priceDiffAsPercentageFailsForZeroReferencePrice() {
        assertThrows(
                ArithmeticException.class,
                () -> CryptoMathUtils.getPriceDiffAsPercentage(BigDecimal.ONE, BigDecimal.ZERO));
    }
}

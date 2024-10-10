package net.osslabz.crypto;

import java.math.BigDecimal;
import java.math.RoundingMode;


public class CryptoMathUtils {

    public static final BigDecimal HUNDRED = BigDecimal.valueOf(100L);

    private CryptoMathUtils() {
        // intentionally empty
    }

    public static boolean isLargerZero(BigDecimal value) {

        return value != null && value.compareTo(java.math.BigDecimal.ZERO) > 0;
    }

    public static BigDecimal getPriceDiff(BigDecimal currentPrice, BigDecimal referencePrice) {

        return currentPrice != null && referencePrice != null ? currentPrice.subtract(referencePrice).stripTrailingZeros() : null;
    }

    public static BigDecimal getPriceDiffAsPercentage(BigDecimal currentPrice, BigDecimal referencePrice) {

        BigDecimal diffPrice = getPriceDiff(currentPrice, referencePrice);
        return diffPrice != null ? diffPrice.divide(referencePrice, 8, RoundingMode.HALF_UP).stripTrailingZeros() : null;
    }
}
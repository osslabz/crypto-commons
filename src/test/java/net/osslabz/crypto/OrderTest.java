package net.osslabz.crypto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

class OrderTest {

    private static final TradingAsset BTC_USDT = new TradingAsset(Exchange.POLONIEX, "BTC", "USDT");

    @Test
    void toBuilderCopiesAllFields() {
        Order order = Order.builder()
                .asset(new TradingAsset(Exchange.POLONIEX, "BTC", "USDT"))
                .action(OrderAction.BUY)
                .type(OrderType.LIMIT)
                .status(OrderStatus.NEW)
                .price(new BigDecimal("42000"))
                .quantity(new BigDecimal("0.5"))
                .build();

        Order filled = order.toBuilder().status(OrderStatus.FILLED).build();

        assertEquals(order.getAsset(), filled.getAsset());
        assertEquals(OrderAction.BUY, filled.getAction());
        assertEquals(OrderType.LIMIT, filled.getType());
        assertEquals(new BigDecimal("42000"), filled.getPrice());
        assertEquals(new BigDecimal("0.5"), filled.getQuantity());
        assertEquals(OrderStatus.FILLED, filled.getStatus());
        assertEquals(OrderStatus.NEW, order.getStatus());
    }

    @Test
    void snapshotsOfTheSameOrderAreEqual() {
        Order placed = placedOrder(BTC_USDT, "order-1", "client-1");
        Order filled = placed.toBuilder()
                .status(OrderStatus.FILLED)
                .cumulativeQuantity(new BigDecimal("0.5"))
                .build();

        assertEquals(placed, filled);
        assertEquals(placed.hashCode(), filled.hashCode());
    }

    @Test
    void ordersWithDifferentExchangeOrderIdsAreNotEqual() {
        assertNotEquals(placedOrder(BTC_USDT, "order-1", "client-1"), placedOrder(BTC_USDT, "order-2", "client-1"));
    }

    @Test
    void ordersWithDifferentClientOrderIdsAreNotEqual() {
        assertNotEquals(placedOrder(BTC_USDT, null, "client-1"), placedOrder(BTC_USDT, null, "client-2"));
    }

    @Test
    void ordersWithTheSameIdsOnDifferentAssetsAreNotEqual() {
        TradingAsset btcUsdtElsewhere = new TradingAsset(Exchange.BINANCE, "BTC", "USDT");

        assertNotEquals(
                placedOrder(BTC_USDT, "order-1", "client-1"), placedOrder(btcUsdtElsewhere, "order-1", "client-1"));
    }

    private static Order placedOrder(TradingAsset asset, String exchangeOrderId, String clientOrderId) {
        return Order.builder()
                .asset(asset)
                .exchangeOrderId(exchangeOrderId)
                .clientOrderId(clientOrderId)
                .action(OrderAction.BUY)
                .type(OrderType.LIMIT)
                .status(OrderStatus.NEW)
                .price(new BigDecimal("42000"))
                .quantity(new BigDecimal("0.5"))
                .build();
    }
}

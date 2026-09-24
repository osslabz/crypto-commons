package net.osslabz.crypto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

class OrderTest {

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
}

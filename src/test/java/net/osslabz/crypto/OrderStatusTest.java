package net.osslabz.crypto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.Test;

class OrderStatusTest {

    @Test
    void terminalStatusesAreFinal() {
        assertTrue(OrderStatus.FILLED.isFinal());
        assertFalse(OrderStatus.PARTIALLY_FILLED.isFinal());
    }

    @Test
    void listsFinalStatusesInDeclarationOrder() {
        assertEquals(
                List.of(
                        OrderStatus.ERROR,
                        OrderStatus.FILLED,
                        OrderStatus.CANCELED,
                        OrderStatus.REPLACED,
                        OrderStatus.REJECTED,
                        OrderStatus.EXPIRED,
                        OrderStatus.CLOSED),
                OrderStatus.NEW.getFinal());
    }
}

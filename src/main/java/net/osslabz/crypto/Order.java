package net.osslabz.crypto;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * A snapshot of an order on an exchange.
 *
 * <p>Two snapshots are equal when they share asset, exchange order id and client order id, whatever
 * their status or fill.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Order {

    @EqualsAndHashCode.Include
    private TradingAsset asset;

    private OrderAction action;

    private OrderType type;

    private OrderStatus status;

    @EqualsAndHashCode.Include
    private String exchangeOrderId;

    @EqualsAndHashCode.Include
    private String clientOrderId;

    private BigDecimal quantity;

    private BigDecimal cumulativeQuantity;

    private BigDecimal amount;

    private BigDecimal cumulativeAmount;

    private BigDecimal price;

    private BigDecimal avgPrice;

    private BigDecimal fee;

    private ZonedDateTime createdAt;

    private ZonedDateTime updatedAt;
}

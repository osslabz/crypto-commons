package net.osslabz.crypto;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * A snapshot of an order on an exchange.
 *
 * <p>Two snapshots are equal when they share asset, exchange order id and client order id, whatever
 * their status or fill. Those three fields are fixed at construction, so an order keeps its place in
 * a hash-based collection.
 */
@Data
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
@Jacksonized
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Order {

    @EqualsAndHashCode.Include
    private final TradingAsset asset;

    private OrderAction action;

    private OrderType type;

    private OrderStatus status;

    @EqualsAndHashCode.Include
    private final String exchangeOrderId;

    @EqualsAndHashCode.Include
    private final String clientOrderId;

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

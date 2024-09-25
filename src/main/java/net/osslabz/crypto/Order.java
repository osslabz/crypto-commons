package net.osslabz.crypto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Order {

    private TradingAsset asset;

    private OrderAction action;

    private OrderType type;

    private OrderStatus status;

    private String exchangeOrderId;

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
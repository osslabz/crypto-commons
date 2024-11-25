package net.osslabz.crypto;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;


public record OhlcKey(OhlcAsset asset, ZonedDateTime openTime) {

    public OhlcKey(OhlcAsset asset, ZonedDateTime openTime) {

        Objects.requireNonNull(asset, "asset cannot be null");
        Objects.requireNonNull(openTime, "openTime cannot be null");
        this.asset = asset;
        this.openTime = openTime;
    }


    public String toString() {

        return this.getLabel();
    }


    public String getLabel() {

        return "%s-%s".formatted(asset.toString(), DateTimeFormatter.ISO_DATE_TIME.format(openTime));
    }
}
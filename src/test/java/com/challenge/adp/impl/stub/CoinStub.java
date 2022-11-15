package com.challenge.adp.impl.stub;

import com.challenge.adp.impl.model.Coin;

import java.math.BigDecimal;
import java.util.List;

public class CoinStub {
    public static List<Coin> getCoinDESCList() {
        return List.of(getCoin(),
                Coin.builder()
                        .id("3")
                        .value(new BigDecimal("0.10"))
                        .amount(100)
                        .build(),
                Coin.builder()
                        .id("2")
                        .value(new BigDecimal("0.05"))
                        .amount(100)
                        .build(),
                Coin.builder()
                        .id("1")
                        .value(new BigDecimal("0.01"))
                        .amount(100)
                        .build());
    }

    public static List<Coin> getCoinDESCListMissing() {
        return List.of(Coin.builder()
                        .value(new BigDecimal("0.25"))
                        .id("4")
                        .amount(0)
                        .build(),
                Coin.builder()
                        .id("3")
                        .value(new BigDecimal("0.10"))
                        .amount(0)
                        .build(),
                Coin.builder()
                        .id("2")
                        .value(new BigDecimal("0.05"))
                        .amount(0)
                        .build(),
                Coin.builder()
                        .id("1")
                        .value(new BigDecimal("0.01"))
                        .amount(0)
                        .build());
    }

    public static List<Coin> getCoinASCList() {
        return List.of(Coin.builder()
                        .id("1")
                        .value(new BigDecimal("0.01"))
                        .amount(100)
                        .build(),
                Coin.builder()
                        .id("2")
                        .value(new BigDecimal("0.05"))
                        .amount(100)
                        .build(),
                Coin.builder()
                        .id("3")
                        .value(new BigDecimal("0.10"))
                        .amount(100)
                        .build(),
                getCoin());
    }

    public static List<Coin> getCoinASCListMissing() {
        return List.of(Coin.builder()
                        .id("1")
                        .value(new BigDecimal("0.01"))
                        .amount(0)
                        .build(),
                Coin.builder()
                        .id("2")
                        .value(new BigDecimal("0.05"))
                        .amount(0)
                        .build(),
                Coin.builder()
                        .id("3")
                        .value(new BigDecimal("0.10"))
                        .amount(0)
                        .build(),
                Coin.builder()
                        .value(new BigDecimal("0.25"))
                        .id("4")
                        .amount(0)
                        .build());
    }

    public static Coin getCoin() {
        return Coin.builder()
                .value(new BigDecimal("0.25"))
                .id("4")
                .amount(100)
                .build();
    }
}

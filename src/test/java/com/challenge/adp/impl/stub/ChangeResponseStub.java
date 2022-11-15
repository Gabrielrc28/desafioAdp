package com.challenge.adp.impl.stub;

import com.challenge.adp.impl.model.ChangeResponse;

import java.math.BigDecimal;
import java.util.List;

public class ChangeResponseStub {
    public static List<ChangeResponse> getChangeResponseASCList() {
        return List.of(ChangeResponse.builder()
                        .value(new BigDecimal("0.01"))
                        .amount(100)
                        .build(),
                ChangeResponse.builder()
                        .value(new BigDecimal("0.05"))
                        .amount(100)
                        .build(),
                ChangeResponse.builder()
                        .value(new BigDecimal("0.10"))
                        .amount(100)
                        .build(),
                ChangeResponse.builder()
                        .value(new BigDecimal("0.25"))
                        .amount(16)
                        .build()
                );
    }

    public static List<ChangeResponse> getChangeResponseDESCList() {
        return List.of(ChangeResponse.builder()
                        .value(new BigDecimal("0.25"))
                        .amount(80)
                        .build(),
                ChangeResponse.builder()
                        .value(new BigDecimal("0.10"))
                        .amount(0)
                        .build(),
                ChangeResponse.builder()
                        .value(new BigDecimal("0.05"))
                        .amount(0)
                        .build(),
                ChangeResponse.builder()
                        .value(new BigDecimal("0.01"))
                        .amount(0)
                        .build());
    }
}

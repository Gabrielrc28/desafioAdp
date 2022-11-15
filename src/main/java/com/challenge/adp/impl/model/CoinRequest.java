package com.challenge.adp.impl.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class CoinRequest {
    private String id;
    private Integer amount;
}

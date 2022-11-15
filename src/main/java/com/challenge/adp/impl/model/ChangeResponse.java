package com.challenge.adp.impl.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@Builder
public class ChangeResponse {
    private BigDecimal value;
    private Integer amount;
}

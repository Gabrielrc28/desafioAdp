package com.challenge.adp.controller;

import com.challenge.adp.impl.model.ChangeResponse;
import com.challenge.adp.impl.service.CoinChangeService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/changes-controller/")
public class ChangeController {
    private final CoinChangeService coinChangeService;

    @PostMapping("more-change/{note}")
    public ResponseEntity<List<ChangeResponse>> getMoreChange(@PathVariable("note") BigDecimal bill) {
        return ResponseEntity.ok().body(coinChangeService.getExchange(bill, Sort.Direction.ASC));
    }
    @PostMapping("less-change/{note}")
    public ResponseEntity<List<ChangeResponse>> getLessChange(@PathVariable("note") BigDecimal bill) {
        return ResponseEntity.ok().body(coinChangeService.getExchange(bill, Sort.Direction.DESC));
    }
}

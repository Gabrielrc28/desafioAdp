package com.challenge.adp.controller;

import com.challenge.adp.impl.model.CoinRequest;
import com.challenge.adp.impl.service.BackOfficeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/back-office/")
public class BackOfficeController {
    private BackOfficeService backOfficeService;

    @PostMapping("update-coin")
    public void updateCoin(@RequestBody CoinRequest coin) {
        backOfficeService.updateCoinAmount(coin);
    }
}

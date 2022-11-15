package com.challenge.adp.impl.service;

import com.challenge.adp.exception.CoinNotFoundException;
import com.challenge.adp.impl.model.Coin;
import com.challenge.adp.impl.model.CoinRequest;
import com.challenge.adp.impl.repository.CoinsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BackOfficeService {

    private final CoinsRepository coinsRepository;

    public void updateCoinAmount(CoinRequest coinRequest) {

        var coinAmount = getById(coinRequest);

        coinAmount.setAmount(coinAmount.getAmount() + coinRequest.getAmount());

        coinsRepository.save(coinAmount);
    }

    private Coin getById(CoinRequest coinRequest) {
        return coinsRepository.findById(coinRequest.getId())
                .orElseThrow(CoinNotFoundException::new);
    }
}

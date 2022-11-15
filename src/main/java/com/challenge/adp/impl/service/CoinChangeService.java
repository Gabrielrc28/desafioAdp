package com.challenge.adp.impl.service;

import com.challenge.adp.exception.NotEnoughCoinsException;
import com.challenge.adp.impl.model.ChangeResponse;
import com.challenge.adp.impl.model.Coin;
import com.challenge.adp.impl.repository.CoinsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CoinChangeService {
    private final CoinsRepository coinsRepository;

    private BigDecimal auxValue = new BigDecimal("0");

    public List<ChangeResponse> getExchange(BigDecimal value, Sort.Direction direction) {
        var allCoins = coinsRepository.findAll(Sort
                .by(direction, "value"));

        var change = allCoins.stream()
                .map(coin -> exchangeBill(value, coin))
                .collect(Collectors.toList());
        validateResult(value, change);

        return change;
    }

    private ChangeResponse exchangeBill(BigDecimal value, Coin coin) {
        var coinType = coin.getValue();

        var changeResponse = getChangeResponse(coinType);

        var totalQuarters = coin.getAmount();

        for (int i = 0; i < totalQuarters; i++) {
            if (0 > auxValue.compareTo(value)) {
                changeResponse.setAmount(changeResponse.getAmount() + 1);
                auxValue = auxValue.add(coinType);
            }
        }
        return changeResponse;
    }

    private void validateResult(BigDecimal value, List<ChangeResponse> coins) {
        if (value.compareTo(auxValue) > 0) {
            throw new NotEnoughCoinsException();
        }
        debitCoins(coins);
    }

    private static ChangeResponse getChangeResponse(BigDecimal quarter) {
        return ChangeResponse.builder()
                .amount(0)
                .value(quarter)
                .build();
    }

    private void debitCoins(List<ChangeResponse> coins) {
        auxValue = BigDecimal.ZERO;

        coins.forEach(coin -> {
            var coinModel = coinsRepository.getByValue(coin.getValue());

            coinModel.setAmount(coinModel.getAmount() - coin.getAmount());

            coinsRepository.save(coinModel);
        });
    }
}

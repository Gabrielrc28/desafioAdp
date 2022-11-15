package com.challenge.adp.impl.service;

import com.challenge.adp.exception.NotEnoughCoinsException;
import com.challenge.adp.impl.repository.CoinsRepository;
import com.challenge.adp.impl.stub.ChangeResponseStub;
import com.challenge.adp.impl.stub.CoinStub;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Sort;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CoinChangeServiceTest {

    private final CoinChangeService coinChangeService;

    private final CoinsRepository coinsRepository;

    public CoinChangeServiceTest() {
        this.coinsRepository = mock(CoinsRepository.class);
        coinChangeService = new CoinChangeService(coinsRepository);
    }

    @Test
    void getExchangeShouldReturnListOfCoinsWhenEverythingIsOKASC() {
        var valueRequest = new BigDecimal(20);
        var sortDirection = Sort.Direction.ASC;

        var expected = ChangeResponseStub.getChangeResponseASCList();

        when(coinsRepository.findAll(any(Sort.class))).thenReturn(CoinStub.getCoinASCList());
        when(coinsRepository.getByValue(any())).thenReturn(CoinStub.getCoin());

        var actual = coinChangeService.getExchange(valueRequest, sortDirection);

        assertEquals(expected, actual);
    }

    @Test
    void getExchangeShouldReturnListOfCoinsWhenEverythingIsOKDESC() {
        var valueRequest = new BigDecimal(20);
        var sortDirection = Sort.Direction.DESC;

        var expected = ChangeResponseStub.getChangeResponseDESCList();

        when(coinsRepository.findAll(any(Sort.class))).thenReturn(CoinStub.getCoinDESCList());
        when(coinsRepository.getByValue(any())).thenReturn(CoinStub.getCoin());

        var actual = coinChangeService.getExchange(valueRequest, sortDirection);

        assertEquals(expected, actual);
    }

    @Test
    void getExchangeShouldThrowExceptionWhenIsNotEnoughCoinsASC() {
        var valueRequest = new BigDecimal(20);
        var sortDirection = Sort.Direction.ASC;

        when(coinsRepository.findAll(any(Sort.class))).thenReturn(CoinStub.getCoinASCListMissing());
        when(coinsRepository.getByValue(any())).thenReturn(CoinStub.getCoin());

        assertThrows(NotEnoughCoinsException.class, () -> coinChangeService.getExchange(valueRequest, sortDirection));
    }

    @Test
    void getExchangeShouldThrowExceptionWhenIsNotEnoughCoinsDESC() {
        var valueRequest = new BigDecimal(20);
        var sortDirection = Sort.Direction.DESC;

        when(coinsRepository.findAll(any(Sort.class))).thenReturn(CoinStub.getCoinDESCListMissing());
        when(coinsRepository.getByValue(any())).thenReturn(CoinStub.getCoin());

        assertThrows(NotEnoughCoinsException.class, () -> coinChangeService.getExchange(valueRequest, sortDirection));
    }

}
package com.challenge.adp.impl.repository;

import com.challenge.adp.impl.model.Coin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;

public interface CoinsRepository extends JpaRepository<Coin, String> {
    @Query("SELECT u FROM Coin u WHERE u.value = ?1")
    Coin getByValue(BigDecimal value);
}

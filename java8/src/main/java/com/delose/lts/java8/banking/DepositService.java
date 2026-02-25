package com.delose.lts.java8.banking;

import java.math.BigDecimal;

public interface DepositService {
    DepositResult processDeposit(DepositCommand command);
}

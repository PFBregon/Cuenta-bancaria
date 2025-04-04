package dev.patriciafb.bankacount.models;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.assertj.core.data.Offset;
import org.junit.jupiter.api.Test;

public class AccountTest {

    @Test
    void testDeposit() {
        Account account = new Account(1000, 5);

        account.deposit(50.0);

        assertEquals(1050.0, account.getBalance(), "Balance should be updated after deposit");
        assertEquals(1, account.getNumberOfDeposits(), "Number of deposits should increment by 1");
    }

    @Test
    void testWithdraw() {
        Account account = new Account(1000, 5);
        boolean result = account.withdraw(500.0);
        assertThat(result).isTrue(); 
        assertThat(account.getBalance()).isCloseTo(500.0, Offset.offset(0.01));
        assertThat(account.getNumberOfWithdrawals()).isEqualTo(1);
    }

    @Test
    void testCalculateMonthlyInterest() {
        Account account = new Account(1000, 12);
        account.calculateMonthlyInterest();
        assertThat(account.getBalance()).isCloseTo(1010.0, Offset.offset(0.01));
    }

    @Test
    void testGenerateMonthlyStatement() {
        Account account = new Account(1000, 12);
        account.monthlyFee = 50; 
        account.generateMonthlyStatement();
        assertThat(account.getBalance()).isCloseTo(960.0, Offset.offset(0.01));
    }
}
package dev.patriciafb.bankacount.models;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.assertj.core.data.Offset;
import org.junit.jupiter.api.Test;

public class AccountTest {
    @Test
    void testRecord() {
        Account account = new Account(1000, 5);
        
        account.record(50.0);
        assertEquals(1050.0, account.getBalance());
        assertEquals(6, account.getNumberConsignments());
    }

    @Test
    void testGetMoney() {
        Account account = new Account(1000, 5);
        boolean result = account.getMoney(500.0);
    
        assertThat(result).isTrue();  
        assertThat(account.getBalance()).isCloseTo(500.0, Offset.offset(0.01));
        assertThat(account.getNumberRetirement()).isEqualTo(1);
    }
}
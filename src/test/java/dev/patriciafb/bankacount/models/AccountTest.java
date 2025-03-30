package dev.patriciafb.bankacount.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;


public class AccountTest {
    @Test
    void testRecord() {
        Account account = new Account(1000, 5);
        
        account.record(50.0);
        assertEquals(1050.0, account.getBalance());
        assertEquals(6, account.getNumberConsignments());
    }
        

}
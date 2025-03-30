package dev.patriciafb.bankacount.models;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class AccountTest {
    @Test
    void testRecord() {
        Account account = new Account(1000, 5);
        account.record(500);
        assertThat(account.getBalance(), is(closeTo(1500, 0.01)));
        assertThat(account.numberConsignments, is(1));
    }

}
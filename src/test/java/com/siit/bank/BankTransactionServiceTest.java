package com.siit.bank;
import com.siit.homework.Course4.bank.BankAccount;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class BankTransactionServiceTest {
    @Test
    public void given_null_input_on_add_money_when_compute_inverse_then_exception_null_is_returned() throws Exception {
        try {
            BankAccount customerAccount = new BankAccount("ROINGB0000000");
            customerAccount.addMoney(null);
        } catch (Throwable ex) {
            assertThat(ex.getMessage()).isEqualTo("The provided amount is null!");
        }
    }

    @Test
    public void given_minus_input_on_add_money_when_compute_inverse_then_exception_amount_greater_than_zero_is_returned() throws Exception {
        try {
            BankAccount customerAccount = new BankAccount("ROINGB0000000");
            customerAccount.addMoney(new BigDecimal("-100"));
        } catch (Throwable ex) {
            assertThat(ex.getMessage()).isEqualTo("The amount should be greater than 0!");
        }
    }

    @Test
    public void given_null_input_on_withdraw_money_when_compute_inverse_then_exception_null_is_returned() throws Exception {
        try {
            BankAccount customerAccount = new BankAccount("ROINGB0000000");
            customerAccount.withdrawMoney(null);
        } catch (Throwable ex) {
            assertThat(ex.getMessage()).isEqualTo("The provided amount is null!");
        }
    }

    @Test
    public void given_minus_input_on_withdraw_money_when_compute_inverse_then_exception_amount_greater_than_zero_is_returned() throws Exception {
        try {
            BankAccount customerAccount = new BankAccount("ROINGB0000000");
            customerAccount.addMoney(new BigDecimal("-100"));
        } catch (Throwable ex) {
            assertThat(ex.getMessage()).isEqualTo("The amount should be greater than 0!");
        }
    }

    @Test
    public void given_input_greater_than_account_ballance_when_compute_inverse_then_exception_not_enough_money_is_returned() throws Exception {
        try {
            BankAccount customerAccount = new BankAccount("ROINGB0000000");
            customerAccount.withdrawMoney(new BigDecimal("100"));
        } catch (Throwable ex) {
            assertThat(ex.getMessage()).isEqualTo("Not enough money for this operation!");
        }
    }

    @Test
    public void given_input_lower_than_account_ballance_when_compute_inverse_then_not_enough_money_is_returned() throws Exception {
        BankAccount customerAccount = new BankAccount("ROINGB0000000");
        customerAccount.addMoney(new BigDecimal("200"));
        customerAccount.withdrawMoney(new BigDecimal("100"));
        assertThat(customerAccount.getBalance()).isEqualTo(new BigDecimal("100"));
    }
}

package com.sda;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertEquals;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class BankAccountTest {

    private BankAccount account;
    private BankAccount account2;

    @BeforeEach
    public void setUp(){
        account = new BankAccount("1234", 1000);
        account2 = new BankAccount("1414", 500);
    }
    @Test
    void testDeposit(){
        Assertions.assertTrue(account.deposit(500));
        Assertions.assertFalse(account.deposit(-20));
        assertEquals(1500, account.getBalance());
    }
    @Test
    void testWithdraw(){
        Assertions.assertTrue(account.withdraw(500));
        Assertions.assertFalse(account.withdraw(1100));
        assertEquals(500, account.getBalance());
    }
    @Test
    void testTransfer(){
        Assertions.assertTrue(account.transfer(500, account2));
        Assertions.assertFalse(account.transfer(1100, account2));
        assertEquals(500, account.getBalance());
    }
    @Test
    void testGetBalance(){
        assertEquals(1000, account.getBalance());
    }
}

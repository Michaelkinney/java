package bank;

import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class CustomerTests {
    @Test
    public void getNameTest() {
        Customer customer = new Customer("Amir", "Yunas", 10000000);
        String expected = "Amir Yunas";
        String actual = customer.getName();
        Assert.assertEquals(actual, expected);
    }
}


/*
    User Story #1:  As a Branch, I want a Customer's withdraw to be properly accounted for, so the Bank isn't giving the Customer money they do NOT have

    Acceptance Criteria:
     - GIVEN any Customer
        WHEN the Customer makes a withdrawal
        THEN the Customer's account is reduced by the amount withdrawn



    User Story #2:  As a Teller, I want notification when a transaction will overdraw an account, so that I can alert the Customer

    Acceptance Criteria:
     - GIVEN a Customer with 1000 balance
        WHEN more than 1000 is withdrawn
        THEN the teller is notified the withdrawal will overdraw the account

 */

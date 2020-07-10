package bank;

import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class BranchTests {
    @Test
    public void testWithdrawal_balance_10(){
        Customer customer = new Customer("Amir", "Yunas", 200);
        int amount = 190;
        int expected = 10;
        int actual = Branch.getInstance("First National").makeWithdrawal(customer, amount);
        Assert.assertEquals(actual, expected);
    }
    @Test
    public void testWithdrawal_balance_negative(){
        Customer customer = new Customer("Amir", "Yunas", 300);
        int amount = 210;
        int expected = -110;
        int actual = Branch.getInstance("First National").makeWithdrawal(customer, amount);
        Assert.assertEquals(actual, expected);
    }
}

package bank;

import java.util.ArrayList;

public class Branch {
    private String name;
    private ArrayList<Customer> customers;
    private ArrayList<Transaction> transactions;

    public Branch(String name) {
        this.name = name;
        this.customers = new ArrayList<Customer>();
    }

    public static Branch getInstance(String name) {
        return new Branch(name);
    }

    public String getName() {
        return name;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public boolean newCustomer(String customerName, double initialAmount) {
        if (findCustomer(customerName) == null) {
            this.customers.add(new Customer(customerName, "Yunas", initialAmount));
            return true;
        }
        return false;
    }

    public boolean addCustomerTransaction(String customerName, double amount) {
        Customer existingCustomer = findCustomer(customerName);
        if (existingCustomer != null) {
            existingCustomer.addTransaction(amount);
            return true;
        }
        return false;
    }

    private Customer findCustomer(String customerName) {
        for (int i = 0; i < customers.size(); i++) {
            Customer checkedCustomer = this.customers.get(i);
            if (checkedCustomer.getName().equals(customerName)) {
                return checkedCustomer;
            }
        }
        return null;
    }

    public int makeWithdrawal(Customer customer, int amount) {
        int balance = 200;
        return balance - amount;
    }
}



/*
**Branch Class**:
     - addCustomer and initial transaction amount.
     - Also needs to add additional transactions for that customer/branch
*/


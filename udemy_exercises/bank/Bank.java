package bank;

        import java.util.ArrayList;


public class Bank {
    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name) {
        this.name = name;
        this.branches = new ArrayList<Branch>();
    }

    public boolean addBranch(String branchName) {
        if (findBranch(branchName) == null) {
            this.branches.add(new Branch(branchName));
            return true;
        }
        return false;
    }

    public boolean addCustomer(String branchName, String customerName, double initialAmount) {
        Branch branch = findBranch(branchName);
        if (branch != null) {
            return branch.newCustomer(customerName, initialAmount);
        }
        return false;

    }

    public boolean addCustomerTransaction(String branchName, String customerName, double amount) {
        Branch branch = findBranch(branchName);
        if (branch != null) {
            return branch.addCustomerTransaction(customerName, amount);
        }
        return false;
    }

    private Branch findBranch(String branchName) {
        for (int i = 0; i < branches.size(); i++) {
            Branch checkedBranch = this.branches.get(i);
            if (checkedBranch.getName().equals(branchName)) {
                return checkedBranch;
            }
        }
        return null;
    }

    public boolean listCustomers(String branchName, boolean showTransactions) {
        Branch branch = findBranch(branchName);
        if (branch != null) {
            System.out.println("Customer details for branch" + branch.getName() + ":");
            ArrayList<Customer> branchCustomers = branch.getCustomers();
            for (int i = 0; i < branchCustomers.size(); i++) {
                Customer branchCustomer = branchCustomers.get(i);
                System.out.println("Customer: " + branchCustomer.getName() + "[" + (i + 1) + "]");
                if (showTransactions) {
                    System.out.println("Transactions: ");
                    ArrayList<Double> transactions = branchCustomer.getTransactions();
                    for (int j = 0; j < transactions.size(); j++) {
                        System.out.println("[" + (j + 1) + "] Amount: " + transactions.get(j));
                    }
                }
            }
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Bank bank = new Bank("Bank of America");

        if (bank.addBranch("Plano")) {
            System.out.println("Plano branch created.");
        }

        bank.addCustomer("Plano", "Mike", 23.45);
        bank.addCustomer("Plano", "Jim", 1120.33);
        bank.addCustomer("Plano", "Dwight", 2.19);

        bank.addBranch("Irving");
        bank.addCustomer("Irving", "Stanely", 1200.22);

        bank.addCustomerTransaction("Plano", "Mike", 200.25);
        bank.addCustomerTransaction("Plano", "Mike", 189.64);
        bank.addCustomerTransaction("Plano", "Jim", -30.54);

        bank.listCustomers("Plano", true);
        bank.listCustomers("Irving", true);

        bank.addBranch("Frisco");

        if (!bank.addCustomer("Frisco", "Ryan", 16.34)) {
            System.out.println("Error. Frisco branch does not exist.");
        }
        if (!bank.addBranch("Plano")) {
            System.out.println("Plano branch already exists.");
        }
        if (!bank.addCustomerTransaction("Plano", "Pam", 46.78)) {
            System.out.println("Customer does not exist.");
        }
        if (!bank.addCustomer("Plano", "Mike", 31.67)) {
            System.out.println("Customer Mike already exists.");
        }
    }
}



/*
**Banking w/ Java Classes**
   - **Bank class**
      - List of Branches
      - Add a new branch
      - Add a customer to that branch with initial transaction
      - Add a transaction for an existing customer for that branch
      - Show a list of customers for a particular branch and optionally a list of their transactions
   - Demonstration autoboxing and unboxing in your code
   - Think about where you are adding the code to perform certain actions
   - **Branch class**
     - List of Customers
     - List of Transactions
   - **Customer Class**:
     - Customer Name
   - **Branch Class**:
     - addCustomer and initial transaction amount.
     - Also needs to add additional transactions for that customer/branch
   - **Bank:**
     
*/
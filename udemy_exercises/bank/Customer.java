package bank;

        import java.util.ArrayList;

public class Customer {
    private ArrayList<Double> transactions;
    private final String firstName;
    private final String lastName;

    public Customer(String firstName, String lastName, double initialAmount){
        this.firstName = firstName;
        this.lastName = lastName;
        this.transactions = new ArrayList<Double>();
        addTransaction(initialAmount);
    }

    public void addTransaction(double amount){
        this.transactions.add(amount);
    }

    public String getName(){
        return String.format("%s %s", firstName, lastName);
    }

    public ArrayList<Double> getTransactions(){
        return transactions;
    }

}


/*
- **Customer Class**:
- Customer Name
*/


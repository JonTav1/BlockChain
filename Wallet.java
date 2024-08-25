import java.util.HashMap;
import java.util.Map;

public class Wallet {

    private Map<String, Integer> balances;

    public Wallet() {
        balances = new HashMap<>();
    }
    //creates a wallet with a name and starting balance
    public void createWallet(String name, int amount) {
        if (!balances.containsKey(name)){
            balances.put(name, amount);
        }
    }
    //updates balance
    public void updateBalance(String name, int amount) {
        balances.put(name, balances.get(name) + amount);
    }
    //gets the balance for corresponding name
    public int getBalance(String name) {
        return balances.get(name);
    }
    //checks if the payer has sufficient funds to send
    public boolean hasSufficientFunds(String payer, int amount) {

        if (walletExists(payer) && balances.get(payer) - amount > 0) {

            return true;
        }
        return false;
    }
    public boolean walletExists(String name) {
        if (balances.containsKey(name)){
            return true;
        }
        return false;
    }
    public void updateBalances(String payer, String payee, int amount) {
        balances.put(payer, balances.get(payer) - amount);
        balances.put(payee, balances.get(payee) + amount);
    }
}
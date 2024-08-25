

public class Transaction {

    private int amount;
    private String payer;
    private String payee;
    //Transaction to be placed in block
    public Transaction(int amount, String payer, String payee){
        this.amount = amount;
        this.payer = payer;
        this.payee = payee;
    }
    //checks if the wallets exist, and if the payer has sufficient funds to send
    public boolean transactionCheck(Wallet wallet) {
        if(wallet.hasSufficientFunds(payer, amount) == true && wallet.walletExists(payee)){
            wallet.updateBalances(payer,payee,amount);
            return true;
        }
        return false;
    }
    //returns to String of Transaction for hash
    public String toString() {
        return amount + payer + payee;
    }
}
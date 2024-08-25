import java.util.ArrayList;
import java.util.List;

public class BlockUtils {
    private List<Block> blockChain = new ArrayList<>();
    public Wallet wallet;
    public List<Block> getBlockChain() {
        return blockChain;
    }
    public BlockUtils(Wallet wallet) {
        this.wallet = wallet;
    }
    private Block getLatestBlock() {
        if (blockChain.isEmpty()){
            createGenesis();
        }
        return blockChain.get(blockChain.size()-1);
    }
    //creates first element in block chain A.K.A. the "Genesis" Block
    private void createGenesis() {
        blockChain.add(new Block(0,"nill","nill", 0, "Genesis"));
    }
    public void addBlock(int amount, String payer, String payee) {
        Transaction transaction = new Transaction(amount, payer, payee);
        boolean validTransaction = transaction.transactionCheck(wallet);
        Block previousBlock = getLatestBlock();
        if(validTransaction) {

            Block newBlock = new Block(amount, payer, payee, previousBlock.getIndex() + 1, previousBlock.getHash());
            blockChain.add(newBlock);
        } else {
            System.err.println("The transaction was not valid, make sure both wallets exist and the payer has sufficient funds.");
        }
    }
    //checks if the current block chain is valid but comparing the stored hash/previoushash,
    // and recalculating the hash. If they are equal, return true. else return false.
    public boolean isChainValid() {
        for(int i = 1; i < blockChain.size(); i++){
            Block currentBlock = blockChain.get(i);
            Block previousBlock = blockChain.get(i - 1);
            if(!currentBlock.getHash().equals(currentBlock.calculateHash())) {
                return false;
            }
            if(!currentBlock.getPreviousHash().equals(previousBlock.getHash())) {
                return false;
            }
        }
        return true;
    }
}

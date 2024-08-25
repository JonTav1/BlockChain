public class BlockChain {
    public static void main(String[] args) {
        Wallet wallet = new Wallet();
        wallet.createWallet("jonathan", 1000);
        wallet.createWallet("Ryan", 1000);
        BlockUtils blockUtils = new BlockUtils(wallet);
        blockUtils.addBlock(150, "jonathan", "Ryan");
        blockUtils.addBlock(100, "Ryan", "jonathan");
        System.out.println(blockUtils.isChainValid());
    }
}
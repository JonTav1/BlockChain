import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Block {
    private int index;  //id for the block
    private long timestamp;  //when the block is created
    private int amount;//"amount" being transferred
    private String payer;//payer
    private String payee;//payee
    private String previousHash;  //hash of previous block
    private String hash;  //hash of current block
    public Transaction transaction;


    public Block(int amount, String payer,String payee,int index, String previousHash) {//Block constructor
        this.index = index;
        this.amount = amount;
        this.payer = payer;
        this.payee = payee;
        this.previousHash = previousHash;
        this.timestamp = System.currentTimeMillis();
        this.transaction = new Transaction(amount, payer, payee);
        this.hash = calculateHash();

    }

    public String getHash(){//returns current block hash
        return hash;
    }
    public int getIndex() {//returns current block index
        return index;
    }
    public void setIndex(int index) {//index setter
        this.index = index;
    }
    public Long getTimestamp() {//returns timestamp of current block
        return timestamp;
    }
    public void setTimestamp(Long timestamp) {//timestamp setter
        this.timestamp = timestamp;
    }
    public String getTransaction() {//returns the data of the block/"transaction"
        return transaction.toString();
    }
    public void setData(String data) {//data setter
        this.transaction = transaction;
    }
    public String getPreviousHash() {//returns previous blocks hash
        return previousHash;
    }


    //coverts the string into bytes to be able to be hashed by sha256, then returns the hexadecimal representation
    // of the hashed value.
    public String calculateHash() {//calculates the hash value of the block
        String text = String.valueOf(index + String.valueOf(timestamp) + previousHash + transaction);
        MessageDigest digest = null;
        try{
            digest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }


        final byte bytes[] = digest.digest(text.getBytes());
        final StringBuilder hexString = new StringBuilder();
        for(final byte b : bytes) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }

}

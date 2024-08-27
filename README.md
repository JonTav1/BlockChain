# BlockChain

This is a little fun blockchain project I decided to do, just because I got interested in how cryptocurrencies work.

This simple BlockChain project gives users the capability to create different wallets, and send funds between the wallets. 

-When the request is made, a "transaction" is made, which then verifies with wallet balances that the "payer" has enough funds, and that both wallets exist. 
-After the transaction is made valid, a block is created - which contains the transaction details, and the hash of the previous block. The hash for this block is created using these details.
-The block is placed in the blockchain, which is just an ArrayList.
-To check if the chain is valid, we re-calculate the hash of each block and compare it with the hash we have stored. If they are different, the chain is deemed invalid.



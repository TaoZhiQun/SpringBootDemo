package com.example.javademo.block;

import java.util.ArrayList;
import java.util.Date;

public class Block {
	// 本区块的hash值
	public String hash;
	// 前一区块的hash值
	public String previousHash;
	//  区块中所有交易数据的默克尔树
	public String merkleRoot;
	public ArrayList<Transaction> transactions = new ArrayList<Transaction>();
	// 时间戳
	public long timeStamp;
	// 工作量证明计数器
	public int nonce;
	
	 Block(String previousHash ) {
		this.previousHash = previousHash;
		this.timeStamp = System.currentTimeMillis();
		this.hash = calculateHash();
	}
	
	// 计算Hash值
	public String calculateHash() {
		String calculatedhash = EncryptUtil.applySha256(
				previousHash +
				Long.toString(timeStamp) +
				Integer.toString(nonce) + 
				merkleRoot
				);
		return calculatedhash;
	}
	
	// 根据难度系数挖矿
	public void mineBlock(int difficulty) {
		merkleRoot = EncryptUtil.getMerkleRoot(transactions);
		String target = EncryptUtil.getDificultyString(difficulty); //Create a string with difficulty * "0"
		while(!hash.substring( 0, difficulty).equals(target)) {
			nonce ++;
			hash = calculateHash();
		}
		System.out.println("Block Mined!!! : " + hash);
	}
	
	//向区块添加交易
	public boolean addTransaction(Transaction transaction) {
		//检查交易是否合法，如果是创世区块则忽略
		if(transaction == null) return false;		
		if((previousHash != "0")) {
			if((transaction.processTransaction() != true)) {
				System.out.println("Transaction failed to process. Discarded.");
				return false;
			}
		}

		transactions.add(transaction);
		System.out.println("Transaction Successfully added to Block");
		return true;
	}
	
}

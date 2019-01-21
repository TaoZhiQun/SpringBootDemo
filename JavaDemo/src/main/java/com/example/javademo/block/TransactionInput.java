package com.example.javademo.block;

/**
 *  交易输入类
 */
public class TransactionInput {
	//  指向交易输出类
	public String transactionOutputId;
	//  未使用的交易输出
	public TransactionOutput UTXO;
	
	public TransactionInput(String transactionOutputId) {
		this.transactionOutputId = transactionOutputId;
	}
}

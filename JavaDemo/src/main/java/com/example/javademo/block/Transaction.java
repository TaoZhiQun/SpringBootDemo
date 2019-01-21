package com.example.javademo.block;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.ArrayList;

public class Transaction {
	//  交易编号
	public String transactionId;
	//  付款人地址 公钥
	public PublicKey sender;
	//  接受人地址 公钥
	public PublicKey reciepient;
	//  转移金额
	public float value;
	// 数字签名
	public byte[] signature;
	// 输入列表
	public ArrayList<TransactionInput> inputs = new ArrayList<TransactionInput>();
	// 输出列表
	public ArrayList<TransactionOutput> outputs = new ArrayList<TransactionOutput>();
	// 已经创建的交易
	private static int sequence = 0;
	
	public Transaction(PublicKey from, PublicKey to, float value,  ArrayList<TransactionInput> inputs) {
		this.sender = from;
		this.reciepient = to;
		this.value = value;
		this.inputs = inputs;
	}

	// 处理所有的交易，boolean用来说明新的交易是否被创建
	public boolean processTransaction() {

		if(verifySignature() == false) {
			System.out.println("#Transaction Signature failed to verify");
			return false;
		}
				
		//  收集未被使用的输入
		for(TransactionInput i : inputs) {
			i.UTXO = NoobChain.UTXOs.get(i.transactionOutputId);
		}

		//  检查交易是否有效
		if(getInputsValue() < NoobChain.minimumTransaction) {
			System.out.println("Transaction Inputs to small: " + getInputsValue());
			return false;
		}
		
		// 创建交易输出 获得输入的剩余金额
		float leftOver = getInputsValue() - value;
		transactionId = calulateHash();
		//  发送金额给收款人
		outputs.add(new TransactionOutput( this.reciepient, value,transactionId));
		// 剩余金额返回给付款人
		outputs.add(new TransactionOutput( this.sender, leftOver,transactionId));
				
		//  把输出增加到未使用的列表中
		for(TransactionOutput o : outputs) {
			NoobChain.UTXOs.put(o.id , o);
		}
		
		//  把已经使用的交易的输入从UXTO中移除
		for(TransactionInput i : inputs) {
			if(i.UTXO == null) continue;
			NoobChain.UTXOs.remove(i.UTXO.id);
		}
		
		return true;
	}

	//  返回余额
	public float getInputsValue() {
		float total = 0;
		for(TransactionInput i : inputs) {
			if(i.UTXO == null) continue;
			total += i.UTXO.value;
		}
		return total;
	}
	
	public void generateSignature(PrivateKey privateKey) {
		String data = EncryptUtil.getStringFromKey(sender) + EncryptUtil.getStringFromKey(reciepient) + Float.toString(value)	;
		signature = EncryptUtil.applyECDSASig(privateKey,data);
	}
	
	public boolean verifySignature() {
		String data = EncryptUtil.getStringFromKey(sender) + EncryptUtil.getStringFromKey(reciepient) + Float.toString(value)	;
		return EncryptUtil.verifyECDSASig(sender, data, signature);
	}
	//  返回输出的总和
	public float getOutputsValue() {
		float total = 0;
		for(TransactionOutput o : outputs) {
			total += o.value;
		}
		return total;
	}
	
	private String calulateHash() {
		sequence++; //increase the sequence to avoid 2 identical transactions having the same hash
		return EncryptUtil.applySha256(
				EncryptUtil.getStringFromKey(sender) +
				EncryptUtil.getStringFromKey(reciepient) +
				Float.toString(value) + sequence
				);
	}
}

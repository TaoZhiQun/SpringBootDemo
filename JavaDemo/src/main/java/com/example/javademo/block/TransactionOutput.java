package com.example.javademo.block;

import java.security.PublicKey;

/**
 *  交易输出类
 */
public class TransactionOutput {
	public String id;
	// 持有者的公钥
	public PublicKey reciepient;
	// 持有者的金额
	public float value;
	// 交易编号
	public String parentTransactionId;

	public TransactionOutput(PublicKey reciepient, float value, String parentTransactionId) {
		this.reciepient = reciepient;
		this.value = value;
		this.parentTransactionId = parentTransactionId;
		this.id = EncryptUtil.applySha256(EncryptUtil.getStringFromKey(reciepient)+Float.toString(value)+parentTransactionId);
	}
	
	//用来验证是否属于你
	public boolean isMine(PublicKey publicKey) {
		return (publicKey == reciepient);
	}
	
}

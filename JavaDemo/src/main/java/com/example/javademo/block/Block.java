package com.example.javademo.block;

public class Block {
    public String hash;
    public String preHash;
    private String data;
    private long timeStamp;
    public Block(String data, String preHash){
        this.data = data;
        this.preHash = preHash;
        this.timeStamp =System.currentTimeMillis();
        this.hash = calculateHash();
    }

    public String calculateHash(){
        String calculateHash = EncryptUtil.applySha256(preHash + Long.toString(timeStamp) + data);
        return calculateHash;
    }

}

package com.example.test.other;


public class Client {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addNode(9);
        myLinkedList.addNode(8);
        myLinkedList.addNode(7);
        myLinkedList.addNode(6);
        myLinkedList.deleteNodeByIndex(2);
        myLinkedList.printLink();
    }
}

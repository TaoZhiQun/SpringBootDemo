package com.example.test.other;

class Node{
    Node next =null;
    int data;
    Node(int data){
        this.data=data;
    }
}
public class MyLinkedList {
    Node head = null;
    public void addNode(int data){
        Node newNode = new Node(data);
        if(null == head){
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null ){
            temp = temp.next;
        }
        temp.next = newNode;
    }

    public void printLink(){
        Node curNode = head;
        while(curNode !=null){
            System.out.print(curNode.data+" ");
            curNode = curNode.next;
        }
    }

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addNode(3);
        myLinkedList.addNode(4);
        myLinkedList.addNode(5);
        myLinkedList.printLink();
    }

}

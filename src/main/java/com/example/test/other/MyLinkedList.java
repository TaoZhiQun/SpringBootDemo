package com.example.test.other;

public class MyLinkedList {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        final Node node = reverseList(node1);
        printLinkList(node);
    }

    Node head;

    public void addNode(int data) {
        Node node = new Node(data);
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
    }

    public static Node reverseList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        final Node node = reverseList(head.next);
        Node t1 = head.next;
        t1.next = head;
        head.next = null;
        return node;
    }

    public boolean deleteNodeByIndex(int index) {
        if (index < 1 || index > length()) {
            return false;
        }
        if (index == 1) {
            head = head.next;
            return true;
        }
        Node temp = head;
        int i = 1;
        while (temp != null) {
            if (i == index) {
                temp.next = temp.next.next;
                return true;
            } else {
                temp = temp.next;
            }
            ++i;
        }
        return true;
    }

    public Node linkSort() {
        Node curNode = head;
        if (curNode != null) {
            Node nextNode = curNode.next;
            while (nextNode != null) {
                if (curNode.data > nextNode.data) {
                    int temp = curNode.data;
                    curNode.data = nextNode.data;
                    nextNode.data = temp;
                }
                nextNode = nextNode.next;
            }
            curNode = curNode.next;
        }
        return head;
    }

    public int length() {
        int length = 0;
        Node curNode = head;
        while (curNode != null) {
            length++;
            curNode = curNode.next;
        }
        return length;
    }


    public void printLink() {
        Node curNode = head;
        while (curNode != null) {
            System.out.print(curNode.data + " ");
            curNode = curNode.next;
        }
        System.out.println();
    }

    public static void printLinkList(Node head) {
        System.out.print(head.data);
        while (head.next != null) {
            System.out.print("->" + head.next.data);
            head = head.next;
        }
        System.out.println();
    }

}

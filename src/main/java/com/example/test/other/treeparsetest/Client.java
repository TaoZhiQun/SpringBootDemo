package com.example.test.other.treeparsetest;

import com.example.util.treeparse.TreeParser;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        final List<MessageBoard> messageBoardList = initMessageBoardTree();
        final List<MessageBoard> treeList = TreeParser.getTree(null, messageBoardList);
        System.out.println(new Gson().toJson(treeList));
    }

    public static List<MessageBoard> initMessageBoardTree(){
        List<MessageBoard> messageBoardList = new ArrayList<>();
        MessageBoard root = new MessageBoard();
        root.setId(1L);
        root.setMessage("这是父节点");

        MessageBoard first11 = new MessageBoard();
        first11.setId(2L);
        first11.setMessage("这是第一层节点1");
        first11.setBelongId(1L);

        MessageBoard first12 = new MessageBoard();
        first12.setId(3L);
        first12.setMessage("这是第一层节点2");
        first12.setBelongId(1L);

        MessageBoard first21 = new MessageBoard();
        first21.setId(4L);
        first21.setMessage("这是第二层节点21");
        first21.setBelongId(2L);

        messageBoardList.add(root);
        messageBoardList.add(first11);
        messageBoardList.add(first12);
        messageBoardList.add(first21);
        return messageBoardList;
    }

    public static List<MessageBoard> initFirstMessageBoardList() {
        List<MessageBoard> messageBoardList = new ArrayList<>();
        MessageBoard messageBoard = new MessageBoard();
        messageBoard.setId(1L);
        messageBoard.setMessage("这是我们第一次见面");
        messageBoard.setClientId("000114615");

        MessageBoard messageBoard1 = new MessageBoard();
        messageBoard1.setId(3L);
        messageBoard1.setMessage("嗯嗯，很有道理呢");
        messageBoard1.setClientId("000114615");
        messageBoard1.setToClientId("000114614");
        messageBoard1.setBelongId(1L);
        messageBoardList.add(messageBoard);
        messageBoardList.add(messageBoard1);
        return messageBoardList;
    }

    public static List<MessageBoard> initSecondMessageBoardList() {
        List<MessageBoard> messageBoardList = new ArrayList<>();
        MessageBoard messageBoard = new MessageBoard();
        messageBoard.setId(2L);
        messageBoard.setMessage("是的没有错");
        messageBoard.setClientId("000114614");
        messageBoard.setToClientId("000114615");
        messageBoard.setBelongId(1L);
        messageBoardList.add(messageBoard);
        return messageBoardList;
    }
}

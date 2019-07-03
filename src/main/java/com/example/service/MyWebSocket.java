package com.example.service;

import com.example.config.WebSocketConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
@ServerEndpoint(value = "/websocket",configurator = WebSocketConfig.class)
public class MyWebSocket {
    private static final Logger loggger = LoggerFactory.getLogger(MyWebSocket.class);
    private static CopyOnWriteArrayList<MyWebSocket> user = new CopyOnWriteArrayList<>();
    private Session session;
    private static int onlineCount = 0;

    @OnMessage
    public void onMessage(String message,Session session){
        try {
            for(MyWebSocket myWebSocket :user){
                myWebSocket.session.getBasicRemote().sendText("用户"+session.getId()+" ： "+message);
            }
            loggger.info("用户"+session.getId()+" ： "+message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @OnOpen
    public void onOpen(Session session,EndpointConfig config){
        String httpSessionId = (String) config.getUserProperties().get("sessionId");
        System.out.println("用户"+ httpSessionId +"已连接");
        this.session = session;
        user.add(this);
        ++onlineCount;
        sendAllUserMessage("当前有"+onlineCount+"人在线");
    }

    public void sendAllUserMessage(String string){
        try {
            for(MyWebSocket webSocket:user){
                webSocket.session.getBasicRemote().sendText("当前在线用户为"+string);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @OnClose
    public void onClose(Session session){
        System.out.println(session.getId()+"close");
        --onlineCount;
        user.remove(this);
    }

    @OnError
    public void onError(Session session,Throwable error){
        System.out.println(session.getId()+"error");
        error.printStackTrace();
    }

}

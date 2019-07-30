package com.example.test.other.treeparsetest;

import com.example.util.treeparse.TreeEntity;

import java.util.List;

public class MessageBoard implements TreeEntity {
    private Long id;
    private String message;
    private String clientId;
    private String toClientId;
    private Long belongId;
    private List<MessageBoard> children;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getToClientId() {
        return toClientId;
    }

    public void setToClientId(String toClientId) {
        this.toClientId = toClientId;
    }

    public Long getBelongId() {
        return belongId;
    }

    public void setBelongId(Long belongId) {
        this.belongId = belongId;
    }

    public List<MessageBoard> getChildren() {
        return children;
    }

    @Override
    public String getNodeId() {
        return String.valueOf(id);
    }

    @Override
    public String getParentNodeId() {
        return null == belongId ? null : String.valueOf(belongId);
    }

    @Override
    public void setChildren(List children) {
        this.children = children;
    }
}

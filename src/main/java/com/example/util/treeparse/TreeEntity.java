package com.example.util.treeparse;

import java.io.Serializable;
import java.util.List;

public interface TreeEntity<E> extends Serializable {
    String getNodeId();
    String getParentNodeId();
    void setChildren(List<E> children);
}

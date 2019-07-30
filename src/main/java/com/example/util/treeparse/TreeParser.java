package com.example.util.treeparse;

import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TreeParser {

    public static <E extends TreeEntity<E>> List<E> getTree(String rootId, List<E> allEntityList) {
        final List<E> retList = new ArrayList<>();
        //获取顶层元素集合
        String parentId;
        final List<E> firstLevelChildren = new ArrayList<E>();
        Collections.sort(allEntityList, new TreeEntityComparator());
        for (E entity : allEntityList) {
            parentId = entity.getParentNodeId();
            if (parentId == null && rootId == null) {
                firstLevelChildren.add(entity);
            } else if (parentId != null && parentId.equals(rootId)) {
                firstLevelChildren.add(entity);
            }
        }
        retList.addAll(firstLevelChildren);
        //获取每个顶层元素的子数据集合
        for (E entity : retList) {
            entity.setChildren(findSubList(entity.getNodeId(), allEntityList));
        }
        return retList;
    }

    /**
     * 获取子数据集合
     *
     * @param id            树节点ID.
     * @param allEntityList 全部实体列表.
     * @return 子树结构节点列表.
     */
    private static <E extends TreeEntity<E>> List<E> findSubList(String id, List<E> allEntityList) {
        List<E> childList = new ArrayList<>();
        String parentId;
        //子集的直接子对象
        for (E entity : allEntityList) {
            parentId = entity.getParentNodeId();
            if (id.equals(parentId)) {
                childList.add(entity);
            }
        }
        //子集的间接子对象
        for (E entity : childList) {
            entity.setChildren(findSubList(entity.getNodeId(), allEntityList));
        }
        //递归退出条件
        if (childList.isEmpty()) {
            return null;
        }
        return childList;
    }

    static class TreeEntityComparator<E extends TreeEntity<E>> implements Comparator<E> {
        @Override
        public int compare(E o1, E o2) {
            return ((E) o1).getNodeId().hashCode() - ((E) o2).getNodeId().hashCode();
        }
    }

    /**
     *  获取留言板类型的集合
     * @param firstEntityList ： 第一层集合
     * @param secondEnityList ： 第二层集合
     * @param <E>
     * @return
     */
    public static <E extends TreeEntity<E>> List<E> findMessageTreeList(List<E> firstEntityList, List<E> secondEnityList) {
        if (CollectionUtils.isEmpty(firstEntityList)) {
            throw new RuntimeException("首层元素集合不能为空");
        }
        for (E firstEntity : firstEntityList) {
            final List<E> firstLevelChildren = new ArrayList<>();
            for (E secondEntity : secondEnityList) {
                if (firstEntity.getNodeId().equals(secondEntity.getParentNodeId())) {
                    firstLevelChildren.add(secondEntity);
                }
            }
            firstEntity.setChildren(firstLevelChildren);
        }
        return firstEntityList;
    }

}

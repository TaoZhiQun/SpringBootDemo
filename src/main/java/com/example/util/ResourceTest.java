package com.example.util;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ResourceTest {
    public static void main(String[] args) {
        Resource resource = new Resource();
        resource.setResourceId("0");
        resource.setParentResourceId(null);
        resource.setResourceName("根节点");

        Resource resource1 = new Resource();
        resource1.setResourceId("1");
        resource1.setResourceName("子节点1");
        resource1.setParentResourceId("0");

        Resource resource2 = new Resource();
        resource2.setResourceId("2");
        resource2.setResourceName("子节点2");
        resource2.setParentResourceId("0");

        Resource resource3 = new Resource();
        resource3.setResourceId("3");
        resource3.setResourceName("子节点4");
        resource3.setParentResourceId("1");

        List<Resource> resourceList = new ArrayList<>();
        resourceList.add(resource);
        resourceList.add(resource1);
        resourceList.add(resource2);
        resourceList.add(resource3);

        Resource permissionTree = createPermissionTree(resourceList);
        System.out.println(new Gson().toJson(permissionTree));

    }
    private   List<Resource>  createChildTree(String resId,List<Resource> resourceList) {
        List<Resource> list = new ArrayList<>();
        for(Resource resource:resourceList){
            if(resource.getParentResourceId().equals(resId)){
                resource.setChildren(createChildTree(resource.getResourceId(),resourceList));
                list.add(resource);
            }
        }
        return list;
    }

    private static List<Resource>createPermissionTree(List<Resource> resourceList){
        List<Resource> list = new ArrayList<>();
        for(Resource res:resourceList){
            if(null == res.getParentResourceId()){
                res.setChildren(createChildTree(res.getResourceId(),resourceList));
                list.add(res);
            }
        }
        return list;

}

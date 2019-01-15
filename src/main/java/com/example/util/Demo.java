package com.example.util;

import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Demo {
    public static void main(String[] args) {
        List<String> fileNames = new ArrayList<>();
        fileNames.add("account");
        fileNames.add("position");

        //  需要核对的是资金和仓单
        List<String> checkFileNames = new ArrayList<>();
        checkFileNames.add("account");
        checkFileNames.add("warehouse");
        checkFileNames.add("market");

        List<String> notContainFileList = new ArrayList<>();
        Map<String, String> collect = fileNames.stream().collect(Collectors.toMap(x -> x, x -> x));
        for(String file:checkFileNames){
            if(!collect.containsKey(file)){
                notContainFileList.add(file);
            }
        }

        if(CollectionUtils.isNotEmpty(notContainFileList)){
            System.out.println(notContainFileList);
        }

    }
}

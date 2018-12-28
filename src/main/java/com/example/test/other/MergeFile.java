package com.example.test.other;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class MergeFile {
    public static final String SUFFIX = ".sql";

    public static String[] divide(String name, long size) throws Exception {
        File file = new File(name);
        if (!file.exists() || (!file.isFile())) {
            throw new Exception("指定文件不存在！");
        }
        File fileFolter = file.getParentFile();
        long fileLength = file.length();
        System.out.println("源文件大小" + fileLength + "字节");
        if (size <= 0) {
            size = size / 2;
        }
        int num = (fileLength % size != 0) ? (int) (fileLength / size + 1) : (int) (fileLength / size);
        String[] fileNames = new String[num];
        int begin = 0;
        long end = 0;
        FileInputStream in = new FileInputStream(file);
        byte[] bytes = new byte[1024];
        for (int i = 0; i < num; i++) {
            File outFile = new File(fileFolter,i+ file.getName());
            FileOutputStream out = new FileOutputStream(outFile);
            end += size;
            end = (end>fileLength)?fileLength:end;
            while(begin<end){
                begin++;
                out.write(in.read());
            }
        /*    for(;begin<end;begin++){
                out.write(in.read());
            }*/
            out.close();
            fileNames[i] = outFile.getAbsolutePath();
        }
        in.close();
        return fileNames;
    }

    public static void main(String[] args) throws IOException {
        String fileName = "C:/Users/Tao/Desktop/t_trade_86663/t_trade.sql";
        long size = 1024*1024*256;
        try {
            divide(fileName,size);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

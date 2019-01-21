package com.example.javademo.demo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Demo {
    public static void main(String[] args) {
        String info[] ={"欢迎来到","Channel"};
        File file = new File("d:"+File.separator+"testChannel.txt");
        FileOutputStream outputStream = null;
        FileChannel fout = null;

        try {
            outputStream = new FileOutputStream(file);
            fout = outputStream.getChannel();
            ByteBuffer buf = ByteBuffer.allocate(1024);
            for(int i=0;i<info.length;i++){
                buf.put(info[i].getBytes());
            }
            buf.flip();
            fout.write(buf);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(null != fout){
                    fout.close();
                }
                if(null != outputStream){
                    outputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

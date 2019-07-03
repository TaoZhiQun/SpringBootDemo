package com.example.javademo.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;

public class NettyClient {
    public static void main(String[] args) throws InterruptedException, UnknownHostException {
       Bootstrap bootstrap = new Bootstrap();
       NioEventLoopGroup group = new NioEventLoopGroup();
       bootstrap.group(group)
               .channel(NioSocketChannel.class)
               .handler(new ChannelInitializer<Channel>() {
                   @Override
                   protected void initChannel(Channel channel) {
                       channel.pipeline().addLast(new StringEncoder());
                   }
               });
        Channel channel = bootstrap.connect(InetAddress.getLocalHost(), 8000).channel();
        while (true){
            channel.writeAndFlush(new Date()+":");
            Thread.sleep(1);
        }
    }
}

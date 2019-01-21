package com.example.javademo.netty;

import org.jboss.netty.bootstrap.ClientBootstrap;
import org.jboss.netty.channel.*;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

public class HelloClient {
    public static void main(String[] args) {
        ClientBootstrap clientBootstrap= new ClientBootstrap(new NioServerSocketChannelFactory(Executors.newCachedThreadPool(),Executors.newCachedThreadPool()));
        clientBootstrap.setPipelineFactory(new ChannelPipelineFactory() {
            @Override
            public ChannelPipeline getPipeline() throws Exception {
                return Channels.pipeline(new HelloClientHandle());
            }
        });
        clientBootstrap.connect(new InetSocketAddress("127.0.0.1",8000));

    }
    private static class HelloClientHandle extends SimpleChannelHandler  {
        @Override
        public void channelConnected(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
            System.out.println("Hello World I am client");
        }
    }
}

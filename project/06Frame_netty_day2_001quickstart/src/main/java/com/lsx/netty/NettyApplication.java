package com.lsx.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NettyApplication {

    public static void main(String[] args) {
        /**
         * netty 步骤
         * 1. 导入 坐标
         * 2.
         */

        // 创建2个线城市

        NioEventLoopGroup mainGrp = null;
        NioEventLoopGroup subGrp = null;

        try {
            mainGrp = new NioEventLoopGroup();
            subGrp = new NioEventLoopGroup();

            // 创建服务器启动对象
            ServerBootstrap bootstrap = new ServerBootstrap();

            // 初始化启动独享
            // 绑定主从线城市
            bootstrap.group(mainGrp, subGrp)
                    // 指定通道类型
                    .channel(NioServerSocketChannel.class)
                    // 指定通道初始化器
                    .childHandler(new WebSocketChannelInitializer());

            // 绑定端口，同步启动
            ChannelFuture future = bootstrap.bind(9090).sync();

            future.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            mainGrp.shutdownGracefully();
            subGrp.shutdownGracefully();
        }


    }

}

package com.lsx.netty;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.util.concurrent.EventExecutorGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 处理的是 socket 的文本消息
 */
public class ChatHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {

    /**
     * 保存所有的客户端连接
     */
    private static ChannelGroup clients = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    private DateFormat sf = new SimpleDateFormat("yyyy-mm-dd hh:MM");

    /**
     * 通道中有消息会自动调用
     * @param channelHandlerContext
     * @param textWebSocketFrame
     * @throws Exception
     */
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, TextWebSocketFrame textWebSocketFrame) throws Exception {
        // 后台收到消息后执行
        String msg = textWebSocketFrame.text();

        System.out.println("接收到的消息数据为： " + msg);

        // 广播消息
        for (Channel client : clients) {
            client.writeAndFlush(new TextWebSocketFrame(sf.format(new Date()) + " : " + msg));
        }
    }

    /**
     * 每增加一个链接都会添加进来
     * @param ctx
     * @throws Exception
     */
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        // 添加活跃连接
        clients.add(ctx.channel());
    }
}

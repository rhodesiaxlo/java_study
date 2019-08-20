package com.lsx.netty;


import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;

public class WebSocketChannelInitializer extends ChannelInitializer<SocketChannel> {

    /**
     * 通道初始化
     * 编写 channelHandler
     * @param socketChannel
     * @throws Exception
     */
    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {

        // 根据 http 的
        ChannelPipeline pipeline = socketChannel.pipeline();

         // http 报文的编解码器
        pipeline.addLast(new HttpServerCodec());


        // 添加大数据流支持
        pipeline.addLast(new ChunkedWriteHandler());

         // 聚合器 文本消息处理为 FullHttpRequest FullHttpResponse
        pipeline.addLast(new HttpObjectAggregator(1024*64));

         // 设置请求访问路由
        pipeline.addLast(new WebSocketServerProtocolHandler("/ws"));

        // 自定义 handler
        pipeline.addLast(new ChatHandler());
    }
}

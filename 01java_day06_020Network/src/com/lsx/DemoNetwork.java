package com.lsx;

public class DemoNetwork {

    public static void main(String[] args) {
        // ip internet protocol
        // tcp transmission control protocol
        // udp  user datagram protocol  不需要连接，耗资小，数据不保证安全

        // 网络编程3要素 ，协议， ip 端口号

        // 应用层
        // 传输层
        // 网络层
        // 物理层

        // http 是面向连接的
        // 服务器端先启动
        // 由客户端发起请求
        // c -s 建立连接，连接中包含一个对象 io
        // 通过 io 进行对象

        // 服务器端可以同时和多个客户端进行交互
        // 如何区分客户端 accept

        // 于多个客户端进行交互需要io流对象
        // 通过获得客户端的socket对象，获取客户端的io流和客户端进行交互

    }
}

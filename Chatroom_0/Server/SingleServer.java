package com.org.chatroom.server.Test;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * 单线程聊天室服务器端
 **/
public class SingleServer {
    public static void main(String[] args) throws Exception {
// 创建服务端Socket，端口号为6666        
        ServerSocket serverSocket = new ServerSocket(6666);
        try {
            System.out.println("等待客户端连接ing...");
// 等待客户端连接，有客户端连接后返回客户端的Socket对象，否则线程将一直阻塞于          
            Socket client = serverSocket.accept();
            System.out.println("有新的客户端连接，端口号为: " + client.getPort());
// 获取客户端的输入输出流            
            Scanner clientInput = new Scanner(client.getInputStream());
            clientInput.useDelimiter("\n");
            PrintStream clientOut = new PrintStream(client.getOutputStream(), true, "UTF-8");
            // 读取客户端输入          
            if (clientInput.hasNext()) {
                System.out.println(client.getInetAddress() + "说: " + clientInput);
            }
            // 向客户端输出          
            clientOut.println("Hello I am Server,Welcome！");
            // 关闭输入输出流            
            clientInput.close();
            clientOut.close();
            serverSocket.close();
        } catch (IOException e) {
            System.err.println("服务端通信出现异常，错误为" + e);
        }
    }
}
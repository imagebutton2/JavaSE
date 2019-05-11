package multi;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;


public class ClientHandler implements Runnable {
    
    private static final Map<String, Socket> SOCKET_MAP = new ConcurrentHashMap<>();
    
    //Socket -> in out
    private final Socket client;
    
    public ClientHandler(Socket client) {
        this.client = client;
    }
    
    @Override
    public void run() {
        try {
            InputStream in = this.client.getInputStream();
            Scanner scanner = new Scanner(in);
            while (true) {
                String line = scanner.nextLine();
                if (line.startsWith("register")) {
                    //注册流程
                    String[] segments = line.split(":");
                    if (segments.length == 2 && segments[0].equals("register")) {
                        String name = segments[1];
                        register(name);
                    }
                    continue;
                }
                if (line.startsWith("group")) {
                    //群聊流程
                    String[] segments = line.split(":");
                    if (segments.length == 2 && segments[0].equals("group")) {
                        String message = segments[1];
                        groupChat(message);
                    }
                    continue;
                }
                if (line.startsWith("private")) {
                    //私聊流程
                    String[] segments = line.split(":");
                    if (segments.length == 3 && segments[0].equals("private")) {
                        String name = segments[1];
                        String message = segments[2];
                        privateChat(name, message);
                    }
                    continue;
                }
                if (line.equals("quit")) {
                    //退出流程
                    quit();
                    break;
                }
            }
        } catch (IOException e) {
        
        }
    }
    
    private void quit() {
        //退出
    }
    
    private void privateChat(String name, String message) {
        //私聊
    }
    
    private void groupChat(String message) {
        //群聊
        
    }
    
    private void register(String name) {
        //注册
        //name -> socket
        //key -> value
        SOCKET_MAP.put(name, this.client);
        this.sendMessage(this.client, "恭喜 <" + name + "> 注册成功");
        printOnlineClient();
    }
    
    private void printOnlineClient() {
        System.out.println("当前在线的客户端有" + SOCKET_MAP.size() + " 名称列表如下：");
        for (String key : SOCKET_MAP.keySet()) {
            System.out.println(key);
        }
    }
    
    private void sendMessage(Socket socket, String message) {
        try {
            OutputStream out = socket.getOutputStream();
            PrintStream printStream = new PrintStream(out);
            printStream.println(message);
            printStream.flush();
        } catch (IOException e) {
        
        }
    }
}

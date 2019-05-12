package multi;
/*

 */

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import javax.print.attribute.standard.RequestingUserName;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MultiThreadServer {
    private static Map<String,Socket> map = new ConcurrentHashMap<>();
    private static class ExecuteClientRequest implements Runnable{
        private Socket client;
        public ExecuteClientRequest(Socket client){
            this.client = client;
        }
        @Override
        public void run() {
            try {
                Scanner in = new Scanner(client.getInputStream());
                String strFromClient = "";
                while(true){
                    if(in.hasNext()){
                        strFromClient = in.nextLine();
                        //windows下消除用户自带的\r,将\r替换为空字符串
                        Pattern pattern = Pattern.compile("\r");
                        Matcher matcher = pattern.matcher(strFromClient);
                        strFromClient = matcher.replaceAll("");
                    }
                    //注册
                    if(strFromClient.startsWith("userName")){
                        String userName = strFromClient.split("\\:")[1];
                        userRegister(userName,client);
                    }
                    //群聊
                    if(strFromClient.startsWith("G:")){
                        String gropMsg = strFromClient.split("\\:")[1];
                        groupChat(gropMsg);
                    }
                    //私聊
                    if(strFromClient.startsWith("P:")){
                        String userName = strFromClient.split("\\:")[1]
                                .split("\\-")[0];
                        String privateMsg = strFromClient.split("\\:")[1]
                                .split("\\-")[1];
                        privatecChat(userName,privateMsg);
                    }
                    //退出
                    if(strFromClient.contains("byebye")){
                        String userName = strFromClient.split("\\:")[0];
                        userOffline(userName);
                        break;
                    }

                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //注册方法
        private void userRegister(String name,Socket socket){
            map.put(name,socket);
            System.out.println("用户"+name+"上线了");
            System.out.println("当前聊天室人数:"+map.size());
            try {
                PrintStream printStream =
                        new PrintStream(socket.getOutputStream(),true,"UTF-8");

                printStream.println("注册成功");
                printStream.println("当前聊天室人数为:"+map.size());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //群聊方法
        private void groupChat(String groupMsg){
            Set<Map.Entry<String,Socket>> set = map.entrySet();
            Iterator<Map.Entry<String,Socket>> iterator =
                    set.iterator();
            while(iterator.hasNext()){
                Map.Entry<String,Socket> client = iterator.next();
                //拿到客户端输出流
                PrintStream printStream =
                        null;
                try {
                    printStream = new PrintStream(client.getValue().getOutputStream(),true,"UTF-8");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                printStream.println("发的信息为:"+groupMsg);
            }

        }
        //私聊
        private void privatecChat(String userName,String privateMsg){
            //取出userName对应的Socket
            Socket client = map.get(userName);
            try {
                PrintStream printStream =
                        new PrintStream(client.getOutputStream(),true,"UTF-8");
                printStream.println("私聊信息为:"+privateMsg);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //退出
        private void userOffline(String userName){
            //删除map中的用户实体
            map.remove(userName);
            System.out.println("用户"+userName+"已下线");
            System.out.println("当前聊天室人数为:"+map.size());
        }
    }

    public static void main(String[] args) throws Exception{
        ServerSocket serverSocket = new ServerSocket(6666);
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        System.out.println("等待客户端连接、、");
        for(int i=0; i<20; i++){
            Socket client = serverSocket.accept();
            System.out.println("有新的客户端连接，端口号为:"+client.getPort());
            executorService.submit(new ExecuteClientRequest(client));
        }
        executorService.shutdown();
        serverSocket.close();
    }
}

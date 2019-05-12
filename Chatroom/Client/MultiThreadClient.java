package multi;


import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;


/*
读取服务器发来的信息
 */
class ReadFromServer implements Runnable {
    private Socket client;
    public ReadFromServer(Socket client){
        this.client = client;
    }
    @Override
    public void run() {
        try {
            Scanner scanner = new Scanner(client.getInputStream());
            while(true){
                if(client.isClosed()){
                    System.out.println("客户端已关闭");
                    scanner.close();
                    break;
                }
                if(scanner.hasNext()){
                    String msgFromServer = scanner.nextLine();
                    System.out.println("服务器发来的信息:"+msgFromServer);

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
//向服务器发送信息线程
class sendToServer implements Runnable{
    private Socket client;
    public sendToServer(Socket client){
        this.client = client;
    }
    @Override
    public void run() {
        try {
            PrintStream print =
                    new PrintStream(client.getOutputStream(),true,"UTF-8");
            //获取用户输出
            Scanner in = new Scanner(System.in);
            while(true){
                System.out.println("请输入要向服务器发送的信息:");
                String msgFromUser = "";
                if(in.hasNext()){
                    msgFromUser = in.nextLine();
                }
                //向服务器发送信息
                print.println(msgFromUser);
                if(msgFromUser.contains("byebye")){
                    System.out.println("客户端退出聊天室");
                    print.close();
                    in.close();
                    client.close();
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
public class MultiThreadClient {
    public static void main(String[] args)throws Exception {
        Socket client = new Socket("127.0.0.1",6666);
        Thread readThread = new Thread(new ReadFromServer(client));
        Thread sentThread = new Thread(new sendToServer(client));
        readThread.start();
        sentThread.start();

    }

}

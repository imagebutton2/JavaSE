package multi;

import java.io.IOException;
import java.net.Socket;


public class MultiClient {
    
    public static void main(String[] args) {
        
        String host = "127.0.0.1";
        int port = 8080;
        try {
            Socket socket = new Socket(host, port);
            Thread read = new ReadDataFromServerThread(socket);
            read.setName("Thread-Client-Read");
            read.start();
            
            Thread write = new WriteDataToServerThread(socket);
            write.setName("Thread-Client-Write");
            write.start();
            
        } catch (IOException e) {
        
        }
        
        
    }
}

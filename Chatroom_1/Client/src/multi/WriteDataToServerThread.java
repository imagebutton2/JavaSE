package multi;

import java.net.Socket;


public class WriteDataToServerThread extends Thread {
    
    private final Socket client;
    
    public WriteDataToServerThread(Socket client) {
        this.client = client;
    }
    
    @Override
    public void run() {
        
        //TODO
    }
}

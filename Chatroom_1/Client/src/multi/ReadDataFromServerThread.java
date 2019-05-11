package multi;

import java.net.Socket;


public class ReadDataFromServerThread  extends Thread{
    
    private final Socket client;
    
    public ReadDataFromServerThread(Socket client) {
        this.client = client;
    }
    
    @Override
    public void run() {
        //TODO
    }
}

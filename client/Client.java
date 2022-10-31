package client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    public final static String SERVER_IP = "172.20.10.9";
    public final static int SERVER_PORT = 9;

    public static void main(String[]args) throws IOException, InterruptedException{
        Socket socket = null;
        try{
           socket = new Socket(SERVER_IP, SERVER_PORT);
           System.out.println("Connected: " + socket);
           InputStream is = socket.getInputStream();
           OutputStream os = socket.getOutputStream();
           for(int i = '0'; i<= '9'; i++){
               System.out.println("Tuan dang ket noi");
               os.write(i);
               int ch = is.read();
               System.out.println((char) ch + " ");
               Thread.sleep(200);
           }
        } catch (IOException ie){
            System.out.println("Can't connect to Server");
        } finally {
            if(socket != null) {
                socket.close();
            }
        }
    }
}

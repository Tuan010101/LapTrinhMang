package TCPTong15;

import java.io.*;
import java.net.Socket;
import java.util.Random;

public class Client {
    public final static String SERVER_IP = "127.0.0.1";//"10.10.11.27";//"192.168.61.106"; //"10.10.10.59";
    public final static int SERVER_PORT = 6868;

    public static void main(String[]args) throws IOException, InterruptedException{
        Socket socket = null;
        String sentence_to_server = null;
        try {
            socket = new Socket(SERVER_IP, SERVER_PORT); // Connect to server
            System.out.println("Connected: " + socket);
            DataInputStream is = new DataInputStream(socket.getInputStream());
            OutputStream os = socket.getOutputStream();
            int num1 = new Random().nextInt(1000);
            int num2 = new Random().nextInt(100000);
            while (true) {
                DataOutputStream dt = new DataOutputStream(os);
                dt.writeUTF(num1 + " " + num2);
                System.out.println(num1 + " " + num2);
                String toServer = is.readUTF();
                System.out.println(toServer);
            }
        } catch (IOException ie) {
            System.out.println("Can't connect to server");
        } finally {
            if (socket != null) {
                socket.close();
            }
        }
    }
}

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Server {
    public final static int SERVER_PORT = 7;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        try {
            System.out.println("Binding to port " + SERVER_PORT + ", please wait ...");
            serverSocket = new ServerSocket(SERVER_PORT);
            System.out.println("Server started: " + serverSocket);
            System.out.println("Waiting for a client ...");
            while (true) {
                try {
                    Socket socket = serverSocket.accept();
                    System.out.println("Client accepted: " + socket);
                    DataInputStream is = new DataInputStream(socket.getInputStream());
                    DataOutputStream os = new DataOutputStream(socket.getOutputStream());
                    String message = is.readUTF();
                    System.out.println("Client: " + message);
                    os.writeUTF("Sap xep cac so: " + sort(message) + "\nTong: " + sum(message));
                    is.close();
                    os.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static ArrayList<Double> sort(String string) {
        StringTokenizer stringTokenizer = new StringTokenizer(string, " ");
        ArrayList<Double> arrayList = new ArrayList<Double>();
        while (stringTokenizer.hasMoreTokens()) {
            String token = stringTokenizer.nextToken();
            Double value = Double.parseDouble(token);
            arrayList.add(value);
        }
        Collections.sort(arrayList);
        return arrayList;
    }
    public static double sum(String string) {
        double tong = 0;
        StringTokenizer stringTokenizer = new StringTokenizer(string, " ");
        while (stringTokenizer.hasMoreTokens()) {
            String token = stringTokenizer.nextToken();
            Double value = Double.parseDouble(token);
            tong += value;
        }
        return tong;
    }
}
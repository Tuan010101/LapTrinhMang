package ThreadTong15;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ThreadClient extends Thread{
    Socket socket;

    public ThreadClient (Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try{
            while (true){
                DataInputStream is = new DataInputStream(socket.getInputStream());
                DataOutputStream os = new DataOutputStream(socket.getOutputStream());
                String message = "";
                message = is.readUTF();
                System.out.println("Client: " + message);
                os.writeUTF("Tong cac chu so bang 15: " + list_sum_digit_of_num(message));
                System.out.println(list_sum_digit_of_num(message));
                //os.writeUTF(String.valueOf(toClient));
            }
        }catch (Exception e) {
            System.out.println("Erro from: " + socket.getInetAddress().getHostAddress());
        }
    }
    public static ArrayList<Integer> list_sum_digit_of_num(String string) {
        StringTokenizer stringTokenizer = new StringTokenizer(string, " ");
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        ArrayList<Integer> arrayList_num = new ArrayList<Integer>();
        while (stringTokenizer.hasMoreTokens()) {
            String token = stringTokenizer.nextToken();
            Integer value = Integer.parseInt(token);
            arrayList.add(value);
        }
        for(int i = Integer.parseInt(String.valueOf(arrayList.get(0))); i < Integer.parseInt(String.valueOf(arrayList.get(1))); i++){
            if (sum_digit_of_num(i) == 15){
                arrayList_num.add(i);
            }
        }
        return arrayList_num;
    }

    public static int sum_digit_of_num(int n) {
        int sum = 0;
        while(n > 0) {
            sum += n%10;
            n = n/10;
        }
        return sum;
    }

}


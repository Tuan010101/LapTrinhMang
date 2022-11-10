package file;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class SapXepVaTinhTong {
    public static ArrayList<Float> sort(String input) {
        StringTokenizer stringTokenizer = new StringTokenizer(input," ");
        float tong = 0;
        ArrayList<Float> arrayList = new ArrayList<Float>();
        while (stringTokenizer.hasMoreTokens()){
            String token = stringTokenizer.nextToken();
            Float value = Float.parseFloat(token);
            arrayList.add(value);
            tong += value;
        }
        Collections.sort(arrayList);
        try {
            FileWriter output = new FileWriter("file/output.txt");
            output.write("Day so tang dan: " + arrayList.toString().substring(1, arrayList.toString().length()-1) + "\n");
            output.write("Tong cac so: " + tong);
            System.out.println("Day so tang dan: " + arrayList.toString().substring(1, arrayList.toString().length()-1));
            System.out.println("Tong cac so: " + tong);
            output.close();
        } catch (IOException e) {
            System.out.println("Error");
            e.printStackTrace();
        }
        return arrayList;
    }
    public static void main(String[]ags) throws IOException {
        String input = new String(Files.readAllBytes(Paths.get("file/input.txt")));
        sort(input);
    }
}
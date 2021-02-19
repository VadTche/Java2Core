package Lesson5;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;

public class MyClass {
    public static void main(String[] args) {
            String[] headerInfo = {"One", "Two", "Three"};
            int[][] dataInfo = {{100, 200, 300}, {400, 500, 600}};
            AppData appData = new AppData(headerInfo, dataInfo);

        try (ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream("appdata.csv"))) {
                objOut.writeObject(appData);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //appData = null;
        try (ObjectInputStream objIn = new ObjectInputStream(new FileInputStream("appdata.csv"))) {
                    appData = (AppData) objIn.readObject();
                    //тут что-то не так, не понимаю как исправить,
                    // и времени не осталось, сдаю как есть)
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(appData);
    }
}
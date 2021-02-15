package Lesson4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Arrays;
import java.util.HashSet;

public class MainClass {
    public static void main(String[] args) {
        System.out.println("Задание 1");
        System.out.println("==========");
        List<String> myMassive = new ArrayList<>(Arrays.asList(
                "Игорь", "Петр", "Ирина", "Катерина", "Трофим", "Анастасия",
                "Петр", "Светлана", "Ирина", "Трофим", "Константин", "Алексей",
                "Ирина", "Полина", "Илья", "София"));
        System.out.println("Первоначальный массив: " + myMassive);

        HashSet<String> uniqMyMassive = new HashSet<>(myMassive);
        System.out.println("\nМассив без повторов: " + uniqMyMassive);

        HashMap<String, Integer> numObj = new HashMap<>();
        for (String obj : myMassive) {
            int val = numObj.getOrDefault(obj, 0) + 1;
            numObj.put(obj, val);
        }
        System.out.println("\nСколько раз встречается каждое имя: " + numObj);

        System.out.println("\nЗадание 2");
        System.out.println("==========");
        Phonebook pb = new Phonebook();
        pb.addRecord("Игорь", 11111);
        pb.addRecord("Трофим", 22222);
        pb.addRecord("Петр", 33333);
        pb.addRecord("Ирина", 44444);
        pb.addRecord("Катерина", 55555);
        pb.addRecord("Трофим", 66666);
        pb.addRecord("Илья", 77777);
        pb.addRecord("Ирина", 88888);
        pb.addRecord("Ирина", 99999);
        pb.getPhoneNumber("Трофим");
        pb.getPhoneNumber("Катерина");
        pb.getPhoneNumber("Ирина");
    }
}

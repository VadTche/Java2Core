package Lesson4;

import java.util.HashMap;
import java.util.HashSet;

public class Phonebook {
    HashMap<String, HashSet<Integer>> phonebook;

    public Phonebook() {
        this.phonebook = new HashMap<>();
    }

    public void addRecord(String name, int phone) {
        HashSet<Integer> numm = phonebook.getOrDefault(name, new HashSet<>());
        numm.add(phone);
        phonebook.put(name, numm);
    }

    public void getPhoneNumber(String name) {
        System.out.println(name + " " + phonebook.getOrDefault(name, new HashSet<>()));
    }
}

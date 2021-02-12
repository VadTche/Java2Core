package Lesson3;

import java.util.ArrayList;

public class Box<T extends Fruit> {

    private final ArrayList<T> fruits = new ArrayList<>();

    public float getWeight() {
        if (fruits.size() != 0) return fruits.size() * fruits.get(0).getWeight();
        return 0;
    }

    public boolean compare(Box<?> otherBox) {
        return getWeight() == otherBox.getWeight();
    }

    public void replaceAllFruitsToOtherBox(Box<T> otherBox) {
        otherBox.fruits.addAll(fruits);
        fruits.clear();
    }

    public void addFruit(T fruitToAdd) { fruits.add(fruitToAdd); }
}


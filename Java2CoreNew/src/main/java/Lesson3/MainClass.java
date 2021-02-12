package Lesson3;

import java.util.Arrays;

public class MainClass {
    /*
1.Написать метод, который меняет два элемента массива местами (массив может быть любого ссылочного типа);
2.Задача:
Даны классы Fruit, Apple extends Fruit, Orange extends Fruit;
Класс Box, в который можно складывать фрукты. Коробки условно сортируются по типу фрукта,
поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
Для хранения фруктов внутри коробки можно использовать ArrayList;
Сделать метод getWeight(), который высчитывает вес коробки, зная вес одного фрукта и их количество:
вес яблока – 1.0f, апельсина – 1.5f (единицы измерения не важны);
Внутри класса Box сделать метод compare(), который позволяет сравнить текущую коробку с той,
которую подадут в compare() в качестве параметра. true – если их массы равны, false в противоположном случае.
Можно сравнивать коробки с яблоками и апельсинами;
Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую.
Помним про сортировку фруктов: нельзя яблоки высыпать в коробку с апельсинами.
Соответственно, в текущей коробке фруктов не остается, а в другую перекидываются объекты, которые были в первой;
Не забываем про метод добавления фрукта в коробку.
     */
    public static void main(String[] args) {
        //Задание 1
        String[] myMassive = new String[]{"Ford", "Dodge"};
        System.out.println("Задание 1");
        System.out.println("==========");
        System.out.println("Первоначальный массив:");
        System.out.println(Arrays.toString(myMassive));
        String temp = myMassive[0];
        myMassive[0] = myMassive[1];
        myMassive[1] = temp;
        System.out.println("\nМассив после перестановки:");
        System.out.println(Arrays.toString(myMassive));

        //Задание 2
        Box<Apple> appleBox1 = new Box<>();
        Box<Apple> appleBox2 = new Box<>();
        Box<Orange> orangeBox = new Box<>();
        Apple a1 = new Apple();
        Apple a2 = new Apple();
        Apple a3 = new Apple();
        Apple a4 = new Apple();
        Orange o1 = new Orange();
        Orange o2 = new Orange();
        System.out.println("\nЗадание 2");
        System.out.println("==========");
        System.out.println("вес яблока: " + a1.getWeight() + " и вес апельсина: " + o1.getWeight());

        System.out.println("\nДобавляем 4 яблока и 2 апельсина в 3 разные коробки");
        appleBox1.addFruit(a1);
        appleBox1.addFruit(a2);
        appleBox1.addFruit(a3);
        appleBox2.addFruit(a4);
        orangeBox.addFruit(o1);
        orangeBox.addFruit(o2);
        System.out.println("\nвес Первой_Коробки с яблоками: " + appleBox1.getWeight());
        System.out.println("вес Второй_Коробки с яблоками: " + appleBox2.getWeight());
        System.out.println("вес Коробки с апельсинами: " + orangeBox.getWeight());

        System.out.println("\nСравниваем Первую_Коробку с яблоками и Коробку с апельсинами: " + appleBox1.compare(orangeBox) + "\n");

        System.out.println("Пересыпаем яблоки из Первой_Коробки во Вторую_Коробку\n");
        appleBox1.replaceAllFruitsToOtherBox(appleBox2);
        System.out.println("вес Первой_Коробки стал: " + appleBox1.getWeight());
        System.out.println("вес Второй_Коробки стал: " + appleBox2.getWeight());
    }
}
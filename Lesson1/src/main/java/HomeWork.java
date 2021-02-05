/*
1. Создайте три класса Человек, Кот, Робот, которые не наследуются от одного класса. Эти классы должны уметь
   бегать и прыгать (методы просто выводят информацию о действии в консоль).
2. Создайте два класса: беговая дорожка и стена, при прохождении через которые, участники должны
   выполнять соответствующие действия (бежать или прыгать), результат выполнения печатаем в консоль
   (успешно пробежал, не смог пробежать и т.д.).
3. Создайте два массива: с участниками и препятствиями, и заставьте всех участников пройти этот набор препятствий.
4. * У препятствий есть длина (для дорожки) или высота (для стены), а участники имеют ограничения на бег и прыжки.
   Если участник не смог пройти одно из препятствий, то дальше по списку препятствий он не идет.
 */
interface Gamer {
    void run (int l);
    void jump (int h);
    boolean getLucky();
}

class Humans implements Gamer {
    public String name;
    private final int limitRun, limitJump;
    public boolean lucky = true;
    public Humans(String name, int limitRun, int limitJump) {
        this.name=name;
        this.limitRun=limitRun;
        this.limitJump=limitJump;
    }
    public String toString() {
        return "человек " + name;
    }
    public void run(int l) {
        setLucky(limitRun >= l);
        if (getLucky()) System.out.println(name + " пробежал дистанцию " + l + " м");
        else System.out.println(name + " не смог пробежать дистанцию " + l + " м - выбывает из соревнования");
    }
    public void jump(int h) {
        setLucky(limitJump >= h);
        if (getLucky()) System.out.println(name + " перепрыгнул барьер " + h + " см");
        else System.out.println(name + " не смог перепрыгнуть барьер " + h + " см - выбывает из соревнования");
    }
    public boolean getLucky() {
        return lucky;
    }
    public void setLucky(boolean lucky) {
        this.lucky = lucky;
    }
}

class Cats implements Gamer {
    public String name;
    private final int limitRun, limitJump;
    public boolean lucky = true;
    public Cats(String name, int limitRun, int limitJump) {
        this.name=name;
        this.limitRun=limitRun;
        this.limitJump=limitJump;
    }
    public String toString() {
        return "кот " + name;
    }
    public void run(int l) {
        setLucky(limitRun >= l);
        if (getLucky()) System.out.println(name + " пробежал дистанцию " + l + " м");
        else System.out.println(name + " не смог пробежать дистанцию " + l + " м - выбывает из соревнования");
    }
    public void jump(int h) {
        setLucky(limitJump >= h);
        if (getLucky()) System.out.println(name + " перепрыгнул барьер " + h + " см");
        else System.out.println(name + " не смог перепрыгнуть барьер " + h + " см - выбывает из соревнования");
    }
    public boolean getLucky() {
        return lucky;
    }
    public void setLucky(boolean lucky) {
        this.lucky = lucky;
    }
}

class Robots implements Gamer {
    public String name;
    private final int limitRun, limitJump;
    public boolean lucky = true;
    public Robots(String name, int limitRun, int limitJump) {
        this.name=name;
        this.limitRun=limitRun;
        this.limitJump=limitJump;
    }
    public String toString() {
        return "робот " + name;
    }
    public void run(int l) {
        setLucky(limitRun >= l);
        if (getLucky()) System.out.println(name + " пробежал дистанцию " + l + " м");
        else System.out.println(name + " не смог пробежать дистанцию " + l + " м - выбывает из соревнования");
    }
    public void jump(int h) {
        setLucky(limitJump >= h);
        if (getLucky()) System.out.println(name + " перепрыгнул барьер " + h + " см");
        else System.out.println(name + " не смог перепрыгнуть барьер " + h + " см - выбывает из соревнования");
    }
    public boolean getLucky() {
        return lucky;
    }
    public void setLucky(boolean lucky) {
        this.lucky = lucky;
    }
}

class Barrier {
    public int l;
    public int h;
}
class Track extends Barrier {
    public Track(int l) {
        this.l=l;
    }
}
class Wall extends Barrier {
    public Wall(int h) {
        this.h=h;
    }
}
public class HomeWork {
    public static void main(String[] args) {
        Gamer hum1 = new Humans("Павел", 1100, 140);
        Gamer hum2 = new Humans("Иван", 1100, 180);
        Gamer cat1 = new Cats("Барсик", 300, 180);
        Gamer cat2 = new Cats("Мурзик", 350, 170);
        Gamer rob1 = new Robots("Роббин", 2000, 40);
        Gamer rob2 = new Robots("Роббик", 900, 40);
        Wall high1 = new Wall(50);
        Wall high2 = new Wall(180);
        Track length1 = new Track(350);
        Track length2 = new Track(1000);
        Barrier[] barriers = {length1, length2, high1, high2};
        Gamer[] gamers = {hum1, hum2, cat1, cat2, rob1, rob2};
        System.out.println("Список участников:");
        for (Gamer obj : gamers) {
            System.out.print(obj.toString() + "| ");
        }
        System.out.println("\n" + "\nИтоги кросса:");
        for (int i = 0; i < 2; i++) {
            for (Gamer obj : gamers) {
                if (obj.getLucky()) {
                    obj.run(barriers[i].l);
                }
            }
        }
        for (int i = 2; i < 4; i++) {
            for (Gamer obj : gamers) {
                if (obj.getLucky()) {
                    obj.jump(barriers[i].h);
                }
            }
        }
    }
}

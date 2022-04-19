import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static Set<Animal> animal = new TreeSet<>();

    public static void main(String[] args) {

        /**
         * 0 Дан ArrayList<Integer>. C помощью Stream Api найдите среднее арифметическое
         */
        System.out.println("*********Task 0**********");
        List<Integer> list = new ArrayList();
        addList(list, 10); // метод заполняет коллекцию
        System.out.println(list); // выводим список (проверка)
        double avg = list.stream()
                .mapToInt(x -> x.intValue())
                .average()
                .getAsDouble();
        System.out.println("Average of list: " + avg);

        /**
         * 1 Дан ArrayList<Double> с числами - 1 50 6 6 6 6 10 10 10. C помощью Stream Api найдите среднее
         * исключите повторяющиеся элементы из коллекции, отсортируйте и сохраните в Set.
         */
        System.out.println("*********Task 1**********");
        List<Double> listTask1 = new ArrayList<>();
        double[] doubleArray = {1, 50, 6, 6, 6, 6, 10, 10, 10};
        for (double d : doubleArray) { // заполняем List <Double>
            listTask1.add(d);
        }
        System.out.println(listTask1);// проверка
        System.out.println("Average of list1: " + listTask1.stream()
                .mapToDouble(x -> x.doubleValue())
                .average()
                .getAsDouble());

        Set<Double> setDouble = listTask1.stream()
                .distinct() // удаляем повторяющие элементы коллекции
                .sorted() // сортируем по возростанию
                .peek(x -> System.out.println(x)) // проверка
                .collect(Collectors.toSet()); // укладываем в Set
        System.out.println("Set: " + setDouble);

        System.out.println("*********Task 2**********");
        /**
         * 2 Создать TreeSet содержащий класс Animal (поля - имя, кол-во лет, месяц рождения). Прибавить
         * всем животным, у которых месяц рождения апрель - 1 год. Распечатать содержимое с помощью for
         * each.
         */
        setAdd(animal); //заполняем TreeSet с помощью метода setADD и
        // сортируем по имени используя compareTo(Object o)
        System.out.println(animal); // проверка
        animal.stream()
                .map(x -> { // сравниваем месяц и если true добавляем 1 год
                    if (x.getMes().equals("Апрель")) {
                        System.out.println(x.getName()); //выводим животных которые родились в Апреле
                        x.setAge(x.getAge() + 1); // +1 год для тех кто родился в Апреле
                    }
                    return x; // не знаю как это работает (Java сама предложила)
                })
                .collect(Collectors.toSet()) // собираем результат обработки в коллекцию
                .forEach(x -> System.out.println(x)); // выводим на печать

        System.out.println("*********Task 3**********");
        /** 3 (выполнять не обязательно) Создайте HashMap, содержащий пары значений - имя игрушки и
         * объект игрушки (класс Product - поля: год выпуска, наименование). Исключить из коллекции
         * игрушки, произведенные до 2010 года. - любым способом, можно без stream.
         */

        Map<String, Toys> mapToys = new HashMap<>();
        mapToys.put("Mersedes", (new Toys(2020, "Car")));
        mapToys.put("Barbie", (new Toys(2009, "doll")));
        mapToys.put("Audi", (new Toys(2008, "Car")));
        mapToys.put("Can", (new Toys(2011, "doll")));
        mapToys.put("BMW", (new Toys(2007, "Car")));

        System.out.println("Проверка" + mapToys); // проверка

        List<String> key = new ArrayList<>(); // для хранения Key из MAP

        for (Map.Entry<String, Toys> entry : mapToys.entrySet()) {
            if (entry.getValue().getYear() < 2010){
                key.add(entry.getKey());
            }
        }
        for (String k: key) {
            mapToys.remove(k);
        }

        System.out.println("Map после удаления игрушек произведенных до 2010 года : " + mapToys);

        System.out.println("*********Task 4**********");
        /** 4 (выполнять не обязательно) Добавить студентов в коллекцию. Создать класс Student,
         * содержащий следующие характеристики – имя, группа, курс, оценки по предметам.
         * Создать коллекцию, содержащую объекты класса Student.
         * Создать коллекцию с фио студентов, если средний балл>=3
         * А также печатает на консоль имена тех студентов из списка, которые обучаются на данном курсе.
         */

        Set<Student> students = new HashSet<>();
        Set<String> studentsThree = new HashSet<>(); // список студентов с AVG >3

        Student s1 = new Student("Bob", "206", 2, 2.5);
        Student s2 = new Student("John", "311", 4, 4.5);
        Student s3 = new Student("Lola", "346", 3, 3.1);
        Student s4 = new Student("Boris", "306", 1, 5);
        Student s5 = new Student("Arnold", "206", 2, 1.9);
        Student s6 = new Student("Richard", "356", 4, 3);
        Student s7 = new Student("Kate", "418", 3, 3.4);
        Student s8 = new Student("Garry", "306", 1, 2.8);

        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);
        students.add(s5);
        students.add(s6);
        students.add(s7);
        students.add(s8);

        for (Student stud: students) {
            if (stud.getAvg() >= 3){
                studentsThree.add(stud.getName());
            }
        }
        System.out.println(students);
        System.out.println(studentsThree);

    }

    private static void setAdd(Set<Animal> animal) {
        Animal a1 = new Animal("Кот", 3, "Апрель");
        Animal a2 = new Animal("Собака", 6, "Май");
        Animal a3 = new Animal("Хомяк", 1, "Январь");
        Animal a4 = new Animal("Корова", 10, "Апрель");
        Animal a5 = new Animal("Лошадь", 15, "Сентябрь");

        animal.add(a1);
        animal.add(a2);
        animal.add(a3);
        animal.add(a4);
        animal.add(a5);

    }

    private static void addList(List list, int compacity) {
        for (int i = 0; i < compacity; i++) {
            list.add((int) (Math.random() * 101));

        }
    }
}

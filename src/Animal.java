import java.util.Comparator;
import java.util.Objects;

public class Animal implements Comparable {

    private String name;
     int age;
    private String mes;

    public Animal(String name, int age, String mes) {
        this.name = name;
        this.age = age;
        this.mes = mes;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getMes() {
        return mes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return Objects.equals(name, animal.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", mes='" + mes + '\'' +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        if (o.getClass() != getClass()){
            throw new IllegalArgumentException("Объект не Animal");
        }
        Animal a1 = this;
        Animal a2 = (Animal) o;

        return a1.getName().compareTo(a2.getName());
    }
}

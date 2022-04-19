public class Student {

    private String name;
    private String gruppa;
    private int curs;
    private double avg;

    public Student(String name, String gruppa, int curs, double avg) {
        this.name = name;
        this.gruppa = gruppa;
        this.curs = curs;
        this.avg = avg;
    }

    public String getName() {
        return name;
    }

    public String getGruppa() {
        return gruppa;
    }

    public int getCurs() {
        return curs;
    }

    public double getAvg() {
        return avg;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", gruppa='" + gruppa + '\'' +
                ", curs=" + curs +
                ", avg=" + avg +
                '}';
    }


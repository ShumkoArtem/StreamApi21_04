public class Toys {
    private int year;
    private String type;

    public Toys(int year, String type) {
        this.year = year;
        this.type = type;
    }

    public int getYear() {
        return year;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Toys{" +
                "year=" + year +
                ", type='" + type + '\'' +
                '}';
    }


}

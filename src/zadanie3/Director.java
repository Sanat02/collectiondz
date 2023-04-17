package zadanie3;

public class Director implements Comparable<Director> {
    private String fullName;

    public String getFullName() {
        return fullName;
    }

    @Override
    public int compareTo(Director o) {
        return this.getFullName().compareTo(o.getFullName());
    }
}

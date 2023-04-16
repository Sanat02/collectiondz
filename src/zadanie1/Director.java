package zadanie1;

public class Director implements Comparable<Director> {
    private String fullName;

//    public Director(String fullName) {
//        this.fullName = fullName;
//    }

    public String getFullName() {
        return fullName;
    }

    @Override
    public int compareTo(Director o) {
        return this.getFullName().compareTo(o.getFullName());
    }
}

package collections;

public class StringOccurrences {
    private final String name;
    private final int occurrence;

    public StringOccurrences(String name, int occurrence) {
        this.name = name;
        this.occurrence = occurrence;
    }

    @Override
    public String toString() {
        return "{" +
                "name = \"" + name + '\"' +
                ", occurrence = " + occurrence +
                '}' + "\n";
    }
}

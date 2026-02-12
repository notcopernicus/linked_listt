public final class Student {
    private final String id;
    private final String name;

    public Student(String id, String name) {
        if (id == null || id.trim().isEmpty()) throw new IllegalArgumentException("ID cannot be null or empty");
        if (name == null || name.trim().isEmpty()) throw new IllegalArgumentException("Name cannot be null or empty");
        this.id = id.trim();
        this.name = name.trim();
    }

    public String getId() { return id; }
    public String getName() { return name; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student other = (Student) o;
        return id.equals(other.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return id + " - " + name;
    }
}
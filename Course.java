// Course.java
import java.io.*;

public class Course {
    private final String code;
    private final String title;
    private final int capacity;
    private final DynamicArray<Student> enrolled;
    private final SinglyLinkedList<Student> waitlist;

    public Course(String code, String title, int capacity) {
        this.code = code;
        this.title = title;
        this.capacity = Math.max(1, capacity);
        this.enrolled = new DynamicArray<>();
        this.waitlist = new SinglyLinkedList<>();
    }

    public boolean enroll(Student s) {
        if (s == null) throw new IllegalArgumentException("Student cannot be null");

        // Prevent duplicates
        Student dummy = new Student(s.getId(), "dummy");
        if (enrolled.indexOf(dummy) >= 0 || waitlist.contains(dummy)) {
            System.out.println("Student " + s.getId() + " is already enrolled or waitlisted.");
            return false;
        }

        if (enrolled.size() < capacity) {
            enrolled.addLast(s);
            System.out.println("Enrolled: " + s);
            return true;
        } else {
            waitlist.addLast(s);
            System.out.println("Added to waitlist: " + s);
            return false;
        }
    }

    public boolean drop(String studentId) {
        if (studentId == null || studentId.trim().isEmpty()) {
            System.out.println("Invalid student ID.");
            return false;
        }

        Student dummy = new Student(studentId, "dummy");

        // Try to remove from enrolled
        int idx = enrolled.indexOf(dummy);
        if (idx >= 0) {
            enrolled.removeAt(idx);
            System.out.println("Dropped from enrolled: " + studentId);

            // Promote from waitlist if possible
            if (!waitlist.isEmpty()) {
                Student promoted = waitlist.removeFirst();
                enrolled.addLast(promoted);
                System.out.println("Promoted from waitlist: " + promoted);
            }
            return true;
        }

        // Try waitlist
        boolean removed = waitlist.remove(dummy);
        if (removed) {
            System.out.println("Removed from waitlist: " + studentId);
            return true;
        }

        System.out.println("Student " + studentId + " not found.");
        return false;
    }

    public boolean isEnrolled(String id) {
        return enrolled.indexOf(new Student(id, "dummy")) >= 0;
    }

    public boolean isWaitlisted(String id) {
        return waitlist.contains(new Student(id, "dummy"));
    }

    public Student[] classList() {
        return enrolled.toArray();
    }

    public Student[] waitlistSnapshot() {
        return waitlist.toArray();
    }

    public enum Role { ENROLLED, WAITLISTED, NOT_FOUND }

    public Role searchById(String id) {
        if (isEnrolled(id)) return Role.ENROLLED;
        if (isWaitlisted(id)) return Role.WAITLISTED;
        return Role.NOT_FOUND;
    }

    public void bulkImport(String csvPath) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(csvPath));
            String line;
            int count = 0;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;
                String[] parts = line.split(",", 2);
                if (parts.length < 2) continue;
                String id = parts[0].trim();
                String name = parts[1].trim();
                if (id.isEmpty() || name.isEmpty()) continue;

                Student s = new Student(id, name);
                enroll(s);
                count++;
            }
            System.out.println("Imported " + count + " students.");
            br.close();
        } catch (IOException e) {
            System.out.println("Error reading CSV: " + e.getMessage());
        }
    }

    public void exportRoster(String csvPath) {
        try {
            PrintWriter pw = new PrintWriter(new FileWriter(csvPath));
            pw.println("ID,Name");
            for (int i = 0; i < enrolled.size(); i++) {
                Student s = enrolled.get(i);
                pw.println(s.getId() + "," + s.getName());
            }
            System.out.println("Roster exported to " + csvPath);
            pw.close();
        } catch (IOException e) {
            System.out.println("Error writing CSV: " + e.getMessage());
        }
    }

    public String getCode() { return code; }
    public String getTitle() { return title; }
    public int getCapacity() { return capacity; }
    public int getEnrolledCount() { return enrolled.size(); }
    public int getWaitlistCount() { return waitlist.size(); }
}

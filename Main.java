// Main.java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        Course course = new Course("CSC252", "Data Structures II", 5); // example capacity

        while (true) {
            printMenu();
            System.out.print("Choice: ");
            String choice = sc.readLine().trim().toUpperCase();

            switch (choice) {
                case "1": // Enroll student
                    System.out.print("Student ID: ");
                    String id = sc.readLine().trim();
                    System.out.print("Name: ");
                    String name = sc.readLine().trim();
                    if (!id.isEmpty() && !name.isEmpty()) {
                        course.enroll(new Student(id, name));
                    } else {
                        System.out.println("ID and name required.");
                    }
                    break;

                case "2": // Drop
                    System.out.print("Student ID to drop: ");
                    String dropId = sc.readLine().trim();
                    course.drop(dropId);
                    break;

                case "3": // Show enrolled
                    System.out.println("\nEnrolled (" + course.getEnrolledCount() + "/" + course.getCapacity() + "):");
                    Student[] roster = course.classList();
                    if (roster.length == 0) {
                        System.out.println("  (none)");
                    } else {
                        for (Student s : roster) {
                            System.out.println("  " + s);
                        }
                    }
                    break;

                case "4": // Show waitlist
                    System.out.println("\nWaitlist (" + course.getWaitlistCount() + "):");
                    Student[] wl = course.waitlistSnapshot();
                    if (wl.length == 0) {
                        System.out.println("  (empty)");
                    } else {
                        for (Student s : wl) {
                            System.out.println("  " + s);
                        }
                    }
                    break;

                case "5": // Search
                    System.out.print("Student ID: ");
                    String searchId = sc.readLine().trim();
                    Course.Role role = course.searchById(searchId);
                    System.out.println("Status: " + role);
                    break;

                case "6": // Bulk import
                    System.out.print("CSV file path: ");
                    String importPath = sc.readLine().trim();
                    course.bulkImport(importPath);
                    break;

                case "7": // Export
                    System.out.print("Export CSV path: ");
                    String exportPath = sc.readLine().trim();
                    course.exportRoster(exportPath);
                    break;

                case "Q":
                    System.out.println("Goodbye.");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
            System.out.println();
        }
    }

    private static void printMenu() {
        System.out.println(" Course Enrollment System=");
        System.out.println("1) Enroll student");
        System.out.println("2) Drop student");
        System.out.println("3) Show enrolled");
        System.out.println("4) Show waitlist");
        System.out.println("5) Search by ID");
        System.out.println("6) Bulk import from CSV");
        System.out.println("7) Export roster");
        System.out.println("Q) Quit");
    }
}
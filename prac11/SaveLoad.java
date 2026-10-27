import java.io.*;

class Student implements Serializable {
    private static final long serialVersionUID = 1L;

    int id;
    String name;
    transient String password;

    Student(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }
}

public class SaveLoad {
    public static void main(String[] args) {
        Student[] students = {
            new Student(1, "Kavya", "pass123"),
            new Student(2, "Rahul", "pass456"),
            new Student(3, "Priya", "pass789")
        };

        try (ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream("students.dat"))) {
            out.writeObject(students);
            System.out.println("Objects saved successfully.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try (ObjectInputStream in = new ObjectInputStream(
                new FileInputStream("students.dat"))) {
            Student[] loadedStudents = (Student[]) in.readObject();

            System.out.println("\nLoaded Student Details:");

            for (Student s : loadedStudents) {
                System.out.println("ID: " + s.id);
                System.out.println("Name: " + s.name);
                System.out.println("Password: " + s.password);
                System.out.println();
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
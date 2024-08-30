package student;

//CourseRegistrationSystem.java
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CourseRegistrationSystem {
 private List<Course> courses;
 private List<Student> students;

 public CourseRegistrationSystem() {
     courses = new ArrayList<>();
     students = new ArrayList<>();
 }

 public void addCourse(Course course) {
     courses.add(course);
 }

 public void addStudent(Student student) {
     students.add(student);
 }

 public void listCourses() {
     System.out.println("Available Courses:");
     for (Course course : courses) {
         System.out.println(course);
     }
 }

 public void listStudents() {
     System.out.println("Registered Students:");
     for (Student student : students) {
         System.out.println(student);
     }
 }

 public Course findCourse(String courseCode) {
     for (Course course : courses) {
         if (course.getCourseCode().equalsIgnoreCase(courseCode)) {
             return course;
         }
     }
     return null;
 }

 public Student findStudent(String studentID) {
     for (Student student : students) {
         if (student.getStudentID().equalsIgnoreCase(studentID)) {
             return student;
         }
     }
     return null;
 }

 public static void main(String[] args) {
     CourseRegistrationSystem system = new CourseRegistrationSystem();

     // Adding some courses
     system.addCourse(new Course("CS101", "Introduction to Computer Science", 3));
     system.addCourse(new Course("MATH101", "Calculus I", 2));

     // Adding some students
     system.addStudent(new Student("S001", "Alice"));
     system.addStudent(new Student("S002", "Bob"));

     Scanner scanner = new Scanner(System.in);
     while (true) {
         System.out.println("\n1. List Courses\n2. List Students\n3. Register for a Course\n4. Drop a Course\n5. Exit");
         System.out.print("Choose an option: ");
         int choice = scanner.nextInt();
         scanner.nextLine(); // consume newline

         if (choice == 1) {
             system.listCourses();
         } else if (choice == 2) {
             system.listStudents();
         } else if (choice == 3) {
             System.out.print("Enter Student ID: ");
             String studentID = scanner.nextLine();
             Student student = system.findStudent(studentID);
             if (student != null) {
                 System.out.print("Enter Course Code: ");
                 String courseCode = scanner.nextLine();
                 Course course = system.findCourse(courseCode);
                 if (course != null) {
                     student.registerCourse(course);
                 } else {
                     System.out.println("Course not found.");
                 }
             } else {
                 System.out.println("Student not found.");
             }
         } else if (choice == 4) {
             System.out.print("Enter Student ID: ");
             String studentID = scanner.nextLine();
             Student student = system.findStudent(studentID);
             if (student != null) {
                 System.out.print("Enter Course Code: ");
                 String courseCode = scanner.nextLine();
                 Course course = system.findCourse(courseCode);
                 if (course != null) {
                     student.dropCourse(course);
                 } else {
                     System.out.println("Course not found.");
                 }
             } else {
                 System.out.println("Student not found.");
             }
         } else if (choice == 5) {
             System.out.println("Exiting...");
             break;
         } else {
             System.out.println("Invalid option.");
         }
     }

     scanner.close();
 }
}

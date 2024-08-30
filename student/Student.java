package student;

//Student.java
import java.util.ArrayList;
import java.util.List;

public class Student {
 private String studentID;
 private String name;
 private List<Course> registeredCourses;

 public Student(String studentID, String name) {
     this.studentID = studentID;
     this.name = name;
     this.registeredCourses = new ArrayList<>();
 }

 public String getStudentID() {
     return studentID;
 }

 public String getName() {
     return name;
 }

 public List<Course> getRegisteredCourses() {
     return registeredCourses;
 }

 public void registerCourse(Course course) {
     if (course.registerStudent()) {
         registeredCourses.add(course);
         System.out.println(name + " registered for " + course.getTitle());
     } else {
         System.out.println("No available slots for " + course.getTitle());
     }
 }

 public void dropCourse(Course course) {
     if (registeredCourses.remove(course)) {
         course.dropStudent();
         System.out.println(name + " dropped " + course.getTitle());
     } else {
         System.out.println(name + " is not registered for " + course.getTitle());
     }
 }

 @Override
 public String toString() {
     return "Student ID: " + studentID + ", Name: " + name;
 }
}

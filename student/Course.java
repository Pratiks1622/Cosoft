package student;

//Course.java
public class Course {
 private String courseCode;
 private String title;
 private int capacity;
 private int enrolledStudents;

 public Course(String courseCode, String title, int capacity) {
     this.courseCode = courseCode;
     this.title = title;
     this.capacity = capacity;
     this.enrolledStudents = 0;
 }

 public String getCourseCode() {
     return courseCode;
 }

 public String getTitle() {
     return title;
 }

 public int getCapacity() {
     return capacity;
 }

 public int getAvailableSlots() {
     return capacity - enrolledStudents;
 }

 public boolean registerStudent() {
     if (enrolledStudents < capacity) {
         enrolledStudents++;
         return true;
     }
     return false;
 }

 public boolean dropStudent() {
     if (enrolledStudents > 0) {
         enrolledStudents--;
         return true;
     }
     return false;
 }

 @Override
 public String toString() {
     return "Course Code: " + courseCode + ", Title: " + title + ", Available Slots: " + getAvailableSlots();
 }
}

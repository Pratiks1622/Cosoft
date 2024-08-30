package quiz;

//QuizResult.java
import java.util.ArrayList;
import java.util.List;

public class QuizResult {
 private int score;
 private List<String> results;

 public QuizResult() {
     score = 0;
     results = new ArrayList<>();
 }

 public void addResult(String questionText, boolean correct) {
     results.add(questionText + ": " + (correct ? "Correct" : "Incorrect"));
     if (correct) {
         score++;
     }
 }

 public int getScore() {
     return score;
 }

 public void displayResults() {
     System.out.println("\nQuiz Results:");
     for (String result : results) {
         System.out.println(result);
     }
     System.out.println("\nFinal Score: " + score);
 }
}

package quiz;

//Quiz.java
import java.util.Scanner;

public class Quiz {
 private static final int TIME_LIMIT_PER_QUESTION = 10; // seconds

 public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);
     Question[] questions = {
         new Question("What is the capital of France?", new String[]{"Berlin", "London", "Paris", "Rome"}, 2),
         new Question("Which planet is known as the Red Planet?", new String[]{"Earth", "Mars", "Jupiter", "Saturn"}, 1),
         new Question("What is the largest ocean on Earth?", new String[]{"Atlantic", "Indian", "Southern", "Pacific"}, 3),
         new Question("What is the chemical symbol for water?", new String[]{"O2", "H2O", "CO2", "H2"}, 1),
         new Question("What is the powerhouse of the cell?", new String[]{"Nucleus", "Mitochondria", "Ribosome", "Golgi apparatus"}, 1)
     };

     QuizResult result = new QuizResult();

     for (Question question : questions) {
         System.out.println(question.getQuestionText());
         String[] options = question.getOptions();
         for (int i = 0; i < options.length; i++) {
             System.out.println((i + 1) + ". " + options[i]);
         }

         QuizTimer timer = new QuizTimer(TIME_LIMIT_PER_QUESTION);
         System.out.print("Your answer (1-4): ");
         int userAnswer = -1;

         while (!timer.isTimeUp() && userAnswer == -1) {
             if (scanner.hasNextInt()) {
                 userAnswer = scanner.nextInt() - 1; // convert to 0-indexed
             }
         }

         timer.cancelTimer();

         if (timer.isTimeUp()) {
             System.out.println("Time's up!");
         }

         boolean correct = question.isCorrectAnswer(userAnswer);
         result.addResult(question.getQuestionText(), correct);
     }

     result.displayResults();
     scanner.close();
 }
}

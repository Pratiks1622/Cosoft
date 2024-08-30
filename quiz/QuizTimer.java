package quiz;

//QuizTimer.java
import java.util.Timer;
import java.util.TimerTask;

public class QuizTimer {
 private Timer timer;
 private boolean timeUp;

 public QuizTimer(int seconds) {
     timer = new Timer();
     timeUp = false;
     timer.schedule(new TimerTask() {
         public void run() {
             timeUp = true;
             timer.cancel();
         }
     }, seconds * 1000);
 }

 public boolean isTimeUp() {
     return timeUp;
 }

 public void cancelTimer() {
     timer.cancel();
 }
}

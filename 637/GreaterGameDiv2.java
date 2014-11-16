public class GreaterGameDiv2 {
  
  public int calc(int[] snuke, int[] sothe) {
    int points = 0;
    
    for (int i = 0; i < snuke.length; i++) {
      if (snuke[i] > sothe[i]) {
        points++;
      }
    }
    return points;
  }

}


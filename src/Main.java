import GameEngine.Engine;
import Tests.MainTester;

public class Main {
  public static void main(String[] args) {

    // Begin Tests
    System.out.println(MainTester.runAllTests());
    // End Tests

    Engine.init(500,500, "Title");
    Engine.update();
  }
}

import GameEngine.Window;
import Tests.ColliderTester;

public class Main {
  public static void main(String[] args) {

    // Begin Tests
    System.out.println(ColliderTester.runAllTests());
    // End Tests

    Window window = new Window(100,500,"Hello");
    window.init();
    window.update();


  }
}

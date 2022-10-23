import GameEngine.Engine;
import GameEngine.GameObjects.Components.SpriteRenderer;
import GameEngine.GameObjects.GameObject;
import GameEngine.Utils.Vector2.Vector2;
import Tests.MainTester;

public class Main {
  public static void main(String[] args) {

    // Begin Tests
    System.out.println(MainTester.runAllTests());
    // End Tests

    SpriteRenderer spriteRenderer = new SpriteRenderer("cloud.png", new Vector2(5,5));

    Engine.init(500,500, "Title");
    Engine.update();
  }
}

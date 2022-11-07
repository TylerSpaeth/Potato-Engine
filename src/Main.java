import GameEngine.Engine;
import GameEngine.GameObjects.Components.SpriteRenderer;
import GameEngine.GameObjects.Components.Transform;
import GameEngine.GameObjects.GameObject;
import GameEngine.Scene;
import GameEngine.Utils.Vector2.Vector2;
import Tests.MainTester;

public class Main {
  public static void main(String[] args) {

    // Begin Tests
    System.out.println(MainTester.runAllTests());
    // End Tests

    Scene scene = new Scene();
    scene.setToCurrentScene();

    GameObject testObject = new GameObject("potato", new Transform(30, 30, 0));
    testObject.addComponent(new SpriteRenderer("cloud.png", new Vector2(30,30), 0));

    scene.addGameObject(testObject);

    Engine.init(1000,1000, "Title");
    Engine.update();
  }
}

import GameEngine.Engine;
import GameEngine.GameObjects.Components.SpriteRenderer;
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

    // Right now 300 sprites results in about 140 fps
    for(int i = 0; i < 3000; i++) {
      scene.addSpriteRendererToLayer(0, new SpriteRenderer("cloud.png", new Vector2(5,5)));
    }

    Engine.init(1000,1000, "Title");
    Engine.update();
  }
}

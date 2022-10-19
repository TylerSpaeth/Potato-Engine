package GameEngine;

import GameEngine.GameObject.GameObject;

import java.util.ArrayList;

/**
 * This is the main class for the Potato Engine
 *
 * @author Tyler Spaeth
 */
public class Engine {

  private static ArrayList<GameObject> gameObjects; // All the primary GameObjects stored here
  private static Window window; // The window for this class
  private static Renderer renderer;
  private static Camera camera;

  /**
   * Initializes the Engine
   *
   * @param windowWidth width of the window
   * @param windowHeight height of the window
   * @param title title for the window
   */
  public static void init(int windowWidth, int windowHeight, String title) {
    gameObjects = new ArrayList<>();
    window = new Window(windowWidth, windowHeight, title);
    renderer = new Renderer();
    camera = new Camera();

    // Initialize all the objects that have just been created if they need to be
    window.init();

    update();
  }

  public static void update() {
    // TODO determine if this is the best way to handle this.
    if(!window.isShouldClose()) { // While the window should not close keep updating
      window.update();
      update();
    }
    else {
      window.closeWindow(); // Otherwise close the Window
    }
  }

}

package GameEngine;

import GameEngine.GameObjects.GameObject;
import GameEngine.Utils.Time.DeltaTime;

import java.util.ArrayList;

/**
 * This is the main class for the Potato Engine
 *
 * @author Tyler Spaeth
 */
public class Engine {

  private static ArrayList<GameObject> gameObjects; // All the primary GameObjects stored here

 //TODO get window for this class
  private static Renderer renderer;
  private static Camera camera;
  private static Window window;

  private static boolean running; // If the engine is running


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
    renderer = new Renderer(window);
    camera = new Camera();


    // Initialize all the objects that have just been created if they need to be
    DeltaTime.init(); // Starts DeltaTime
    window.init();

    running = true;
  }

  /**
   * This method makes the Engine run.
   */
  public static void update() {

    //TODO decide if while loop or recursion is better

    while(running) { // While the window should not close keep updating


      //Updates the DeltaTIme, setting the deltaTIme to the amount of time since this was last
      // called. Keep this at the start or end of the function
      DeltaTime.update(); //TODO there needs to be a limit on max deltatime
      renderer.update();
      // This was causing a stack overflow error, so for now it will be a loop
      //update(); // Recursive statement. Keeps the updates going for as long as the Window is open
    }

      // TODO add shutdown code

  }

}

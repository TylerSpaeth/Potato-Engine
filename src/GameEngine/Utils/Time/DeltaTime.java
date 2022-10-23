package GameEngine.Utils.Time;

/**
 * DeltaTime is the time between updates of a loop.
 *
 * @author Tyler Spaeth
 */
public class DeltaTime {
  // TODO Potentially change this class to be a general time class and have DeltaTime be one of the
  //  types of time in the class

  private static float lastTime; // The last time the current nanosecond was updated

  private static float deltaTime; // Value for delta time

  /**
   * Initializes DeltaTime by getting the current time
   */
  public static void init() {
    lastTime = System.nanoTime(); // Set the last time equal to the current nanosecond
  }

  /**
   * Updates delta time by getting the current time and subtracting the last time this was called
   */
  public static void update() {
    float currentTime = System.nanoTime(); // The current time
    deltaTime = currentTime - lastTime;
    lastTime = currentTime; // Set the last time this was called to this time
  }

  /**
   * Gets the DeltaTime for the last time this was called
   *
   * @return float representing the time since the last update loop
   */
  public static float getDeltaTime() {
    return deltaTime;
  }
}

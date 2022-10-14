package GameEngine.Vector2;

/**
 * Vector2 is an object that stores x and y coordinates.
 *
 * @author Tyler Spaeth
 */
public class Vector2 {

  // X and Y variables for the Vector2
  private float x;
  private float y;

  /**
   * Constructor for a Vector2 object
   *
   * @param x x coordinate of this Vector2
   * @param y y coordinate of this Vector2
   */
  public Vector2(float x, float y) {
    this.x = x;
    this.y = y;
  }

  /**
   * Set the x coordinate of this Vector2
   *
   * @param x desired x coordinate for this Vector2
   */
  public void setX(float x){
    this.x = x;
  }

  /**
   * Set the y coordinate of this Vector2
   *
   * @param y desired y coordinate for this Vector2
   */
  public void setY(float y){
    this.y = y;
  }

  /**
   * Get the x coordinate of this Vector2
   */
  public float getX() {
    return x;
  }

  /**
   * Get the y coordinate of this Vector2
   */
  public float getY() {
    return y;
  }

}

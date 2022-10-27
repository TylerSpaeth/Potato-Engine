package GameEngine.GameObjects.Components;

import GameEngine.Utils.Vector2.Vector2;

/**
 * Transform is a type of Component the holds things like position, rotation and height.
 *
 * @author Tyler Spaeth
 */
public class Transform extends Component {
  // TODO ensure that scale can not be negative
  private Vector2 position;
  private int rotation; // Will be 0-359
  private Vector2 scale; // Scale of the item (1,1) would be default size

  /**
   * Constructor for a Transform component.
   *
   * @param xPosition x position for this Transform
   * @param yPosition y position for this Transform
   * @param rotation angle of rotation for this Transform (In Degrees)
   */
  public Transform(float xPosition, float yPosition, int rotation) {
    this.position = new Vector2(xPosition, yPosition);
    this.rotation = rotation % 360; // Binds the value between 0-359
    this.scale = new Vector2(1,1);
  }

  /**
   * Changes the position value to a new position
   *
   * @param position The updated Vector2 for the location of the Transform
   */
  public void moveTo(Vector2 position) {
    this.position = position;
  }

  /**
   * Changes the rotation value to a new rotation
   *
   * @param rotation The desired angle of rotation for the Transform
   */
  public void rotateTo(int rotation) {
    this.rotation = rotation % 360; // Binds the value between 0-359
  }

  /**
   * Sets the scale of this Transform.
   *
   * @param scale A Vector2 of the desired scale of this Transform
   *
   * @throws IllegalArgumentException if the x or y value of the scale is negative
   */
  public void setScale(Vector2 scale) {
    if(scale.getX() < 0 || scale.getY() < 0) {
      throw new IllegalArgumentException("Scale can not be negative.");
    }
    this.scale = scale;
  }

  /**
   * Getter for the Vector2 position
   *
   * @return the position value of this Transform
   */
  public Vector2 getPosition() {
    return position;
  }

  /**
   * Getter for the rotation of this Transform
   *
   * @return the rotation of this Transform
   */
  public int getRotation() {
    return rotation;
  }

  /**
   * Getter for the scale of this Transform
   *
   * @return the scale of this Transform
   */
  public Vector2 getScale() {
    return scale;
  }

}



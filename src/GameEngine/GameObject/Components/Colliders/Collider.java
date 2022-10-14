package GameEngine.GameObject.Components.Colliders;

import GameEngine.Vector2.Vector2;

/**
 * Collider is the base class in which all types of Collider derive.
 *
 * @author Tyler Spaeth
 */
public abstract class Collider {

  private Vector2 centerPosition; // The center position for the Collider
  private boolean isTrigger; // If the Collider should act as trigger instead of a solid Collider

  /**
   * Constructor for a Collider object. Takes in a centerPosition and isTrigger parameters.
   *
   * @param centerPosition Vector2 for the x and y coordinates of the Collider
   * @param isTrigger boolean for if the collider should behave as a trigger or solid collider
   */
  public Collider(Vector2 centerPosition, boolean isTrigger) {
    this.centerPosition = centerPosition;
    this.isTrigger = isTrigger;
  }

  /**
   * Getter for the centerPosition value of this Collider object
   *
   * @return the Vector2 representing the centerPosition of the Collider
   */
  public Vector2 getCenterPosition() {
    return centerPosition;
  }

  /**
   * Getter for the isTrigger value of this Collider object
   *
   * @return true if this Collider is a trigger, otherwise false
   */
  public boolean getIsTrigger() {
    return isTrigger;
  }

  /**
   * Sets the centerPosition value of this Collider to the given Vector2
   *
   * @param centerPosition a Vector2 representing the desired centerPosition value
   */
  public void setCenterPosition(Vector2 centerPosition) {
    this.centerPosition = centerPosition;
  }

  /**
   * Sets the isTrigger value of this Collider to the given boolean
   *
   * @param isTrigger a boolean that is true if the Collider should be a trigger, otherwise false.
   */
  public void setIsTrigger(boolean isTrigger) {
    this.isTrigger = isTrigger;
  }

}

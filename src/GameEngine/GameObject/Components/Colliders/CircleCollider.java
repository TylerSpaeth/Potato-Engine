package GameEngine.GameObject.Components.Colliders;

import GameEngine.Vector2.Vector2;

/**
 * A circular Collider.
 *
 * @author Tyler Spaeth
 */
public class CircleCollider extends Collider {

  private float radius; // The radius of the circle

  /**
   * Constructor for a CircleCollider object
   *
   * @param centerPosition a Vector2 of the position for the CircleCollider
   * @param isTrigger a boolean for if this CircleCollider should be a trigger
   * @param radius a float for the radius of the CircleCollider
   */
  public CircleCollider(Vector2 centerPosition, boolean isTrigger, float radius) {
    super(centerPosition, isTrigger);
    this.radius = radius;
    this.type = Type.CIRCLE;
  }

  /**
   * Getter for the radius value of this CircleCollider
   *
   * @return a float representing the radius of this CircleCollider
   */
  public float getRadius() {
    return radius;
  }

  /**
   * Sets the radius of this CircleCollider
   *
   * @param radius a float representing the desired radius of the CircleCollider
   */
  public void setRadius(float radius) {
    this.radius = radius;
  }

  @Override
  public boolean collided(Collider other) {
    //TODO finish this
    return false;
  }

}

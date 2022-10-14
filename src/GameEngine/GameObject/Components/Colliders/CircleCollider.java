package GameEngine.GameObject.Components.Colliders;

import GameEngine.Vector2.Vector2;

/**
 * A circular Collider.
 *
 * @author Tyler Spaeth
 */
public class CircleCollider extends Collider{

  private float radius; // The radius of the circle

  /**
   * Constructor for a CircleCollider object
   *
   * @param centerPosition a Vector2 of the position for the Collider.
   * @param isTrigger
   * @param radius
   */
  public CircleCollider(Vector2 centerPosition, boolean isTrigger, float radius) {
    super(centerPosition, isTrigger);
    this.radius = radius;
  }

  public float getRadius() {
    return radius;
  }

  public void setRadius(float radius) {
    this.radius = radius;
  }
}

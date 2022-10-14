package GameEngine.GameObject.Components.Colliders;

import GameEngine.Vector2.Vector2;

public class BoxCollider extends Collider {

  private Vector2 boxDimensions;

  public BoxCollider(Vector2 centerPosition, boolean isTrigger, Vector2 boxDimensions) {
    super(centerPosition, isTrigger);
    this.boxDimensions = boxDimensions;
  }

  public Vector2 getBoxDimensions() {
    return boxDimensions;
  }

  public void setBoxDimensions(Vector2 boxDimensions) {
    this.boxDimensions = boxDimensions;
  }
}

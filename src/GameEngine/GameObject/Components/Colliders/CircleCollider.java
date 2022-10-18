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

    if(other.type == Type.CIRCLE) {
      CircleCollider otherCircle = (CircleCollider) other;
      Vector2 otherCircleCenter = otherCircle.getCenterPosition();
      float otherCircleRadius = otherCircle.getRadius();

      // Start circle difference formula
      double partOne = Math.pow(otherCircleCenter.getX() - getCenterPosition().getX(), 2);
      double partTwo = Math.pow(otherCircleCenter.getY() - getCenterPosition().getY(), 2);
      double differenceFormula = Math.sqrt(partOne + partTwo);
      // End circle difference formula

      // If the distance between the centers is less than the two radius's combined
      if(differenceFormula <= getRadius() + otherCircleRadius) {
        return true;
      }
    }
    else if(other.type == Type.BOX) {
      // TODO only check the corners not the whole side - for optimization sake
      BoxCollider otherBox = (BoxCollider) other; // Cast to BoxCollider for BoxCollider methods
      Vector2 otherBoxCenter = other.getCenterPosition();
      float otherTopEdge = otherBox.getCenterPosition().getY() + otherBox.getBoxDimensions().getY();
      float otherBottomEdge = otherBox.getCenterPosition().getY() - otherBox.getBoxDimensions().getY();
      float otherRightEdge = otherBox.getCenterPosition().getX() + otherBox.getBoxDimensions().getX();
      float otherLeftEdge = otherBox.getCenterPosition().getX() - otherBox.getBoxDimensions().getX();

      // Check Top-Right
      if(getCenterPosition().getY() >= otherBoxCenter.getY() &&
          getCenterPosition().getX() >= otherBoxCenter.getX()) {

        // Check along the Top edge for collision
        for(float i = otherLeftEdge; i <= otherRightEdge; i+= 0.05f) { // Check every .05 along the top edge of BoxCollider
          // Start Circle Difference Formula
          double partOne = Math.pow(getCenterPosition().getX() - i, 2);
          double partTwo = Math.pow(getCenterPosition().getY() - otherTopEdge, 2);
          double differenceFormula = Math.sqrt(partOne + partTwo);
          // End Circle Difference Formula

          // This has to be subtracted or there will be a rounding error
          differenceFormula -= .0000000000000122;

          // If the result of the equation is less than or equal to the radius then they have collided
          if(differenceFormula <= getRadius()) {
            return true;
          }
        }
        //Check along the Right edge for collision
        for(float i = otherTopEdge; i >= otherBottomEdge; i -= 0.05f) { // Check every .05 along the right edge of BoxCollider
          // Start Circle Difference Formula
          double partOne = Math.pow(getCenterPosition().getX() - otherRightEdge, 2);
          double partTwo = Math.pow(getCenterPosition().getY() - i, 2);
          double differenceFormula = Math.sqrt(partOne + partTwo);
          // End Circle Difference Formula

          // This has to be subtracted or there will be a rounding error
          differenceFormula -= .0000000000000122;

          // If the result of the equation is less than or equal to the radius then they have collided
          if(differenceFormula <= getRadius()) {
            return true;
          }
        }

      }
      // Check Bottom-Right
      else if(getCenterPosition().getY() < otherBoxCenter.getY() &&
          getCenterPosition().getX() >= otherBoxCenter.getX()) {

        //Check along the Right edge for collision
        for(float i = otherTopEdge; i >= otherBottomEdge; i -= 0.05f) { // Check every .05 along the right edge of BoxCollider
          // Start Circle Difference Formula
          double partOne = Math.pow(getCenterPosition().getX() - otherRightEdge, 2);
          double partTwo = Math.pow(getCenterPosition().getY() - i, 2);
          double differenceFormula = Math.sqrt(partOne + partTwo);
          // End Circle Difference Formula

          // This has to be subtracted or there will be a rounding error
          differenceFormula -= .0000000000000122;

          // If the result of the equation is less than or equal to the radius then they have collided
          if(differenceFormula <= getRadius()) {
            return true;
          }
        }
        // Check along the Bottom edge for collision
        for(float i = otherRightEdge; i >= otherLeftEdge; i-= 0.05f) { // Check every .05 along the top edge of BoxCollider
          // Start Circle Difference Formula
          double partOne = Math.pow(getCenterPosition().getX() - i, 2);
          double partTwo = Math.pow(getCenterPosition().getY() - otherBottomEdge, 2);
          double differenceFormula = Math.sqrt(partOne + partTwo);
          // End Circle Difference Formula

          // This has to be subtracted or there will be a rounding error
          differenceFormula -= .0000000000000122;

          // If the result of the equation is less than or equal to the radius then they have collided
          if(differenceFormula <= getRadius()) {
            return true;
          }
        }

      }
      // Check Bottom-Left
      else if(getCenterPosition().getY() < otherBoxCenter.getY() &&
          getCenterPosition().getX() < otherBoxCenter.getX()) {

        // Check along the Bottom edge for collision
        for(float i = otherLeftEdge; i <= otherRightEdge; i+= 0.05f) { // Check every .05 along the top edge of BoxCollider
          // Start Circle Difference Formula
          double partOne = Math.pow(getCenterPosition().getX() - i, 2);
          double partTwo = Math.pow(getCenterPosition().getY() - otherBottomEdge, 2);
          double differenceFormula = Math.sqrt(partOne + partTwo);
          // End Circle Difference Formula

          // This has to be subtracted or there will be a rounding error
          differenceFormula -= .0000000000000122;

          // If the result of the equation is less than or equal to the radius then they have collided
          if(differenceFormula <= getRadius()) {
            return true;
          }
        }

        //Check along the Left edge for collision
        for(float i = otherTopEdge; i >= otherBottomEdge; i -= 0.05f) { // Check every .05 along the right edge of BoxCollider
          // Start Circle Difference Formula
          double partOne = Math.pow(getCenterPosition().getX() - otherLeftEdge, 2);
          double partTwo = Math.pow(getCenterPosition().getY() - i, 2);
          double differenceFormula = Math.sqrt(partOne + partTwo);
          // End Circle Difference Formula

          // This has to be subtracted or there will be a rounding error
          differenceFormula -= .0000000000000122;

          // If the result of the equation is less than or equal to the radius then they have collided
          if(differenceFormula <= getRadius()) {
            return true;
          }
        }

      }
      // Check Top-Left
      else if(getCenterPosition().getY() >= otherBoxCenter.getY() &&
          getCenterPosition().getX() < otherBoxCenter.getX()) {

        // Check along the Top edge for collision
        for(float i = otherLeftEdge; i <= otherRightEdge; i+= 0.05f) { // Check every .05 along the top edge of BoxCollider
          // Start Circle Difference Formula
          double partOne = Math.pow(getCenterPosition().getX() - i, 2);
          double partTwo = Math.pow(getCenterPosition().getY() - otherTopEdge, 2);
          double differenceFormula = Math.sqrt(partOne + partTwo);
          // End Circle Difference Formula

          // This has to be subtracted or there will be a rounding error
          differenceFormula -= .0000000000000122;

          // If the result of the equation is less than or equal to the radius then they have collided
          if(differenceFormula <= getRadius()) {
            return true;
          }
        }

        //Check along the Left edge for collision
        for(float i = otherTopEdge; i >= otherBottomEdge; i -= 0.05f) { // Check every .05 along the right edge of BoxCollider
          // Start Circle Difference Formula
          double partOne = Math.pow(getCenterPosition().getX() - otherLeftEdge, 2);
          double partTwo = Math.pow(getCenterPosition().getY() - i, 2);
          double differenceFormula = Math.sqrt(partOne + partTwo);
          // End Circle Difference Formula

          // This has to be subtracted or there will be a rounding error
          differenceFormula -= .0000000000000122;

          // If the result of the equation is less than or equal to the radius then they have collided
          if(differenceFormula <= getRadius()) {
            return true;
          }
        }
      }
    }

    return false;
  }

}

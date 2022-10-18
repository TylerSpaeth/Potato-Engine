package GameEngine.GameObject.Components.Colliders;

import GameEngine.Vector2.Vector2;

/**
 * A rectangular Collider.
 *
 * @author Tyler Spaeth
 */
public class BoxCollider extends Collider {

  private Vector2 boxDimensions;

  /**
   * Constructor for a BoxCollider object
   *
   * @param centerPosition a Vector2 of the position of the BoxCollider
   * @param isTrigger a boolean for if this BoxCollider should act as a trigger
   * @param boxDimensions a Vector2 of the dimensions of the BoxCollider
   */
  public BoxCollider(Vector2 centerPosition, boolean isTrigger, Vector2 boxDimensions) {
    super(centerPosition, isTrigger);
    this.boxDimensions = boxDimensions;
    this.type = Type.BOX;
  }

  /**
   * Getter for the boxDimensions variable
   *
   * @return a Vector2 of the dimensions of the BoxCollider
   */
  public Vector2 getBoxDimensions() {
    return boxDimensions;
  }

  /**
   * Sets the dimensions of the BoxCollider
   *
   * @param boxDimensions a Vector2 representing the desired dimensions of this BoxCollider
   */
  public void setBoxDimensions(Vector2 boxDimensions) {
    this.boxDimensions = boxDimensions;
  }

  /**
   * Checks if this BoxCollider collided with the given Collider
   *
   * @param other the Collider to check if there was collision with
   * @return true if there is collision
   */
  @Override
  public boolean collided(Collider other) {
    //TODO implement trigger collision
    float topEdge = getCenterPosition().getY() + getBoxDimensions().getY();
    float bottomEdge = getCenterPosition().getY() - getBoxDimensions().getY();
    float rightEdge = getCenterPosition().getX() + getBoxDimensions().getX();
    float leftEdge = getCenterPosition().getX() - getBoxDimensions().getX();

    // Begin collision with a BoxCollider
    if(other.type == Type.BOX) {
      BoxCollider otherBox = (BoxCollider) other; // Cast to BoxCollider for BoxCollider methods
      float otherTopEdge = otherBox.getCenterPosition().getY() + otherBox.getBoxDimensions().getY();
      float otherBottomEdge = otherBox.getCenterPosition().getY() - otherBox.getBoxDimensions().getY();
      float otherRightEdge = otherBox.getCenterPosition().getX() + otherBox.getBoxDimensions().getX();
      float otherLeftEdge = otherBox.getCenterPosition().getX() - otherBox.getBoxDimensions().getX();

      // Checking if otherObject collides from the right
      if(rightEdge >= otherLeftEdge && (topEdge >= otherBottomEdge || bottomEdge >= otherTopEdge)) {
        return true;
      }
      // Checking if other collided from the left
      else if (leftEdge >= otherRightEdge && (topEdge >= otherBottomEdge || bottomEdge >= otherTopEdge)) {
        return true;
      }
      // Checking if other collided from the top
      else if (topEdge >= otherBottomEdge && (leftEdge >= otherRightEdge || rightEdge >= otherLeftEdge)) {
        return true;
      }
      // Checking if other collided from the bottom
      else if (bottomEdge <= otherTopEdge && (leftEdge >= otherRightEdge || rightEdge >= otherLeftEdge)) {
        return true;
      }

    }
    // Begin Collision with a CircleCollider
    else if (other.type == Type.CIRCLE) {
      //TODO only check the corners not the whole side - for optimization sake
      CircleCollider circle = (CircleCollider) other;
      Vector2 circleCenter = circle.getCenterPosition();
      float circleRadius = circle.getRadius();

      // Check Top-Right
      if(circleCenter.getY() >= getCenterPosition().getY() &&
          circleCenter.getX() >= getCenterPosition().getX()) {

        // Check along the Top edge for collision
        for(float i = leftEdge; i <= rightEdge; i+= 0.05f) { // Check every .05 along the top edge of BoxCollider
          // Start Circle Difference Formula
          double partOne = Math.pow(circleCenter.getX() - i, 2);
          double partTwo = Math.pow(circleCenter.getY() - topEdge, 2);
          double differenceFormula = Math.sqrt(partOne + partTwo);
          // End Circle Difference Formula

          // This has to be subtracted or there will be a rounding error
          differenceFormula -= .0000000000000122;

          // If the result of the equation is less than or equal to the radius then they have collided
          if(differenceFormula <= circleRadius) {
            return true;
          }
        }
        //Check along the Right edge for collision
        for(float i = topEdge; i >= bottomEdge; i -= 0.05f) { // Check every .05 along the right edge of BoxCollider
          // Start Circle Difference Formula
          double partOne = Math.pow(circleCenter.getX() - rightEdge, 2);
          double partTwo = Math.pow(circleCenter.getY() - i, 2);
          double differenceFormula = Math.sqrt(partOne + partTwo);
          // End Circle Difference Formula

          // This has to be subtracted or there will be a rounding error
          differenceFormula -= .0000000000000122;

          // If the result of the equation is less than or equal to the radius then they have collided
          if(differenceFormula <= circleRadius) {
            return true;
          }
        }

      }
      // Check Bottom-Right
      else if(circleCenter.getY() < getCenterPosition().getY() &&
          circleCenter.getX() >= getCenterPosition().getX()) {

        //Check along the Right edge for collision
        for(float i = topEdge; i >= bottomEdge; i -= 0.05f) { // Check every .05 along the right edge of BoxCollider
          // Start Circle Difference Formula
          double partOne = Math.pow(circleCenter.getX() - rightEdge, 2);
          double partTwo = Math.pow(circleCenter.getY() - i, 2);
          double differenceFormula = Math.sqrt(partOne + partTwo);
          // End Circle Difference Formula

          // This has to be subtracted or there will be a rounding error
          differenceFormula -= .0000000000000122;

          // If the result of the equation is less than or equal to the radius then they have collided
          if(differenceFormula <= circleRadius) {
            return true;
          }
        }
        // Check along the Bottom edge for collision
        for(float i = rightEdge; i >= leftEdge; i-= 0.05f) { // Check every .05 along the top edge of BoxCollider
          // Start Circle Difference Formula
          double partOne = Math.pow(circleCenter.getX() - i, 2);
          double partTwo = Math.pow(circleCenter.getY() - bottomEdge, 2);
          double differenceFormula = Math.sqrt(partOne + partTwo);
          // End Circle Difference Formula

          // This has to be subtracted or there will be a rounding error
          differenceFormula -= .0000000000000122;

          // If the result of the equation is less than or equal to the radius then they have collided
          if(differenceFormula <= circleRadius) {
            return true;
          }
        }

      }
      // Check Bottom-Left
      else if(circleCenter.getY() < getCenterPosition().getY() &&
          circleCenter.getX() < getCenterPosition().getX()) {

        // Check along the Bottom edge for collision
        for(float i = leftEdge; i <= rightEdge; i+= 0.05f) { // Check every .05 along the top edge of BoxCollider
          // Start Circle Difference Formula
          double partOne = Math.pow(circleCenter.getX() - i, 2);
          double partTwo = Math.pow(circleCenter.getY() - bottomEdge, 2);
          double differenceFormula = Math.sqrt(partOne + partTwo);
          // End Circle Difference Formula

          // This has to be subtracted or there will be a rounding error
          differenceFormula -= .0000000000000122;

          // If the result of the equation is less than or equal to the radius then they have collided
          if(differenceFormula <= circleRadius) {
            return true;
          }
        }

        //Check along the Left edge for collision
        for(float i = topEdge; i >= bottomEdge; i -= 0.05f) { // Check every .05 along the right edge of BoxCollider
          // Start Circle Difference Formula
          double partOne = Math.pow(circleCenter.getX() - leftEdge, 2);
          double partTwo = Math.pow(circleCenter.getY() - i, 2);
          double differenceFormula = Math.sqrt(partOne + partTwo);
          // End Circle Difference Formula

          // This has to be subtracted or there will be a rounding error
          differenceFormula -= .0000000000000122;

          // If the result of the equation is less than or equal to the radius then they have collided
          if(differenceFormula <= circleRadius) {
            return true;
          }
        }

      }
      // Check Top-Left
      else if(circleCenter.getY() >= getCenterPosition().getY() &&
          circleCenter.getX() < getCenterPosition().getX()) {

        // Check along the Top edge for collision
        for(float i = leftEdge; i <= rightEdge; i+= 0.05f) { // Check every .05 along the top edge of BoxCollider
          // Start Circle Difference Formula
          double partOne = Math.pow(circleCenter.getX() - i, 2);
          double partTwo = Math.pow(circleCenter.getY() - topEdge, 2);
          double differenceFormula = Math.sqrt(partOne + partTwo);
          // End Circle Difference Formula

          // This has to be subtracted or there will be a rounding error
          differenceFormula -= .0000000000000122;

          // If the result of the equation is less than or equal to the radius then they have collided
          if(differenceFormula <= circleRadius) {
            return true;
          }
        }

        //Check along the Left edge for collision
        for(float i = topEdge; i >= bottomEdge; i -= 0.05f) { // Check every .05 along the right edge of BoxCollider
          // Start Circle Difference Formula
          double partOne = Math.pow(circleCenter.getX() - leftEdge, 2);
          double partTwo = Math.pow(circleCenter.getY() - i, 2);
          double differenceFormula = Math.sqrt(partOne + partTwo);
          // End Circle Difference Formula

          // This has to be subtracted or there will be a rounding error
          differenceFormula -= .0000000000000122;

          // If the result of the equation is less than or equal to the radius then they have collided
          if(differenceFormula <= circleRadius) {
            return true;
          }
        }
      }
    }

    return false; // If there is no collision
  }
}

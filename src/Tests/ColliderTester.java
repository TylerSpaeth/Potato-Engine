package Tests;

import GameEngine.GameObjects.Components.Colliders.BoxCollider;
import GameEngine.GameObjects.Components.Colliders.CircleCollider;
import GameEngine.Utils.Vector2.Vector2;

/**
 * Tester for the Collider object along with its derived objects
 *
 * @author Tyler Spaeth
 */
public class ColliderTester {

  /**
   * Runs all the tests in this class
   *
   * @return true if all tests pass, otherwise false
   */
  public static boolean runAllTests()  {
    return testBoxCollider()
        && testCircleCollider();
  }

  /**
   * Tester for the BoxCollider object
   *
   * @return true if all tests pass, otherwise false
   */
  private static boolean testBoxCollider() {

    // (1) Test collision with a box collider that should have collided
    {
      BoxCollider testCollider = new BoxCollider(new Vector2(0, 0),
          false, new Vector2(1, 1));
      BoxCollider otherCollider = new BoxCollider(new Vector2(3, 1),
          false, new Vector2(4, 4));
      if (testCollider.collided(otherCollider) == false) {
        System.err.println("testBoxCollider test 1 has failed. A collision was expected " +
            "but did not happen.");
        return false;
      }
    }
    // (2) Test with a collider that is overlapping directly
    {
      BoxCollider testCollider = new BoxCollider(new Vector2(0, 0),
          false, new Vector2(3, 3));
      if (testCollider.collided(testCollider) == false) {
        System.err.println("testBoxCollider test 2 has failed. A collision was expected " +
            "but did not happen.");
        return false;
      }
    }
    // (3) Test with a collider that has no size, just a center
    {
      BoxCollider testCollider = new BoxCollider(new Vector2(0, 0),
          false, new Vector2(1, 1));
      BoxCollider otherCollider = new BoxCollider(new Vector2(.5f, .5f),
          false, new Vector2(0, 0));
      if (testCollider.collided(otherCollider) == false) {
        System.err.println("testBoxCollider test 3 has failed. A collision was expected " +
            "but did not happen.");
        return false;
      }
    }
    // (4) Test with a collider that shouldn't collide
    {
      BoxCollider testCollider = new BoxCollider(new Vector2(0, 0),
          false, new Vector2(1, 1));
      BoxCollider otherCollider = new BoxCollider(new Vector2(4, 4),
          false, new Vector2(1, 1));
      if (testCollider.collided(otherCollider) == true) {
        System.err.println("testBoxCollider test 4 has failed. A collision was not expected " +
            "but happened.");
        return false;
      }
    }
    // (5) Test Top Collision
    {
      BoxCollider testCollider = new BoxCollider(new Vector2(0, 0),
          false, new Vector2(1, 1));
      BoxCollider otherCollider = new BoxCollider(new Vector2(0, 2),
          false, new Vector2(1, 1));
      if (testCollider.collided(otherCollider) == false) {
        System.err.println("testBoxCollider test 5 has failed. A collision was expected " +
            "but did not happened.");
        return false;
      }
    }
    // (6) Test Bottom Collision
    {
      BoxCollider testCollider = new BoxCollider(new Vector2(0, 0),
          false, new Vector2(1, 1));
      BoxCollider otherCollider = new BoxCollider(new Vector2(0, -2),
          false, new Vector2(1, 1));
      if (testCollider.collided(otherCollider) == false) {
        System.err.println("testBoxCollider test 6 has failed. A collision was expected " +
            "but did not happened.");
        return false;
      }
    }
    // (7) Test Right Collision
    {
      BoxCollider testCollider = new BoxCollider(new Vector2(0, 0),
          false, new Vector2(1, 1));
      BoxCollider otherCollider = new BoxCollider(new Vector2(2, 0),
          false, new Vector2(1, 1));
      if (testCollider.collided(otherCollider) == false) {
        System.err.println("testBoxCollider test 7 has failed. A collision was expected " +
            "but did not happened.");
        return false;
      }
    }
    // (8) Test Left Collision
    {
      BoxCollider testCollider = new BoxCollider(new Vector2(0, 0),
          false, new Vector2(1, 1));
      BoxCollider otherCollider = new BoxCollider(new Vector2(-2, 0),
          false, new Vector2(1, 1));
      if (testCollider.collided(otherCollider) == false) {
        System.err.println("testBoxCollider test 8 has failed. A collision was expected " +
            "but did not happened.");
        return false;
      }
    }

    // (9) Test Collision against a CircleCollider from the Top
    {
      BoxCollider testCollider = new BoxCollider(new Vector2(0, 0),
          false, new Vector2(1, 1));
      CircleCollider circleCollider = new CircleCollider(new Vector2(0, 2),
          false, 1);
      if (testCollider.collided(circleCollider) == false) {
        System.err.println("testBoxCollider test 9 has failed. A collision was expected " +
            "but did not happened.");
        return false;
      }
    }
    // (10) Test Collision against a CircleCollider from the Right
    {
      BoxCollider testCollider = new BoxCollider(new Vector2(0, 0),
          false, new Vector2(1, 1));
      CircleCollider circleCollider = new CircleCollider(new Vector2(2, 0),
          false, 1);
      if (testCollider.collided(circleCollider) == false) {
        System.err.println("testBoxCollider test 10 has failed. A collision was expected " +
            "but did not happened.");
        return false;
      }
    }
    // (11) Test Collision against a CircleCollider from the Bottom
    {
      BoxCollider testCollider = new BoxCollider(new Vector2(0, 0),
          false, new Vector2(1, 1));
      CircleCollider circleCollider = new CircleCollider(new Vector2(0, -2),
          false, 1);
      if (testCollider.collided(circleCollider) == false) {
        System.err.println("testBoxCollider test 11 has failed. A collision was expected " +
            "but did not happened.");
        return false;
      }
    }
    // (12) Test Collision against a CircleCollider from the Left
    {
      BoxCollider testCollider = new BoxCollider(new Vector2(0, 0),
          false, new Vector2(1, 1));
      CircleCollider circleCollider = new CircleCollider(new Vector2(-2, 0),
          false, 1);
      if (testCollider.collided(circleCollider) == false) {
        System.err.println("testBoxCollider test 12 has failed. A collision was expected " +
            "but did not happened.");
        return false;
      }
    }
    // (13) Test Collision against on CircleCollider in the Top-Right corner
    {
      BoxCollider testCollider = new BoxCollider(new Vector2(0, 0),
          false, new Vector2(1, 1));
      CircleCollider circleCollider = new CircleCollider(new Vector2(1.707f, 1.707f),
          false, 1);
      if (testCollider.collided(circleCollider) == false) {
        System.err.println("testBoxCollider test 13 has failed. A collision was expected " +
            "but did not happened.");
        return false;
      }
    }
    // (14) Test Collision against on CircleCollider in the Top-Left corner
    {
      BoxCollider testCollider = new BoxCollider(new Vector2(0, 0),
          false, new Vector2(1, 1));
      CircleCollider circleCollider = new CircleCollider(new Vector2(-1.707f, 1.707f),
          false, 1);
      if (testCollider.collided(circleCollider) == false) {
        System.err.println("testBoxCollider test 14 has failed. A collision was expected " +
            "but did not happened.");
        return false;
      }
    }
    // (15) Test Collision against on CircleCollider in the Bottom-Left corner
    {
      BoxCollider testCollider = new BoxCollider(new Vector2(0, 0),
          false, new Vector2(1, 1));
      CircleCollider circleCollider = new CircleCollider(new Vector2(-1.707f, -1.707f),
          false, 1);
      if (testCollider.collided(circleCollider) == false) {
        System.err.println("testBoxCollider test 15 has failed. A collision was expected " +
            "but did not happened.");
        return false;
      }
    }
    // (16) Test Collision against on CircleCollider in the Bottom-Right corner
    {
      BoxCollider testCollider = new BoxCollider(new Vector2(0, 0),
          false, new Vector2(1, 1));
      CircleCollider circleCollider = new CircleCollider(new Vector2(1.707f, -1.707f),
          false, 1);
      if (testCollider.collided(circleCollider) == false) {
        System.err.println("testBoxCollider test 16 has failed. A collision was expected " +
            "but did not happened.");
        return false;
      }
    }
    // (17) Test collision on a CircleCollider that shouldn't collide
    {
      BoxCollider testCollider = new BoxCollider(new Vector2(0, 0),
          false, new Vector2(1, 1));
      CircleCollider circleCollider = new CircleCollider(new Vector2(50, 11),
          false, 1);
      if (testCollider.collided(circleCollider) == true) {
        System.err.println("testBoxCollider test 17 has failed. A collision was not expected " +
            "but happened.");
        return false;
      }

      return true; // If all tests pass
    }
  }

  /**
   * Tester for the BoxCollider object
   *
   * @return true if all tests pass, otherwise false
   */
  private static boolean testCircleCollider() {

    // (1) Test Collision with another circle that it should collide with
    {
      CircleCollider testCollider = new CircleCollider(new Vector2(0,0),
          false, 1);
      CircleCollider otherTestCollider = new CircleCollider(new Vector2(2,0),
          false, 1);
      if(testCollider.collided(otherTestCollider) == false) {
        System.err.println("testCircleCollider test 1 failed. " +
            "Collision was expected but did not happen.");
        return false;
      }
    }
    // (2) Test collision with a circle in same position
    {
      CircleCollider testCollider = new CircleCollider(new Vector2(0,0),
          false, 1);
      if(testCollider.collided(testCollider) == false) {
        System.err.println("testCircleCollider test 2 failed. " +
            "Collision was expected but did not happen.");
        return false;
      }
    }
    // (3) Test Collision against a BoxCollider from the Bottom
    {
      BoxCollider testCollider = new BoxCollider(new Vector2(0, 0),
          false, new Vector2(1, 1));
      CircleCollider circleCollider = new CircleCollider(new Vector2(0, 2),
          false, 1);
      if (circleCollider.collided(testCollider) == false) {
        System.err.println("testCircleCollider test 3 has failed. A collision was expected " +
            "but did not happened.");
        return false;
      }
    }
    // (4) Test Collision against a BoxCollider from the Left
    {
      BoxCollider testCollider = new BoxCollider(new Vector2(0, 0),
          false, new Vector2(1, 1));
      CircleCollider circleCollider = new CircleCollider(new Vector2(2, 0),
          false, 1);
      if (circleCollider.collided(testCollider) == false) {
        System.err.println("testCircleCollider test 4 has failed. A collision was expected " +
            "but did not happened.");
        return false;
      }
    }
    // (5) Test Collision against a BoxCollider from the Top
    {
      BoxCollider testCollider = new BoxCollider(new Vector2(0, 0),
          false, new Vector2(1, 1));
      CircleCollider circleCollider = new CircleCollider(new Vector2(0, -2),
          false, 1);
      if (circleCollider.collided(testCollider) == false) {
        System.err.println("testCircleCollider test 5 has failed. A collision was expected " +
            "but did not happened.");
        return false;
      }
    }
    // (5) Test Collision against a BoxCollider from the Right
    {
      BoxCollider testCollider = new BoxCollider(new Vector2(0, 0),
          false, new Vector2(1, 1));
      CircleCollider circleCollider = new CircleCollider(new Vector2(-2, 0),
          false, 1);
      if (circleCollider.collided(testCollider) == false) {
        System.err.println("testCircleCollider test 5 has failed. A collision was expected " +
            "but did not happened.");
        return false;
      }
    }
    // (6) Test Collision against on BoxCollider in the Bottom-Left corner
    {
      BoxCollider testCollider = new BoxCollider(new Vector2(0, 0),
          false, new Vector2(1, 1));
      CircleCollider circleCollider = new CircleCollider(new Vector2(1.707f, 1.707f),
          false, 1);
      if (circleCollider.collided(testCollider) == false) {
        System.err.println("testCircleCollider test 6 has failed. A collision was expected " +
            "but did not happened.");
        return false;
      }
    }
    // (7) Test Collision against on BoxCollider in the Bottom-Right corner
    {
      BoxCollider testCollider = new BoxCollider(new Vector2(0, 0),
          false, new Vector2(1, 1));
      CircleCollider circleCollider = new CircleCollider(new Vector2(-1.707f, 1.707f),
          false, 1);
      if (circleCollider.collided(testCollider) == false) {
        System.err.println("testCircleCollider test 7 has failed. A collision was expected " +
            "but did not happened.");
        return false;
      }
    }
    // (8) Test Collision against on BoxCollider in the Top-Right corner
    {
      BoxCollider testCollider = new BoxCollider(new Vector2(0, 0),
          false, new Vector2(1, 1));
      CircleCollider circleCollider = new CircleCollider(new Vector2(-1.707f, -1.707f),
          false, 1);
      if (circleCollider.collided(testCollider) == false) {
        System.err.println("testCircleCollider test 8 has failed. A collision was expected " +
            "but did not happened.");
        return false;
      }
    }
    // (9) Test Collision against on BoxCollider in the Top-Left corner
    {
      BoxCollider testCollider = new BoxCollider(new Vector2(0, 0),
          false, new Vector2(1, 1));
      CircleCollider circleCollider = new CircleCollider(new Vector2(1.707f, -1.707f),
          false, 1);
      if (circleCollider.collided(testCollider) == false) {
        System.err.println("testCircleCollider test 9 has failed. A collision was expected " +
            "but did not happened.");
        return false;
      }
    }

    return true; // If all tests pass
  }

}

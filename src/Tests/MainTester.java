package Tests;

/**
 * The main tester class that combines all the other classes
 */
public class MainTester {

  /**
   * Runs all the tests and outputs the results
   *
   * @return the results of all the tests
   */
  public static String runAllTests() {
    return "All Tests Passed: " + ColliderTester.runAllTests();
  }

}

import org.lwjgl.*;
import org.lwjgl.glfw.*;
import org.lwjgl.opengl.*;
import org.lwjgl.system.*;

import java.nio.*;

import static org.lwjgl.glfw.Callbacks.*;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryStack.*;
import static org.lwjgl.system.MemoryUtil.*;

/**
 * This class holds the functionality of a window for the Potato Engine
 *
 * @author Tyler Spaeth
 */
public class Window {

  // Variable to store the handle of the window.
  private long window;
  // Variables for window size
  private int width;
  private int height;

  /**
   * Constructor for the window object
   *
   * @param width the width in pixels of the window
   * @param height the height in pixels of the window
   * @param title title for the window
   */
  public Window(int width, int height, String title) {

    // Initialize GLFW. GLFW will not work without this.
    if (!glfwInit()) {
      throw new IllegalStateException("Unable to initialize GLFW");
    }

    // Create the window and assign the handle
    window = glfwCreateWindow(width, height, title, 0, 0);
    // If the window handle has not been changed from its default value of zero, a window has not
    // been created
    if(window == 0) {
      throw new RuntimeException("Failed to create the GLFW window");
    }
    glfwShowWindow(window);

  }


  public void run() {}

  public void init() {}

  public void loop() {}


}

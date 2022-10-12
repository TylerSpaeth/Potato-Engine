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
 * This class holds the functionality of a window for the Potato Engine.
 *
 * Makes use of LWJGL libraries.
 *
 * @see <a href="https://www.lwjgl.org/guide">https://www.lwjgl.org/guide</a>
 *
 * @author Tyler Spaeth
 */
public class Window {

  // Variable to store the handle of the window.
  private long window;
  // Variables for window size
  private int width;
  private int height;
  private String title;

  /**
   * Constructor for the window object
   *
   * @param width the width in pixels of the window
   * @param height the height in pixels of the window
   * @param title title for the window
   */
  public Window(int width, int height, String title) {
    this.width = width;
    this.height = height;
    this.title = title;
  }


  public void run() {}

  /**
   * Method for initializing the window.
   * *Mainly just  the boilerplate code defined by the LWJGL sample*
   *
   * @see <a href="https://www.lwjgl.org/guide">https://www.lwjgl.org/guide</a>
   */
  public void init() {
    // Initializes the error callback to print to system.err
    GLFWErrorCallback.createPrint(System.err).set();

    // Initialize GLFW. GLFW will not work without this.
    if (!glfwInit()) {
      throw new IllegalStateException("Unable to initialize GLFW");
    }

    // Configuration for GLFW
    glfwDefaultWindowHints();
    glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE);
    glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE);

    // Create the window and assign the handle
    window = glfwCreateWindow(width, height, title, 0, 0);
    // If the window handle has not been changed from its default value of zero, a window has not
    // been created
    if(window == 0) {
      throw new RuntimeException("Failed to create the GLFW window");
    }

    // Setup a key callback. It will be called every time a key is pressed, repeated or released.
    glfwSetKeyCallback(window, (window, key, scancode, action, mods) -> {
      if ( key == GLFW_KEY_ESCAPE && action == GLFW_RELEASE )
        glfwSetWindowShouldClose(window, true); // We will detect this in the rendering loop
    });

    // Get the thread stack and push a new frame
    try ( MemoryStack stack = stackPush() ) {
      IntBuffer pWidth = stack.mallocInt(1); // int*
      IntBuffer pHeight = stack.mallocInt(1); // int*

      // Get the window size passed to glfwCreateWindow
      glfwGetWindowSize(window, pWidth, pHeight);

      // Get the resolution of the primary monitor
      GLFWVidMode vidmode = glfwGetVideoMode(glfwGetPrimaryMonitor());

      // Center the window
      glfwSetWindowPos(
          window,
          (vidmode.width() - pWidth.get(0)) / 2,
          (vidmode.height() - pHeight.get(0)) / 2
      );
    } // the stack frame is popped automatically

    // Make the OpenGL context current
    glfwMakeContextCurrent(window);
    // Enable v-sync
    glfwSwapInterval(1);

    // Makes the window visible
    glfwShowWindow(window);
  }

  /**
   * Method for updating the window.
   * *Much of the code comes from the loop method defined in the LWJGL sample*
   *
   * @see <a href="https://www.lwjgl.org/guide">https://www.lwjgl.org/guide</a>
   */
  public void update() {
    // TODO this method needs to be changed so that it is not handling if the window should close
    // This line is critical for LWJGL's interoperation with GLFW's
    // OpenGL context, or any context that is managed externally.
    // LWJGL detects the context that is current in the current thread,
    // creates the GLCapabilities instance and makes the OpenGL
    // bindings available for use.
    GL.createCapabilities();

    // Setup clear color
    glClearColor(1,0,0,0);

    // Run the rendering loop until the user has attempted to close
    // the window or has pressed the ESCAPE key.
    while (!glfwWindowShouldClose(window)) {
      glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT); // clear the framebuffer

      glfwSwapBuffers(window); // swap the color buffers

      // Poll for window events. The key callback above will only be
      // invoked during this call.
      glfwPollEvents();
    }
  }

}

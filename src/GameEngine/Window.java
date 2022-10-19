package GameEngine;

import org.lwjgl.glfw.*;
import org.lwjgl.opengl.*;
import org.lwjgl.system.*;

import java.nio.*;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryStack.*;

/**
 * This class holds the functionality of a window for the Potato GameEngine.Engine. Windows are a singleton
 * so only one may exist at a time.
 * <br>
 * <br>
 * Makes use of LWJGL libraries.
 *
 * @see <a href="https://www.lwjgl.org/guide">https://www.lwjgl.org/guide</a>
 *
 * @author Tyler Spaeth
 */
public class Window {
  // TODO this class needs to be overhauled in order to be more modular and work better with other
  //  components. Also make sure that the way it interacts with the Engine is correct


  // Variable for the one window that will exist
  private static Window _window = null;

  // Variable to store the handle of the window.
  private long windowHandle;

  private boolean shouldClose; // Determines whether the window should close

  // Variables for window attributes
  private int width;
  private int height;
  private final String title;
  private boolean vsync;

  /**
   * Constructor for the window object
   *
   * @param width the width in pixels of the window
   * @param height the height in pixels of the window
   * @param title title for the window
   */
  public Window(int width, int height, String title) {
    // If another window already exist throw an exception. This way only one can exist
    if(_window != null) {
      throw new IllegalStateException("A window has already been initialized, only one may exist" +
          " at a time ");
    }
    // Set the window instance to this one
    _window = this;

    this.width = width;
    this.height = height;
    this.title = title;
    this.vsync = true;
  }

  /**
   * Constructor for the window object
   *
   * @param width the width in pixels of the window
   * @param height the height in pixels of the window
   * @param title title for the window
   * @param vsync whether vsync should be enabled or not
   */
  public Window(int width, int height, String title, boolean vsync) {
    // If another window already exist throw an exception. This way only one can exist
    if(_window != null) {
      throw new IllegalStateException("A window has already been initialized, only one may exist" +
          " at a time ");
    }
    // Set the window instance to this one
    _window = this;

    this.width = width;
    this.height = height;
    this.title = title;
    this.vsync = vsync;
  }

  /**
   * Method for initializing the window.
   * <br>
   * <br>
   * *Mainly just the boilerplate code defined by the LWJGL sample*
   *
   * @see <a href="https://www.lwjgl.org/guide">https://www.lwjgl.org/guide</a>
   */
  public void init() {
    this.shouldClose = false;

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
    glfwWindowHint(GLFW_DECORATED, GLFW_FALSE); // Makes the window not have any border

    // Create the window and assign the handle
    windowHandle = glfwCreateWindow(width, height, title, 0, 0);
    // If the window handle has not been changed from its default value of zero, a window has not
    // been created
    if(windowHandle == 0) {
      throw new RuntimeException("Failed to create the GLFW window");
    }

    // Setup a key callback. It will be called every time a key is pressed, repeated or released.
    glfwSetKeyCallback(windowHandle, (window, key, scancode, action, mods) -> {
      if ( key == GLFW_KEY_ESCAPE && action == GLFW_RELEASE )
        glfwSetWindowShouldClose(window, true); // We will detect this in the rendering loop
    });

    // Get the thread stack and push a new frame
    try (MemoryStack stack = stackPush()) {
      IntBuffer pWidth = stack.mallocInt(1); // int*
      IntBuffer pHeight = stack.mallocInt(1); // int*

      // Get the window size passed to glfwCreateWindow
      glfwGetWindowSize(windowHandle, pWidth, pHeight);

      // Get the resolution of the primary monitor
      GLFWVidMode vidMode = glfwGetVideoMode(glfwGetPrimaryMonitor());

      // Center the window
      glfwSetWindowPos(
          windowHandle,
          (vidMode.width() - pWidth.get(0)) / 2, // Screen width - window width / 2
          (vidMode.height() - pHeight.get(0)) / 2 // screen height - window height / 2
      );
    } // the stack frame is popped automatically

    // Make the OpenGL context current
    glfwMakeContextCurrent(windowHandle);

    if(vsyncEnabled()) {
      // Enable v-sync
      glfwSwapInterval(1);
    }

    // Makes the window visible
    glfwShowWindow(windowHandle);


    // This line is critical for LWJGL's interoperation with GLFW's
    // OpenGL context, or any context that is managed externally.
    // LWJGL detects the context that is current in the current thread,
    // creates the GLCapabilities instance and makes the OpenGL
    // bindings available for use.
    GL.createCapabilities();

    // Setup clear color
    glClearColor(1,0,0,0);
  }

  /**
   * Method for updating the window.
   * <br>
   * <br>
   * *Much of the code comes from the loop method defined in the LWJGL sample*
   *
   * @see <a href="https://www.lwjgl.org/guide">https://www.lwjgl.org/guide</a>
   */
  public void update() {
    // Run the rendering loop until the user has attempted to close
    // the window or has pressed the ESCAPE key.
    if (!glfwWindowShouldClose(windowHandle)) {
      glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT); // clear the framebuffer

      glfwSwapBuffers(windowHandle); // swap the color buffers

      // Poll for window events. The key callback above will only be
      // invoked during this call.
      glfwPollEvents();
    }
    else {
      shouldClose = true;
    }


  }

  /**
   * Closes the window
   */
  public void closeWindow() {
    // Destroy the window
    glfwDestroyWindow(windowHandle);

    // Terminate the window
    glfwTerminate();
    glfwSetErrorCallback(null).free();
  }

  /**
   * Checks if the window should be closing
   *
   * @return A boolean for if the window should close
   */
  public boolean isShouldClose() {
    return this.shouldClose;
  }

  /**
   * This method checks if vsync is enabled
   *
   * @return true if vsync is enabled, otherwise false
   */
  private boolean vsyncEnabled() {
    return vsync;
  }

}

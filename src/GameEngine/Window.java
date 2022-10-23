package GameEngine;

import javax.swing.*;
import java.awt.*;

/**
 * This class holds the functionality of a window for the Potato GameEngine.Engine.
 * Windows are a singleton so only one may exist at a time.
 *
 * @author Tyler Spaeth
 */
public class Window extends JFrame {

  Window _window = null;

  private int width;
  private int height;
  private String title;
  private Canvas canvas;

  /**
   * Constructor for a Window object.
   *
   * @param width width of the Window in pixels
   * @param height height of the Window in pixels
   * @param title a title for the window
   */
  public Window(int width, int height, String title) {
    this.width = width;
    this.height = height;
    this.title = title;
  }

  /**
   * Method for initializing the window.
   */
  public void init() {

    if(_window != null) {
      throw new IllegalStateException("A window has already been initialized, only one may exist" +
          " at a time ");
    }

    setSize(width, height);
    setTitle(title);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setResizable(false);
    setLocationRelativeTo(null); // Centers
    // setUndecorated(true); Removes border

    setVisible(true);

    // Creation of canvas

    canvas = new Canvas();
    canvas.setPreferredSize(new Dimension(width, height));
    canvas.setMaximumSize(new Dimension(width, height));
    canvas.setMinimumSize(new Dimension(width, height));
    canvas.setFocusable(false);

    add(canvas);
    pack();
  }

  public void update(){
    //TODO decide to use or not
  }

  /**
   * Getter for the canvas that is on this Window
   *
   * @return
   */
  public Canvas getCanvas() {
    return this.canvas;
  }

}

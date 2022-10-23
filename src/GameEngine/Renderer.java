package GameEngine;

import GameEngine.GameObjects.Components.SpriteRenderer;

import java.awt.*;
import java.awt.image.BufferStrategy;

/**
 * Class for rendering to the window
 *
 * @author Tyler Spaeth
 */
public class Renderer {

  private BufferStrategy bufferStrategy;
  private Graphics graphics;

  private Window window;
  public int x;

  /**
   * Constructor for a Renderer object
   *
   * @param window the window that the Renderer should render too
   */
  public Renderer(Window window) {
    this.window = window;
    x = 5;
  }

  /**
   * Renders the next buffer to the screen
   */
  private void render() {
    bufferStrategy = window.getCanvas().getBufferStrategy(); // Get the active bufferstrategy

    if(bufferStrategy == null) { // If there is no bufferstrategy
      window.getCanvas().createBufferStrategy(3); // TODO determine correct num buffers
      return;
    }

    graphics = bufferStrategy.getDrawGraphics();

    graphics.clearRect(0,0, window.getWidth(), window.getHeight()); // Clears frame

    // Do all drawing here

    // Renders all SpriteRenders
    for(SpriteRenderer spriteRenderer : SpriteRenderer.getSpriteRenderers()) {
      spriteRenderer.render(graphics, window);
    }

    // End drawing here
    bufferStrategy.show(); // Makes everything drawn above visible
    graphics.dispose(); // Gets rid of what graphics currently is so it can be reused
  }

  /**
   * Updates this Renderer
   */
  public void update() {
    render();
  }

}

package GameEngine.GameObjects.Components;

import GameEngine.Utils.Vector2.Vector2;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Class for sprite rendering
 */
public class SpriteRenderer extends Component{

  // TODO account for rotation and scale && account for situations that throw errors.
  //  Also potential keep track of what layer the sprite renderer is on

  private Image sprite; // The sprite for this GameObject
  private Vector2 position; // The position of this SpriteRenderer

  /**
   * Default constructor for a SpriteRenderer.
   */
  public SpriteRenderer() {

    this.sprite = null;

  }

  /**
   * Constructor for a SpriteRenderer that takes a filePath.
   *
   * @param filePath the filepath for the desired sprite
   */
  public SpriteRenderer(String filePath, Vector2 position) {

    // Load the given filePath to an Image
    try {
      this.sprite = ImageIO.read(new File(filePath));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    this.position = position;

  }

  /**
   * Constructor for a SpriteRenderer that takes a Sprite.
   *
   * @param sprite the desired sprite for this SpriteRenderer
   */
  public SpriteRenderer(Image sprite, Vector2 position) {

    this.sprite = sprite;
    this.position = position;

  }

  /**
   * Changes the sprite to the sprite corresponding to this url
   *
   * @param filePath the filepath for the desired sprite
   */
  public void changeSprite(String filePath) {

    // Load the given filePath to an Image
    try {
      this.sprite = ImageIO.read(new File(filePath));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Changes the sprite to the given sprite
   *
   * @param sprite the desired sprite for this SpriteRenderer
   */
  public void changeSprite(Image sprite) {
    this.sprite = sprite;
  }

  /**
   * Renders this sprite to the screen
   *
   * @param graphics the graphics object to render to
   * @param window the window to render to
   */
  public void render(Graphics graphics, Window window) {
    graphics.drawImage(sprite, (int)position.getX(), (int)position.getY(), window);
  }

  /**
   * Sets the position of this SpriteRenderer to the given Vector2
   *
   * @param position the desired position of this sprite
   */
  public void setPosition(Vector2 position) {
    this.position = position;
  }

  /**
   * Gets the position of this Sprite Renderer
   *
   * @return the Vector2 for the position of this sprite renderer
   */
  public Vector2 getPosition() {
    return this.position;
  }

}

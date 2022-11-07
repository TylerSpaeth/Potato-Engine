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
  private int layer; // The layer that the sprite should be rendered on

  /**
   * Default constructor for a SpriteRenderer.
   */
  public SpriteRenderer() {

    this.sprite = null;
    this.position = null;
    this.layer = 0;

  }

  // TODO make SpriteRenderer constructors that don't take a layer variable. Set layer to 0
  /**
   * Constructor for a SpriteRenderer that takes a filePath.
   *
   * @param filePath the filepath for the desired sprite
   * @param position the position of the SpriteRenderer
   * @param layer the layer to draw the sprite
   */
  public SpriteRenderer(String filePath, Vector2 position, int layer) {

    // Load the given filePath to an Image
    try {
      this.sprite = ImageIO.read(new File(filePath));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    this.position = position;
    this.layer = layer;

  }

  /**
   * Constructor for a SpriteRenderer that takes a Sprite.
   *
   * @param sprite the desired sprite for this SpriteRenderer
   * @param position the position of the SpriteRenderer
   * @param layer the layer to draw the sprite
   */
  public SpriteRenderer(Image sprite, Vector2 position, int layer) {

    this.sprite = sprite;
    this.position = position;
    this.layer = layer;
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


  // Begin Getters and Setters
  public void setPosition(Vector2 position) {
    this.position = position;
  }

  public Vector2 getPosition() {
    return this.position;
  }

  public int getLayer() {
    return this.layer;
  }

  public void setLayer(int layer) {
    this.layer = layer;
  }
  // End Getters and Setters
}

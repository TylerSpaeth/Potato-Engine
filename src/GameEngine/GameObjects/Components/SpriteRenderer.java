package GameEngine.GameObjects.Components;

import GameEngine.Utils.Vector2.Vector2;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Class for sprite rendering
 */
public class SpriteRenderer extends Component{

  // TODO account for rotation and scale && account for situations that throw errors

  private Image sprite; // The sprite for this GameObject

  // TODO potentially move this to a Scene class
  private static ArrayList<SpriteRenderer> spriteRenderers; // List of all sprite renders that exist
  private Vector2 position;

  /**
   * Default constructor for a SpriteRenderer
   */
  public SpriteRenderer() {

    // Initializes spriteRenders if not done already
    if(spriteRenderers == null) {
      spriteRenderers = new ArrayList<>();
    }

    this.sprite = null;
    spriteRenderers.add(this); // Add this SpriteRender to this list of SpriteRenderers
  }

  /**
   * Constructor for a SpriteRenderer that takes a filePath
   *
   * @param filePath the filepath for the desired sprite
   */
  public SpriteRenderer(String filePath, Vector2 position) {

    // Initializes spriteRenders if not done already
    if(spriteRenderers == null) {
      spriteRenderers = new ArrayList<>();
    }

    // Load the given filePath to an Image
    try {
      this.sprite = ImageIO.read(new File(filePath));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    this.position = position;

    spriteRenderers.add(this); // Add this SpriteRender to this list of SpriteRenderers
  }

  /**
   * Constructor for a SpriteRenderer that takes a Sprite
   *
   * @param sprite the desired sprite for this SpriteRenderer
   */
  public SpriteRenderer(Image sprite, Vector2 position) {

    // Initializes spriteRenders if not done already
    if(spriteRenderers == null) {
      spriteRenderers = new ArrayList<>();
    }

    this.sprite = sprite;
    this.position = position;

    spriteRenderers.add(this); // Add this SpriteRender to this list of SpriteRenderers
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

    // TODO revamp this

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

  // Begin Static Methods
  /**
   * Getter for the list of SpriteRenders
   *
   * @return the list of active SpriteRenderers
   */
  public static ArrayList<SpriteRenderer> getSpriteRenderers() {
    return spriteRenderers;
  }
  // End Static Methods
}

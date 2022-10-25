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

  // Which layer this Sprite should be rendered on. Layer 0 is further back than layer 1
  private int layer;

  /**
   * Default constructor for a SpriteRenderer. Default layer is 0.
   */
  public SpriteRenderer() {

    // Initializes spriteRenders if not done already
    if(spriteRenderers == null) {
      spriteRenderers = new ArrayList<>();
    }

    this.sprite = null;
    spriteRenderers.add(this); // Add this SpriteRender to this list of SpriteRenderers

    this.layer = 0; // The lowest possible layer
  }

  /**
   * Constructor for a SpriteRenderer that takes a filePath. Default layer is 0.
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

    this.layer = 0; // The lowest possible layer
  }

  /**
   * Constructor for a SpriteRenderer that takes a Sprite. Default layer is 0.
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

    this.layer = 0; // The lowest possible layer
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

  /**
   * Sets the layer to this given layer. A high number will be rendered above a lower number
   *
   * @param layer the layer for this SpriteRenderer
   *
   * @throws IllegalArgumentException if the given layer is a negative number
   */
  public void setLayer(int layer) {
    if(layer < 0) {
      throw new IllegalArgumentException("Layer must be greater than or equal to 0");
    }
    this.layer = layer;
  }

  /**
   * Gets the layer of this SpriteRenderer
   *
   * @return the layer for this SpriteRenderer
   */
  public int getLayer() {
    return this.layer;
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

  /**
   * Gets the highest layer number in the spriteRenderers list
   *
   * @return the highest layer number in the spriteRenderers list
   */
  public static int getHighestLayer() {
    // TODO test
    int highestLayer = 0;
    for(SpriteRenderer spriteRenderer : spriteRenderers) {
      if(spriteRenderer.getLayer() > highestLayer) {
        highestLayer = spriteRenderer.getLayer();
      }
    }
    return highestLayer;
  }
  // End Static Methods
}

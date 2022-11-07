package GameEngine;

import GameEngine.GameObjects.Components.Component;
import GameEngine.GameObjects.Components.SpriteRenderer;
import GameEngine.GameObjects.GameObject;
import com.sun.jdi.request.DuplicateRequestException;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * A Scene for a game in Potato Engine
 */
public class Scene {

  private static Scene currentScene = null; // The active scene
  private ArrayList<GameObject> gameObjects; // All the GameObjects in the scene

  // All the SpriteRenderers in the scene grouped by layer
  private HashMap<Integer, ArrayList<SpriteRenderer>> spriteRenderersByLayer;

  /**
   * Constructor for a Scene. Initializes all instance variables.
   */
  public Scene() {
    this.gameObjects = new ArrayList<>();
    this.spriteRenderersByLayer = new HashMap<>();
  }

  /**
   * Sets the currentScene of to this Scene
   */
  public void setToCurrentScene() {
    Scene.currentScene = this;
  }

  /**
   * Gets the current Scene
   *
   * @return the current Scene
   */
  public static Scene getCurrentScene() {
    return currentScene;
  }

  //TODO figure out if this should be used
  public void addGameObject(GameObject gameObject) {
    if(gameObject == null) {
      throw new IllegalArgumentException("This GameObject is null");
    }

    gameObjects.add(gameObject); // Add this GameObject to the list of GameObjects

    for(Component component : gameObject.getComponents()) { // Check comps. of the gameObject
      if(component instanceof SpriteRenderer spriteRenderer) { // If one is a SpriteRenderer add it
        addSpriteRendererToLayer(spriteRenderer.getLayer(), spriteRenderer);
      }
    }
  }

  /**
   * Adds a layer to the HashMap of layers.
   *
   * @param layerNumber the number for the layer, lower being rendered first
   *
   * @throws DuplicateRequestException if a layer has already been created with this number
   */
  public void addLayer(int layerNumber) {

    if(spriteRenderersByLayer.containsKey(layerNumber)) {
      throw new DuplicateRequestException("A layer with this number has already been created");
    }

    spriteRenderersByLayer.put(layerNumber, new ArrayList<>());
  }

  /**
   * Adds a SpriteRenderer to a given layer. If the layer does not exist already, one will be created
   *
   * @param layerNumber the number for the layer, lower being rendered first
   * @param spriteRenderer the SpriteRenderer to add
   *
   * @throws IllegalArgumentException the SpriteRenderer is null
   * @throws DuplicateRequestException if the SpriteRenderer has already been added
   */
  public void addSpriteRendererToLayer(int layerNumber, SpriteRenderer spriteRenderer) {
    if(spriteRenderer == null) {
      throw new IllegalArgumentException("This SpriteRenderer is null");
    }
    // If the layer does not exist, create it
    else if(!spriteRenderersByLayer.containsKey(layerNumber)) {
      addLayer(layerNumber);
    }

    for(int layer : spriteRenderersByLayer.keySet()) {
      if(spriteRenderersByLayer.get(layer).contains(spriteRenderer)) {
        throw new DuplicateRequestException("This sprite renderer has already been added to the scene");
      }
    }

    spriteRenderersByLayer.get(layerNumber).add(spriteRenderer);
  }

  /**
   * Gets the Hashmap of layers and SpriteRenderers
   *
   * @return the Hashmap of layers and SpriteRenderers
   */
  public HashMap<Integer, ArrayList<SpriteRenderer>> getSpriteRenderersByLayer() {
    return this.spriteRenderersByLayer;
  }
}
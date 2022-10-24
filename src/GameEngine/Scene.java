package GameEngine;

import GameEngine.GameObjects.Components.SpriteRenderer;
import GameEngine.GameObjects.GameObject;

import java.util.ArrayList;

/**
 * A Scene for a game in Potato Engine
 */
public class Scene {

  private static Scene currentScene = null; // The active scene
  private ArrayList<GameObject> gameObjects; // All the GameObjects in the scene
  private ArrayList<SpriteRenderer> spriteRenderers; // All the SpriteRenderers in the scene

  /**
   * Constructor for a Scene. Initializes all instance variables.
   */
  public Scene() {
    this.gameObjects = new ArrayList<>();
    this.spriteRenderers = new ArrayList<>();
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
    gameObjects.add(gameObject);
  }

}
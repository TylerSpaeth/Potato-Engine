package GameEngine.GameObject;

import GameEngine.GameObject.Components.Component;

import java.util.ArrayList;

/**
 * Class for GameObject functionality.
 *
 * @author Tyler Spaeth
 */
public class GameObject {

  private ArrayList<GameObject> children; // All GameObjects that are children of this
  private ArrayList<Component> components; // All components attached to this GameObject

  /**
   * Constructor for a GameObject. It initializes all instance variables
   */
  public GameObject() {
    // Initializing Arraylists
    this.children = new ArrayList<>();
    this.components = new ArrayList<>();
  }


}

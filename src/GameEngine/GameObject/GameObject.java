package GameEngine.GameObject;

import GameEngine.GameObject.Components.Component;
import GameEngine.GameObject.Components.Transform;
import com.sun.jdi.request.DuplicateRequestException;

import java.util.ArrayList;

/**
 * Class for GameObject functionality.
 *
 * @author Tyler Spaeth
 */
public class GameObject {
  //TODO implement tester for this class
  private ArrayList<GameObject> children; // All GameObjects that are children of this
  private ArrayList<Component> components; // All components attached to this GameObject
  private boolean containsTransform;
  private String name;

  /**
   * Constructor for a GameObject. It initializes all instance variables
   */
  public GameObject(String name) {
    // Initializing Arraylists
    this.children = new ArrayList<>();
    this.components = new ArrayList<>();
    this.containsTransform = false;
    this.name = name;
  }

  /**
   * Getter for the children ArrayList
   *
   * @return ArrayList of GameObjects that are children
   */
  public  ArrayList<GameObject> getChildren() {
    return this.children;
  }

  /**
   * Getter for the components ArrayList
   *
   * @return ArrayList of Components attached to this GameObject
   */
  public ArrayList<Component> getComponents() {
    return this.components;
  }

  /**
   * Getter for this GameObject's name
   *
   * @return the name of this GameObject
   */
  public String getName() {
    return this.name;
  }

  /**
   * Sets the name for this GameObject
   *
   * @param name String of the name for this GameObject
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Adds a GameObject as a child of this GameObject
   *
   * @param gameObject a GameObject to be added as a child
   * @throws DuplicateRequestException if this GameObject has already been added as a child
   * @throws IllegalArgumentException if this GameObject is null
   */
  public void addChild(GameObject gameObject) {
    if(gameObject == null) {
      throw new IllegalArgumentException("This GameObject is null");
    }
    else if(!children.contains(gameObject)) {
      children.add(gameObject);
    }
    else {
      throw new DuplicateRequestException("This GameObject has already been added as a child");
    }
  }

  /**
   * Adds a Component to this GameObject
   *
   * @param component the Component to be added to this GameObject
   * @throws IllegalArgumentException if more than 1 Transform is added to this GameObject. Also, can
   *                                  be thrown if the Component is null.
   * @throws DuplicateRequestException if this given Component already has been added
   */
  public void addComponent(Component component) {
    if(component == null) {
      throw new IllegalArgumentException("This Component is null");
    }
    else if(component.getClass().equals(Transform.class)) { // If the Component is a Transform
      if(!containsTransform) {
        components.add(component);
        this.containsTransform = true;
      }
      else { // Only one Transform is allowed at a time
        throw new IllegalArgumentException("This GameObject already has a Transform Component");
      }
    }
    else if(!children.contains(component)) { // Ensures that no duplicates are added
      components.add(component);
    }
    else {
      throw new DuplicateRequestException("The same component was added twice");
    }
  }
}

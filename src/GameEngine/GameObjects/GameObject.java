package GameEngine.GameObjects;

import GameEngine.GameObjects.Components.Component;
import GameEngine.GameObjects.Components.Transform;
import com.sun.jdi.request.DuplicateRequestException;

import java.util.ArrayList;

/**
 * Class for GameObject functionality.
 *
 * @author Tyler Spaeth
 */
public class GameObject {
  //TODO implement tester for this class. This class also needs to be overhauled because it does not
  // work well with the current system
  private ArrayList<GameObject> children; // All GameObjects that are children of this
  private ArrayList<Component> components; // All components attached to this GameObject
  private boolean containsTransform; // True if this GameObject has a transform
  private String name; // Name of this GameObject
  private static ArrayList<String> names; // A list of all the names that exist

  /**
   * Constructor for a GameObject. It initializes all instance variables.
   *
   * @param name the name of this GameObject
   *
   * @throws IllegalArgumentException if the name is null or blank
   * @throws DuplicateRequestException if a GameObject with that name has already been created
   */
  public GameObject(String name) {
    // Initializing Arraylists
    this.children = new ArrayList<>();
    this.components = new ArrayList<>();
    this.containsTransform = false;

    if(name == null || name.trim().equals("")) {
      throw new IllegalArgumentException("This name is null or blank");
    }
    else if(names.contains(name)) {
      throw new DuplicateRequestException("A GameObject with this name already exists");
    }
    else {
      this.name = name;
      names.add(name);
    }
  }

  /**
   * Constructor for a GameObject. Initializes instance variables and adds the things passed as params
   *
   * @param name the name for this GameObject
   * @param transform the Transform for this GameObject
   *
   * @throws IllegalArgumentException if the transform is null. Also, if the name is null or blank.
   * @throws DuplicateRequestException if a GameObject with that name has already been created
   */
  public GameObject(String name, Transform transform) {
    this.children = new ArrayList<>();
    this.components = new ArrayList<>();

    if(transform == null) {
      throw new IllegalArgumentException("Transform is null");
    }
    else {
      components.add(transform);
      this.containsTransform = true;
    }

    setName(name);
    names.add(name);
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

  /**
   * Changes the name of this GameObject to the givenName
   *
   * @param name a name for this GameObject
   *
   * @throws IllegalArgumentException if the transform is null. Also, if the name is null or blank.
   * @throws DuplicateRequestException if a GameObject with that name has already been created
   */
  public void setName(String name) {
    if(name == null || name.trim().equals("")) {
      throw new IllegalArgumentException("This name is null or blank");
    }
    else if(names.contains(name)) {
      throw new DuplicateRequestException("A GameObject with this name already exists");
    }
    else {
      this.name = name;
      names.remove(this.name); // Remove the name that is being changed
      names.add(name);
    }
  }

  /**
   * Removes a name from the list of names
   *
   * @param name the name to remove from the list
   *
   * @throws IllegalArgumentException if the name is null, blank, or no GameObjects with
   * that name exist
   */
  public static void removeName(String name) {
    if(name == null || name.trim().equals("")) {
      throw new IllegalArgumentException("This name is null or blank");
    }
    else if(!names.contains(name)) {
      throw new IllegalArgumentException("No GameObject with this name exists.");
    }
    else {
      names.remove(name);
    }
  }
}